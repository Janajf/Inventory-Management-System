import React from 'react';
import { Link } from 'react-router-dom';
import Password from '../components/Password';
//import  from '../../components/';

const Login = () => {

    return (
        <div>
            {/* <Login /> */}
            <h2>Log in to CD Inventory Control System</h2>

            <input type="email" placeholder="Email/Username" className="email"/>
            
            <br/>
            <br/>

            <div className="password-login">
                <Password />
            </div>

            <br/>
            <br/>

            <span>
                <button type="submit" className="login">
                    <span>Log In</span>
                </button>
            </span>

            <br/>
            <br/>

            <p>Don't have an account? <Link to="/create-account">Create Account</Link></p>
        </div>
    )
};

export default Login;