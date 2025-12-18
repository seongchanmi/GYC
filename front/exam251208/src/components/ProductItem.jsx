function ProductItem({ product, onDelete }) {

    const { id, name, price } = product;

    const handleDelete = () => onDelete(id);

    return (
        <li
            style={{
                display: "flex",
                alignItems: "center",
                width: "300px",
                margin: "10px auto"
            }}>
            <p>{name}: {price}원</p>
            <button onClick={handleDelete}>삭제</button>
        </li>
    );
}

export default ProductItem;