import { useState, useEffect } from "react";
import api from "../../services/api";

const UserProfile = () => {
    const [user, setUser] = useState<any>(null);

    useEffect(() => {
        api<any[]>('/api/users').then(response => {
            if (response && response.length > 0) setUser(response[0]);
        }).catch(err => console.error("Erro ao carregar perfil", err));
    }, []);

    if (!user) return <div className="block-container">Carregando perfil...</div>;

    return (
        <div className="users-container">
            <h2>Meu Perfil</h2>
            <article className="user-card" style={{ width: '100%', maxWidth: '400px' }}>
                <p><strong>Nome:</strong> {user.name}</p>
                <p><strong>Email:</strong> {user.email}</p>
                <p><strong>ID:</strong> {user.id}</p>
            </article>
        </div>
    );
};
export default UserProfile;