import { useState } from "react";
import { useLocation, useNavigate } from 'react-router-dom';
import './NoteEditor.css';

function NoteEditor()
{
    const [ title, setTitle ] = useState('');
    const [ note, setNote ] = useState('');

    const { name, id } = location.state || { name: "Default User",id:-1 };

    const updateTitle = (e) => {
        setTitle(e.target.value);
    }

    const updateNote = (e) => {
        setNote(e.target.value);
    }
    
    const saveNote = () => {
        
    }

    return <div id="container">

    <nav className="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div className="container-fluid d-flex justify-content-between">
        <button className="btn btn-primary ms-auto" id="log-out">Save and Exit</button>
      </div>
    </nav>

    <div id="input-container">
    <input id="title" value={title} onChange={updateTitle} placeholder="Title"></input>
    <textarea id="note" value={note} onChange={updateNote} placeholder="Note"></textarea>
    </div>
    </div>;
}

export default NoteEditor;