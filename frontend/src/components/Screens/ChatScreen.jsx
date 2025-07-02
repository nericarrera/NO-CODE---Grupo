import React, { useEffect, useRef, useState } from 'react'
import Panel from '../chat/Panel'
import InputMessage from '../chat/InputMessage'
import Message from '../chat/Message'
import BodyChat from '../chat/BodyChat'
import messages from '../../messages.json'


const ChatScreen = () => {

  const [newMessage, setNewMessage]=useState()
  const [chat, setChat]=useState()

  const [chatId, setChatId] = useState([])

  
  useEffect(()=>{
    const actualChat = messages.find(e=>e.equipo_id === chatId)
    setChat(actualChat)
    console.log(chat);
    
  }, [chatId])
  

  
  
 const handleSender =()=>{
  const time = new Date();
  const data = {
    mensaje: newMessage,
    id: 1,
    time:time.toLocaleTimeString('es-AR',{hour: '2-digit', minute: '2-digit', hour12:false}) ,
    nombre: "Jose"
  }
   
  setChat((prev)=> ({...prev, mensajes:[...prev.mensajes, data]}))
   
   
 }


  return (
    <section className='bg-black relative h-screen flex flex-col overflow-hidden'>
        <div className='bg-graphite text-white font-sans font-bold text-2xl p-4 h-18 border-b-[0.5px] border-davyGray'>ConverSAFe</div>
        <div className='flex flex-1 overflow-hidden'>
              <Panel historial={messages} setChatId={setChatId}/>
              <div className='flex flex-col flex-1 w-full justify-between'>
                <BodyChat messages={chat} chatId={chatId}/>
                <InputMessage handle={()=>handleSender()} set={setNewMessage}/>
              </div>
        </div>
    </section>
  )
}

export default ChatScreen