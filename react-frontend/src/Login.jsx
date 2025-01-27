import './Login.css'

import { useState, React } from 'react';
import axios from 'axios';

function Login() {

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

        axios.get('http://localhost:8080/user?id=1')
             .then((response) => {
                console.log(response.data);
             })
            .catch((error) => 
            {

            });
    }

    const onRegister = () => {
        console.log('Register Button Clicked');
    };

    return (
      <div id="login">
        <h1>Login to Note App</h1>
        <label >Username: </label><input type="text" value={username} onChange={onUsernameChange}/>
        <label>Password: </label><input type="password" value={password} onChange={onPasswordChange}/>
        <button onClick={onLogin}>Login</button>
        <button onClick={onRegister}>Register</button>
      </div>
    );
  }
  
export default Login;