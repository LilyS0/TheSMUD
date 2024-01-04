package com.smud.api.smudapi.model.Cards.Traps;

public class DamageTrap extends Trap{

    private int damage;

    public DamageTrap(){
        this.name = "Damage trap";
        this.health = 10;
        this.damage = 10;
    }

    @Override
    public boolean canOccupy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canOccupy'");
    }

    public int getDamage(){
        return damage;
    }

}
