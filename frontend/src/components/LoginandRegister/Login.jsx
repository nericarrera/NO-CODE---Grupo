import { useState } from 'react';

import { Link, useNavigate } from 'react-router-dom';

import { login } from '../../auth/api';
import ButonAuth from '../buttons/butonAuth';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  let navigate = useNavigate();


  const handleSubmit = async (e) => {
    e.preventDefault();

    
    const data = {
      email,
      password
    };

    await login(data)
      .then(navigate("/"))
    

  };

  return (
    <div className="rounded-2xl bg-gradient-to-br from-gray-900 to-gray-800 flex items-center justify-center p-4">
      <div className="w-full max-w-md bg-white/5 backdrop-blur-sm border border-white/10 rounded-xl shadow-xl overflow-hidden">
        <div className="p-8">
          <div className="text-center mb-8">
            <h2 className="text-3xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-blue-400 to-purple-500 mb-2">
              Iniciar Sesión
            </h2>
            <p className="text-gray-400">Ingresa tus credenciales para continuar</p>
          </div>

          <form onSubmit={handleSubmit} className="space-y-5">
            <div className="space-y-1">
              <label className="block text-sm font-medium text-gray-300">Email:</label>
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="w-full px-4 py-3 bg-white/5 border border-white/10 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500/50 text-white placeholder-gray-500 transition-all"
                placeholder="tu@email.com"
                required
              />
            </div>

            <div className="space-y-1">
              <label className="block text-sm font-medium text-gray-300">Contraseña:</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className="w-full px-4 py-3 bg-white/5 border border-white/10 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500/50 text-white placeholder-gray-500 transition-all"
                placeholder="••••••••"
                required
              />
            </div>

            <div className="flex justify-end">
              <Link 
                to="/forgot-password" 
                className="text-sm text-blue-400 hover:text-blue-300 transition-colors"
              >
                ¿Olvidaste tu contraseña?
              </Link>
            </div>
            <ButonAuth title={"Ingresar"}/>
          </form>

          <div className="mt-6 text-center text-sm text-gray-400">
            ¿No tienes cuenta?{" "}
            <Link 
              to="/register" 
              className="text-blue-400 hover:text-blue-300 font-medium transition-colors"
            >
              Regístrate
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;