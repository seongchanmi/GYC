import React from 'react';
const users= [
    { id:1, name:'한라봉', age: 2},
    { id:2, name:'진지향', age: 4},
    { id:3, name:'타이벡', age: 3},
    { id:4, name:'유라조생', age: 5}
];

const data = [
    { no:10, name: '감홍', email: 'aaa.com'},
    { no:20, name: '부사', email: 'bbb.com'},
    { no:30, name: '홍옥', email: 'ccc.com'}
]
    
function ListEx2() {
    const nav = ['home', 'about', 'intro'];

    return (
        <section className="borderTop">
        {/* 구조분해할당 */}
        <ol>
            {data.map(({no, name, email}) => (
            <li key={no}>
                <p>이름: {name}</p>
                <p>이메일: {email}</p>
            </li>
            ))}
        </ol>

            <h2>리스트 안에 버튼 넣기</h2>
              <ul>
                {nav.map((menu,idx) => (
                 <li key={idx}>
                    <button>{menu}</button>
                 </li>
                ))}
        </ul>
        <hr/>

        <h2>객체 리스트 렌더링</h2>
        <ul>
            {users.map((user) => 
            <li key={user.id}>
                {"이름:" + user.name + " / 나이: "+ user.age}
            </li>
            )}
        </ul>
        <hr />
        
        <ol>
            {data.map((item, no) => (
            <li key={no}>
                {/* {"이름: " + item.name + " / 이메일: " + item.email} */}
                <p>이름: {item.name}</p>
                <p>이메일: {item.email}</p>
            </li>
            ))}
        </ol>


        </section>
    );
}

export default ListEx2;