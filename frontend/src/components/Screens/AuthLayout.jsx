import React from 'react'

const AuthLayout = ({children}) => {
  return (
    <div className=' flex  justify-center items-center h-screen bg-gradient-to-r from-blue-500 to-purple-500'>
        {children}
    </div>
  )
}

export default AuthLayout