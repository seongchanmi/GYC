import './App.css'
import RootLayout from './layouts/RootLayout';
import { createBrowserRouter, RouterProvider} from 'react-router';
import Home from './pages/Home';
import Todos from './pages/Todos';
import NotFoundPage from './pages/NotFoundPage';
import RootError from './pages/RootError';
import TodosError from './pages/TodosError';

// 라우터 트리 생성
// /, <Home />
// todos, <Todos />

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
        path: "todos",
        element: <Todos />,
        errorElement: <TodosError />
      },
      {
        path: "*",
        element: <NotFoundPage />
      }
    ],
    errorElement: <RootError />
  }
])

function App() {
  return <RouterProvider router={router} />
}

export default App;