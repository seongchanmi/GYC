// 입력 컴포넌트
function SearchBox({value, onQuery}) {
    return (
        <div>
            <input type="search"
            placeholder="검색어를 입력하세요"
            value={value}
            onChange={evt => onQuery(evt.target.value)} />
        </div>
    );
}

export default SearchBox;