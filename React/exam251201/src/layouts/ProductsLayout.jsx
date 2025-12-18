import { Link, Outlet } from "react-router";

function ProductsLayout() {
    return (
        <div>
            <h2>Products</h2>

            <nav>
                <Link to="/products">상품 입력</Link> |
                <Link to="/products/output">상품 출력</Link> |
                <Link to="/products/customer">고객센터</Link>
            </nav>
            
            <Outlet />
        </div>
    );
}

export default ProductsLayout;