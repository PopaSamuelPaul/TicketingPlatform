import React, {useState} from 'react';
import api from '../services/api.ts'

const Login=()=> {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');


    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault();
        setError('');

        try {
            const response = await api.post('/auth/login', {
                email: email,
                password: password
            });
            const token = response.data;
            localStorage.setItem('jwt_token', token);
            alert('Logare cu succes!');
        } catch (_err) {
            setError('Email sau parola incorrecta!');
        }
    };

    return (
        <div style={{padding: '20px', maxWidth: '300px', margin: '0 auto'}}>
            <h2>Login</h2>
            {error && <p style={{color: 'red'}}>{error}</p>}
            <form onSubmit={handleLogin} style={{display: 'flex', flexDirection: 'column', gap: '10px'}}>
                <input
                    type="email"
                    placeholder="Adresa de email:"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="parola"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <button type="submit" style={{padding: '10px'}}>
                    Intra in cont
                </button>
            </form>
        </div>
    );

}
export default Login;