import { useState } from "react";
import ColorPicker from "./child-components/colorPicker";

function ComEx1() {
    const [color, setColor] = useState("#eee");

    return (
        <section className="borderTop">
            <h2>부모 상태 공유</h2>
            <p>컬러값: {color}</p>
            <input type="color" 
            value={color}
            onChange={(evt) => setColor(evt.target.value)}
            />
            <hr />

            {/* 부모 -> 자식으로 상태 props 전달 */}
            <div style={{display: "flex", gap: 16}}>
            {/* props명=값 */}
            <ColorPicker text="box1" color={color} />
            <ColorPicker text="box2" color={color} />

            {/* type="color" 
            value={color}
            onChange={(evt) => setColor(evt.target.value)}  */}
            </div>
        </section>
    );
}

export default ComEx1