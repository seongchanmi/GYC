import { Box, Button, Container, Stack, Typography } from "@mui/material";
import { Link, Outlet } from "react-router";
import { TiMessages } from "react-icons/ti";

function AppLayout() {
    return (
        <Box sx={{ minHeight: '100vh', bgcolor: '#e6e6fa', pb: 6 }}>
            {/* header */}
            <Box
                component="header" sx={{
                    position: 'fixed',
                    top: 0,
                    zIndex: 10,
                    bgcolor: '#dda0dd',
                    borderBottom: '1px solid #dda0dd',
                    width: '100%',
                }}>
                <Container maxWidth="sm" sx={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', height: 60 }}>
                    <Box component={Link} to="/posts"
                        sx={{
                            display: 'flex',
                            alignItems: 'center', // flex일 때만 가능한 위 아래 중앙 정렬
                            textDecoration: 'none'
                        }}>
                        <Box sx={{
                            width: 40, height: 40,
                            bgcolor: '#fff',
                            borderRadius: '50%', // 모서리 둥글게 처리
                            display: 'grid', // 바둑판 형태의 레이아웃 스타일
                            placeItems: 'center', // grid 일 때만 적용 가능한 x, y 축 중앙 정렬
                            mr: 1.5
                        }}>
                            <TiMessages style={{ color: '#9370db', fontSize: 22, }} />
                        </Box>
                        <Typography variant='h6' sc={{ fontweight: 700, color: '#000000ff' }}>
                            게시판
                        </Typography>
                    </Box>
                    {/* 오른쪽 메뉴: 회원가입/로그인 */}
                    <Stack direction="row" spacing={1.5} alignItems="center">
                        <Button component={Link} to="/posts" variant="text" sx={{ fontWeight: 500, color: 'inherit', fontSize: 14 }}>로그인</Button>
                        <Button component={Link} to="/posts" variant="text" sx={{ fontWeight: 500, color: 'inherit', fontSize: 14 }}>회원가입</Button>
                    </Stack>
                </Container>
            </Box>

            {/* 자식 컴포넌트(본문) 영역 */}
            <Container maxWidth="md" sx={{ pt: 10, pb: 6 }}>
                <Outlet />
                {/* Outlet은 자식 컴포넌트가 보여지는 공간 */}
            </Container>
        </Box>
    );
}

export default AppLayout;