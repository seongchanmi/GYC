import React, { useState } from 'react';

function FormEx3() {
    const [show, setShow] = useState(false); //toggle 기능을 가지고 있어야 함
    const [pw, setPw] = useState("");

    const [email, setEmail] = useState("");
    const isVali = email.includes("@"); // 포함된 여부를 true/false로 반환

    const handleSubmit = (evt) => {
        // html 요소의 기본 기능 제거 (form과 a태그는 submit를 하면 새로고침을 하기 때문에)
        evt.preventDefault();
        alert(`이메일: ${email}`);
        // 다시 업데이트
        // 전송버튼을 클릭해서 내용을 알림창으로 띄웠으면, 사용성을 위해 내용을 지움(초기화)
        setEmail("");
    }

    return (
        <section className="borderTop">

            <form onSubmit={handleSubmit}>
                <h2>form 태그로 submit 처리</h2>
                <input type="email" 
                placeholder="이메일을 입력하세요"
                value={email}
                onChange={evt => setEmail(evt.target.value)}
                />
                {!isVali && <p style={{color: "red"}}>이메일 형식이 아닙니다</p>}
                <button type="submit">전송</button>
            </form>
            <hr />

            <h2>필드 조건문</h2>
            <input 
            type={show ? "text" : "password"}
            value={pw}
            onChange={evt => setPw(evt.target.value) } />
            {/* "비밀번호 미입력시 비밀번호는 필수입니다."를 출력 */}
            {pw.trim() == "" && <p style={{color: "red"}}>비밀번호는 필수입니다.</p>}
            {/* {pw == null && <p>비밀번호는 필수입니다.</p>} */}
            {/* pw == null 이 안되는 이유는 -> 초기값을 useState("") 로 줬기 때문에 ""값을 무조건 가지기 때문 */}

            <button onClick={() => setShow(!show)}>
                {/* 토글 기능을 넣기 -> !show */}
                {show ? "숨기기" : "보이기"}
            </button>

        </section>
    );
}

export default FormEx3;