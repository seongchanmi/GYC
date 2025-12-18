import React from 'react';

function BasicEx6(props) {
    const fruits = ['한라봉', '진지향', '윈터프린스', '유라조생', '타이벡', '천혜향', '레드향'];

    return (
        <section className='borderBottom'>
            <h2>리스트 렌더링</h2>
            <p>배열, 객체 등을 .map() 메서드를 이용해 렌더링.</p>
            <p>배열.map(콜백함수);</p>
            <p>map()을 사용하는 경우 반복하는 요소에 **반드시 고유한 key 속성**이 있어야 함</p>
            <p>map의 기본 index를 key 속성으로 사용하는 것은 권장되지 않음. 예를 들면 id값</p>
            <ul>
                {
                    fruits.map((fruit, idx) => <li key={idx}>{fruit}</li>)
                }
            </ul>
        </section>
    );
}

export default BasicEx6;