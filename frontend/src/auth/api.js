import axios from 'axios'

const urlbase = 'http://localhost:8080'

export const register = async (data) =>{
    try{
        const res = await axios.post(`${urlbase}/auth/register`, data)
        return res.data;
    }catch (e){
        console.error(e);
        
    }
    
}
export const login = async (data) =>{
    try{
        const res = await axios.post(`${urlbase}/auth/login`, data)
        return res.data;
    }catch(e){
        console.error(e);
        
    }
}