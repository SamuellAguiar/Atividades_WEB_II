const Settings = () => {
    return (
        <div className="users-container">
            <h2>Configurações do Sistema</h2>
            <div className="user-card" style={{width: '100%', display: 'flex', flexDirection: 'column', gap: '1rem'}}>
                <label><input type="checkbox"/> Ativar modo noturno</label>
                <label><input type="checkbox" defaultChecked/> Notificações via E-mail</label>
                <button className="user-btn outline" onClick={() => alert("Salvo!")}>Salvar Alterações</button>
            </div>
        </div>
    );
};
export default Settings;