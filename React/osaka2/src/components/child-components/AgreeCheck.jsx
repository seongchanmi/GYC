function AgreeCheck({text, onAgree, checked}) {
    return (
        <label style={{display: 'block'}}>
            <input type="checkbox" 
            checked={checked}
            onChange={(evt) => onAgree(evt.target.checked)} />
            {text}
        </label>
    );
}

export default AgreeCheck;