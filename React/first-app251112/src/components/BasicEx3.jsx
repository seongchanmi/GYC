import React from 'react';
import BasicEx3Child from './BasicEx3Child';

function BasicEx3({ name }) {
    return (
        <section className='borderBottom'>
            <h2>{ name }로 데이터 전달</h2>
            <ul>
                <li>{ name }는 부모가 자식에게 전달하는 값(속성)</li>
                <li>자식은 { name }를 읽기 전용으로만 사용 가능</li>
                <li>변수, 함수(state 변경용) 모두 전달 가능</li>
                <li>자식에게서부터 부모로 { name } 전달은 기본적으로 안됨</li>
            </ul>
            <BasicEx3Child menu = "매콤달걀떡국"/>
            <BasicEx3Child menu = "오삼불고기"/>
            <BasicEx3Child menu = "메추리알조림"/>
        </section>
    );
}

export default BasicEx3; 