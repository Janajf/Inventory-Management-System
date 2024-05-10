import React, {useState, useEffect} from 'react'
import Navbar from '../components/Navbar';
import SideNav from '../components/SideNav';
import Table from '../components/Table';

const InventoryTable = () => {
  return (
    <div className='inventory'>
        <Navbar />
        <div className='container'>
        <SideNav />
        <div className='content'>
            <h1 style={{fontSize:'4rem', margin:'30px'}}>INVENTORY</h1>
                <Table />
            </div>
        </div>
    </div>
  )
}

export default InventoryTable;