
function ListEx1(props) {
    const mandarin = ['한라봉', '타이벡', '윈터프린스', '진지향', '유라조생', '유라실생'];

    return (
        <div>
          <h2>기본 리스트 렌더링</h2>
          <ul>
            <li>.map()을 사용할 경우 고유한 key값 필수</li>
            <li>매개변수(파라미터)의 기본값인 index를 가져와 사용하는 것은 권장하지 않음</li>
          </ul>
          <ul>
            {/* 배열.map((요소[, 인덱스]) => {}); */}
            {
                mandarin.map((item, idx) => {
                    return <li key={idx}>{item}</li>
                })
            }
          </ul>
        </div>
    );
}

export default ListEx1;