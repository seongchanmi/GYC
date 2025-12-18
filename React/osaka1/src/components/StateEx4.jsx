import React, { useState } from 'react';
import StateEx4Child from './StateEx4Child';

function StateEx4(props) {
    const [num, setNum] = useState(0);
    const [count, setCount] = useState(0);

    const plus = () => {
        /*
        setCount(count +1);
        setCount(count +1);
        */
        setCount(prev => prev +1);
        setCount(prev => prev +1);
    }

    const minus = () => {}

    return (
        <section className = "borderTop">
            <h2>자식 컴포넌트 연결 후 props에서 전달</h2>
            <StateEx4Child cookie = "망고" />
            
            <hr />
            <h2>그냥 새 값으로 넘기기</h2>
            <p>연속으로 여러번 업데이트하는 경우 문제가 생길 수 있음</p>
            <button onClick={()=>setNum(num + 1)}>1 증가</button>
            <button onClick={()=>setNum(num - 1)}>1 감소</button>
            <p>값:{num}</p>

            <h2>함수로 값 넘기기</h2>
            <ul>
                <li>이전 값을 기반으로 업데이트하는 방식</li>
                <li>prev, prevState 등의 매개변수(파라미터)명을 주로 사용</li>
            </ul>
            <p>값: {count}</p>
            <button onClick={plus}>1 증가</button>
            <button onClick={() => setCount(prev => prev -1)}>1 감소</button>   
            
        </section>
    );
}

export default StateEx4;