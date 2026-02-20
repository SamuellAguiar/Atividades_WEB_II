import './App.css'

import { RouterProvider } from 'react-router-dom';
import { routes } from './Routes/routes.tsx'

import Header from './components/header/Header'

function App() {


    return (
        <>
            <div>
                <Header/>

                <RouterProvider router={routes}/>

            </div>
        </>
    )
}

export default App
