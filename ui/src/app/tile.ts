import { SMUDCharacter } from "./SMUDCharacter";
import { card } from "./card";

export interface tile{
    placedCard: card;
    character: SMUDCharacter;
}