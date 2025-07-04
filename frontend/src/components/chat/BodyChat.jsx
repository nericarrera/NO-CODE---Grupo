import { useEffect, useRef } from 'react'

import Message from './Message'

const BodyChat = ({messages}) => {
  
  
  useEffect(()=>{

  },[messages])
    
    const scrollRef = useRef(null)

    useEffect(()=>{
        scrollRef.current?.scrollIntoView({behavior: "auto"})
    }, [messages])
  
  return (
    <div className='flex flex-col h-full w-full overflow-y-scroll gap-3' >
        {
             messages && messages.mensajes.map((item,index)=>(
                    <Message message={item.contenido} time={item.timestamp} name={item.autor.nombre} id={item.autor.id} key={index} />
                )
                
            ) 
        }
        <div ref={scrollRef}/>
    </div>
  )
}

export default BodyChat