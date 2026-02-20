import { createBrowserRouter } from "react-router-dom"

import Content from "../components/Content/Content"
import ListUsers from "../components/users/ListUsers"
import ListSales from "../components/sales/ListSales"
import ListEvents from "../components/eventos/ListEvents"
import UserProfile from "../components/profile/UserProfile"
import Notifications from "../components/notifications/Notifications"
import Settings from "../components/settings/Settings"
export const routes = createBrowserRouter([
    {
        path: "/",
        element: <Content />,
        children: [
            { path: "/users", element: <ListUsers /> },
            { path: "/sales", element: <ListSales /> },
            { path: "/events", element: <ListEvents /> },
            { path: "/profile", element: <UserProfile /> },      // Nova rota
            { path: "/notifications", element: <Notifications /> }, // Nova rota
            { path: "/settings", element: <Settings /> }         // Nova rota
        ]
    }
])