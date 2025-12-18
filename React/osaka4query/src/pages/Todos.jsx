import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { useState } from "react";
import TodoItem from "../components/TodoItem";
import { fetchTodos, createTodo, toggleTodoDone, deleteTodo, updateTodo } from "../api/todoApi";
import { Box, Button, Container, IconButton, Paper, TextField, Tooltip, Typography } from "@mui/material";
import AddBoxIcon from '@mui/icons-material/AddBox';
import HourglassBottomIcon from '@mui/icons-material/HourglassBottom';

function Todos() {
    // 클라이언트 객체를 가져와 캐시 무효화
    const queryClient = useQueryClient();
    const [input, setInput] = useState(""); // == content 입력값

    // TanStack Query =====================================================
    // ['todos'] 키로 된 캐시 초기화. 다시 호출해서 최신 데이터로 업데이트
    const refetch = () => {
        queryClient.invalidateQueries({ queryKey: ['todos'] })
    }

    // 조회
    const {
        data: todos = [], // 데이터 객체. 빈배열로 todos 이름으로 설정
        isError, // true/false
        error, // 에러 객체(정보)
        isLoading // 처음 데이터 요청 true/false 
    } = useQuery({
        queryKey: ['todos'], // 캐시 이름이자 쿼리 고유 키. 캐시에 저장된 데이터를 재사용시 씀
        queryFn: fetchTodos // 실제 요청 함수
    });

    // 추가
    const addMutation = useMutation({
        mutationFn: createTodo, // content
        onSuccess: refetch
    });

    // 토글 여부
    const toggleMutation = useMutation({
        mutationFn: toggleTodoDone, //{id, isCompeleted}
        onSuccess: refetch
    });

    // 삭제 Mutation
    const deleteMutation = useMutation({
        mutationFn: deleteTodo,
        onSuccess: refetch
    });

    // 전체 수정 Mutation
    const updateMutation = useMutation({
        mutationFn: updateTodo,
        onSuccess: refetch
    })

    // 이벤트 핸들러 =====================================================
    const handleAddList = (evt) => {
        evt.preventDefault();
        if (input.trim() === "") return;
        addMutation.mutate(input); // 변경 요청 메서드
        setInput("");
    }

    /*
    .mutate(전달값);
    mutationFn 호출 → 실제 서버 요청
    요청 성공 → onSuccess 콜백 실행 : true / false (isPending과 함께 쓸 수 있음)
    요청 실패 → onError 콜백 실행(작성한 경우) : true / false, error 객체에 값을 넘김
    비동기 요청동안 상태 관리 가능: isPending(요청 상태)
    */

    // 완료 여부 토글 -> TodoItem에 id만 넘김
    const onToggleDone = (id) => {
        const target = todos.find((todo) => todo.id == id);
        if (!target) return;

        const nextFlag = target.isCompleted === "Y" ? "N" : "Y"
        toggleMutation.mutate({
            id: target.id,
            isCompleted: nextFlag,
        });
    }

    // 삭제 버튼
    const onDelete = (id) => {
        deleteMutation.mutate(id);
    }

    // 수정 + 저장 버튼
    const onUpdate = (id, content) => {

        const target = todos.find(todo => todo.id === id);
        if (!target) return;

        updateMutation.mutate({
            id,
            content,
            isCompleted: target.isCompleted,
            imageUrl: target.imageUrl ?? null // 널인듯 nullish 연산자
        });
    }

    if (isLoading) return <p>데이터 불러오는 중...</p>
    if (isError) return <p style={{ color: '#f00' }}>오류: {error?.message}</p>

    return ( // return 영역은 뷰에서 보여지는 영역
        // 중앙 정렬을 위한 반응형 레이아웃 박스
        <Container maxWidth="md">
            <Paper sx={{ p: 4 }} elevation={1}>
                <Typography variant="h5" gutterBottom>
                    📝Todos(TanStack Query + DB)
                </Typography>
                {/* <h1>📝Todos(TanStack Query + DB)</h1> */}

                <Box component="form" onSubmit={handleAddList}
                    sx={{
                        mt: 3,
                        mb: 3,
                        display: "flex",
                        alignItems: "center",
                        gap: 1
                    }}>

                    <TextField fullWidth size="small" label="할 일 입력"
                        sx={{ mt:2, flex: 1 }}
                        value={input}
                        onChange={(evt) => setInput(evt.target.value)} />
                        
                    <Tooltip title="추가">
                    <IconButton type='submit' variant='outlined' disabled={addMutation.isPending} sx={{ mt: 2 }}>
                        {addMutation.isPending ? <HourglassBottomIcon /> : <AddBoxIcon color="primary" fontSize="large"/>}
                    </IconButton>
                    </Tooltip>

                    {/* <Button type='submit' variant='outlined' disabled={addMutation.isPending} sx={{ mt: 2 }}>
                        {addMutation.isPending ? '추가 중...' : '추가'}
                    </Button> */}

                </Box>

                <ul>
                    {
                        todos.map((todo) => (
                            <TodoItem key={todo.id}
                                todo={todo}
                                onToggleDone={onToggleDone}
                                onDelete={onDelete}
                                onUpdate={onUpdate}
                                isTogglePending={toggleMutation.isPending}
                                isDeletePending={deleteMutation.isPending}
                                isUpdatePending={updateMutation.isPending}
                            />

                        ))
                    }
                </ul>
            </Paper>
        </Container>
    );
}

export default Todos;