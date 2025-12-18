import { QueryClient } from '@tanstack/react-query';
import './App.css'
import Products from './Pages/Products'

const queryClient = new QueryClient();

function App() {
  return (
    <>
      <Products />
    </>
  );
}

export default App;