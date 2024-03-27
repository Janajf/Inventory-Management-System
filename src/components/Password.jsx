import React, { useState } from 'react';
import showIcon from '/showpassword.png';
import hideIcon from "/hidepassword.png";

const Password = () => {
    const [showPassword, setShowPassword] = useState(false);

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    return (
        <div className="password-component">
            <input type={showPassword ? 'text' : 'password'} placeholder="Password" className="password"/>
            <span className="password-toggle" onClick={togglePasswordVisibility}>
                <img src={showPassword ? hideIcon : showIcon} alt="Toggle Password Visibility" />
            </span>
        </div>
    );
}

export default Password;