import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import styles from './Login.module.css';
import UserService from '../../Service/UserService';
import ReCAPTCHA from 'react-google-recaptcha';

function Login() {
    const navigate = useNavigate();

    const [loginData, setLoginData] = useState({
        email: "",
        password: ""
    });

    const [errors, setErrors] = useState({
        email: "",
        password: ""
    });

    // const [captchaValue, setCaptchaValue] = useState(null);

    // const handleCaptchaChange = (value) => {
    //     setCaptchaValue(value);
    // };

    const onChangeHandler = (e) => {
        setLoginData({ ...loginData, [e.target.name]: e.target.value });
        setErrors({ ...errors, [e.target.name]: "" });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // if (!captchaValue) {
        //     alert("Please complete the CAPTCHA");
        //     return;
        // }
        
        const newErrors = {};

        if (!loginData.email.trim()) {
            newErrors.email = "*Required field";
        } else if (!/^\S+@\S+\.\S+$/.test(loginData.email)) {
            newErrors.email = "Invalid email format";
        }

        if (!loginData.password.trim()) {
            newErrors.password = "*Required field";
        }

        setErrors(newErrors);

        if (Object.keys(newErrors).length === 0) {
            const response = await UserService.loginUser(loginData);

            if (response) {
                toast.success("Login successful!");
                console.log(response);
                localStorage.setItem("jwtToken", JSON.stringify(response.data.jwt));
                localStorage.setItem("id", JSON.stringify(response.data.user.id));
                localStorage.setItem("email", JSON.stringify(response.data.user.email));
                localStorage.setItem("role", JSON.stringify(response.data.user.role));
                localStorage.setItem("name", JSON.stringify(response.data.user.name));
                navigate('/', {
                    state: {
                        id: response.data.user.id,
                        role: response.data.user.role,
                        name: response.data.user.name
                    }
                });
            } else {
                toast.error("Invalid credentials. Please try again.");
            }
        }
    };

    return (
        <div className={`${styles.container} container`}>
            <div className="row justify-content-center">
                <div className={`${styles.container1} col-md-8 col-lg-6`}>
                    <h3 className={`${styles.title} text-center mb-4`}>Login</h3>
                    <form>
                        <div className="form-group mb-3">
                            <label htmlFor="email">Email</label>
                            <input
                                type="text"
                                id='email'
                                name='email'
                                className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                                value={loginData.email}
                                onChange={onChangeHandler}
                            />
                            {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                        </div>

                        <div className="form-group mb-3">
                            <label htmlFor="password">Password</label>
                            <input
                                type="password"
                                id='password'
                                name='password'
                                className={`form-control ${errors.password ? 'is-invalid' : ''}`}
                                value={loginData.password}
                                onChange={onChangeHandler}
                            />
                            {errors.password && <div className="invalid-feedback">{errors.password}</div>}
                        </div>

                        {/* Add reCAPTCHA here */}
                        {/* <div className="form-group mb-3">
                            <ReCAPTCHA
                                siteKey="6LdFF80qAAAAAKkOoZuaoXFvRJ7mHCDq5dstoFM2"
                                onChange={handleCaptchaChange}
                            />
                        </div> */}

                        <button type="submit" className={`${styles.submit} submit w-100`} onClick={handleSubmit}>
                            Login
                        </button>
                    </form>

                    <div className="text-center mt-3">
                        <p>Don't have an account? <span className="text-primary" onClick={() => navigate("/register")}>Sign up</span></p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
