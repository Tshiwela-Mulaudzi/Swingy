package com.swingy.model;
import javax.validation.constraints.*;

public class Hero extends Player {
    public static final String FILENAME = "heroes.txt";
    
    private Position previousPosition = null;
    @NotBlank(message = "Name cannot be null")
    //@Size(max=3,min=10, message="The name must be between 3 and 10 in length")
    private String name = null;
    @NotBlank(message = "Class cannot be null")
    //@Size(max=3,min=10, message="The Class must be between 3 and 10 in length")
    private String heroClass = null;
    @Digits(integer=1, fraction=0, message="Level digits cannot less/greater than 1")
	@Min(value=1, message="Level min value cannot be less than 1")
	@Max(value=5, message="Level max value cannot be more than 5")
    private int level;
    @Digits(integer=2, fraction=0, message="Experience digits cannot greater than 2")
    @Min(value=0, message="Experience min value cannot be less than 0")
    @Max(value=50, message="Experience max value cannot be more than 50")
    private long experience;
    @Digits(integer=2, fraction=0, message="Attack digits cannot greater than 2")
    @Min(value=0, message="Attack min value cannot be less than 0")
    @Max(value=50, message="Attack max value cannot be more than 50")
    private int attack;
    @Digits(integer=2, fraction=0, message="Defence digits cannot greater than 2")
    @Min(value=0, message="Defence min value cannot be less than 0")
    @Max(value=50, message="Defence max value cannot be more than 50")
    private int defence;
    @Digits(integer=2, fraction=0, message="HitPoints digits cannot greater than 2")
    @Min(value=0, message="HitPoints min value cannot be less than 0")
    @Max(value=50, message="HitPoints max value cannot be more than 50")
    private int hitPoints;

    public Hero(){}

    public Hero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
    }

    public void setHero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
    }

    public String heroStats(){
        String results = null;

        results = "--- Hero Stats ---\n";
        results += String.format("Name: %s\n", this.name);
        results += String.format("Class: %s\n", this.heroClass);
        results += String.format("Level: %s\n", this.level);
        results += String.format("Experience: %s\n", this.experience);
        results += String.format("Attack: %s\n", this.attack);
        results += String.format("Defence: %s\n", this.defence);
        results += String.format("Hit Points: %s\n", this.hitPoints);
        return results;
    }

    public void takeArtifacts(int weapon, int armor, int helm){
        this.attack += weapon;
        this.defence += armor;
        this.hitPoints += helm;
    }

    public int getAttackValue(){
        return this.attack;
    }

    public int getDefenceValue(){
        return this.defence;
    }

    public int getHitPoints(){
        return this.hitPoints;
    }

    public void incrementLevel(){
        this.level++;
    }

    public int getLevel(){
        return this.level;
    }

    public void makePreviousPositionNull(){
        this.previousPosition = null;
    }

    public void setPreviousPosition(int row, int column){
        if (this.previousPosition == null)
            this.previousPosition = new Position(row, column);
        else {
            this.previousPosition.setRow(row);
            this.previousPosition.setColumn(column);
        }
    }

    public Position getPreviousPosition(){
        return this.previousPosition;
    }

    public void changePosition(int row, int column){
        this.setPreviousPosition(this.getRow(), this.getColumn());

        this.position.changeRow(row);
        this.position.changeColum(column);
    }

    public String toString(){
        String results = null;

        results = String.format("%s,%s,%d,%d,%d,%d,%d", this.name, this.heroClass, this.level, this.experience, this.attack, this.defence, this.hitPoints);
        return results;
    }
}