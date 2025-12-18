import { useState } from "react";
import AgreeCheck from "./child-components/AgreeCheck";

function ComEx3() {
    const [agree1, setAgree1] = useState(false);
    const [agree2, setAgree2] = useState(false);
    const [agree3, setAgree3] = useState(false);
    const [agree4, setAgree4] = useState(false);

    // 네 개 값 모두 참일 때 참이라는 값을 가지도록
    const all = agree1 && agree2 && agree3 && agree4;

    return (
        <section className="borderTop">
            <h2>체크 박스 모두 동의 시 다음 버튼 활성화</h2>
            <hr />
            
            {/* 함수를 자식에게 내려보내주고 값을 받음 */}
            <AgreeCheck text="약관동의1" onAgree={setAgree1} checked={agree1} />
            <AgreeCheck text="약관동의2" onAgree={setAgree2} checked={agree2} />
            <AgreeCheck text="약관동의3" onAgree={setAgree3} checked={agree3} />
            <AgreeCheck text="약관동의4" onAgree={setAgree4} checked={agree4} />       
            <button disabled={!all}>다음</button>     
        </section>
    );
}

export default ComEx3;