import { useState } from 'react';
import {Link} from 'react-router-dom'

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aquí iría la lógica para enviar los datos al backend
    console.log('Datos de login:', { email, password });
  };

  return (
    <div className="bg-blue-300 rounded-3xl self-center" >
      <h2 className='text-4xl text-center'>Iniciar Sesión</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label>
          <input 
            className='border-amber-600 border-2 rounded-3xl'
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
    
          />
        </div>
        <div>
          <label>Contraseña:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Ingresar</button>
      </form>
      <Link to="/forgot-password">¿Olvidaste tu contraseña?</Link>
      <p>¿No tienes cuenta? <Link to="/register">Regístrate</Link></p>
    </div>
  );
};

export default Login; 	 