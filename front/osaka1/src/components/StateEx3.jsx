import { useState } from "react";

function StateEx3(props){
    const [mode, setMode] = useState("일반");
    const [show, setShow] = useState(true);
    return (
        <section className="borderTop">
            <h2>state 연습</h2>

            <h3>토글</h3>
            {/*버튼을 클릭하면 버튼 내용은 숨기기/보이기 토글, 그에 따라 p영역도 보이고 숨겨짐*/}
            {/* ! 부정 연산자: 입력값의 반대값 반환 */}
            <button onClick={()=>setShow(!show)}> 
                {show ? "숨기기" : "보이기" }
            </button>
            { show && <p>버튼을 클릭하면 보이는 영역</p> }
            {/*해당 버튼을 클릭하며 현재모드 영역에 해당 모드로 변경*/}
            <h3>일반모드 / 관리자모드</h3>
            <button onClick={()=>setMode("일반")}>일반</button>
            <button onClick={()=>setMode("관리자")}>관리자</button>
            <p>현재 모드 : {mode}</p>
        </section>
    )
}

export default StateEx3;