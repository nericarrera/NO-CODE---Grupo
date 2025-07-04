import React from "react"

const Chat = ({item, selected, setId}) => {  
  
  const handleSelect = ()=>{
    setId(item.id)
  }

  return (
    <button className={`flex  rounded-xl ${selected === item.id && 'bg-ebony' }` } onClick={handleSelect}>
        {
            selected === item.id && <div className="bg-cyan pl-1.5 rounded-l-xl"/> 
        }
        <div className=" p-3 pl-6 leading-3">
            <div className="text-white font-bold text-left">{item.nombre}</div>
            <div className="text-teal text-sm truncate w-28 text-left">{item.mensajes[item.mensajes.length -1]?.contenido}</div>
        </div> 
    </button>
  )
}

export default Chat