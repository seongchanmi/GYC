import { useState } from "react";
import LikeBtn from "./child-components/LikeBtn";

function ComEx2() {
    const [ total, setTotal ] = useState(0);

    const handleLike = () => {
        setTotal(prev => prev +1); //이전 값을 받아서 업데이트 하는 방식으로 하는 게 조금 더 안전하다~
    }

    return (
        <section className="borderTop">
            <h2>자식 컴포넌트의 값 받기</h2>
            <p>총 좋아요 수: {total}</p>
            <hr />

            {/* 부모는 상태값만 가지고 자식은 이벤트 함수를 받을 수 있음 -> 값을 자식으로부터 받음 */}
            {/* onLike가 props 이름임 */}
            <LikeBtn onLike={handleLike} /> 
            <LikeBtn onLike={handleLike} /> 
            <LikeBtn onLike={handleLike} /> 
        </section>
    );
}

export default ComEx2;