
function Home() {
    return (
        <section>
            <h1>🐳TanStack Query🐳</h1>
            <p>데이터 fetch, 캐싱, 재요청 처리를 자동 처리하는 상태 라이브러리</p>

            <ul>
                <li>데이터 캐싱</li>
                <li>자동 재처리</li>
                <li>로딩/에러 상태 제공</li>
                <li>mutation(POST/PUT/PATCH/DELETE) 처리 및 캐시 갱신</li>
            </ul>

            <h3>Hook</h3>
            <ul>
                <li>useQuery: 조회 전용 GET</li>
                <li>useMutation: 수정/등록/삭제 POST/PUT/PATCH/DELETE 처리</li>
                <li>useQueryClient: 캐시 조작시 사용 .invalidateQueries()로 다시 불러옴</li>
            </ul>
        </section>
    );
}

export default Home;