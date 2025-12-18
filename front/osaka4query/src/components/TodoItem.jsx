import { useState } from "react";
import TodoImage from "./TodoImage";
import dayjs from "dayjs";
import { Box, Button, IconButton, ListItem, Stack, TextField, Tooltip } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete"
import CancelIcon from '@mui/icons-material/Cancel';
import EditIcon from '@mui/icons-material/Edit';
import HourglassBottomIcon from '@mui/icons-material/HourglassBottom';
import TaskAltIcon from '@mui/icons-material/TaskAlt';

function TodoItem({
    todo,
    onToggleDone,
    onDelete,
    onUpdate,
    isTogglePending,
    isDeletePending,
    isUpdatePending
}) {
    const { id, content, regDate, isCompleted, imageUrl } = todo;

    const [isEdit, setIsEdit] = useState(false);
    const [editInput, setEditInput] = useState(content);

    const apiBase = import.meta.env.VITE_API_BASE_URL;
    // 이미지 경로
    const imageSrc = imageUrl ? `${apiBase}${imageUrl}` : null;

    // 완료 토글
    const handleToggle = () => onToggleDone(id);

    // 삭제
    const handleDelete = () => onDelete(id);

    // 수정 시작
    const handleStartEdit = () => {
        setIsEdit(true);
        setEditInput(content); // 항상 최신 내용으로 초기화
    };

    //취소
    const handleCancel = () => {
        setIsEdit(false);
        setEditInput(content); //원래 내용으로 롤백
    };

    // 수정 저장
    const handleSave = () => {
        const input = editInput.trim();
        if (input === " ") return;
        onUpdate(id, input); // 부모 컴포넌트(서버 처리)에 결과값을 반환
        setIsEdit(false);
    }

    return (
        <ListItem divider>
            {/* 체크박스 */}
            <input type="checkbox"
                checked={isCompleted == "Y"}
                onChange={handleToggle}
                disabled={isTogglePending}
            />

            {/* 이미지 있으면 출력 */}
            {imageSrc && <TodoImage src={imageSrc} alt={`img${id}`} />}

            {/* 내용 + 수정 버튼(완료, 취소) */}
            {isEdit ? (
                <>
                    {/*수정 중일 때 */}
                    <Box
                        component="form"
                        onSubmit={handleSave}
                        sx={{
                            mt: 3,
                            mb: 3,
                            display: "flex",
                            alignItems: "center",
                            gap: 1
                        }}>

                        <TextField
                            fullWidth size="small"
                            value={editInput}
                            onChange={(evt) => setEditInput(evt.target.value)}
                            sx={{ flex: 1 }}
                        />

                        <Tooltip title="수정 저장">
                            <IconButton
                                type="submit"
                                variant="contained"
                                onClick={handleSave}
                                disabled={isUpdatePending}>
                                {isUpdatePending ? <HourglassBottomIcon color="primary" /> : <TaskAltIcon color="primary" />}
                            </IconButton>
                        </Tooltip>

                        {/* <Button
                            type="submit"
                            variant="contained"
                            onClick={handleSave}
                            disabled={isUpdatePending}>
                            {isUpdatePending ? '저장 중...' : '저장'}
                        </Button> */}

                        <Tooltip title="취소">
                            <IconButton
                                type="reset"
                                variant="outlined"
                                onClick={handleCancel}>
                                <CancelIcon color="secondary" />
                            </IconButton>
                        </Tooltip>

                        {/* <Button
                            type="reset"
                            variant="outlined"
                            onClick={handleCancel}>
                            취소
                        </Button> */}
                    </Box>
                </>
                /*            
                <input 
                type="text"
                value={editInput}
                onChange={(evt) => setEditInput(evt.target.value)} />
                <button onClick={handleSave} disabled={isUpdatePending}>
                {isUpdatePending ? '저장 중...' : '저장'}
                </button>
                <button type="reset" onClick={handleCancel}>취소</button>
                */
            ) : (
                <>
                    {/* 수정 중이 아닐 때 */}
                    <p style={{
                        fontSize: 20,
                        display: 'inline-block',
                        marginRight: 10,
                        color: isCompleted === "Y" ? '#999' : '#000',
                        textDecoration: isCompleted === "Y" ? 'line-through' : 'none'
                    }}>{content} -
                        <span style={{ fontSize: 13, fontStyle: 'italic' }}>
                            {dayjs(regDate).format("YY년 MM월 DD일 HH시 mm분")}
                        </span>
                    </p>

                    <Tooltip title="수정">
                        <IconButton onClick={handleStartEdit}>
                            {isUpdatePending ? <HourglassBottomIcon color="primary" /> : <EditIcon color="primary" />}
                        </IconButton>
                    </Tooltip>

                    {/* <button onClick={handleStartEdit}>
                        {isUpdatePending ? '수정 중...' : '수정'}
                    </button> */}
                </>
            )}

            {/* 삭제 버튼 */}
            <Tooltip title="삭제">
                <IconButton
                    onClick={handleDelete}
                    disabled={isDeletePending}
                    sx={{ ml: 1 }}>
                    {isDeletePending ? <HourglassBottomIcon /> : <DeleteIcon />}
                </IconButton>
            </Tooltip>
            {/* <button
                onClick={handleDelete}
                disabled={isDeletePending}>
                {isDeletePending ? '삭제 중...' : '삭제'}
            </button> */}
        </ListItem >
    );
}

export default TodoItem;