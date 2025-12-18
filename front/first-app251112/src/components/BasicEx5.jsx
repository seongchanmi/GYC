import React from 'react';

function BasicEx5(props) {
    const isLogin = true;
    const loginStyle = {fontWeight: isLogin ? "bold" : "normal", color: isLogin ? "orange" : "#330feaff"}

    return (
        <section className='borderBottom'>
            <h2>조건부 렌더링(&&, ? :)</h2>
            <p>
                조건에 따라 보여주기<br />
                로그인 여부에 따라 메시지 변경
            </p>
            <hr />
            {/* &&연산자. 앞의 조건이 참이면 뒤의 구문이 출력 */}
            {isLogin && <p style={loginStyle}>로그인 상태입니다.</p>}
            <p style={loginStyle} className={isLogin ? "bgColor" : ""}>{ isLogin ? "관리자 페이지로 이동합니다." : "로그인이 필요합니다."}</p>
        </section>
    );
}

export default BasicEx5;