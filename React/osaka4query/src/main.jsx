import { createRoot } from 'react-dom/client'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { ReactQueryDevtools } from '@tanstack/react-query-devtools'
import { createTheme, CssBaseline, ThemeProvider } from '@mui/material'
import App from './App.jsx'

// QueryClient 인스턴스 생성
// API REFERENCE → QueryClient
const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: 1, // 실패시 재시도 횟수
      staleTime: 1000, // 데이터 유지 시간
    }
  }
});

// 기본 스타일 설정. 타이포그래피, 컬러 테마...
const theme = createTheme({
  palette:{
    primary:{
      main: "#9370db"
    },
    secondary:{
      main: "#dda0dd"
    },
    mode: "light"
  },
  typography: {
    fontFamily: ["Song Myung", "-apple-system", "BlinkMacSystemFont", "Helvetica Neue", "Apple SD Gothic Neo", "Arial", "sans-serif"].join(",")
  }
});

createRoot(document.getElementById('root')).render(
  <ThemeProvider theme={theme}>
    <QueryClientProvider client={queryClient}>
      {/* mui가 만들어 놓은 css reset 코드*/}
      <CssBaseline />
      <App />
      {/* Query 개발자 도구 */}
      {/* <ReactQueryDevtools initialIsOpen={false} /> */}
    </QueryClientProvider>
  </ThemeProvider>
)
