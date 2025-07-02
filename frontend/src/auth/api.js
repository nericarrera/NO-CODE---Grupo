import axios from 'axios';

// --- ELIGE UNA OPCIÓN (cambia solo esto) --- //
const MODO_SIMULACION = true; // true = pruebas sin backend | false = con backend real
const urlbase = MODO_SIMULACION ? '' : 'http://localhost:8080';

// --- CÓDIGO QUE NO TOCARÁS NUNCA MÁS --- //
export const register = async (data) => {
  try {
    if (MODO_SIMULACION) {
      // Simulación para frontend
      console.log('(SIMULACIÓN) Registrando:', data.email);
      return { success: true, user: data };
    } else {
      // Conexión real al backend
      const res = await axios.post(`${urlbase}/auth/register`, data);
      return res.data;
    }
  } catch (e) {
    throw new Error(MODO_SIMULACION ? 'Error simulado' : e.response?.data?.message || 'Error en registro');
  }
};

export const login = async (data) => {
  try {
    if (MODO_SIMULACION) {
      // Simulación para frontend
      console.log('(SIMULACIÓN) Login:', data.email);
      return { 
        token: 'token-simulado-' + Math.random().toString(36).slice(2),
        user: { email: data.email } 
      };
    } else {
      // Conexión real al backend
      const res = await axios.post(`${urlbase}/auth/login`, data);
      return res.data;
    }
  } catch (e) {
    throw new Error(MODO_SIMULACION ? 'Credenciales inválidas (simulado)' : e.response?.data?.message || 'Error en login');
  }
};