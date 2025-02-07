import React, { useEffect, useState } from 'react'
import styles from './ShowTournaments.module.css'
import TournamentService from '../../Service/TournamentService';
import TournamentCard from './TournamentCard/TournamentCard';
import TournamentFormModal from '../Modals/TournamentFormModal';
import { useLocation } from 'react-router-dom';

function ShowTournaments() {
    const [tournaments, setTournaments] = useState([]);

    const [isAdmin, setIsAdmin] = useState(false);

    const [isModalOpen, setIsModalOpen] = useState(false);

    const location = useLocation();
    const userRole = location.state?.role || JSON.parse(localStorage.getItem("role"));

    useEffect(() => {
        if (userRole == "ROLE_ADMIN")
            setIsAdmin(true);
        fetchData();
    }, [])

    const fetchData = async () => {
        const response = await TournamentService.getAllTournaments()
        try {
            if (response) {
                console.log(response.data);
                setTournaments(response.data);
            }
        } catch (err) {
            console.log("error fetching data " + err);
        }
    }

    return (
        <div>
            <div className={styles.tournamentList}>
                {tournaments.map((tournament) => (
                    <TournamentCard key={tournament.tournamentId} tournament={tournament} isAdmin={isAdmin} fetchData={fetchData} />
                ))}

                {isAdmin && (
                    <div className={styles.add}>
                        <div className={styles.cardContent}>
                            {/* <h3 className={styles.cardTitle}>Add Tournament</h3> */}
                            <button className={styles.addButton} onClick={() => setIsModalOpen(true)} title="Add New">
                                <svg xmlns="http://www.w3.org/2000/svg"
                                    viewBox="0 0 24 24"
                                    className={styles.addButtonIcon}>
                                    <path d="M12 22C17.5 22 22 17.5 22 12C22 6.5 17.5 2 12 2C6.5 2 2 6.5 2 12C2 17.5 6.5 22 12 22Z" strokeWidth="1.5"></path>
                                    <path d="M8 12H16" strokeWidth="1.5"></path>
                                    <path d="M12 16V8" strokeWidth="1.5"></path>
                                </svg>
                            </button>
                        </div>
                        {isModalOpen && (
                            <TournamentFormModal modalval={isModalOpen} onClose={() => setIsModalOpen(false)} fetchData={fetchData} />
                        )}
                    </div>
                )}
            </div>


        </div>
    )
}

export default ShowTournaments