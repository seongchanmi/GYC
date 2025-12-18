import React from 'react';

function Ex1(props) {
    const names = ['한라봉', '감홍', '감', '귤', '진지향'];
    // return 위의 영역(현재 위치)은 자바스크립트의 영역
    const scores = [10, 20, 30, 40];
    return (
        <>
        <ul>
            { names.map((name, idx) => (
                <li key={idx}>{name}</li>
            ))}
        </ul>
        <ul>
            { scores.map((score, idx) => (
                <li key={idx}>{score}</li>
            ))}
        </ul>
        </>
    );
}

export default Ex1;