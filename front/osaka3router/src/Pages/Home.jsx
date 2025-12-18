function Home() {
    return (
        <section className="borderTop">
            {/* <DeclarativeMode /> */}
            <h1>react-router</h1>
            <p>페이지의 새로고침 없이 필요한 컴포넌트를 바꿔줌</p>

            <ul>
                <li>Declarative: 단순한 페이지 전환</li>
                <li>Data: CLUD 등의 SPA 구성</li>
                <li>Framework: SSR, 대규모 프로젝트</li>
            </ul>

            <h3>용어</h3>
            <ul>
                <li>Route: 컴포넌트와 경로 연결</li>
                <li>Link: SPA 방식으로 이동(재랜더링 없음)</li>
                <li>Outlet: 중첩 라우팅에서 자식 컴포넌트가 보이는 영역</li>
                <li>useNavigate: 컴포넌트 안에서 버튼에 주로 사용되는 이동</li>
            </ul>
        </section>
    );
}

export default Home;