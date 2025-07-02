import {Routes, Router, Route, BrowserRouter} from 'react-router-dom'
import './App.css'
import ForgotPassword from './components/ForgotPassword'
import Authorization from './components/Screens/Authorization'
import ChatScreen from './components/Screens/ChatScreen'


function App() {
  

  return (
    <BrowserRouter >
      <Routes>
        <Route path="/" element={<ChatScreen />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
