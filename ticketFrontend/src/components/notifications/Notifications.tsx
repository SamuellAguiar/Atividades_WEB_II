import {useState, useEffect} from "react";
import api from "../../services/api";

const Notifications = () => {
    const [notifications, setNotifications] = useState<any[]>([]);

    useEffect(() => {
        api<any[]>('/notifications/notifications-list')
            .then(res => setNotifications(res))
            .catch(() => setNotifications([])); // Fallback para lista vazia
    }, []);

    return (
        <div className="users-container">
            <h2>Notificações</h2>
            {notifications.length === 0 ? (
                <p>Não há notificações no momento.</p>
            ) : (
                <div className="users-grid">
                    {notifications.map(n => (
                        <article key={n.id} className="user-card">{n.message}</article>
                    ))}
                </div>
            )}
        </div>
    );
};
export default Notifications;