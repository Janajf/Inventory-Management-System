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
                          justifyContent: 'space-between', 
                          width: '40%',
                          fontSize: '2rem',
                        }}>
              <Link to={`/home`} style={{padding: '20px 0px 0px 30px'}}> Home </Link>
              <Link to={`/dashboard`} style={{padding: '20px 0px 0px 30px'}}> Dashboard </Link>
              <Link to={`/`} style={{padding: '20px 0px 0px 30px', whiteSpace: 'nowrap'}}> Log Out </Link>
              <Link to={`/profile`} style={{padding: '20px 0px 0px 30px'}}><img className="profileLogo" src={profileLogo}/></Link>
            </div>         
        </header>
  )
}

export default Navbar