import React, { useState } from 'react';

function FormEx2() {
    const [agree, setAgree] = useState(false);
    const [role, setRole] = useState("사용자");
    return (
        <section className="borderTop">
            <h2>체크박스(여러 개 선택 가능) 상태</h2>
            <label htmlFor="role">
                <input type="checkbox" id ="role" 
                checked={agree} // 없어도 작동은 되는데, 명확하게 해주기 위해서 작성해 주는 것이 좋음
                onChange={(evt) => setAgree(evt.target.checked)} />
                약관에 동의합니다.
            </label>
            {/* 체크하면 동의 완료 출력, 하지 않으면 동의 필요 출력 */}
            <p>{ agree ? "동의 완료" : "동의 필요" }</p>
            <hr />

            <h2>라디오버튼(하나만 선택) 상태</h2>
            <label>
                <input type="radio" value="사용자" name="group"
                onChange={evt => setRole(evt.target.value)} /> 사용자
            </label>

            <input type="radio" value="관리자" id="admin" name="group"
             onChange={evt => setRole(evt.target.value)} />
            <label htmlFor="admin">관리자</label>

            <p>모드: {role}</p>

        </section>
    );}

export default FormEx2;