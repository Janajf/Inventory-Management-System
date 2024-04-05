import React, { useState } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import './App.css'
import Login from './containers/Login'
import CreateAccount from './containers/CreateAccount'

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <>
      <Router>
        <Routes>
            <Route path="/" element={isLoggedIn ? <Navigate to="/home" /> : <Login setIsLoggedIn={setIsLoggedIn} />} />
            <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn} />} />
            <Route path="/create-account" element={<CreateAccount />} />
        </Routes>
      </Router>
    </>
  )
}

export default App
