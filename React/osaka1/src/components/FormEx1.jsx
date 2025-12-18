import React, { useState } from 'react';

function FormEx1() {
    //react에서 상태 변화를 자동으로 감지하고 업데이트 시켜주는 hook -> useState
    /*
    문자열 초기값: ""
    숫자 초기값: 0
    객체 초기값(은 상황에 따라 다르지만): null, {}
    배열 초기값: []
    boolean 초기값: false
    */

    // 객체는 키:값 의 형태로 구성

    const [name, setName] = useState("");
    const [age, setAge] = useState(0);

    const [form, setForm] = useState({userId:"", phone:""});

    const change = (evt) => {
        setForm( { ...form, [evt.target.name] : evt.target.value });
    }
    // evt.target.name -> 이벤트가 발생한 요소의 name 속성 값을 가져오는 것
    // ...form -> 스프레드 연산자 / 기존값을 복사해서 펼쳐놓음
    // , [evt.target.name] : evt.target.value  -> 객체(키:값)는 해당되는 부분만 업데이트


    return (
        <section className="borderTop">
            <h2>폼 값 여러 개를 객체로 관리</h2>
            <input type="text"
            placeholder="아이디를 입력하세요"
            name="userId"
            onChange={change} />
            <input type="tell"
            placeholder="연락처를 입력하세요"
            name="phone" 
            onChange={change}/>
            <p>
                아이디: {form.userId} / 연락처: {form.phone}
            </p>
            <hr />

            <h2>입력</h2>
            <input type="text" 
            placeholder="이름을 입력하세요." 
            value={name}
            onChange={ (evt) => {setName(evt.target.value)} }
            />
            <input type="number" 
            placeholder="나이를 입력하세요." 
            value={age}
            onChange={ (evt) => {setAge(evt.target.value)} }
            />
            <p>이름: {name} / 나이: {age}</p>
        </section>
    );
}

export default FormEx1;