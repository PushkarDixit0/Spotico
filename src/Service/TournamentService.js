import axios from 'axios';

const BASE_URL = "http://localhost:8080/";
const token = JSON.parse(localStorage.getItem("jwtToken"));

class TournamentService {
    
    getAllTournaments() {
        console.log(token)
        if (!token) {
            console.error("No token found");
            return Promise.reject("No token found"); 
        }
        return axios.get(BASE_URL + "tournament", this.getHeaders());
    }

    addTournament(tournament) {
        return axios.post(BASE_URL + "tournament", tournament, this.getHeaders());
    }

    updateTournament(tournament) {
        return axios.put(`${BASE_URL}tournament/${tournament.tournamentId}`, tournament, this.getHeaders());
    }

    deleteTournament(id) {
        return axios.delete(`${BASE_URL}tournament/${id}`, this.getHeaders());
    }

    getEnrolledUsers(tournamentId) {
        return axios.get(`${BASE_URL}tournament/${tournamentId}/enrolled-users`, this.getHeaders());
    }

    getHeaders() {
        const token = JSON.parse(localStorage.getItem("jwtToken")); 
        return token ? { headers: { Authorization: `Bearer ${token}` } } : {};
    }
}

export default new TournamentService();
