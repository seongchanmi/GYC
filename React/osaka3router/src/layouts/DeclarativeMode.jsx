import { BrowserRouter, Link, Route, Routes } from "react-router"
import Home from "../pages/Home"
import About from "../pages/About"
import NotFoundPage from "../Pages/NotFoundPage";

function DeclarativeMode() {
    return (
        <BrowserRouter>
            <nav>
                {/* <a></a> 태그는 링크와 관련된 태그 */}
                {/* <a href="/">홈</a> | <a href="/about">소개</a> | <a href="#">위로</a> */}

                <Link to="/">홈</Link> | <Link to="/about">소개</Link> | <Link to="/products">제품</Link>
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                {/* 페이지를 찿을 수 없을 때. 항상 제일 마지막에 작성 */}
                <Route path="*" element={<NotFoundPage />} />
            </Routes>
        </BrowserRouter>
    );
}

export default DeclarativeMode;