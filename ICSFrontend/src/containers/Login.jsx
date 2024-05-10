import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import logo from '../images/logo.png';
//import Password from '../components/Password';
import { getUsers } from '../components/userService';
import { useAuth } from '../contexts/AuthContext';
import { doSignInUserWithEmailAndPassword } from '../auth';
//import  from '../../components/';

const Login = ({ setCurrentUser }) => {
    const { userLoggedIn, currentUser } = useAuth();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showPassword, setShowPassword] = useState(false);
    const [message, setMessage] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            await doSignInUserWithEmailAndPassword(email, password);
            window.location.href = "/dashboard";
        } catch(error){
            setMessage('Email or password is invalid')
        }

        console.log("Logging in...");
        console.log("Email:", email);
        console.log("Password:", password);

        setEmail('');
        setPassword('');
    };

    return (
        <div className="login-page">
            {/* <Login /> */}
            <div>
                <form onSubmit={handleLogin} className='login-form'>
                    <img className="login-logo" src={logo} />
                    <div>
                        <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                    </div>
                    <div>
                        <div style={{margin: '0'}}>
                            <input onChange={(e) => setPassword(e.target.value) } type={showPassword ? "text" : "password"} placeholder="Password"></input>
                            <span className="toggle-password" onClick={() => setShowPassword(!showPassword)}>
                                {showPassword ?  <i className="fa fa-eye"></i>: <i className="fa fa-eye-slash"></i>}
                            </span>
                        </div>
                        <p onClick={() => window.location.href = "/forgot-password"} style={{marginTop:'10px'}}>Forgot password?</p>
                    </div>

                    <p className="error-msg">{message}</p>

                    <button type="submit" onClick={handleLogin}>Log In</button>

                    <p>Don't have an account? <Link to="/create-account" className="link">Create Account</Link></p>

                    </form>
                </div>
        </div>
    )
};

export default Login;