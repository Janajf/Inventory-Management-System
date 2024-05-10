import React, {useState, useEffect } from 'react'
import searchIcon from '../images/search.png'

const InventorySearch = ({  tableRows, setTableRows, selectedTable, savedTableRows }) => {
  const tableFields = {
    Laptops: ["assetTag", "serialNumber", "status", "brand", "model", "type", "color", "issuedTo", "grant"],
    Students: ["badge", "studentName", "location"],
    Supplies: [""]
  };

  const handleSearch = (userInput) => {
    if (!userInput.trim()) {
      setTableRows(savedTableRows);
    } else {
      console.log(savedTableRows)
      const filteredOptions = savedTableRows.filter(row => {
        const fieldsToSearch = tableFields[selectedTable] || [];
        return fieldsToSearch.some(field => {
          const fieldValue = row[field] ? row[field].toLowerCase() : '';
          return fieldValue.includes(userInput.toLowerCase());
        });
      });
      setTableRows(filteredOptions);
    }
  };

  return (
    <div className="search-bar">
      <input
        type="text"
        placeholder="Search..."
        onChange={(e) => handleSearch(e.target.value)}
      />
      <img src={searchIcon} alt="Search" />
    </div>
  );
};

export default InventorySearch;