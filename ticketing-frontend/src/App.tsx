import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from './components/Login';
import Events from './components/Events';
import './index.css';

function App() {
    return (
        <BrowserRouter>
            <div>
                <h1 style={{ textAlign: 'center', padding: '10px', backgroundColor: '#333', color: 'white' }}>
                    Ticketing Platform
                </h1>

                <Routes>
                    <Route path="/login" element={<Login />} />

                    <Route path="/events" element={<Events />} />

                    <Route path="/" element={<Navigate to="/events" />} />
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;