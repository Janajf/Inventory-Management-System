import React, { useState, useEffect } from 'react';
import Navbar from '../components/Navbar';
import SideNav from '../components/SideNav';

const Dashboard = () => {
    const handleInventory = (e) => {
        e.preventDefault();

        window.location.href = "/inventory";
    };

    const handleExpense = (e) => {
        e.preventDefault();

        window.location.href = "/";
    };

    return (
        <div className='dashboard'>
            <Navbar />
            <div className='container'>
                <SideNav />
                <div className='content'>
                    <h1 style={{ fontSize: '4rem', marginTop: '30px' }}>DASHBOARD</h1>
                    <div style={
                        {
                            width: '600px',
                            height: '300px',
                            padding: '20px'
                        }
                    }>
                        <button type="submit" onClick={handleInventory} className='inventoryButton'>Inventory Control System</button>

                        <br/>

                        <button type="submit" onClick={handleExpense} className='expenseButton'>Expense Tracker</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Dashboard;