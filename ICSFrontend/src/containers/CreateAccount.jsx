import React, { useState } from 'react';
//import ReactDOM from 'react-dom';
import { Link } from 'react-router-dom';
import logo from '../images/logo.png';
import axios from 'axios';
//import Password from '../components/Password';
import { createUser } from '../components/userService';
import signUpFirebase from '../components/signUpFirebase';
import { doCreateUserWithEmailAndPassword } from '../auth';

function CreateAccount() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const apiUrl = import.meta.env.REACT_APP_API_URL;

    const handleCreateAccount = async (e) => {
        e.preventDefault();

        console.log('Creating account...');
        console.log("First name:", firstName);
        console.log("Last name:", lastName);
        console.log('Email:', email);
        console.log('Password:', password);

        try {
            const fireBaseUser = await signUpFirebase(email, password);

            if (fireBaseUser) {
                await doCreateUserWithEmailAndPassword(email, password);
                await axios.post(`${apiUrl}/users`, {
                    firstName: firstName,
                    lastName: lastName,
                    email: email,
                    password: password,
                    role: 'USER'
                });

                createUser({ name: username, admin: false, uid: fireBaseUser.uid})
                console.log('User created:', fireBaseUser);
            }

            setFirstName('');
            setLastName('');
            setEmail('');
            setPassword('');
        } catch (error) {
            console.error('Error creating account:', error.message);
        }
    };

    return (
        <div className="login-page">
            <form onSubmit={handleCreateAccount} id="register-form" className='login-form'>
                <img className="login-logo" src={logo} />
                
                <div>
                    <input type="text" placeholder="First Name" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                </div>
                <div>
                    <input type="text" placeholder="Last Name" value={lastName} onChange={(e) => setLastName(e.target.value)} />
                </div>
                <div>
                    <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div>
                    <input type="password" placeholder="Password" value={password} className="password" onChange={(e) => setPassword(e.target.value)} required minLength={6} />
                </div>

                <button type="submit">Create Account</button>

                <p>Already have an account? <Link to="/login" className="link">Log In</Link></p>
            </form>
        </div>
    );
};

export default CreateAccount;