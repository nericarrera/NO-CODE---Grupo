import React, { useEffect, useRef, useState } from 'react'
import Panel from '../chat/Panel'
import InputMessage from '../chat/InputMessage'
import BodyChat from '../chat/BodyChat'
import messages from '../../messages.json'
import { getAllChats, getChatById, getUserByEmail } from '../../auth/api'
import { useWebSocket } from '../hooks/useWebSocket'


const ChatScreen = () => {
 const [allChats, setAllChats] = useState([]);
  const [newMessage, setNewMessage] = useState('');
  const [chat, setChat] = useState();
  const [chatId, setChatId] = useState();

  const { connected, sender, subscribeToChat } = useWebSocket((mensaje) => {
    setChat((prev) => {
      if (!prev) return prev;
      return { ...prev, mensajes: [...prev.mensajes, mensaje] };
    });
  });

  useEffect(() => {
    const loadChats = async () => {
      const res = await getAllChats();
      setAllChats(res);
    };
    getUserByEmail();
    loadChats();
  }, []);

  useEffect(() => {
    if (chatId) {
      const loadChatById = async () => {
        const res = await getChatById(chatId);
        setChat(res);
      };
      loadChatById();
      subscribeToChat(chatId);
    }
  }, [chatId]);

  const handleSender = () => {
    if (!newMessage || !chatId) return;

    const time = new Date();

    const data = {
      contenido: newMessage,
      autor: {
        id: Number(localStorage.getItem('id')),
        nombre: localStorage.getItem('nombre'),
      },
      timestamp: time.toLocaleTimeString('es-AR', {
        hour: '2-digit',
        minute: '2-digit',
        hour12: false,
      }),
      chatId: chatId,
    };

    setChat((prev) => ({ ...prev, mensajes: [...prev.mensajes, data] }));

    sender({
      autorId: Number(localStorage.getItem('id')),
      chatId: chatId,
      contenido: newMessage,
    });

    setNewMessage('');
  };


  return (
    <section className='bg-black relative h-screen flex flex-col overflow-hidden'>
        <div className='bg-graphite text-white font-sans font-bold text-2xl p-4 h-18 border-b-[0.5px] border-davyGray'>ConverSAFe</div>
        <div className='flex flex-1 overflow-hidden'>
              <Panel historial={allChats} setChatId={setChatId} chatId={chatId}/>
              <div className='flex flex-col flex-1 w-full justify-between'>
                <BodyChat messages={chat}/>
                {
                  chatId && <InputMessage handle={handleSender} set={setNewMessage}/>
                }
                
              </div>
        </div>
    </section>
  )
}

export default ChatScreen