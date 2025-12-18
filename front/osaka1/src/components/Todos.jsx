import { useState } from "react";
import { v4 as uuid } from "uuid"; // package.json에 dependendies에 uuid 설치 되어 있음

function Todos() {
    const [list, setList] = useState([]); // [ {id: , text: }, {}, {}]
    const [text, setText] = useState("");
    const [editId, setEditId] = useState(null); // 수정 중인 id 저장

    const add = () => {
        // setList(text);  [ "문자열" ]
        const name = text.trim(); // 앞뒤 여백 지우기
        if (!name) return;
        setList((prev) => [...prev, { id: uuid(), name }]); // text: text 이긴한데, 키와 값이 같으면 그냥 한번만 써도 ㄱㅊ대
        setText(""); // 값 초기화
    }

    // 삭제
    const remove = (id) => {
        // 내가 선택한 아이디값만 빼고 나머지를 반환, 업데이트
        setList(prev => prev.filter(item => item.id !== id));
    }

    // 수정
    const startEdit = (id, name) => {
        setEditId(id);
        setText(name); // 기존 내용을 입력창에 출력
    }

    const saveEdit = () => {
        setList(prev =>
            prev.map(item => item.id == editId ? { ...item, name: text } : item)
        );
        setEditId(null);
        setText("");
    }

    return (
        <>
            <h2>Todo list</h2>
            <input type="text"
                placeholder="할 일 입력"
                value={text} // 값을 초기화 할거면 value를 꼭 써줘야 함
                onChange={(evt) => setText(evt.target.value)}
                onKeyDown={(evt) => {
                    if (evt.key == "Enter") add();
                }} />
            {
                editId == null ?
                    <button onClick={add}>입력</button> : <button onClick={saveEdit}>수정완료</button>
            }

            <hr />

            <ul>
                {list.map(({ id, name }) => ( // 구조분해할당
                    <li key={id} style={{ margin: "16px 0" }}>
                        {name}
                        <button onClick={() => startEdit(id, name)}>수정</button>
                        <button onClick={() => remove(id)}>삭제</button>
                    </li>
                ))}
            </ul>
        </>
    );
}

export default Todos;