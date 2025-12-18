// 자식 컴포넌트

// 컴포넌트는 함수형태로 이루어져있음
// 함수는 정해진 방식으로 값을 받고 정해진 방식으로 값을 돌려줌
// return은 랜더링이 되는 영역
// props(={text})를 내려줌
function ColorPicker({ text, color }) {
    return (
        <div style={{
            backgroundColor: color,
            padding: 6,
            borderRadius: 10
        }}>
           <p>{text}의 컬러값은 {color}</p>
        </div>
    );
}

export default ColorPicker;