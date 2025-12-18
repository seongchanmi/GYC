import { useRouteError } from "react-router";

function UsersError() {

    const error = useRouteError();

    return (
        <div>
            <h2>목록을 불러오는 중 오류 발생</h2>
            <pre>
                {error?.statusText || error?.message}
            </pre>
        </div>
    );
}

export default UsersError;