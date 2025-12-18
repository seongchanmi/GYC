import { useState } from 'react'
import reactLogo from './assets/react.svg' // './': 상대경로
import viteLogo from '/vite.svg' // '/': 절대 경로
import './App.css'
import BasicEx1 from './components/BasicEx1'
import BasicEx2 from './components/BasicEx2'
import BasicEx3 from './components/BasicEx3'
import BasicEx4 from './components/BasicEx4'
import BasicEx5 from './components/BasicEx5'
import BasicEx6 from './components/BasicEx6'

// 자바스크립트 영역

/*
JSX
JavaScript + XML
html처럼 보이는 자바스크립트로 브라우저가 직접 해석할 수 없기 때문에 babel과 같은 트랜스파일을 통해 실행
빌드 시 자바스크립트 언어로 변경

html5: <br>, <hr>, <img>
xml: <br />, <hr />, <img />

<>, <fragment></fragment> : fragment
반드시 부모 요소로 전체를 감싸야 한다
(<foam>을 쓰던지 <div>를 쓰던지 <>를 쓰던지)
렌더링이 될 때 html 구조를 만들지 않음
*/

// 자바스크립트 객체
// 전역 영역, 전역 변수
const borderStyle = {
  //"키": "값", 키: '값', 키
  borderBottom : '2px solid lightskyblue', 
  padding : 16,
  margin : '16px 0'
};

function App() {
  const [count, setCount] = useState(0)
// 자바스크립트 영역
  return (
    <>
    {/* JSX 영역 주석 처리 방법 */}

    {/* 하위, 자식 컴포넌트 연결 */}
    <BasicEx6 />
    <BasicEx5 />
    <BasicEx4 title="특수한 props">
      <p>내일은 즐거운 금요일!</p>
      <p>붕어빵 개시!</p>
    </BasicEx4>
    <BasicEx3 name="props" />
    <BasicEx2 />
    <BasicEx1 />
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div style={borderStyle}>
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>



    </>
  )
}

export default App
