import axios from 'axios';

export async function fetchProduct() {
    const res = await axios.get("http://localhost:8080/api/products");
    // console.log(res.data);
    return res.data;
}

export async function createProduct(product) {
    const res = await axios.post("http://localhost:8080/api/products", product);
    return res.data;
}

export async function deleteProduct(id) {
    const res = await axios.delete(`http://localhost:8080/api/products/${id}`)
    return res.data !== undefined && res.data !== null ? res.data : true;
}