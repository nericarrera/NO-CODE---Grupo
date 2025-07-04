import { useState } from "react";
import { Link } from "react-router-dom";

const ForgotPassword = () => {
  const [email, setEmail] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    
    console.log('Email para recuperación:', email);
  };

  return (
    <div className=" bg-gradient-to-br from-gray-900 to-gray-800 flex items-center justify-center p-4 rounded-2xl">
      <div className="w-full max-w-md bg-white/5 backdrop-blur-sm border border-white/10 rounded-xl shadow-xl overflow-hidden">
        <div className="p-8">
          <div className="text-center mb-8">
            <h2 className="text-3xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-blue-400 to-purple-500 mb-2">
              Recuperar Contraseña
            </h2>
            <p className="text-gray-400">Ingresa tu email para recibir instrucciones</p>
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

            <button
              type="submit"
              className="w-full py-3.5 bg-gradient-to-r from-blue-500 to-purple-600 text-white font-medium rounded-lg hover:shadow-lg hover:shadow-blue-500/30 transition-all duration-300"
            >
              Enviar Instrucciones
            </button>
          </form>

          <div className="mt-6 text-center text-sm text-gray-400">
            ¿Recordaste tu contraseña?{" "}
            <Link 
              to="/login" 
              className="text-blue-400 hover:text-blue-300 font-medium transition-colors"
            >
              Volver al Login
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ForgotPassword;