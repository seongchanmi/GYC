import { useRouteError } from 'react-router';

function TodosError() {
    const error = useRouteError();

    return (
        <div>
            <h2>TodosError</h2>
            <p style={{color: '#f00'}}>{error?.statusText || error?.message}</p>
        </div>
    );
}

export default TodosError;