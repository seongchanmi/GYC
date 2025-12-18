import { useState } from "react";


function ProductList() {
    const [text, setText] = useState("");
    const [list, setList] = useState([]);
    const [id, setId] = useState(1);
    const [editId, setEditId] = useState(null);
    const content = text;

    const add = () => {
        const product = text.trim();
        if (!product) return;
        setId(prev => prev +1);
        setList((prev) => [...prev, { id: id, product }]);
        setText("");
    }

    // 삭제
    const remove = (id) => {
        setList(prev => prev.filter(item => item.id !== id));
    }

    // 수정
    const startEdit = (id, product) => {
        setEditId(id);
        setText(product);
    }

    const saveEdit = () => {
        setList(prev => 
            prev.map(item => item.id == editId ? { ...item, product: text } : item)
        );
        setEditId(null);
        setText("");
    }

    return (
        <>
            <h2>제품 리스트 (자동 증가 ID)</h2>
            <input type="text"
                placeholder="제품명을 입력"
                value={text}
                onChange={(evt) => setText(evt.target.value)}
                onKeyDown={(evt) => {
                    if(evt.key == "Enter") {
                        if(editId == null) {
                            add();
                            } else {
                                saveEdit();
                            }
                }}} />
                
            {
                editId == null ?
                <button onClick={add} disabled={!content}>입력</button> :
                <button onClick={saveEdit}>수정완료</button>
            }

            <ul>
                {list.map(({ id, product }) => (
                    <li key={id}>
                        {id}번 제품명: {product}
                        <button onClick={() => startEdit(id, product)}>수정</button>
                        <button onClick={() => remove(id)}>삭제</button>
                    </li>
                ))}
            </ul>



        </>
    );
}

export default ProductList;