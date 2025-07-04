import { Client } from "@stomp/stompjs";
import { useEffect, useRef, useState } from "react";
import SockJS from "sockjs-client";

export function useWebSocket(messageCallback) {
    const client = useRef(null);
    const [connected, setConnected] = useState(false);
    const currentSubscription = useRef(null);

    useEffect(() => {
        if (client.current) return;

        console.log('Conectando...');
        const newClient = new Client({
            webSocketFactory: () => new SockJS('http://localhost:8080/chat'),
            reconnectDelay: 5000,
        });

        newClient.onConnect = () => {
            console.log('WebSocket conectado');
            setConnected(true);
        };

        newClient.onStompError = (e) => {
            console.error('Error en STOMP:', e);
        };

        newClient.activate();
        client.current = newClient;

        return () => {
            console.log('Desconectando...');
            if (client.current) {
                client.current.deactivate();
                client.current = null;
            }
            setConnected(false);
        };
    }, []);

    const subscribeToChat = (chatId) => {
        if (!client.current || !client.current.connected) {
            console.log('No hay conexión WebSocket todavía');
            return;
        }

        if (currentSubscription.current) {
            currentSubscription.current.unsubscribe();
            console.log('Desuscripto del chat anterior');
        }

        console.log(`Suscripto a /topic/mensajes/${chatId}`);
        currentSubscription.current = client.current.subscribe(
            `/topic/mensajes/${chatId}`,
            (msg) => {
                const body = JSON.parse(msg.body);
                messageCallback(body);
            }
        );
    };

    const sender = (msg) => {
        if (client.current && client.current.connected) {
            console.log('Enviando mensaje por WebSocket');
            client.current.publish({
                destination: '/app/mensaje',
                body: JSON.stringify(msg),
            });
        } else {
            console.log('No se puede enviar, WebSocket no conectado');
        }
    };

    return { connected, sender, subscribeToChat };
}