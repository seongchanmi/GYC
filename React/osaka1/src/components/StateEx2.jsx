import { use, useState } from 'react';

function StateEx2(props) {
  const [txt, setTxt] = useState("");
  const [msg, setMsg] = useState("");
  const [userid, setUserid] = useState("");
  const [userPw, setUserPw] = useState("");

  return (
    <section className="borderTop">
      <h2>onClick, onChange</h2>
      <h3>event 객체</h3>
      <ul>
        <li>이벤트와 관련된 정보와 기능을 담고 있는 특별한 객체</li>
        <li>이벤트 함수의 첫 번째 매개변수(파라미터)로 전달</li>
        <li>event, evt, e 등의 이름으로 사용</li>
        <li>e.target : 이벤트가 발생한 그 요소</li>
        <li>e.target.value : 이벤트가 발생한 그 요소의 값(form과 관련된 요소)</li>
        <li>e.preventDefault(); : 요소의 기본 기능 삭제(a, form ..)</li>
        <li>e.stopPropagation(); : 이벤트 버블링(자식 -&gt; 부모) 전달 차단</li>
        <li>e.type : 이벤트 종류(keyup, click...)</li>
      </ul>
      <h3>onChange 이벤트 핸들러</h3>
      <p>input, select 등에서 값이 변할 때 실행. blur(커서가 사라진 상태. 포커스가 없어진 상태)일 때 실행</p>
      <h3>onClick 이벤트 핸들러</h3>

      <div>
        <input
          type="text"
          placeholder='이곳에 작성하세요.'
          value={txt}
          onChange={(evt) => setTxt(evt.target.value)} />
        <p>입력 내용: {txt}</p>
        <button onClick={() => setTxt("")}>초기화</button>
      </div>
      <div>
        <h4>{msg}</h4>
        {/* 버튼에 담겨져 있던 메시지가 h4 영역에 출력 */}
        <button onClick={() => setMsg("곧 점심시간")}>메시지 보여주기</button>
      </div>
      <hr />
      <div>
        {/* 필드에 작성된 값이 p요소에 출력 */}
        <input
          type="text"
          placeholder='아이디를 입력하세요.'
          value={userid}
          onChange={(evt) => setUserid(evt.target.value)} />
        <input type="password" 
        placeholder='비밀번호를 입력하세요.' 
        value={userPw} 
        onChange={(evt) => setUserPw(evt.target.value)} />
        <p>아이디: {userid}</p>
        <p>비밀번호: {userPw}</p>
      </div>
    </section>
  );
}

export default StateEx2;