const GATEWAY_URL = 'http://localhost:9081';

async function api<T>(endpoint: string, config?: RequestInit): Promise<T> {
    const response = await fetch(`${GATEWAY_URL}${endpoint}`, {
        ...config,
        headers: {
            'Content-Type': 'application/json',
            ...config?.headers,
        },
    });

    if (!response.ok) {
        // Se der erro 400 ou 404, vamos ver o que o servidor respondeu
        const errorText = await response.text();
        throw new Error(`Erro ${response.status}: ${errorText}`);
    }

    return response.json();
}
export default api;