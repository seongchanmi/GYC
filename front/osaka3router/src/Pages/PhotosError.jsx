import { useRouteError } from "react-router";

function PhotosError() {
    // 데이터를 불러오는 경우 loader나 렌더링시 발생되는 오류 읽음
    const error = useRouteError();

    return (
        <div>
            <h2>앨범 목록을 불러오는 중 오류 발생</h2>
            <pre style={{ color: "#f00" }}>
                {/* .statusText 응답 에러일 때 / .message 일반 오류 */}
                {error?.statusText || error?.message}
            </pre>
        </div>
    );
}

export default PhotosError;