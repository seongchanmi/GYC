//출력 컴포넌트
function UserList({query, items}) {

    const list = items.filter(
        item => item.toLowerCase().includes(query.toLowerCase())

        // 영어가 있다!! 하면 위와 같이 코드 작성

        // 한글 밖에 없으면 아래로 해도 상관 없음
        // item => item.includes(query) 
        // 문자열이나 배열에 포함되어ㅣ 있는지 true, false 로 검사
    );

    return (
        <ul>
          {list.map((elem, idx) => <li key={idx}>{elem}</li>)}  
        </ul>
    );
}

export default UserList;