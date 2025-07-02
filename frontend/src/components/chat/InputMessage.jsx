import { useEffect, useState } from 'react'
import send from '../../assets/send.png'

const InputMessage = ({set, handle}) => {
  const [inputValue, setInputValue]=useState('')
  const handleInput =(e)=>{
    setInputValue(e.target.value)
    set(e.target.value)
  }
  const handleSender = (e)=>{
    handle()
    setInputValue('')
  }



  return (
    <div className='bg-graphite w-full h-18 flex items-center p-10 justify-around self-end'>
        <input placeholder='Escribe un mensaje...' className='border-davyGray w-[80%] border-2 h-12 pl-8 rounded-2xl placeholder-davyGray text-white' value={inputValue} onChange={handleInput}/>
        <button onClick={handleSender} className='cursor-pointer active:scale-90 ' disabled={inputValue === ''}>
            <img src={send} alt="enviar" />
        </button>
    </div>
  )
}

export default InputMessage