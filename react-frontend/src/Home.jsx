import './Home.css';  
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import NoteButton from './NoteButton';
import { useEffect, useState } from 'react';

function Home() {
  const location = useLocation();
  const { name, id } = location.state || { name: "Default User",id:-1 };

  const [ diaries, setDiaries ] = useState();
  const navigate = useNavigate();

  const logOut = () => {
    navigate("/login")  
  }

  useEffect(()=>{
    setInterval(()=>{
      axios.get('http://localhost:8080/get-notes?userId=' + id)
                    .then((response) => {
                        console.log(response.data);
                        setDiaries(response.data);
                      })
                    .catch((error) => 
                    {

                    });

    }, 10)
  },[]);

  return (
    <div className="container">
    <nav className="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div className="container-fluid d-flex justify-content-between">
        <h4>{"Welcome, " + name}</h4>
        <button onClick={logOut}className="btn btn-primary ms-auto" id="log-out">Log Out</button>
      </div>
    </nav>
    <div className="container">
      {diaries && diaries.map((note)=>{return <NoteButton key={note.id} noteName={note.name} note={note.note}></NoteButton>
})}
    </div>
    </div>
  );
}

export default Home;

