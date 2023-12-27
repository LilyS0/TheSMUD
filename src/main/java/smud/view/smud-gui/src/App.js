import './App.css';
import Homepage from './pages/Homepage';
import PlayChoice from './pages/PlayChoice';
import Store from './pages/Store';
import Inventory from './pages/Inventory';
import Arena from './pages/Arena';
import Dungeon from './pages/Dungeon';
import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';

function App() {
  
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route index element={<Homepage/>} />
          <Route path="/play-choice" element={<PlayChoice/>} />
          <Route path="/store" element={<Store/>}/>
          <Route path="/inventory" element={<Inventory/>}/>
          <Route path="/arena" element={<Arena/>}/>
          <Route path="/dungeon" element={<Dungeon/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
