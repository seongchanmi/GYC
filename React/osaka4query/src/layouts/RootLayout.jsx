import { AppBar, Box, IconButton, Toolbar, Typography, Button } from "@mui/material";
import { Link, Outlet } from "react-router";
import MenuIcon from '@mui/icons-material/Menu';
import HomeRoundedIcon from '@mui/icons-material/HomeRounded';
import ListAltIcon from '@mui/icons-material/ListAlt';

function RootLayout() {

    // const onStyle = {
    //     backgroundColor: "mediumpurple",
    //     color: "#fff",
    //     textDecoration: "none",
    //     borderRadius: "4px",
    //     fontWeight: "bold",
    //     padding: "0 10px"
    // }

    // const deStyle = {
    //     textDecoration: "none",
    //     color: "#000",
    //     padding: "4px 10px",
    // }

    // const navStyle = ({ isActive }) => isActive ? onStyle : deStyle;

    const navLayout = {
        display: 'flex',
        gap: 18,
        listStyle: 'none',
        padding: 0
    }

    const navList = {
        color: 'mediumpurple',
        textDecoration: 'none',
        padding: '4px 8px',
        display: 'inline-block',
    }

    return (
        <Box sx={{ bgcolor: "#e6e6fa", minHeight: "100vh" }}>
            {/* 상단 헤더 */}
            <AppBar position="static">
                <Toolbar>
                    <IconButton
                        size="large"
                        edge="start"
                        color="inherit"
                        aria-label="menu"
                        sx={{ mr: 2 }}
                    >
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6"
                        component={Link}
                        to="/"
                        sx={{ flexGrow: 1, textDecoration: "none", color: "inherit" }}>
                        Todos Logo
                    </Typography>
                    <IconButton sx={{ color: '#ffffff' }} component={Link} to="/">
                        <HomeRoundedIcon fontSize="large" />
                    </IconButton>
                    <IconButton sx={{ color: '#ffffff' }} component={Link} to="/todos">
                        <ListAltIcon fontSize="large" />
                    </IconButton>
                    {/* <Button color="inherit" component={Link} to="/">홈</Button> */}
                    {/* <Button color="inherit" component={Link} to="/todos">todos</Button> */}
                </Toolbar>
            </AppBar>

            {/* <ul style={navLayout}>
                <li><Link to="/" style={navList}>Home</Link></li>
                <li><Link to="/todos" style={navList}>Todos</Link></li>
                <Link to="/*"></Link>
            </ul>
            <hr /> */}

            <Box sx={{ p: 3 }}>
                <Outlet />
            </Box>

        </Box>
    );
}

export default RootLayout;