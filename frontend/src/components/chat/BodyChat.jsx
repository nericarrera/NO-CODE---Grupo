import { useEffect, useRef } from 'react'

import Message from './Message'

const BodyChat = ({messages}) => {
    
    const scrollRef = useRef(null)

    useEffect(()=>{
        scrollRef.current?.scrollIntoView({behavior: "auto"})
    }, [messages])
  
  return (
    <div className='flex flex-col h-full w-full overflow-y-scroll gap-3' >
        {
             messages ? messages.mensajes.map((item,index)=>(
                    <Message message={item.mensaje} time={item.time} name={item.nombre} id={item.id} key={index} />
                )
                
            ) : <div/>
        }
        <div ref={scrollRef}/>
    </div>
  )
}

export default BodyChat