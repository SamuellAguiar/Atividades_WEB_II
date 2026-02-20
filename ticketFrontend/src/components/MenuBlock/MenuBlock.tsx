import { Link } from "react-router-dom"
import "../../styles/MenuBlock.css"

const MenuBlock = () => {
    return(
        <div className="menu-container">
            <div className="menu-profile-container"></div>
            <ul className="menu-content">
                <li><Link to="/profile">Perfil</Link></li>
                <li><Link to="/users">Usuários</Link></li>
                <li><Link to="/sales">Vendas</Link></li>
                <li><Link to="/events">Eventos</Link></li>
                <li><Link to="/settings">Configurações</Link></li>
                <li><Link to="/notifications">Notificações</Link></li>
            </ul>
        </div>
    )
}

export default MenuBlock