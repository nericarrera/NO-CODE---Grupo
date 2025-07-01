import React from "react"

const Chat = ({title, lastMessage, selected}) => {

  return (
    <div className={`flex  rounded-xl ${selected && 'bg-ebony' }`}>
        {
            selected && <div className="bg-cyan pl-1.5 rounded-l-xl"/> 
        }
        <div className=" p-3 pl-6 leading-3">
            <div className="text-white font-bold">{title}</div>
            <div className="text-teal text-sm truncate w-28">{lastMessage}</div>
        </div> 
    </div>
  )
}

export default Chat