import { Component } from '@angular/core';
import { tile } from '../tile';
import { TILES } from '../mock-tiles';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent {
  tiles: tile[][] = [];
  tiles1: tile[] = TILES;

  constructor(){
    for(let i=0; i<13; i++){
      this.tiles.push(TILES);
    }
  }
}
