import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { motion } from 'framer-motion';

const containerVariants = {
  hidden: { opacity: 0 },
  visible: {
    opacity: 1,
    transition: {
      staggerChildren: 0.15,
      delayChildren: 0.2,
    },
  },
};

const itemVariants = {
  hidden: { y: 30, opacity: 0 },
  visible: {
    y: 0,
    opacity: 1,
    transition: { 
      type: 'spring', 
      stiffness: 120,
      damping: 12
    },
  },
};

const buttonVariants = {
  hover: {
    scale: 1.03,
    boxShadow: '0px 0px 20px rgba(108, 99, 255, 0.7)',
    transition: { 
      duration: 0.4,
      ease: [0.04, 0.62, 0.23, 0.98]
    },
  },
  tap: { 
    scale: 0.98,
    boxShadow: '0px 0px 10px rgba(108, 99, 255, 0.5)'
  },
};

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Login con:', { email, password });
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-[#0a0a12] p-4 sm:p-6">
      <motion.div
        initial="hidden"
        animate="visible"
        variants={containerVariants}
        className="w-full max-w-md relative"
      >
        {/* Efecto de neón detrás de la tarjeta */}
        <motion.div
          initial={{ opacity: 0 }}
          animate={{ opacity: 0.6 }}
          transition={{ duration: 1.5, repeat: Infinity, repeatType: 'reverse' }}
          className="absolute -inset-2 rounded-2xl bg-gradient-to-r from-primary/30 to-secondary/30 blur-md z-0"
        />
        
        {/* Tarjeta principal */}
        <motion.div
          variants={itemVariants}
          className="relative z-10 bg-gradient-to-br from-[#121228] to-[#0a0a18] border border-[#ffffff08] rounded-2xl p-8 sm:p-10 shadow-2xl shadow-primary/10 backdrop-blur-sm"
        >
          {/* Logo */}
          <motion.div 
            variants={itemVariants}
            className="flex justify-center mb-8"
          >
            <motion.div 
              whileHover={{ scale: 1.1 }}
              className="w-20 h-20 rounded-full bg-gradient-to-br from-primary/10 to-secondary/10 flex items-center justify-center border border-primary/30 shadow-glow"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-10 w-10 text-primary drop-shadow-glow"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={1.5}
                  d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
                />
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={1.5}
                  d="M12 15v2m0 0v2m0-2h2m-2 0H10m6-10a6 6 0 00-12 0v1m12-1a6 6 0 01-12 0v1"
                />
              </svg>
            </motion.div>
          </motion.div>

          {/* Título */}
          <motion.div variants={itemVariants}>
            <motion.h2 
              className="text-3xl sm:text-4xl font-bold text-center mb-2 bg-clip-text text-transparent bg-gradient-to-r from-primary to-secondary"
              animate={{
                backgroundPosition: ['0% 50%', '100% 50%', '0% 50%'],
              }}
              transition={{
                duration: 8,
                repeat: Infinity,
                ease: 'linear',
              }}
              style={{
                backgroundSize: '200% 200%',
              }}
            >
              Acceso Seguro
            </motion.h2>
            <motion.p 
              variants={itemVariants}
              className="text-center text-[#ffffff99] mb-8 text-sm sm:text-base"
            >
              Autentícate para acceder al sistema
            </motion.p>
          </motion.div>

          {/* Formulario */}
          <form onSubmit={handleSubmit} className="space-y-6">
            <motion.div variants={itemVariants}>
              <label className="block text-[#ffffffcc] mb-2 text-sm font-medium">Correo Electrónico</label>
              <div className="relative">
                <input
                  type="email"
                  className="w-full px-4 py-3 bg-[#ffffff08] border border-[#ffffff15] rounded-xl focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-transparent transition-all placeholder-[#ffffff50] text-white"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  placeholder="tu@email.com"
                  required
                />
                <div className="absolute inset-0 rounded-xl border border-primary/20 pointer-events-none opacity-0 group-hover:opacity-100 transition-opacity" />
              </div>
            </motion.div>

            <motion.div variants={itemVariants}>
              <label className="block text-[#ffffffcc] mb-2 text-sm font-medium">Contraseña</label>
              <div className="relative group">
                <input
                  type="password"
                  className="w-full px-4 py-3 bg-[#ffffff08] border border-[#ffffff15] rounded-xl focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-transparent transition-all placeholder-[#ffffff50] text-white"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  placeholder="••••••••"
                  required
                />
                <div className="absolute inset-0 rounded-xl border border-primary/20 pointer-events-none opacity-0 group-hover:opacity-100 transition-opacity" />
              </div>
            </motion.div>

            <motion.div variants={itemVariants} className="pt-2">
              <motion.button
                type="submit"
                variants={buttonVariants}
                whileHover="hover"
                whileTap="tap"
                className="w-full py-3.5 bg-gradient-to-r from-primary to-secondary rounded-xl font-medium text-white text-sm sm:text-base tracking-wide relative overflow-hidden"
              >
                <span className="relative z-10">Ingresar</span>
                <motion.span
                  initial={{ x: '-100%' }}
                  whileHover={{ x: '0%' }}
                  transition={{ duration: 0.6 }}
                  className="absolute inset-0 bg-gradient-to-r from-primary/30 to-secondary/30 z-0"
                />
              </motion.button>
            </motion.div>
          </form>

          {/* Links */}
          <motion.div 
            variants={itemVariants}
            className="mt-8 text-center text-sm"
          >
            <Link
              to="/forgot-password"
              className="text-[#ffffff99] hover:text-primary transition-colors duration-300 inline-block mx-2"
            >
              Recuperar acceso
            </Link>
            <span className="text-[#ffffff30] mx-1">•</span>
            <Link
              to="/register"
              className="text-[#ffffff99] hover:text-secondary transition-colors duration-300 inline-block mx-2"
            >
              Crear cuenta
            </Link>
          </motion.div>
        </motion.div>

        {/* Efecto de partículas */}
        <motion.div 
          className="absolute inset-0 overflow-hidden z-[-1] pointer-events-none"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ duration: 1 }}
        >
          {[...Array(15)].map((_, i) => (
            <motion.div
              key={i}
              initial={{
                y: Math.random() * 100,
                x: Math.random() * 100,
                opacity: 0,
              }}
              animate={{
                y: [0, -Math.random() * 30, 0],
                x: [0, Math.random() * 20 - 10, 0],
                opacity: [0.3, 0.8, 0.3],
              }}
              transition={{
                duration: 5 + Math.random() * 10,
                repeat: Infinity,
                repeatType: 'reverse',
                ease: 'easeInOut',
              }}
              className="absolute rounded-full bg-gradient-to-r from-primary/30 to-secondary/30"
              style={{
                width: `${Math.random() * 8 + 4}px`,
                height: `${Math.random() * 8 + 4}px`,
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
