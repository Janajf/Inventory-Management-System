import React, { useState } from 'react';
import { Link } from 'react-router-dom';
//import Password from '../components/Password';
import { getUsers } from '../components/userService';
//import  from '../../components/';

const Login = ({ setCurrentUser }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = (e) => {
        e.preventDefault();
        console.log("Logging in...");
        console.log("Username:", username);
        console.log("Password:", password);

        setUsername('');
        setPassword('');
    };

    return (
        <div>
            {/* <Login /> */}
            <h2>Log in to CD Inventory Control System</h2>
            <form onSubmit={handleLogin}>
                <input type="username" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} required />
            
                <br/>
                <br/>

                <div className="password-login">
                    <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>

                <br/>
                <br/>

                <span>
                    <button type="submit" className="login" onClick={handleLogin}>
                        <span>Log In</span>
                    </button>
                </span>
            </form>

            <br/>
            <br/>

            <p>Don't have an account? <Link to="/create-account">Create Account</Link></p>
        </div>
    )
};

export default Login;