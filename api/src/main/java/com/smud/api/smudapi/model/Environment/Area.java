package com.smud.api.smudapi.model.Environment;

import java.util.ArrayList;

import com.smud.api.smudapi.model.Cards.NPCs.NPC;


/*
 * <<composite>> of tiles in composite pattern for environment subsystem
 * represents a composite of tiles that one or more players and cards can exist in
 */

public abstract class Area implements DungeonElement{
    
    protected Tile[][] tiles;

    @Override
    public void updateTime(boolean isDay) {
        for(Tile[] row: tiles){
            for(Tile tile: row){
                tile.updateTime(isDay);
            }
        }
    }

    //setters

    public void setTiles(Tile[][] tiles){
        this.tiles = tiles;
    }

    //getters

    public Tile getTile(int x, int y){
        return tiles[y][x];
    }

    @Override
    public ArrayList<NPC> getMonsters() {

        ArrayList<NPC> monsters = new ArrayList<>();

        for(Tile[] row: tiles){
            for(Tile tile: row){
                monsters.add(tile.getMonster());
            }
        }

        return monsters;
    }

    @Override
    public ArrayList<DungeonElement> getChildren() {
        ArrayList<DungeonElement> children = new ArrayList<>();

        for(Tile[] row: tiles){
            for(Tile tile: row){
                children.add(tile);
            }
        }

        return children;
    }
}
