import React from 'react'
import Chat from './Chat'

const Panel = () => {
  return (
    <section className='bg-graphite w-80 p-6 flex flex-col gap-8'>
        <div className='text-platine font-sans'>Tus chats</div>
        <div className='gap-2 flex flex-col'>
            <Chat title={"Equipo de diseño"} lastMessage={"este es el ultimo mensaje"} selected={true}/>
            <Chat title={"Equipo de backend"} lastMessage={"este es el ultimo mensaje"} selected={false}/>
            <Chat title={"Equipo de frontend"} lastMessage={"este es el ultimo mensaje"} selected={false}/>
        </div>
    </section>
  )
}

export default Panel