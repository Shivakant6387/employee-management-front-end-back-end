// eslint-disable-next-line no-unused-vars
import React, { useEffect, useState } from 'react'
import {useNavigate,useParams} from 'react-router-dom'
import { createEmployee, exitEmployee, getEmployee } from '../../services/EmployeeService'
const EmployeeComponent = () => {
    const[firstName, setFirstName]=useState('')
    const[lastName, setLastName]=useState('')
    const[email, setEmail]=useState('')
    const {id}=useParams();
    const [errors, setErrors]=useState({
        firstName:'',
        lastName:'',
        email:''
    })
    const navigator=useNavigate();

    useEffect(()=>{
        if(id){
            getEmployee(id).then((response)=>{
                setFirstName(response.data.firstName);
                setLastName(response.data.lastName);
                setEmail(response.data.email);
            }).catch(error=>{
                console.error(error);
            })
        }

    },[id])
    function saveOrEditEmployee(e){
        e.preventDefault();

        if(validateForm()){
            const employee={firstName,lastName,email}
             console.log(employee);
            if(id){
                exitEmployee(id,employee).then((response)=>{
                    console.log(response.data)
                    navigator('/employees')
                }).catch(error=>{
                    console.error(error);
                })
            }else{
                    createEmployee(employee).then((response)=>{
                    console.log(response.data);
                    navigator('/employees')
                }).catch(error=>{
                    console.error(error);
                })
            }
        
        }
    }
    function validateForm(){
        let valid=true;
        const errorCoppy={... errors}
        if(firstName.trim()){
            errorCoppy.firstName='';
        }else{
            errorCoppy.firstName='First name is required';
            valid=false;
        }
        if(lastName.trim()){
            errorCoppy.lastName='';
        }else{
            errorCoppy.lastName='Last name is required';
            valid=false;
        }
        if(email.trim()){
            errorCoppy.email='';
        }else{
            errorCoppy.email='Email name is required';
            valid=false;
        }
        setErrors(errorCoppy);
        return valid;
    }
    function pageTitle(){
        if(id){
            return <h2 className='text-center'>Update Employee</h2>
        }else{
            <h2 className='text-center'>Add Employee</h2>
        }

    }
  return (
    <div className='container'>
        <br/><br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                {
                    pageTitle()
                }
                <div className='cord-boby'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>First Name :</label>
                            <input type='text'
                            placeholder='Enter Employee First Name'
                            name='firstName'
                            value={firstName}
                            className={`form-contro ${errors.firstName ? 'is-invalid':''}`}
                            onChange={(e)=>setFirstName(e.target.value)}
                            >
                            </input>
                            {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Last Name :</label>
                            <input type='text'
                            placeholder='Enter Employee Last Name'
                            name='lastName'
                            value={lastName}
                            className={`form-contro ${errors.lastName ? 'is-invalid':''}`}
                            onChange={(e)=>setLastName(e.target.value)}
                            >
                            </input>
                            {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Email :</label>
                            <input type='text'
                            placeholder='Enter Employee  Email'
                            name='email'
                            value={email}
                            className={`form-contro ${errors.email ? 'is-invalid':''}`}
                            onChange={(e)=>setEmail(e.target.value)}
                            >
                            </input>
                            {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                        </div>
                        <button className='btn btn-success' onClick={saveOrEditEmployee}>Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
  )
}

export default EmployeeComponent