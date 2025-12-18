import { useRouteError } from 'react-router';

function RootError() {
    const error = useRouteError();
    return (
        <div>
            <h2>RootError</h2>
            <p style={{color: '#f00'}}>{error?.statusText || error?.message}</p>
        </div>
    );
}

export default RootError