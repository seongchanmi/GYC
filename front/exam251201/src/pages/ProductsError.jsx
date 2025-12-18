import { useRouteError } from "react-router";

function ProductsError() {

    const error =useRouteError();

    return (
        <>
            <h3>오류 발생</h3>
            <p>{error.message}</p>
            <p>{error?.message || "알 수 없는 오류"}</p>
        </>
    );
}

export default ProductsError;