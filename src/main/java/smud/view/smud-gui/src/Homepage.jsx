import React from "react";


export default function Homepage(){
    return(
        <div>
            <h1>The SMUD</h1>
            <h2 onClick={() => window.location.href='/play-choice'}>Play</h2>
            <h2>Store</h2>
            <h2>Inventory</h2>
        </div>
    )
}