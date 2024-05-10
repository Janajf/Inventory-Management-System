import React, { useState } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import './App.css'
import Login from './containers/Login'
import CreateAccount from './containers/CreateAccount'
import ForgotPassword from './containers/ForgotPassword'
import InventoryTable from './containers/InventoryTable'
import Dashboard from './containers/Dashboard'
import ProfileInformation from './containers/ProfileInformation'

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <>
      <Router>
        <Routes>
            <Route path="/" element={isLoggedIn ? <Navigate to="/dashboard" /> : <Login setIsLoggedIn={setIsLoggedIn} />} />
            <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn} />} />
            <Route path="/forgot-password" element={<ForgotPassword />} />
            <Route path="/create-account" element={<CreateAccount />} />
            <Route path="/inventory" element={<InventoryTable />}/>
            <Route path="/dashboard" element={<Dashboard />}/>
            <Route path="/profile" element={<ProfileInformation/>}/>
        </Routes>
      </Router>
    </>
  )
}

export default App
