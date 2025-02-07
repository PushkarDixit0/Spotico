import React, { useEffect, useState } from "react";
import styles from "./Navbar.module.css";
import { FaUserCircle } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const [selectedSection, setSelectedSection] = useState("Tournaments");
  const [menuOpen, setMenuOpen] = useState(false);
  const [isAdmin , setIsAdmin] = useState(false);

  const navigate = useNavigate();


  useEffect(()=>{
    if(JSON.parse(localStorage.getItem("role"))==="ROLE_ADMIN"){
      setIsAdmin(true);
    }
  },[])

 const handleLogout = ()=>{
  console.log("logout")
  localStorage.clear();
  navigate("/login");
}

const handleEnrollment = ()=>{
  navigate("/enrollment");

}

  return (
    <nav className={styles.navbar}>
      <div className={styles.logo} onClick={()=>navigate('/')}>
        <img src="./sportico logo1.png" alt="App Logo" />
      </div>

      <div className={styles.navLinks}>
        <button
          className={`${styles.navButton} ${selectedSection === "Tournaments" ? styles.active : ""}`}
          onClick={() => setSelectedSection("Tournaments")}
        >
          Tournaments
        </button>

        <button
          className={`${styles.navButton} ${selectedSection === "Coaching" ? styles.active : ""}`}
          onClick={() => setSelectedSection("Coaching")}
        >
          Coaching
        </button>
      </div>


      <div className={styles.profileMenu}>
      <h5>Hii, {JSON.parse(localStorage.getItem("name"))}</h5>
      <FaUserCircle
          className={styles.profileIcon}
          onClick={() => setMenuOpen(!menuOpen)}
        />

        <ul className={`${styles.menuDropdown} ${menuOpen ? styles.open : ""}`}>
          <li onClick={() => setMenuOpen(false)}>Profile</li>
          {!isAdmin && (
            <>
            <li onClick={handleEnrollment}>Enrolled Tournaments</li>
            <li onClick={() => setMenuOpen(false)}>Enrolled Coaching</li>
            </>
          )} 
          <li onClick={handleLogout}>Logout</li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
