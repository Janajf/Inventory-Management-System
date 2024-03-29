import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import './App.css'
import Login from './containers/Login'
import CreateAccount from './containers/CreateAccount'

function App() {

  return (
    <>
      <Router>
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/create-account" element={<CreateAccount />} />
        </Routes>
      </Router>
    </>
  )
}

export default App
