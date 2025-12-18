import React from 'react';

function ListEx3() {
    const items = [];
    const scores = [80, 91, 77, 98, 60];
    const animals = ['강아지', '고양이'];

    return (
        <section className="borderTop">

            <h2>리스트에 스타일 조건 적용</h2>
            <ul>
                {/* scores에서 90점 이상인 경우 글자 색상 변경 */}
                {scores.map((score, idx) =>
                    <li key={idx} style={{ color: score >= 90 ? "orange" : "black" }}>점수: {score}점</li>
                )}
            </ul>
            <hr />

            <h2>조건부 + 리스트</h2>
            {/* animals의 데이터가 없는 경우 동물이 없습니다 출력 */}
            {animals.length == 0 && <p>동물이 없습니다</p>}
            {/* animals의 데이터가 있는 경우 리스트 출력 */}
            {animals.length != 0 && (
                <ul>
                    {animals.map((ani, idx) => <li key={idx}>{ani}</li>)}
                </ul>
            )}
            <hr />

            <h2>조건부 렌더링</h2>
            {/* items의 배열 요소의 수(length)가 0이면 데이터 없음이 출력되고 있으면 데이터 있음 출력 */}
            {items.length == 0 ? <p>데이터 없음</p> : <p>데이터 있음</p>}

        </section>
    );
}

export default ListEx3;