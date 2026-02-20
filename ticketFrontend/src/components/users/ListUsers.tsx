import {useState, useEffect} from "react";
import api from "../../services/api";
import "../../styles/Card.css";

interface IUser {
    id: string;
    name: string;
    email: string;
}

const ListUsers = () => {
    const [users, setUsers] = useState<IUser[]>([]);
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");

    // 1. Carregar Usuários
    const loadUsers = () => {
        api<IUser[]>('/api/users')
            .then(response => setUsers(response))
            .catch(error => console.error("Erro ao carregar:", error));
    };

    useEffect(() => {
        loadUsers();
    }, []);

    // 2. Adicionar Usuário (POST)
    const handleAddUser = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await api('/api/users', {
                method: 'POST',
                body: JSON.stringify({
                    name: name,
                    email: email,
                    password: "default_password", // Campo obrigatório
                    city: "Não informada",        // Campo obrigatório
                    creditCardNumber: "0000 0000 0000 0000", // Campo obrigatório
                    creditCardNetworkID: null     // UUID ou null
                })
            });
            setName("");
            setEmail("");
            loadUsers();
        } catch (error) {
            alert("Erro ao salvar. Verifique o console do IntelliJ.");
        }
    };

    // 3. Remover Usuário (DELETE)
    const handleRemove = async (id: string) => {
        if (!window.confirm("Deseja remover este usuário?")) return;
        try {
            // Seu Controller espera um DeleteUserDTO no corpo da requisição
            await api('/users/remove', {
                method: 'DELETE',
                body: JSON.stringify({id: id})
            });
            loadUsers();
        } catch (error) {
            alert("Erro ao remover");
        }
    };

    return (
        <div className="users-container">
            <h2>Gestão de Usuários</h2>

            {/* Formulário de Cadastro */}
            <form onSubmit={handleAddUser} className="card" style={{marginBottom: '20px', padding: '15px'}}>
                <input value={name} onChange={e => setName(e.target.value)} placeholder="Nome" required/>
                <input value={email} onChange={e => setEmail(e.target.value)} placeholder="Email" required/>
                <button type="submit" className="user-btn outline">+ Salvar</button>
            </form>

            <div className="users-grid">
                {users.map(user => (
                    <article className="user-card" key={user.id}>
                        <div className="user-card-head">
                            <span className="user-badge">ID</span>
                            <code className="user-id">{user.id}</code>
                        </div>
                        <p className="user-name">{user.name}</p>
                        <p className="user-email">{user.email}</p>
                        <div className="user-actions">
                            <button onClick={() => handleRemove(user.id)} className="user-btn danger">Remover</button>
                        </div>
                    </article>
                ))}
            </div>
        </div>
    );
};

export default ListUsers;