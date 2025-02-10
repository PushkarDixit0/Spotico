import axios from 'axios';

const BASE_URL = "http://localhost:8080/";
const token = JSON.parse(localStorage.getItem("jwtToken"));

class UserService {
    
    getAllUsers() {
        if (!token) {
            console.error("No token found");
            return Promise.reject("No token found"); 
        }
        return axios.get(BASE_URL + "user/users", this.getHeaders());
    }

    addUser(user) {
        return axios.post(BASE_URL + "user/adduser", user, this.getHeaders());
    }

    loginUser(user) {
        return axios.post(BASE_URL + "user/login", user,this.getHeaders());
    }

    deleteUser(id) {
        return axios.delete(`${BASE_URL}user/deleteuser/${id}`, this.getHeaders());
    }

    updateUser(user) {
        return axios.put(`${BASE_URL}user/update/${user.id}`, user, this.getHeaders());
    }

    getSingleUser(id){
        return axios.get(BASE_URL + `user/${id}`, this.getHeaders());
    }

    getHeaders() {
        const token = JSON.parse(localStorage.getItem("jwtToken")); 
        return token ? { headers: { Authorization: `Bearer ${token}` } } : {};
    }

    
}

export default new UserService();
