import './App.css';
import Homepage from './Homepage';
import PlayChoice from './PlayChoice';
import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";

function App() {
  
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Homepage/>} />
          <Route path="/play-choice" element={<PlayChoice/>} />
        </Routes>
      </BrowserRouter>
    </div>
    
  );
}

export default App;
