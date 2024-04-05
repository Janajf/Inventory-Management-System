import React, { useState } from 'react';
import showIcon from '/showpassword.png';
import hideIcon from "/hidepassword.png";

const Password = ({ getPassword }) => {
    const [showPassword, setShowPassword] = useState(false);
    const [password, setPassword] = useState('');

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handlePasswordSubmit = async () => {
        await getPassword(() => password);
    };

    return (
        <div className="password-component">
            <input type={showPassword ? 'text' : 'password'} placeholder="Password" className="password" value={password} onChange={handlePasswordChange} />
            <span className="password-toggle" onClick={togglePasswordVisibility}>
                <img src={showPassword ? hideIcon : showIcon} alt="Toggle Password Visibility" />
            </span>
        </div>
    );
}

export default Password;