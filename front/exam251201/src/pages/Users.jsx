import { useLoaderData } from "react-router";

function Users() {
    const users = useLoaderData();
    
    return (
        <section className="borderTop">
            <h2>users</h2>

            <h3>User 목록</h3>
            <ol>
                {
                    users.slice(0,5).map((list) => (
                    <li key={list.id}>
                        <h3>{list.username}</h3>
                        <p>{list.email}</p>
                        <p>{list.address.city}</p>
                    </li>
                    ))
                }
            </ol>
        </section>
    );
}

export default Users;