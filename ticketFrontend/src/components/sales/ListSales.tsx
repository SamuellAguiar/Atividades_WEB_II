import {useState, useEffect} from "react";
import api from "../../services/api";

interface ISale {
    id: string;
    userId: string;
    eventId: string;
    purchaseStatus: number; // No Java é int, melhor manter como number aqui
}

const ListSales = () => {
    const [sales, setSales] = useState<ISale[]>([]);
    const [userId, setUserId] = useState("");
    const [eventId, setEventId] = useState("");

    const loadSales = () => {
        // Rota /sales/list-sales mapeada para o SALES-SERVICE via Gateway
        api<ISale[]>('/sales/list-sales')
            .then(response => {
                console.log("Vendas carregadas:", response);
                setSales(response);
            })
            .catch(error => console.error("Erro ao carregar vendas:", error));
    };

    useEffect(() => {
        loadSales();
    }, []);

    const handleCreateSale = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            // Importante: eventId e userId devem ser UUIDs válidos (strings no JS)
            // purchaseStatus: 1 enviado como número para bater com o 'int' do Record Java
            await api('/sales', {
                method: 'POST',
                body: JSON.stringify({
                    eventId: eventId,
                    userId: userId,
                    purchaseStatus: 1
                })
            });

            setUserId("");
            setEventId("");
            alert("Venda realizada com sucesso!");
            loadSales();
        } catch (error) {
            console.error(error);
            alert("Erro 400: Verifique se os IDs são UUIDs válidos e se os serviços estão UP.");
        }
    };

    return (
        <div className="users-container">
            <div className="page-header">
                <h2>Vendas (Tickets)</h2>
                <p>Realize vendas vinculando IDs de usuários e eventos ativos.</p>
            </div>

            <form onSubmit={handleCreateSale} className="user-card"
                  style={{marginBottom: '2rem', display: 'flex', flexWrap: 'wrap', gap: '1rem'}}>
                <div style={{flex: 1, minWidth: '200px'}}>
                    <label style={{fontSize: '0.8rem', display: 'block', marginBottom: '4px'}}>UUID do Usuário</label>
                    <input
                        style={{width: '100%', padding: '8px', borderRadius: '4px', border: '1px solid #ddd'}}
                        value={userId}
                        onChange={e => setUserId(e.target.value)}
                        placeholder="Ex: 550e8400-e29b..."
                        required
                    />
                </div>
                <div style={{flex: 1, minWidth: '200px'}}>
                    <label style={{fontSize: '0.8rem', display: 'block', marginBottom: '4px'}}>UUID do Evento</label>
                    <input
                        style={{width: '100%', padding: '8px', borderRadius: '4px', border: '1px solid #ddd'}}
                        value={eventId}
                        onChange={e => setEventId(e.target.value)}
                        placeholder="Ex: 123e4567-e89b..."
                        required
                    />
                </div>
                <button type="submit" className="user-btn" style={{alignSelf: 'flex-end', height: '40px'}}>
                    Finalizar Venda
                </button>
            </form>

            <div className="users-grid">
                {sales.length === 0 ? (
                    <p>Nenhuma venda encontrada.</p>
                ) : (
                    sales.map(sale => (
                        <article className="user-card" key={sale.id}>
                            <div className="user-card-head">
                                <span className="user-badge">TICKET</span>
                                <code className="user-id">{sale.id}</code>
                            </div>
                            <p className="user-name">Status: {sale.purchaseStatus === 1 ? "Confirmado" : sale.purchaseStatus}</p>
                            <div style={{fontSize: '0.85rem', color: '#64748b'}}>
                                <p><strong>User:</strong> {sale.userId}</p>
                                <p><strong>Event:</strong> {sale.eventId}</p>
                            </div>
                        </article>
                    ))
                )}
            </div>
        </div>
    );
};

export default ListSales;