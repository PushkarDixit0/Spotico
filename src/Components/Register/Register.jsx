import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import styles from './Register.module.css'; 
import UserService from '../../Service/UserService';

function Register() {
    const navigate = useNavigate();

    const [userData, setUserData] = useState({
        fname: "",
        lname: "",
        dob: "",
        email: "",
        mobNo: "",
        password: "",
    });

    const [errors, setErrors] = useState({
        fname: "",
        lname: "",
        dob: "",
        email: "",
        mobNo: "",
        password: "",
    });

    const onChangeHandler = (e) => {
        setUserData({ ...userData, [e.target.name]: e.target.value });
        setErrors({ ...errors, [e.target.name]: "" });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const newErrors = {};

        for (const key in userData) {
            if (!userData[key].trim()) {
                newErrors[key] = "*Required field";
            }
        }

        const today = new Date();
        const dob = new Date(userData.dob);

        if (dob > today) {
            newErrors.dob = "Date of birth cannot be in the future";
        }

        if (userData.email.trim() && !/^\S+@\S+\.\S+$/.test(userData.email)) {
            newErrors.email = "Invalid email format";
        }

        if (userData.mobNo.trim() && !/^\d{10}$/.test(userData.mobNo)) {
            newErrors.mobNo = "Invalid mobile number format. Please enter a 10-digit number.";
        }

        setErrors(newErrors);

        if (Object.keys(newErrors).length === 0) {
            const response = await UserService.addUser({ ...userData });
            console.log(response)
            if (response) {
                toast.success("User Registered successfully!");
                localStorage.setItem("jwtToken", JSON.stringify(response.data.jwt));
                localStorage.setItem("id", JSON.stringify(response.data.user.id));
                localStorage.setItem("email", JSON.stringify(response.data.user.email));
                localStorage.setItem("role", JSON.stringify(response.data.user.role));
                localStorage.setItem("name",JSON.stringify(response.data.user.name))
                navigate('/', {
                    state: {
                        id: response.data.user.id,
                        email: response.data.user.email,
                        role: response.data.user.role,
                        name: response.data.user.name
                    }
                });
            }else {
                toast.error("Invalid credentials. Please try again.");
            }
        }
    };

    return (
        <>
            <div className="container">
                <div className="row justify-content-center">
                    <div className={`col-md-8 col-lg-6 ${styles.container1}`}>
                    <h3 className={`${styles.title} text-center mb-4`}>Register</h3>
                    <form>
                            <div className={`form-group mb-3 ${styles.formGroup}`}>
                                <div className="row">
                                    <div className="col-md-6">
                                        <label htmlFor="fname">First name</label>
                                        <input
                                            type="text"
                                            id='fname'
                                            name='fname'
                                            className={`form-control ${errors.fname ? 'is-invalid' : ''}`}
                                            value={userData.fname}
                                            onChange={onChangeHandler}
                                        />
                                        {errors.fname && <div className="invalid-feedback">{errors.fname}</div>}
                                    </div>

                                    <div className="col-md-6">
                                        <label htmlFor="lname">Last name</label>
                                        <input
                                            type="text"
                                            id='lname'
                                            name='lname'
                                            className={`form-control ${errors.lname ? 'is-invalid' : ''}`}
                                            value={userData.lname}
                                            onChange={onChangeHandler}
                                        />
                                        {errors.lname && <div className="invalid-feedback">{errors.lname}</div>}
                                    </div>
                                </div>
                            </div>

                            <div className={`form-group mb-3 ${styles.formGroup}`}>
                                <label htmlFor="dob">Date of Birth</label>
                                <input
                                    type="date"
                                    id='dob'
                                    name='dob'
                                    className={`form-control ${errors.dob ? 'is-invalid' : ''}`}
                                    value={userData.dob}
                                    onChange={onChangeHandler}
                                />
                                {errors.dob && <div className="invalid-feedback">{errors.dob}</div>}
                            </div>

                            <div className={`form-group mb-3 ${styles.formGroup}`}>
                                <label htmlFor="mobNo">Mobile number</label>
                                <input
                                    type="text"
                                    id='mobNo'
                                    name='mobNo'
                                    className={`form-control ${errors.mobNo ? 'is-invalid' : ''}`}
                                    value={userData.mobNo}
                                    onChange={onChangeHandler}
                                />
                                {errors.mobNo && <div className="invalid-feedback">{errors.mobNo}</div>}
                            </div>

                            <div className={`form-group mb-3 ${styles.formGroup}`}>
                                <label htmlFor="email">Email</label>
                                <input
                                    type="text"
                                    id='email'
                                    name='email'
                                    className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                                    value={userData.email}
                                    onChange={onChangeHandler}
                                />
                                {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                            </div>

                            <div className={`form-group mb-3 ${styles.formGroup}`}>
                                <label htmlFor="password">Password</label>
                                <input
                                    type="password"
                                    id='password'
                                    name='password'
                                    className={`form-control ${errors.password ? 'is-invalid' : ''}`}
                                    value={userData.password}
                                    onChange={onChangeHandler}
                                />
                                {errors.password && <div className="invalid-feedback">{errors.password}</div>}
                            </div>

                            <button type="submit" className={`submit w-100 ${styles.submit}`} onClick={handleSubmit}>
                                Continue
                            </button>
                        </form>

                        <div className="text-center mt-3">
                            <p id={styles.text}>Already have an account? <span className="text-primary" onClick={() => navigate("/login")}>Sign in</span></p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Register;
