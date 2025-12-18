# 백엔드 #

## entity:
Integer id;
String content;
LocalDateTime regDate;
YnFflag isCompleted; // Y/N
String imageUrl;
 nm    
## json
{
    "id": 1,
    "content": "할 일", // 필수 입력
    "regDate": "2025-11-26 09:35:11",
    "isCompleted": "N", // 선택 입력
    "imageUrl": "pic.png" // 선택 입력
}
j
## URL: /todos
GET         /todos            전체 조회 List<TodoDto>
POST        /todos            등록 TodoDto { content, isCompleted, imageUrl }
PUT         /todos/{id}       전체 수정 TodoDto
PATCH       /todos/{id}/done  수정 { isCompleted }
DELTE       /todos/{id}       삭제 .noContent()  >> 204 상태코드 반환 (=성공)
