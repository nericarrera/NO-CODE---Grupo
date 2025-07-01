import {Routes, Router, Route, BrowserRouter} from 'react-router-dom'
import './App.css'
import ForgotPassword from './components/ForgotPassword'
import Authorization from './components/Screens/Authorization'

function App() {
  

  return (
    <BrowserRouter >
      <Routes>
        <Route path="/" element={<Authorization />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
