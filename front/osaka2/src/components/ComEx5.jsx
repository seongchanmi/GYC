import { useState, useSyncExternalStore } from "react";
import Tag from "./child-components/Tag";

function ComEx5() {
    const users = ['한라봉', '진지향', '감홍', '타이벡', '유라조생', '유라실생'];
    const [selected, setSelected] = useState([]);

    const toggleTag = (user) => {
        if(selected.includes(user)) {// 이미 선택되었다면 상태 배열에서 제거 !==
            setSelected(selected.filter(u => u !== user)) // filter는 배열에서 돌아간다~
        } else { // 선택이 안되었으면 추가 
            setSelected([...selected, user]);
        }
    }

    return (
        <section className="borderTop">
            <h2>다중 선택 토글</h2>
            { users.map((user, idx) => (
                <Tag key={idx} text={user} onToggle={() => toggleTag(user)} active={selected.includes(user)} />
            ))}
            <p>선택: {selected.join("","") || "없음"}</p>
        </section>
    );
}

export default ComEx5; 