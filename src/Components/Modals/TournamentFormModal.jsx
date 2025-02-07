import React, { useState } from 'react';
import styles from "../Modals/FormModal.module.css";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import TournamentService from '../../Service/TournamentService';
import { colors } from '@mui/material';

function TournamentFormModal({ modalval, edit, existingData, onClose, onSubmit, fetchData }) {

    // if (modalval) {
    //     document.body.classList.add('active-modal');
    // } else {
    //     document.body.classList.remove('active-modal');
    // }

    const [tournamentData, setTournamentData] = useState({
        tournamentId: existingData?.tournamentId || 0,
        tournamentName: existingData?.tournamentName || "",
        tournamentDescription: existingData?.tournamentDescription || "",
        tournamentVenue: existingData?.tournamentVenue || "",
        sportName: existingData?.sportName || "",
        tournamentDate: existingData?.tournamentDate ? new Date(existingData.tournamentDate).toISOString().split('T')[0] : "",
        tournamentTime: existingData?.tournamentTime || "09:00",
        slots: existingData?.slots || 0
    });

    const handleChange = (e) => {
        setTournamentData({ ...tournamentData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
    
        const formattedTime = tournamentData.tournamentTime.length === 5
            ? tournamentData.tournamentTime
            : tournamentData.tournamentTime;
    
        const finalData = { ...tournamentData, tournamentTime: formattedTime };
    
        try {
            let response;
            if (edit) {
                response = await TournamentService.updateTournament(finalData);
                console.log(response)
            } else {
                response = await TournamentService.addTournament(finalData);
            }
    
            if (response) {
                toast.success(edit ? "Tournament Updated Successfully" : "Tournament Created Successfully");
                fetchData();
                onClose();  
            }
        } catch (err) {
            console.error("Error:", err);
            toast.error("Something went wrong. Please try again.");
        }
    };
    

    return (
        <div className={styles.modal}>
            <div className={styles.overlay} onClick={onClose}></div>
            <div className={styles.modal_content}>
                <h2 className={styles.heading}>{edit ? "Edit Tournament" : "Add Tournament"}</h2>
                <form onSubmit={handleSubmit} className={styles.formContainer}>
                    <table className={styles.formTable}>
                        <tbody>
                            <tr>
                                <td><label htmlFor="tournamentName">Name</label></td>
                                <td><input type="text" id="tournamentName" name="tournamentName" value={tournamentData.tournamentName} onChange={handleChange} required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="tournamentVenue">Venue</label></td>
                                <td><input type="text" id="tournamentVenue" name="tournamentVenue" value={tournamentData.tournamentVenue} onChange={handleChange} required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="sportName">Sport Name</label></td>
                                <td><input type="text" id="sportName" name="sportName" value={tournamentData.sportName} onChange={handleChange} required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="tournamentDate">Date</label></td>
                                <td><input type="date" id="tournamentDate" name="tournamentDate" value={tournamentData.tournamentDate} onChange={handleChange} required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="tournamentTime">Time</label></td>
                                <td><input type="time" id="tournamentTime" name="tournamentTime" value={tournamentData.tournamentTime} onChange={handleChange} required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="slots">Slots</label></td>
                                <td><input type="number" id="slots" name="slots" value={tournamentData.slots} onChange={handleChange} min="1" required /></td>
                            </tr>
                            <tr>
                                <td><label htmlFor="tournamentDescription">Description</label></td>
                                <td><textarea id="tournamentDescription" name="tournamentDescription" value={tournamentData.tournamentDescription} onChange={handleChange} required /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div className={styles.btns}>
                        <button type="button" className={styles.cancel_btn} onClick={onClose}>Cancel</button>
                        <button type="submit" className={styles.confirm_btn}>Save</button>
                    </div>
                </form>



            </div>
        </div>
    );
}

export default TournamentFormModal;
