import { NavLink, Outlet } from "react-router";

function RootLayout() {

    return (
        <div>
            <NavLink to="/">Home</NavLink> |
            <NavLink to="/users">Users</NavLink> |
            <NavLink to="/products">Products</NavLink> 
            <NavLink to="/*"></NavLink> 

            <hr />
            <Outlet />
        </div>
    );
}

export default RootLayout;