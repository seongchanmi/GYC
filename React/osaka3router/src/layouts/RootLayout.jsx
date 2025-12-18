import { NavLink, Outlet } from "react-router";

// 공통 레이아웃
function RootLayout() {

    const onStyle = {
        backgroundColor: "darkcyan",
        color: "#fff",
        textDecoration: "none",
        borderRadius: "4px",
        fontWeight: "bold",
        padding: "0 10px"
    }

    const deStyle = {
        textDecoration: "none",
        color: "#000",
        padding: "4px 10px",
    }

    const navStyle = ({isActive}) => isActive ? onStyle : deStyle;



    return (
        <div>
            <NavLink to="/" style={navStyle}>홈</NavLink> |
            <NavLink to="/photos" style={navStyle}>앨범</NavLink> |
            <NavLink to="/about" style={navStyle}>소개</NavLink> |
            <NavLink to="/products" style={navStyle}>제품</NavLink>
            <NavLink to="/*" style={navStyle}></NavLink>


            <hr />
            {/* 이 부분에 하위 컴포넌트(페이지)가 들어옴 */}
            <Outlet />
        </div>
    );
}

export default RootLayout;