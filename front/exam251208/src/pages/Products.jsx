import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { createProduct, deleteProduct, fetchProduct } from "../api/productApi.js";
import { useState } from "react";
import ProductItem from "../components/ProductItem.jsx";

function Products() {


    const queryClient = useQueryClient();
    const [name, setName] = useState("");
    const [price, setPrice] = useState("");

    const refetch = () => {
        queryClient.invalidateQueries({ queryKey: ['product'] })
    }

    const { data: products = [] } = useQuery({
        queryKey: ['product'],
        queryFn: fetchProduct
    });

    const addMutation = useMutation({
        mutationFn: createProduct,
        onSuccess: refetch
    })

    const deleteMutaion = useMutation({
        mutationFn: deleteProduct,
        onSuccess: refetch
    });

    const handleAddList = (evt) => {
        evt.preventDefault();
        addMutation.mutate({
            name: name,
            price: Number(price)
        }
        );
        setName("");
        setPrice("");
    }

    const onDelete = (id) => {
        deleteMutaion.mutate(id);
    }

    return (
        <div
            style={{
                maxWidth: "600px",
                margin: "0 auto",
                textAlign: "center"
            }}>
            <h1>Products</h1>

            <input
                type="text"
                placeholder="상품 입력"
                value={name}
                onChange={(evt) => setName(evt.target.value)}
            />

            <input
                type="number"
                placeholder="가격 입력"
                value={price}
                onChange={(evt) => setPrice(evt.target.value)}
            />
            <button
                type="submit"
                onClick={handleAddList}>추가</button>

            <ul>
                {
                    products.map((product) => (
                        <ProductItem key={product.id}
                            product={product}
                            onDelete={onDelete}

                        />
                    ))
                }
            </ul>
        </div>
    );
}

export default Products