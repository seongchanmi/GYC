
function Tag({text, onToggle, active}) {
    return (
        <button 
        onClick={onToggle}
        style={{
            margin: 6,
            backgroundColor: active ? "orange" : "transparent"
        }}
        >
            {text}
        </button>
    );
}

export default Tag;