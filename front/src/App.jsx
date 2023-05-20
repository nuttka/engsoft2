import React from 'react';
import Home from './pages/home';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Register from './pages/register';
import Property from './pages/property';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home />}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/property/:id" element={<Property/>}/>
            </Routes>
        </Router>
        
    )
}

export default App;