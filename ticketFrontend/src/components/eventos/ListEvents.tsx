import {useState, useEffect} from "react"
import api from "../../services/api"

interface IEvent {
    id: string;
    description: string;
    price: number;
    date: string;
}

const ListEvents = () => {
    const [events, setEvents] = useState<IEvent[]>([])

    // Estados para o formulário (conforme o seu CreateEventDTO)
    const [description, setDescription] = useState("")
    const [price, setPrice] = useState<number>(0)
    const [eventDate, setEventDate] = useState("")

    const loadEvents = () => {
        // Rota corrigida conforme o EventsController e Gateway
        api<IEvent[]>('/events/list-events')
            .then(response => {
                setEvents(response)
            })
            .catch(error => console.error("Erro ao carregar eventos:", error))
    }

    useEffect(() => {
        loadEvents()
    }, [])

    const handleCreateEvent = async (e: React.FormEvent) => {
        e.preventDefault()
        try {
            // O seu record CreateEventDTO espera:
            // (String description, int type, float price, Date date, Date startSales, Date endSales)
            await api('/events', {
                method: 'POST',
                body: JSON.stringify({
                    description: description,
                    type: 1,            // Valor inteiro padrão exigido pelo DTO
                    price: price,       // Float
                    date: eventDate,    // Data do evento
                    startSales: eventDate, // Data início (usando a mesma para simplificar)
                    endSales: eventDate    // Data fim (usando a mesma para simplificar)
                })
            })

            alert("Evento criado com sucesso!")
            setDescription("")
            setPrice(0)
            setEventDate("")
            loadEvents()
        } catch (error) {
            console.error(error)
            alert("Erro 400: Verifique se todos os campos (incluindo as datas) estão corretos.")
        }
    }

    return (
        <div className="users-container">
            <div className="page-header" style={{marginBottom: '2rem'}}>
                <h2>Gestão de Eventos</h2>
                <p>Cadastre novos eventos para que fiquem disponíveis para venda.</p>
            </div>

            {/* Formulário de Cadastro de Evento */}
            <form onSubmit={handleCreateEvent} className="user-card" style={{marginBottom: '3rem'}}>
                <div style={{display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '1rem'}}>
                    <div style={{gridColumn: 'span 2'}}>
                        <label style={{fontSize: '0.85rem', fontWeight: 600}}>Descrição do Evento</label>
                        <input
                            style={{
                                width: '100%',
                                padding: '10px',
                                marginTop: '5px',
                                borderRadius: '8px',
                                border: '1px solid #e2e8f0'
                            }}
                            value={description}
                            onChange={e => setDescription(e.target.value)}
                            placeholder="Ex: Show de Rock / Conferência Web"
                            required
                        />
                    </div>
                    <div>
                        <label style={{fontSize: '0.85rem', fontWeight: 600}}>Preço (R$)</label>
                        <input
                            type="number"
                            step="0.01"
                            style={{
                                width: '100%',
                                padding: '10px',
                                marginTop: '5px',
                                borderRadius: '8px',
                                border: '1px solid #e2e8f0'
                            }}
                            value={price}
                            onChange={e => setPrice(Number(e.target.value))}
                            required
                        />
                    </div>
                    <div>
                        <label style={{fontSize: '0.85rem', fontWeight: 600}}>Data do Evento</label>
                        <input
                            type="date"
                            style={{
                                width: '100%',
                                padding: '10px',
                                marginTop: '5px',
                                borderRadius: '8px',
                                border: '1px solid #e2e8f0'
                            }}
                            value={eventDate}
                            onChange={e => setEventDate(e.target.value)}
                            required
                        />
                    </div>
                </div>
                <button type="submit" className="user-btn" style={{marginTop: '1.5rem', width: '200px'}}>
                    Criar Evento
                </button>
            </form>

            {/* Listagem de Eventos */}
            <div className="users-grid">
                {events.length === 0 ? (
                    <p>Nenhum evento registrado.</p>
                ) : (
                    events.map(event => (
                        <article className="user-card" key={event.id}>
                            <div className="user-card-head">
                                <span className="user-badge">EVENTO</span>
                                <code className="user-id">{event.id}</code>
                            </div>
                            <p className="user-name">{event.description}</p>
                            <p className="user-email">
                                <strong>Preço:</strong> R$ {event.price.toFixed(2)}
                            </p>
                            <p className="user-email">
                                <strong>Data:</strong> {new Date(event.date).toLocaleDateString('pt-BR')}
                            </p>
                        </article>
                    ))
                )}
            </div>
        </div>
    )
}

export default ListEvents