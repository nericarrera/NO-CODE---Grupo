import axios from "axios";

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
        localStorage.setItem("token", res.data.token)
        localStorage.setItem("email", res.data.email)
        return res.data;
    }catch(e){
        console.error(e);
        
    }
}

export const getUserByEmail = async ()=>{
    try{
        const token = localStorage.getItem("token")
        const email = localStorage.getItem("email")
        const res = await axios.get(`${urlbase}/usuario?email=${email}`, {headers:{
            Authorization:`Bearer ${token}`
        }})
        localStorage.setItem("nombre", res.data.nombre)
        localStorage.setItem("id", res.data.id)
    }catch(e){
        console.error(e);
    }
}

export const getAllChats = async () =>{
    try{
        const token = localStorage.getItem("token")
        const res = await axios.get(`${urlbase}/api/chat`, {
            headers:{
                Authorization: `Bearer ${token}`
            }
        })
        
        return res.data
    }catch(e){
        console.error(e);
        
    }
}

export const getChatById=async(id)=>{
    try{
        const token = localStorage.getItem("token")
        const res = await axios.get(`${urlbase}/api/chat/${id}`, {
            headers:{
                Authorization: `Bearer ${token}`
            }
        })
        return res.data
    }catch(e){
        console.error(e);
        
    }
}
