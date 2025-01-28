import './App.css'
import Login from './Login.jsx'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return <Router>
    <Routes>
    <Route path='/' element={<h1>Hello</h1>} />
    <Route path='/login' element={<Login />} />
    <Route path='/home' element={<Home />} />
    </Routes>
  </Router> 
}

export default App
