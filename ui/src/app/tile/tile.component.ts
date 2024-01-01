import { Component, Input } from '@angular/core';
import { tile } from '../tile';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.css']
})
export class TileComponent {

  @Input() tile: tile;
  imagePath: string;

  constructor(){
    this.imagePath = "assets/images/tiles.png";
    this.tile = {placedCard: {id: 0, name: "card"}, character: {name: "char", health:0, attack:0, defense:0}};
  }
}
