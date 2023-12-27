import React from "react";
import { Link } from "react-router-dom";


export default function Homepage(){
    return(
        <div>
            <h1>The SMUD</h1>
            <Link to="/play-choice">Play</Link>
            <br></br>
            <Link to="/store">Store</Link>
            <br></br>
            <Link to="/inventory">Inventory</Link> 
        </div>
    )
} 