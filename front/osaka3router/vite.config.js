import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
// Server Options → server.proxy → Example
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': { // 리액트에서 /api/**로 요청 → vite가 대신 외부 서버로 요청
        target: 'https://jsonplaceholder.org',
        changeOrigin: true, // Origin 헤더에 http://localhost:5173/ → jsonplaceholder.org로 변경
        secure: false, // HTTPS 인증서 검사를 안하겠다는 뜻 (HTTP와 HTTPS는 아예 다른 것임)
        rewrite: (path) => path.replace(/^\/api/, ''), // /api/posts → posts
      }
    }
  }
})
