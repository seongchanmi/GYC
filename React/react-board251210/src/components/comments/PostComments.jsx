import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { fetchComments } from "../../api/commentApi";
import { useState } from "react";
import { Box, Paper, TextField, Typography } from "@mui/material";
import Loader from "../common/Loader";
import ErrorMessage from "../common/ErrorMessage";

function PostComments({ postId }) {

    const queryClient = useQueryClient();

    // 새 댓글 입력
    const [newContent, setNewContent] = useState("");

    // 수정 모드
    const [edit, setEdit] = useState(false);

    // 수정 댓글 입력
    const [editContent, setEditContent] = useState("");

    // TanStack Query ========================
    // 조회
    const {
        data: comments = [],
        isLoading: isCommentsLoading,
        isError: isCommentsError,
        // 컴포넌트 안에 또 컴포넌트... 이런식으로 가기 때문에 같은 이름이면 충돌이 일어날 수 있으니까 이름을 바꿔줌
        error } = useQuery({
            queryKey: ['postComments', postId],
            queryFn: () => fetchComments(postId)
        });

    //작성
    const createMutation = useMutation({
        mutationFn: (content) => createComment(postId, { content }),
        // content는 아래에서 (return의 영역에서 입력 받은 값)을 매개변수로 넘겨주는 것임
        onSuccess: () => {
            setNewContent(""); // 작성이 성공하면 필드값을 지워(초기화)
            queryClient.invalidateQueries({ queryKey: ['postsComments', postId] });
        },
        onError: () => {
            alert('댓글 등록에 실패했습니다.')
        }
    }); // .mutate(newContent);

    //수정
    const updateMutation = useMutation({

    });

    //삭제
    const deleteMutaion = useMutation({

    });

    // 이벤트 핸들러 =========================

    return (
        <Box>
            <Typography variant='h6' sx={{ fontWeight: 600, mb: 1, fontSize: 16 }}>댓글</Typography>

            {isCommentsLoading && <Loader />}
            {isCommentsError && <ErrorMessage />}

            {/* 댓글 목록 */}
            <Paper>
                <TextField />
            </Paper>
        </Box>
    );
}

export default PostComments;