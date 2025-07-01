import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';

// Animaciones
const containerVariants = {
  hidden: { opacity: 0 },
  visible: {
    opacity: 1,
    transition: {
      staggerChildren: 0.2,
      delayChildren: 0.3,
    },
  },
};

const itemVariants = {
  hidden: { y: 20, opacity: 0 },
  visible: {
    y: 0,
    opacity: 1,
    transition: { type: 'spring', stiffness: 100 },
  },
};

const buttonVariants = {
  hover: {
    scale: 1.05,
    boxShadow: '0px 0px 15px rgba(108, 99, 255, 0.5)',
    transition: { duration: 0.3 },
  },
  tap: { scale: 0.95 },
};

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Login con:', { email, password });
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-dark text-light p-4">
      <motion.div
        initial="hidden"
        animate="visible"
        variants={containerVariants}
        className="w-full max-w-md"
      >
        {/* Card */}
        <motion.div
          variants={itemVariants}
          className="bg-gradient-to-br from-dark to-gray-900 border border-primary/20 rounded-2xl p-8 shadow-2xl shadow-primary/10"
        >
          {/* Logo Futurista */}
          <motion.div 
            variants={itemVariants}
            className="flex justify-center mb-8"
          >
            <div className="w-16 h-16 rounded-full bg-primary/10 flex items-center justify-center border border-primary/30">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-8 w-8 text-primary"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={2}
                  d="M12 11c0 3.517-1.009 6.799-2.753 9.571m-3.44-2.04l.054-.09A13.916 13.916 0 008 11a4 4 0 118 0c0 1.017-.07 2.019-.203 3m-2.118 6.844A21.88 21.88 0 0015.171 17m3.839 1.132c.645-2.266.99-4.659.99-7.132A8 8 0 008 4.07M3 15.364c.64-1.319 1-2.8 1-4.364 0-1.457.39-2.823 1.07-4"
                />
              </svg>
            </div>
          </motion.div>

          {/* Título */}
          <motion.h2 
            variants={itemVariants}
            className="text-3xl font-bold text-center mb-2 bg-clip-text text-transparent bg-gradient-to-r from-primary to-secondary"
          >
            Bienvenido
          </motion.h2>
          <motion.p 
            variants={itemVariants}
            className="text-center text-light/60 mb-8"
          >
            Inicia sesión para acceder al dashboard
          </motion.p>

          {/* Formulario */}
          <form onSubmit={handleSubmit}>
            <motion.div variants={itemVariants} className="mb-6">
              <label className="block text-light/80 mb-2 text-sm">Email</label>
              <input
                type="email"
                className="w-full px-4 py-3 bg-dark/50 border border-light/10 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-transparent transition-all"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </motion.div>

            <motion.div variants={itemVariants} className="mb-8">
              <label className="block text-light/80 mb-2 text-sm">Contraseña</label>
              <input
                type="password"
                className="w-full px-4 py-3 bg-dark/50 border border-light/10 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-transparent transition-all"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </motion.div>

            <motion.div variants={itemVariants}>
              <motion.button
                type="submit"
                variants={buttonVariants}
                whileHover="hover"
                whileTap="tap"
                className="w-full py-3 bg-gradient-to-r from-primary to-secondary rounded-lg font-medium text-dark hover:shadow-lg transition-all"
              >
                Ingresar
              </motion.button>
            </motion.div>
          </form>

          {/* Links */}
          <motion.div 
            variants={itemVariants}
            className="mt-6 text-center text-sm"
          >
            <Link
              to="/forgot-password"
              className="text-light/60 hover:text-primary transition-colors"
            >
              ¿Olvidaste tu contraseña?
            </Link>
            <span className="mx-2 text-light/30">|</span>
            <Link
              to="/register"
              className="text-light/60 hover:text-secondary transition-colors"
            >
              Crear cuenta
            </Link>
          </motion.div>
        </motion.div>

        {/* Efecto de partículas (opcional) */}
        <motion.div 
          variants={itemVariants}
          className="absolute inset-0 overflow-hidden z-[-1]"
        >
          {[...Array(10)].map((_, i) => (
            <motion.div
              key={i}
              animate={{
                y: [0, -20, 0],
                x: [0, 15, 0],
                opacity: [0.5, 1, 0.5],
              }}
              transition={{
                duration: 5 + Math.random() * 10,
                repeat: Infinity,
                repeatType: 'reverse',
              }}
              className="absolute rounded-full bg-primary/10"
              style={{
                width: `${Math.random() * 10 + 5}px`,
                height: `${Math.random() * 10 + 5}px`,
                left: `${Math.random() * 100}%`,
                top: `${Math.random() * 100}%`,
              }}
            />
          ))}
        </motion.div>
      </motion.div>
    </div>
  );
};

export default Login;
