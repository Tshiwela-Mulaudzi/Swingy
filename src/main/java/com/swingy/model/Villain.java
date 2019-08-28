package com.swingy.model;

import java.util.Random;

public class Villain extends Player {
    private final int powerRange = 20;
    private int weapon;
    private int armor;
    private int helm;

    public Villain(int level){
        Random random = new Random();
   
        this.weapon = random.nextInt(this.powerRange + 1) * level;
        this.armor = random.nextInt(this.powerRange + 1) * level;
        this.helm = random.nextInt(this.powerRange + 1) * level;
    }

    public int getWeaponValue(){
        return this.weapon;
    }

    public int getArmorValue(){
        return this.armor;
    }

    public int getHelmValue(){
        return this.helm;
    }

    public String stats(){
        String results = null;
        results = "--- Villain Stats ---\n";
        results += String.format("Weapon: %s\n", this.weapon);
        results += String.format("Armor: %s\n", this.armor);
        results += String.format("Helm: %s\n", this.helm);
        return results;
    }
}