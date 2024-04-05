import React, { useState } from 'react';
//import ReactDOM from 'react-dom';
import { Link } from 'react-router-dom';
//import Password from '../components/Password';
import { createUser } from '../components/userService';
import signUpFirebase from '../components/signUpFirebase';

function CreateAccount() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleCreateAccount = async (e) => {
        e.preventDefault();

        console.log('Creating account...');
        console.log("First name:", firstName);
        console.log("Last name:", lastName);
        console.log('Email:', email);
        console.log('Username:', username);
        console.log('Password:', password);

        const fireBaseUser = await signUpFirebase(email, password);

        if (fireBaseUser) {
            createUser({ name: username, admin: false, uid: fireBaseUser.uid})
            console.log('User created:', fireBaseUser);
        }

        setFirstName('');
        setLastName('');
        setEmail('');
        setUsername('');
        setPassword('');
    };

    return (
        <div>
            <h2>Create account for CD Inventory Control System</h2>
            <form onSubmit={handleCreateAccount}>
                <input type="text" placeholder="First Name" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                <input type="text" placeholder="Last Name" value={lastName} onChange={(e) => setLastName(e.target.value)} />

                <br/>
                <br/>

                <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />

                <br/>
                <br/>

                <input type="text" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} required />

                <br/>
                <br/>

                <div class="icons">
                    <i class="fa-regular fa-eye"></i>
                </div>

                <input type="password" placeholder="Password" value={password} className="password" onChange={(e) => setPassword(e.target.value)} required />

                <br/>
                <br/>

                <button type="submit">Create Account</button>
            </form>
            <p>Already have an account? <Link to="/login">Log In</Link></p>
        </div>
    );
};

export default CreateAccount;