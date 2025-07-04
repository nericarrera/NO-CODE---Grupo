import { useState } from "react";
import { Link } from "react-router-dom";
import { register } from "../../auth/api";
import ButonAuth from "../buttons/butonAuth";


const Register = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleSubmit = async(e) => {
    e.preventDefault();
    const data = {
      name ,
      email,
      password
    }
    const res = await register(data)
    console.log(res);
    
  };

  return (
    <div className="rounded-2xl bg-gradient-to-br from-gray-900 to-gray-800 flex items-center justify-center p-4">
      <div className="w-full max-w-md bg-white/5 backdrop-blur-sm border border-white/10 rounded-xl shadow-xl overflow-hidden">
        <div className="p-8">
          <div className="text-center mb-8">
            <h2 className="text-3xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-blue-400 to-purple-500 mb-2">
              Crear Cuenta
            </h2>
            <p className="text-gray-400">Completa tus datos para registrarte</p>
          </div>

          <form onSubmit={handleSubmit} className="space-y-5">
            <div className="space-y-1">
              <label className="block text-sm font-medium text-gray-300">Nombre:</label>
              <input
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                className="w-full px-4 py-3 bg-white/5 border border-white/10 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500/50 text-white placeholder-gray-500 transition-all"
                placeholder="Tu nombre completo"
                required
              />
            </div>

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

            <div className="space-y-1">
              <label className="block text-sm font-medium text-gray-300">Repetir Contraseña:</label>
              <input
                type="password"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                className="w-full px-4 py-3 bg-white/5 border border-white/10 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500/50 text-white placeholder-gray-500 transition-all"
                placeholder="••••••••"
                required
              />
            </div>

            <ButonAuth title={"Registrarse"}/>
          </form>

          <div className="mt-6 text-center text-sm text-gray-400">
            ¿Ya tienes cuenta?{" "}
            <Link 
              to="/" 
              className="text-blue-400 hover:text-blue-300 font-medium transition-colors"
            >
              Inicia Sesión
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;