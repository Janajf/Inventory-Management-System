import React from 'react';
import { Link } from 'react-router-dom'
import Password from '../components/Password';
//import  from '../../components/';

const CreateAccount = () => {
    return (
        <div>
            {/* <Login /> */}
            <h2>Create account for CD Inventory Control System</h2>

            <input type="text" placeholder="First Name" className="firstName"/>
            <input type="text" placeholder="Last Name" className="lastName"/>

            <br/>
            <br/>

            <input type="email" placeholder="Email/Username" className="email"/>

            <br/>
            <br/>

            <div className="password-create-account">
                <Password />
            </div>

            <br/>
            <br/>

            <span>
                <button type="submit" className="createAccount">
                    <span>Create Account</span>
                </button>
            </span>

            <br/>
            <br/>

            <p>Already have an account? <Link to="/login">Log In</Link></p>
        </div>
    )
};

export default CreateAccount;