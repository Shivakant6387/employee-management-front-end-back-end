
import './App.css'
import EmployeeComponent from './assets/components/EmployeeComponent'
import FooterComponent from './assets/components/FooterComponent'
import ListEmployeeComponents from './assets/components/ListEmployeeComponents'
import HeaderComponent from './assets/components/headerComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
function App() {

  return (
    <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/' element={<ListEmployeeComponents />}></Route>
          <Route path='/employees' element={<ListEmployeeComponents />}></Route>
          <Route path='/add-employee' element={<EmployeeComponent />}></Route>
          <Route path='edit-employee/:id' element={<EmployeeComponent />}></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
  )
}

export default App
