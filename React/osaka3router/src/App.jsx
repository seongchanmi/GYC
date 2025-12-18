import { createBrowserRouter, RouterProvider } from 'react-router';
import './App.css'
import RootLayout from './layouts/RootLayout';
import Home from './pages/Home';
import About from './pages/About';
import Products from './pages/Products';
import NotFoundPage from './Pages/NotFoundPage';
import AboutLayout from './layouts/AboutLayout';
import Company from './Pages/Company';
import Family from './Pages/Family';
import AboutError from './Pages/AboutError';
import Photos from './Pages/Photos';
import PhotosError from './Pages/PhotosError';

// Data 모드 loader 설정 
async function photosLoader() {
  // const res = await fetch("https://jsonplaceholder.org/posts");
  const res = await fetch('/api/posts');

  if(!res.ok) throw new Error("앨범 데이터 못 불러옴");

  const data = await res.json();
  console.log(data);

  return data; // useLoaderData()로 받음
}

// 라우트 트리 생성
const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />, // 공통 레이아웃
    children: [// RootLayout 컴포넌트 안에서 변경되는 컴포넌트(페이지)
      {
        index: true, // path: "/"랑 같은 의미. "첫 페이지"라는 의미라능. 첫 페이지라서 index를 쓴 거라능
        element: <Home />
      },
      {
        path: "photos",
        element: <Photos />,
        loader: photosLoader, // Data Router loader: 로더 함수
        errorElement: <PhotosError />
      },
      {
        path: "about", // 슬래시(/)로 시작하지 않음. 부모 경로 슬래시(/) 기준으로 뒤에 붙기 때문. declarative 모드에는 앞에 슬래시(/)로 시작함. 
        element: <AboutLayout />,
        // 가장 가까운 컴포넌트의 errorElement 적용
        // 렌더링 중 오류가 발생하면 보여지는 컴포넌트
        errorElement: <AboutError />,
        children: [
          {
            index: true, 
            element: <About />
          },
          {
            path: "company",
            element: <Company />
          },
          {
            path: "family",
            element: <Family />
          },
        ]
      },
      {
        path: "products",
        element: <Products />
      },
      {
        path: "*",
        element: <NotFoundPage />
      }
      ]
  },
]);

function App() {
  // 해당 컴포넌트에 연결
  return <RouterProvider router={router} />
}

export default App;