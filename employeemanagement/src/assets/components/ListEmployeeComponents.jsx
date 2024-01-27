
// eslint-disable-next-line no-unused-vars
import React, { useEffect, useState } from 'react';
import { deleteEmployee, listEmployees } from '../../services/EmployeeService';
import {useNavigate} from 'react-router-dom'
const ListEmployeeComponents = () => {
    const [listEmployee,setEmployee]=useState([])
    const navigator=useNavigate();
    useEffect(()=>{
      getAllEmployees();
    },[])
    function getAllEmployees(){
      listEmployees().then((response)=>
        {
            setEmployee(response.data);
        
        }).catch(error=>{
            console.error(error);
        })
    }

    function addNewEmployee(){
      navigator('/add-employee')
    }
    function exitEmployee(id){
      navigator(`/edit-employee/${id}`)
    }
    function removeEmployee(id){
      console.log(id);
      // eslint-disable-next-line no-unused-vars
      deleteEmployee(id).then((response)=>{
          getAllEmployees();
      }).catch(error=>{
        console.error(error);
      })
    }
  return (
    <div className='container'>
      <h2 className='text-center'>List of Employees</h2>
      <button className='btn btn-success mb-2' onClick={addNewEmployee}>add Employee</button>
      <table className='table table-striped table-bordered'>
        <thead>
            <tr>
            <th>Employee Id</th>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee Email Id</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            {
               listEmployee.map(employee=><tr key={employee.id}>
                    <td>{employee.id}</td>
                    <td>{employee.firstName}</td>
                    <td>{employee.lastName}</td>
                    <td>{employee.email}</td>
                    <td><button className='btn btn-info'onClick={()=>exitEmployee(employee.id)}>Edit</button>
                    <button className='btn btn-danger'onClick={()=>removeEmployee(employee.id)} style={{marginLeft:'15px'}}>Delete</button>
                    </td>
                </tr>)
            }
        </tbody>
      </table>
    </div>
  )
}

export default ListEmployeeComponents
