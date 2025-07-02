import React, { useEffect, useState } from 'react'
import Chat from './Chat'

const Panel = ({historial, setChatId}) => {

  const [selectId, setSelectId]=useState()
  
  useEffect(()=>{
    setChatId(selectId)
  }, [selectId])


  return (
    <section className='bg-graphite w-80 p-6 flex flex-col gap-8'>
        <div className='text-platine font-sans'>Tus chats</div>
        <div className='gap-2 flex flex-col'>
          {
            historial.map((item, index)=>(
              <Chat item={item} selected={selectId} key={index} setId={setSelectId}/>
            ))
          }
        </div>
    </section>
  )
}

export default Panel