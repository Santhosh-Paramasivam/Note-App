import Login from './Login.jsx'
import Home from './Home.jsx'
import NoteEditor from './NoteEditor.jsx';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return <Router>
    <Routes>
    <Route path='/' element={<h1>Hello</h1>} />
    <Route path='/login' element={<Login />} />
    <Route path='/home' element={<Home />} />
    <Route path='/editor' element={<NoteEditor/>} />
    </Routes>
  </Router> 
}

export default App
