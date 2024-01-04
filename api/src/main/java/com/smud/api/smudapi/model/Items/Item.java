package com.smud.api.smudapi.model.Items;

import com.smud.api.smudapi.model.SMUDCharacter;

/*
 * <<state>> in state pattern for item subsystem
 * represents an item that can be collected in PvE and used in PvP
 */

public interface Item {
    public void applyItem(SMUDCharacter character);
    public int getGoldValue();
}


