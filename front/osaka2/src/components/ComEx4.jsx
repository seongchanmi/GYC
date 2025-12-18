import { useState } from "react";
import SearchBox from "./child-components/SearchBox";
import UserList from "./child-components/UserList";

function ComEx4() {
    const users = ['한라봉', '진지향', '감홍', '타이벡', '유라조생', '유라실생'];
    const [query, setQuery] = useState("");

    return (
        <section className="borderTop">
            <h2>입력과 결과 처리 분리</h2>
            <p>부모 컴포넌트가 상태를 가지고 자식 컴포넌트에 상태와 업데이트 함수 전달</p>
            <br />

            <SearchBox value={query} onQuery={setQuery} />
            <UserList query={query} items={users} />
        </section>
    );
}

export default ComEx4;