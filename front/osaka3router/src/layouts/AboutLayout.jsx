import { Link, Outlet } from "react-router";

// about 전용 레이아웃
function AboutLayout() {
    return (
        <div>
            <h2>소개 페이지</h2>

            <nav>
                <Link to="/about">소개 메인</Link> | 
                <Link to="/about/company">회사 소개</Link> | 
                <Link to="/about/family">구성원 소개</Link>
            </nav>

            {/* 또 한 번 중첩되는 영역 */}
            <Outlet />
        </div>
    );
}

export default AboutLayout