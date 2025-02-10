import React, { useEffect, useState } from "react";
import styles from "./Profile.module.css";
import UserService from "../../Service/UserService";

const Profile = () => {
  const [user, setUser] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  const [editableUser, setEditableUser] = useState(null);

  useEffect(() => {
    UserService.getSingleUser(JSON.parse(localStorage.getItem("id")))
      .then((response) => {
        setUser(response.data);
        setEditableUser(response.data);
      })
      .catch((error) => console.error("Error fetching profile:", error));
  }, []);

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleChange = (e) => {
    setEditableUser({ ...editableUser, [e.target.name]: e.target.value });
  };

  const handleSave = () => {
    UserService.updateUser(editableUser)
      .then((response) => {
        console.log(response)
        setUser(editableUser);
        setIsEditing(false);
      })
      .catch((error) => console.error("Error updating profile:", error));
  };

  if (!user) {
    return <div className={styles.loading}>Loading profile...</div>;
  }

  return (
    <div className={styles.container}>
      <div className={styles.profileCard}>
        <div className={styles.header}>Profile</div>
        <div className={styles.details}>
          {["fname", "lname", "email", "mobNo"].map((field) => (
            <div className={styles.row} key={field}>
              <strong>{field === "fname" ? "First Name" : field === "lname" ? "Last Name" : field === "mobNo" ? "Mobile Number" : "Email"} : </strong>
              {isEditing ? (
                <input
                  type="text"
                  name={field}
                  value={editableUser[field]}
                  onChange={handleChange}
                  className={styles.input}
                />
              ) : (
                <span>{user[field]}</span>
              )}
            </div>
          ))}
        </div>

        {isEditing ? (
          <button className={styles.button} onClick={handleSave}>Save</button>
        ) : (
          <button className={styles.button} onClick={handleEdit}>Update Details</button>
        )}
        
      </div>
    </div>
  );
};

export default Profile;
