import { useLoaderData } from "react-router";

function Photos() {
    // loader에서 리턴한 반환값을 훅으로 받음
    const photos = useLoaderData(); // data -> 배열을 받음

    return (
        <section className="borderTop">
            <h2>Data 모드에는</h2>
            <p>url → loader 실행 → 컴포넌트 실행 → action 실행(폼 제출시)</p>

            <ul>
                <li>loader: 페이지 진입 전 데이터 로딩. API 요청. 반환값은 useLoaderData</li>
                <li>action: Foam 데이터 처리. GET, POST, DELETE, PUT 등 변경 요청 담당. 반환값은 자동으로 라우터에 적용</li>
                <li>errorElement: 라우터 단위로 에러 처리. loader, action 오류 발생시 멈추지 않고 넘겨줌</li>
            </ul>

            <h3>앨범 목록</h3>
            <ol>
                {
                    // .slice(시작인덱스, 해당 인덱스 앞까지)
                    photos.slice(0,10).map(({ id, slug, title, thumbnail }) => (
                    <li key={id}>
                     <h3>{slug}</h3>
                     <p style={{
                        overflow: "hidden", // 내용이 넘치면 숨김
                        textOverflow: "ellipsis", // 말줄임(...)
                        whiteSpace: "nowrap", // 한 줄일 때 줄바꿈 안됨
                        width: 200
                    }}>{title}</p>
                     <img src={thumbnail} alt={title} />
                    </li>
                    ))
                }
            </ol>

        </section>
    );
}

export default Photos;