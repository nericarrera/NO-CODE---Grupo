import { useState } from 'react'
import send from '../../assets/send.png'

const InputMessage = ({set, handle}) => {
  

  return (
    <div className='bg-graphite w-full h-18 flex items-center p-10 justify-around self-end'>
        <input placeholder='Escribe un mensaje...' className='border-davyGray w-[80%] border-2 h-12 pl-8 rounded-2xl placeholder-davyGray text-white' onChange={(e)=>set(e.target.value)}/>
        <button onClick={()=>handle()} className='cursor-pointer active:scale-90'>
            <img src={send} alt="enviar" />
        </button>
    </div>
  )
}

export default InputMessage