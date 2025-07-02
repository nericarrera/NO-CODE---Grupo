import React, { useEffect, useRef, useState } from 'react'
import Panel from '../chat/Panel'
import InputMessage from '../chat/InputMessage'
import Message from '../chat/Message'
import BodyChat from '../chat/BodyChat'
import messages from '../../messages.json'


const ChatScreen = () => {
  const [historial, setHistorial]= useState([])
  const [newMessage, setNewMessage]=useState()

  
  
  useEffect(()=>{
    
    setHistorial(messages)
  }, [])

  
  
 const handleSender =()=>{
  const time = new Date();
  const data = {
    mensaje: newMessage,
    id: 1,
    time:time.toLocaleTimeString('es-AR',{hour: '2-digit', minute: '2-digit', hour12:false}) ,
    nombre: "Jose"
  }
   setHistorial((prev)=>[...prev, data])
   
   
 }


  return (
    <section className='bg-black relative h-screen flex flex-col overflow-hidden'>
        <div className='bg-graphite text-white font-sans font-bold text-2xl p-4 h-18 border-b-[0.5px] border-davyGray'>ConverSAFe</div>
        <div className='flex flex-1 overflow-hidden'>
              <Panel />
              <div className='flex flex-col flex-1 w-full justify-between'>
                <BodyChat messages={historial}/>
                <InputMessage handle={()=>handleSender()} set={setNewMessage}/>
              </div>
        </div>
    </section>
  )
}

export default ChatScreen