import React, { useEffect, useState } from 'react';
import Navbar from '../../Components/Navbar/Navbar';
import CoachingCard from '../../Components/ShowCoaching/CoachingCard/CoachingCard';
import sportService from '../../Service/SportService';
import userService from '../../Service/UserService';
import coachingEnrollService from '../../Service/CoachingEnrollService';
import CoachingSessionService from '../../Service/CoachingSessionService';
import styles from '../../Components/ShowCoaching/ShowCoaching.module.css';

export default function EnrollCoaching() {
  // eslint-disable-next-line no-unused-vars
  const [enrollFlag, setEnrollFlag] = useState(true);
  const [coachingEnrollments, setCoachingEnrollments] = useState([]);
  const [coachingSessions, setCoachingSessions] = useState([]);
  const [sports, setSports] = useState([]);
  const [coaches, setCoaches] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const userId = localStorage.getItem("id");

        const [enrollmentRes, sessionsRes, sportsRes, coachesRes] = await Promise.all([
          coachingEnrollService.getAllEnrollmentsById(userId),
          CoachingSessionService.getAllSessions(),
          sportService.getAllSports(),
          userService.getAllCoaches()

        ]);

        if (enrollmentRes.status === 200 && Array.isArray(enrollmentRes.data)) {
          setCoachingEnrollments(enrollmentRes.data);
         
          
        } else {
          console.error('Invalid enrollment data format:', enrollmentRes.data);
        }

        if (sessionsRes.status === 200 && Array.isArray(sessionsRes.data)) {
          setCoachingSessions(sessionsRes.data);
        } else {
          console.error('Invalid coaching session data format:', sessionsRes.data);
        }

        if (sportsRes.status === 200 && Array.isArray(sportsRes.data)) {
       
            setSports(sportsRes.data);

            
        } else {
          console.error('Invalid sports data format:', sportsRes.data);
        }

        if (coachesRes.status === 200 && Array.isArray(coachesRes.data)) {
           setCoaches(coachesRes.data);
         
         
            
        } else {
          console.error('Invalid coaches data format:', coachesRes.data);
        }
      } catch (err) {
        console.error('Error fetching data:', err);
        setError('Failed to load data.');
      } finally {
               
        setLoading(false);
      }

     
      
      
    };

    fetchData();
  }, []);

  if (loading) return <p>Loading your enrollments...</p>;

  // Map enrollments to session details
  const enrolledCoachingSessions = coachingEnrollments.map((enroll) => {
    const session = coachingSessions.find((session) => session.id === enroll.coachingSessionId);
    return session ? { ...session, paymentType: enroll.paymentType, sportId: enroll.sportId } : null;
  }).filter(Boolean); // Remove null values

  return (
    <div>
      <Navbar />
      <h2 className={styles.heading}>Your Enrolled Coaching Sessions</h2>
      <div className={styles.coachingContainer}>
        <div className={styles.coachingList}>
          {error ? (
            <p className={styles.errorMessage}>{error}</p>
          ) : enrolledCoachingSessions.length > 0 ? (
            enrolledCoachingSessions.map((coaching) => (
              <CoachingCard 
                key={coaching.id} 
                coaching={coaching} 
                sports={sports} 
                coaches={coaches} 
                EnrollFlag={enrollFlag} 
              />
            ))
          ) : (
            <p>You have not enrolled in any coaching sessions.</p>
          )}
        </div>
      </div>
    </div>
  );
}
