import React, { useEffect, useState } from "react";
import styles from "./Navbar.module.css";
import { FaUserCircle } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const Navbar = ({ setSearchSport }) => {
  const [selectedSection, setSelectedSection] = useState("Tournaments");
  const [menuOpen, setMenuOpen] = useState(false);
  const [isAdmin, setIsAdmin] = useState(false);
  const [userName, setUserName] = useState(null);

  const navigate = useNavigate();

  useEffect(() => {
    const role = JSON.parse(localStorage.getItem("role"));
    const name = JSON.parse(localStorage.getItem("name"));

    if (role === "ROLE_ADMIN") {
      setIsAdmin(true);
    }

    if (name) {
      setUserName(name);
    }
  }, []);

  const handleLogout = () => {
    console.log("logout");
    localStorage.clear();
    navigate("/");
    window.location.reload();  
  };

  const handleEnrollment = () => {
    navigate("/enrollment");
  };

  return (
    <nav className={styles.navbar}>
      <div className={styles.logo} onClick={() => navigate("/")}>
        <img src="./sportico logo1.png" alt="App Logo" />
      </div>

      <div className={styles.navLinks}>
        <button
          className={`${styles.navButton} ${
            selectedSection === "Tournaments" ? styles.active : ""
          }`}
          onClick={() => setSelectedSection("Tournaments")}
        >
          Tournaments
        </button>

        <button
          className={`${styles.navButton} ${
            selectedSection === "Coaching" ? styles.active : ""
          }`}
          onClick={() => setSelectedSection("Coaching")}
        >
          Coaching
        </button>
      </div>

      <div className={styles.searchContainer}>
        <input
          type="text"
          placeholder="Search by Sport Name..."
          onChange={(e) => setSearchSport(e.target.value)}
          className={styles.searchInput}
        />
      </div>

      <div className={styles.profileMenu}>
        {userName ? (
          <>
            <h5>Hi, {userName}</h5>
            <FaUserCircle
              className={styles.profileIcon}
              onClick={() => setMenuOpen(!menuOpen)}
            />
            <ul
              className={`${styles.menuDropdown} ${
                menuOpen ? styles.open : ""
              }`}
            >
              <li onClick={() => navigate("/profile")}>Profile</li>
              {!isAdmin && (
                <>
                  <li onClick={handleEnrollment}>Enrolled Tournaments</li>
                  <li onClick={() => setMenuOpen(false)}>Enrolled Coaching</li>
                </>
              )}
              <li onClick={handleLogout}>Logout</li>
            </ul>
          </>
        ) : (
          <div className={styles.authLinks}>
            <button onClick={() => navigate("/login")}>Login</button>
            <button onClick={() => navigate("/register")}>Register</button>
          </div>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
