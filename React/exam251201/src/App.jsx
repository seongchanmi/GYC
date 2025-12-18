import { createBrowserRouter, RouterProvider } from 'react-router';
import './App.css'
import Home from './pages/Home';
import RootLayout from './layouts/RootLayout';
import ProductsLayout from './layouts/ProductsLayout';
import Users from './pages/Users';
import UsersError from './pages/UsersError';
import NotFoundPage from './pages/NotFoundPage';
import ProductsError from './pages/ProductsError';
import ProductInput from './pages/ProductInput';
import ProductOutput from './pages/ProductOutput';
import Customer from './pages/Customer';

async function dataLoader() {
  const res = await fetch('/api/users');

  if(!res.ok) throw new Error("데이터 못 불러옴");

  const data = await res.json();
  console.log(data);

  return data;
}

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      {
        index: true,
        element: <Home />
      },
      {
        path: "users",
        element: <Users />,
        loader: dataLoader,
        errorElement: <UsersError />
      },
      {
        path: "products",
        element: <ProductsLayout />,
        errorElement: <ProductsError />,
        children: [
          {
            index: true,
            element: <ProductInput />
          },
          {
            path: "output",
            element: <ProductOutput />
          },
          {
            path: "customer",
            element: <Customer />
          }
        ]
      },
      {
        path: "*",
        element: <NotFoundPage />
      }
    ]
  }
]);

function App() {
  return <RouterProvider router={router} fallbackElement={<div>로딩중...</div>} />
}

export default App;