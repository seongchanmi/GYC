import React, { Children } from 'react';

function BasicEx4({ children, title }) {
    return (
        <section className='borderBottom'>
            <h2>children으로 넣기</h2>
            <p>children은 컴포넌트 태그 사이에 있는 내용을 그대로 넣는 특별한 props</p>
            <h3>{title}</h3>
            {children}
        </section>
    );
}

export default BasicEx4;