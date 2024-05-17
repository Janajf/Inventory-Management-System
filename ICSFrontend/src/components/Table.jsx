import React, { useEffect, useState} from "react";
import axios from 'axios';
import AddRowForm from "./AddRowForm";
import LaptopTable from "./LaptopTable";
import StudentTable from "./StudentTable";
import InventorySearch from "./InventorySearch";
import SupplyTable from "./SupplyTable";

const Table = () => {
  
  const apiUrl = process.env.REACT_APP_API_URL;
  const [editedRowValues, setEditedRowValues] = useState({});
  const [addRowMode, setAddRowMode] = useState(false);
  const [tableRows, setTableRows] = useState([]);
  const [savedTableRows, setSavedTableRows] = useState([]);
  const [editMode, setEditMode] = useState(false);
  const [selectedRow, setSelectedRow] = useState(0);
  const [currentId, setCurrentId] = useState(0);
  const [selectedTable, setSelectedTable] = useState("Computers");
  const currentDate = new Date().toISOString().split("T")[0];

  useEffect(() => {
    // Reset editedRowValues when edit mode changes
    if (!editMode) {
      setEditedRowValues({});
    }
  }, [editMode]);

  useEffect(() => {
    fetchData();
  }, [selectedTable]);

  const addNewRow = () => {
    setAddRowMode(!addRowMode);
  };
  const handleInputChange = (field, value) => {
    setEditedRowValues((prev) => ({
      ...prev,
      [field]: value,
    }));
  };
  //editing existing rows
  const confirmEdit = () => {
    //searches for selectedRow and edits the values that have been changed.
    const updatedRows = tableRows.map((row) =>
      row.id === selectedRow ? { ...row, ...editedRowValues } : row
    );
    console.log(updatedRows);
    async function update() {
      try {
        const newRow = updatedRows.find((row) => row.id === selectedRow);
        await axios.put(`${apiUrl}/${selectedTable.toLowerCase()}/${selectedRow}`, newRow);
        fetchData();
        
      } catch (error) {
        console.error("something went wrong could not update");
      }
    }
    //temp
    update();
    setEditMode(false);
  };
  const fetchData = async () => {
    try {
      const response = await axios.get(`${apiUrl}/${selectedTable.toLowerCase()}`);
      setTableRows(response.data ? response.data : []);
      setSavedTableRows(response.data ? response.data : []);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  //editing
  const editRow = (id) => {
    setSelectedRow(id);
    setEditMode(true);
  };
  //deleting
  const deleteRow = (id) => {
    async function handleDelete() {
      try {
        await axios.delete(`${apiUrl}/${selectedTable.toLowerCase()}/${id}`);
        fetchData();
      } catch (error) {
        console.error("something went wrong could not delete");
      }
    }
    handleDelete();
  };
  const changeDisplayedTable = (e) => {
    setSelectedTable(e.target.value);
  }
  return (
    <div style={{display:'flex', flexDirection: 'column', alignItems: 'center'}}>
      <div>
        <label style={{fontSize:"1.5rem"}}>View: </label>
        <select onChange={changeDisplayedTable}>
        <option value="Computers">Computers</option>
        <option value="Students">Students</option>
        <option value="Supplies">Supplies</option>
      </select>
      <button onClick={addNewRow} className="addNewButton">
        Add New
      </button>
      </div>
      <div style={{width: '100%', display:'flex', justifyContent:"space-between"}}>
        <InventorySearch tableRows={tableRows} setTableRows={setTableRows} selectedTable={selectedTable} savedTableRows={savedTableRows}/>
        <div></div>
      </div>
      {addRowMode && (
        <AddRowForm
          fetchData={fetchData}
          setTableRows={setTableRows}
          setAddRowMode={setAddRowMode}
          addNewRow={addNewRow}
          selectedTable={selectedTable}
        />
      )}
      {selectedTable === "Computers" ? 
        <LaptopTable
          tableRows={tableRows}
          editMode={editMode}
          selectedRow={selectedRow}
          handleInputChange={handleInputChange}
          confirmEdit={confirmEdit}
          editRow={editRow}
          deleteRow={deleteRow}
          currentId={currentId}
          setCurrentId={setCurrentId}
        /> :
        selectedTable === "Students" ? 
        <StudentTable
          tableRows={tableRows}
          editMode={editMode}
          selectedRow={selectedRow}
          handleInputChange={handleInputChange}
          confirmEdit={confirmEdit}
          editRow={editRow}
          deleteRow={deleteRow}
          currentId={currentId}
          setCurrentId={setCurrentId}
        /> : 
          <SupplyTable 
            tableRows={tableRows}
            editMode={editMode}
            selectedRow={selectedRow}
            handleInputChange={handleInputChange}
            confirmEdit={confirmEdit}
            editRow={editRow}
            deleteRow={deleteRow}
            currentId={currentId}
            setCurrentId={setCurrentId}
          />
      } 
    </div>
  );
};

export default Table;