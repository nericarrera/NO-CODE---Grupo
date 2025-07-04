import React, { useEffect, useState } from 'react'

const Message = ({message,name, time, id}) => {
  const [hora, setHora]=useState('')
  const myId = localStorage.getItem("id")
  const obtenerHora = ()=>{
    const date = new Date(time);
    const horas = date.getHours().toString().padStart(2, '0');
    const minutos = date.getMinutes().toString().padStart(2, '0');
    const newTime = `${horas}:${minutos}`
    
    setHora(newTime); 
  }

  
  useEffect(()=>{
    obtenerHora()
    console.log(id + " " + myId);
    
  },[time])
  
  return (
    <div className={` w-2/3 p-3 m-3 rounded-2xl ${id === parseInt(myId)  ? 'self-end bg-indianYellow' : 'bg-gray-600'}`}>
        <div className={`${id === parseInt(myId) ? 'text-davyGray' : 'text-platine'}`}>{message}</div>
        <div className='text-teal text-right'>{name} - {hora} </div>
    </div>
  )
}

export default Message