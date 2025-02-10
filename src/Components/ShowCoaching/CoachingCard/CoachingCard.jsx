import React, { useState } from 'react';

import feedbackService from '../../../Service/FeedbackService';
import styles from './CoachingCard.module.css';
import coachingEnrollService from '../../../Service/CoachingEnrollService';


const CoachingCard = ({ coaching, sports, coaches, EnrollFlag }) => {
  const [feedbackMsg, setFeedbackMsg] = useState("");
  const [showFeedbackInput, setShowFeedbackInput] = useState(false);

// const isAdmin=localStorage.getItem("role")==="ROLE_ADMIN"?true:false;

  if (!coaching) return null;


  const sport = sports.find(sport => sport.id === coaching.sportID);
  const sportName = sport?.name || "N/A";
  const coach = coaches.find(coach => coach.id === coaching.coachID);
  const coachName = coach ? `Mr. ${coach.fname} ${coach.lname}` : "N/A";

  const formattedDate = coaching.createdOn
    ? new Date(coaching.createdOn).toLocaleDateString('en-US', { year: 'numeric', month: 'long', day: 'numeric' })
    : "Date not available";

  const handleEnrollClick = async () => {
    const userId = localStorage.getItem("id");
    if (!userId) {
      alert("User not logged in. Please log in first.");
      return;
    }

    const enrollmentData = {
      userId: Number(userId),
      coachingSessionId: coaching.id,
      sportId: sport?.id || "N/A",
      paymentType: "PAYMENT_PENDING",
      sportType: sport?.type || "N/A"
    };

    try {
      await coachingEnrollService.saveEnrollment(enrollmentData);
      alert("Successfully enrolled in coaching session!");
    } catch (error) {
      console.error("Enrollment failed:", error);
      alert("Enrollment failed. Please try again later.");
    }
  };

  const handleFeedbackSubmit = async () => {
    if (!feedbackMsg.trim()) {
      alert("Feedback cannot be empty!");
      return;
    }

    const userId = localStorage.getItem("id");
    if (!userId) {
      alert("User not logged in. Please log in first.");
      return;
    }

    const feedbackData = {
      user_ID: Number(userId),
      coach_ID: coaching.coachID,
      message: feedbackMsg,
      date: new Date().toISOString().split('T')[0]
    };

    try {
      await feedbackService.submitFeedback(feedbackData);
      alert("Feedback submitted successfully!");
      setFeedbackMsg("");
      setShowFeedbackInput(false);
    } catch (error) {
      console.error("Feedback submission failed:", error);
      alert("Failed to submit feedback. Please try again later.");
    }
  };

  return (
    <div className={`${styles.card} ${showFeedbackInput ? styles.expandedCard : ''}`}>
      <h3>{coaching.session_Branch ?? "Session Type Not Available"}</h3>
      <p><strong>Venue:</strong> {coaching.venue ?? "Venue not specified"}</p>
      <p><strong>Date:</strong> {formattedDate}</p>
      <p><strong>Sport:</strong> {sportName}</p>
      <p><strong>Coach:</strong> {coachName}</p>

      {!EnrollFlag && (
        <button className={styles.enrollButton} onClick={handleEnrollClick}>
          Enroll Now
        </button>
      )}


{EnrollFlag && (
  showFeedbackInput ? (
    <div className={`${styles.feedbackInputContainer} ${styles.feedbackActive}`}>
     <button className={styles.cancelButton} onClick={() => setShowFeedbackInput(false)}>❌</button>
      <input
        type="text"
        value={feedbackMsg}
        onChange={(e) => setFeedbackMsg(e.target.value)}
        placeholder="Enter your feedback..."
        className={styles.feedbackInput}
      />
      
      <button className={styles.sendButton} onClick={handleFeedbackSubmit}>➤</button>
    
    
    </div>
  ) : (
    <button className={styles.enrollButton} onClick={() => setShowFeedbackInput(true)}>
      Feedback
    </button>
    
  )
)}

    </div>
  );
};

export default CoachingCard;
