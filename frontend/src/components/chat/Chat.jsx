import React from "react"

const Chat = ({item, selected, setId}) => {
  
  
  const handleSelect = ()=>{
    setId(item.equipo_id)
  }

  return (
    <button className={`flex  rounded-xl ${selected === item.equipo_id && 'bg-ebony' }` } onClick={handleSelect}>
        {
            selected === item.equipo_id && <div className="bg-cyan pl-1.5 rounded-l-xl"/> 
        }
        <div className=" p-3 pl-6 leading-3">
            <div className="text-white font-bold">{item.nombre}</div>
            <div className="text-teal text-sm truncate w-28">{item.mensajes[item.mensajes.length -1].mensaje}</div>
        </div> 
    </button>
  )
}

export default Chat