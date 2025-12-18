// import axios from 'axios';
import { api } from './api';

/*
axios
응답시 상태 검증하여 자동으로 에러 처리 (=에러가 있으면 자동으로 throw 해준다는 말)
JSON 자동 변환
헤더값 설정 자동

응답 값은 항상 data
*/

export async function fetchTodos() {
    // const res = await axios.get("http://localhost:8080/todos");
    const res = await api.get('/todos');
    console.log(res.data);
    return res.data;
}

// 추가 
export async function createTodo(content) {
    /*
    const res = await fetch("http://localhost:8080/todos", {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({content})
    })
    if(!res.ok) return new Error("등록 실패");
    return res.json();
    */
    // const res = await axios.post("http://localhost:8080/todos", { content });
    const res = await api.post('/todos', { content });
    return res.data
}

// 완료 여부 토글
export async function toggleTodoDone({ id, isCompleted }) {
    // const res = await axios.patch(`http://localhost:8080/todos/${id}/done`, { isCompleted });
    const res = await api.patch(`/todos/${id}/done`, { isCompleted });
    return res.data; // 서버에서 수정된 TodoDto 반환
}

// 삭제
export async function deleteTodo(id) {
    const res = await api.delete(`/todos/${id}`);
    return res.data !== undefined && res.data !== null ? res.data : true; // 돌려 받는 데이터가 없어서
}

// 전체 수정 content, isCompleted, imageUrl
export async function updateTodo({ id, content, isCompleted, imageUrl }) {
    const res = await api.put(`/todos/${id}`, { id, content, isCompleted, imageUrl }); // { id, content, isCompleted, imageUrl }는 수정하는 값이 아니고, 넘겨주는 데이터임
    return res.data; //서버에서 수정된 TodoDto 반환
}