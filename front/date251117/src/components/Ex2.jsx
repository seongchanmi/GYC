import React, { useState } from 'react';

function Ex2(props) {
    const [name, setName] = useState("한라봉"); //useState(초기값) 쓸때 위에 import 들어갔는지 확인 필요
    return (
        <>
        <h2>state 상태</h2>
        <p>{name}</p>
        <button onClick={() => setName("감홍")}>감홍</button> {}
        <button onClick={() => setName("부사")}>부사</button> {}
        <button onClick={() => setName("진지향")}>진지향</button>
        </>
    );
}

export default Ex2;