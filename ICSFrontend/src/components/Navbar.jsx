import React from 'react'
import logo from '../images/logo.png'
import { Link } from 'react-router-dom'
import profileLogo from '../images/user-profile.png'

const Navbar = () => {
  return (
        <header className='header'>
            <img className="logo" src={logo} />
            <div style={{
                          display: 'flex', 
                          justifyContent: 'space-evenly', 
                          width: '30%', 
                          fontSize: '2rem'
                        }}>
              <Link to={`/dashboard`}> Home </Link>
              <Link to={`/`}> Log Out </Link>
              <Link to={`/profile`}><img className="profileLogo" src={profileLogo}/></Link>
            </div>         
        </header>
  )
}

export default Navbar