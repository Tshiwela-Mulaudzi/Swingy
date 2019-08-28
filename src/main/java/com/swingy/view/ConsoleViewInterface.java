package com.swingy.view;

import com.swingy.model.Hero;
import com.swingy.helpers.Tools;
import com.swingy.controller.GameMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.Validation;
import java.util.Set;
import javax.validation.ConstraintViolation;

public class ConsoleViewInterface implements ViewModeInterface {
    private final String name = "Console";
    private Hero hero = null;
    private String gameMode = null;
    private ViewModeInterface view = null;

    public ConsoleViewInterface(){
        System.out.printf("%s MODE\n", this.name);
    }

    public void Starting(Scanner sc){
        int input = -1;

        try {
            System.out.println("\nYOU");
            sc = new Scanner(System.in);
            System.out.print("Press 1 to create hero OR Press 2 to select hero: ");
            if (!sc.hasNextInt())
                throw new Exception();
            input = sc.nextInt();
            sc.nextLine(); // Moving Cursor
            if ((input < 1) || (2 < input))
                throw new Exception();
        } catch (Exception e){
            System.out.println("\nERROR\nInput should be 1 or 2.");
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            if (input == 1)
                this.createHero(sc);
            else if (input == 2)
                this.SelectingOldHero(sc);
        }
    }

    private boolean isOkay() {
        boolean successful = true;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Hero>> violations = validator.validate(this.hero);
        for (ConstraintViolation<Hero> violation : violations) {
            successful = false;
            System.out.println(violation.getMessage()); 
        }
        return (successful);
    }

    public void createHero(Scanner sc){
        String name = null;
        String heroClass = null;
        int level;
        long experience;
        int attack;
        int defence;
        int hitPoints;

        System.out.println("\nGAME\nNow, lets create a new hero");
//        System.out.println("\nYOU");

        try {
            System.out.print("Enter name of your hero: ");
            name = sc.nextLine();
            
            System.out.print("Enter class your hero should belong to: ");
            heroClass = sc.nextLine();
            
            System.out.print("Enter Level (Integer between 1 - 5): ");
            level = sc.nextInt();
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter your experience level (Number): ");
            experience = sc.nextLong();
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter attack points (Number): ");
            attack = sc.nextInt();
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter defence points(Number): ");
            defence = sc.nextInt();
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter hit points (Number): ");
            hitPoints = sc.nextInt();

            this.hero = new Hero(name, heroClass, level, experience, attack, defence, hitPoints);
            if (!this.isOkay()) {
                this.gameMode = "CONSOLE";
                System.out.println("GAME");
                this.view = new ConsoleViewInterface();
                this.view.run();
            }
        } catch (NoSuchElementException e){
            System.out.println("\n\nERROR\nWrong input data type");
            if (sc != null)
                sc.close();
            System.exit(1);
        } catch (Exception e){
            System.out.println("\n\nERROR\nInput should be between 1 - 5 :: " + e.getMessage());
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            System.out.println("\nGAME:\nNew hero created.");
            System.out.println(this.hero.heroStats());
        }
    }

    public void SelectingOldHero(Scanner sc){
        String heroes = null;
        int heroNumber = -1;
        String heroChosen = null;
        
        System.out.println("\nGAME\nLets select an already existing hero");
        heroes = Tools.AllSavedHeroes(Hero.FILENAME);
        System.out.println(heroes);
        try {
            System.out.println("\nYOU");
            System.out.print("Press hero number you want to select: ");
            heroNumber = sc.nextInt();
            sc.nextLine(); // Moving Cursor

            heroChosen = heroes.split("\n")[heroNumber - 1];
            heroChosen = heroChosen.replaceFirst("[0-9]* - ", "");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nERROR\nHero number chosen doesn't exit.");
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("\nERROR\nOnly numbers accepted.");
            System.exit(0);
        }

        try {
            String data[] = heroChosen.split(",");
            String name = data[0];
            String heroClass = data[1];
            int level = Integer.parseInt(data[2]);
            long experience = Long.parseLong(data[3]);
            int attack = Integer.parseInt(data[4]);
            int defence = Integer.parseInt(data[5]);
            int hitPoints = Integer.parseInt(data[6]);
            this.hero = new Hero(name, heroClass, level, experience, attack, defence, hitPoints);

            System.out.println("\nGAME\nHero Selected");
            System.out.println(this.hero.heroStats());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nERROR\nDatafile corrupt.");
            System.exit(0);
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        this.Starting(sc);
        GameMap map = new GameMap(this.hero.getLevel(), this.hero);
        String move = null;
        boolean correct = false;
        
        System.out.println(map.toString());

        while (true){
            if (map.metVillain()){
                System.out.printf("You met (a) villain(s)\n");
                System.out.println(map.getMetVillainsPositionString());

                System.out.print("\nFight (F) OR Run (R): ");

                String fightOrRun = sc.nextLine();
                if (fightOrRun.equals("R") || fightOrRun.equals("r")){
                    fightOrRun = map.meetOutcome();
                }else if (fightOrRun.charAt(0) == 'F' || fightOrRun.charAt(0) == 'f'){
                    System.out.println("\nGAME\nLets fight");
                    String fightResults = map.fight();
                    System.out.println("\tYOU " + fightResults);
                    if (fightResults.equals("LOSS")){
                        break;
                    }
                    System.out.println(this.hero.heroStats());
                }
                else{
                    System.out.print("Enter an existing game control");
                }
            } 
            else 
            {
                System.out.print("\nEnter your move (N - North, E - East(Right), W - (West)Left & S - South(Down)): ");
                move = map.move(sc.nextLine());
                if (move.equals("END"))
                {
                    System.out.println("\nGAME\nGame ended. You finished the game.");
                    break;
                }
                else {}
            }
            System.out.println("\nGAME");
            System.out.println(map.toString());
        }
    }
}