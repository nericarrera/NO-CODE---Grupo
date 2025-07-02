import React from 'react'

const Message = ({message,name, time, id}) => {

  
  const myId = 1;
  return (
    <div className={` w-2/3 p-3 m-3 rounded-2xl ${id === myId ? 'self-end bg-indianYellow' : 'bg-gray-600'}`}>
        <div className={`${id===myId ? 'text-davyGray' : 'text-platine'}`}>{message}</div>
        <div className='text-teal text-right'>{name} - {time}</div>
    </div>
  )
}

export default Message