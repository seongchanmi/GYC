import { useRouteError } from "react-router";

function AboutError() {

    // 오류 정보 읽음
    const error = useRouteError();

    return (
        <>
            <h3>오류 발생!</h3>
            <h3>오류 발생!</h3>
            <h3>오류 발생!</h3>
            <p>{error.message}</p>
            {/* error = { message: "오류" } */}
            <p>{error?.message || "알 수 없는 오류"}</p>
        </>
    );
}

export default AboutError