import React from 'react';

function BasicEx2(props) {
    const imgUrl = 'https://placehold.co/400x200/orange/fff?text=img';
    const desc = '임시 이미지(placeholder image)';
    return (
        <section className='borderBottom'>
        <h2>JSX 속성 바인딩</h2>
        <img src={imgUrl} alt={desc} />
        </section>
    );
}

export default BasicEx2;