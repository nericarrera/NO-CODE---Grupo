window.global = window
import {Routes, Router, Route, BrowserRouter} from 'react-router-dom'
import './App.css'
import ForgotPassword from './components/ForgotPassword'

import ChatScreen from './components/Screens/ChatScreen'
import Login from './components/LoginandRegister/Login'
import Register from './components/LoginandRegister/Register'
import AuthLayout from './components/Screens/AuthLayout'


function App() {
  

  return (
    <BrowserRouter >
      <Routes>
        <Route path='/login' element={<AuthLayout><Login/></AuthLayout>} />
        <Route path='/register' element={<AuthLayout><Register /></AuthLayout>}/>
        <Route path="/forgot-password" element={<AuthLayout><ForgotPassword /></AuthLayout>} />
        <Route path="/" element={<ChatScreen />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
