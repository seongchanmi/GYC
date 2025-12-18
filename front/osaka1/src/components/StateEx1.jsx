import { useState } from "react";

function StateEx1() {
  const [username, setUsername] = useState("한라봉");
  const [count, setCount] = useState(0);

  return (
    <section className="borderTop">
      <h2>State 상태 관리</h2>
      <h3>useState()</h3>
      <ul>
        <li>함수형 컴포넌트에서 상태(state)를 관리하는 훅(hook)</li>
        <li>변경되는 값을 인지하고 값이 바뀔 때마다 다시 렌더링되도록 함</li>
        <li>const [값(변수), 업데이트 set함수] = useState(초기값);</li>
      </ul>
      <hr />
      <div>
        <p>이름 : {username}</p>
        <button onClick={() => setUsername("타이벡")}>이름 바꾸기</button>
      </div>
      <div>
        <p>클릭수: {count}</p>
        <button onClick={() => setCount(count + 1)}>1씩 증가</button>
      </div>
    </section>
  );
}

export default StateEx1;