import React from "react";
import { Link } from "react-router-dom";

export default function PlayChoice(){
    return(
        <div>
            <Link to="/arena">Arena</Link>
            <br></br>
            <Link to="/dungeon">Dungeon</Link>
        </div>
    )
}