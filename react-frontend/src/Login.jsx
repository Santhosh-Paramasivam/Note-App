import './Login.css'

import { useState, React } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {

    const navigate = useNavigate();

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const onUsernameChange = (e) => {
        setUsername(e.target.value);
    }

    const onPasswordChange = (e) => {
        setPassword(e.target.value);
    }

    const onLogin = () => {
        console.log('Login Button Clicked');

        if(!username || !password)
        {
          alert("Username and password fields cannot be empty!");
          return;
        }
        
        if(username.length < 8 || password.length < 8)
        {
          alert("Username and password must be atleast 8 characters long");          
          return;
        }


        axios.get('http://localhost:8080/authuser?username=' + username + '&password=' + password)
             .then((response) => {
                console.log(response.data);
                navigate("/home", { state : { name : username, id : response.data} });
             })
            .catch((error) => 
            {

            });

    }

    const onRegister = () => {
        console.log('Register Button Clicked');

        axios.post('http://localhost:8080/adduser?username=' + username + '&password=' + password)
                    .then((response) => {
                        console.log(response.data);
                    })
                    .catch((error) => 
                    {

                    });
    };

    return (
      <div id="login">
        <h3>Login to Note App</h3>
        <label>Username: </label><input type="text" value={username} onChange={onUsernameChange}/>
        <label>Password: </label><input type="password" value={password} onChange={onPasswordChange}/>
        <button onClick={onLogin}>Login</button>
        <button onClick={onRegister}>Register</button>
      </div>
    );
  }
  
export default Login;