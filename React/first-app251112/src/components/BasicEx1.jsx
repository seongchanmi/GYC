import React from 'react';

//rsc : 리터럴 방식 함수

/* 컴포넌트의 약속된 값
1. 문서명과 컴포넌트명은 동일
2. 컴포넌트명의 첫글자는 반드시 대문자
3. vite는 확장자명이 반드시 .jsx
*/


const BasicEx1 = () => {
    const user = '한라봉';
    const a = 10, b = 20;
    return (
        <section className='borderBottom'>
            <h2>JSX에서 지역 변수 출력하기</h2>
            <p>안녕하세요? <strong style = { {fontSize: 20, backgroundColor:'orange'} }>{ user }</strong>님</p>
            <p>{user}님<br />
            {a} + {b}는 몇 개일까요?
            </p>
            <p>정답은 {a + b}입니다.</p>
        </section>
    );
};

export default BasicEx1;