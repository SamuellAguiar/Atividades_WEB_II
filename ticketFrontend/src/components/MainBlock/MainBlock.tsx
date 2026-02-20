import "../../styles/MainBlock.css"
import { Outlet } from "react-router-dom"

const MainBlock = () => {
    return (
        <div className="block-container">
            <Outlet></Outlet>
        </div>
    )
}

export default MainBlock