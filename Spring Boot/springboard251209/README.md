# spirng board

- 포스팅(이미지 첨부)
- 댓글
- 회원가입/로그인

----------------------

## 공통
base URL: /api

### 게시글
- GET         /api/posts              목록조회
- GET         /api/posts/{postid}     상세조회
- POST        /api/posts/             게시글 작성(인증 필요)
- PUT         /api/posts/{postid}     수정(작성자만)
- DELETE      /api/posts/{postid}     삭제(작성자만)

### 이미지
- POST        /api/files/image       이미지 url로 반환