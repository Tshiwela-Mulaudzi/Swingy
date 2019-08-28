package com.swingy.helpers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tools{
    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);  
    }

    public static String AllSavedHeroes(String filename){
        FileReader fr = null;
        BufferedReader br = null;
        String line = null;
        String results = null;
        int count = 1;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            line = br.readLine();
            if (line == null)
                throw new NoDataException();
            results = count++ + " - " + line;
            while ((line = br.readLine()) != null){
                results += "\n" + count++ + " - " + line;
            }
        } catch (IOException e) {
            System.out.println("\nERROR\nProblem with reading file.");
            System.exit(0);
        } catch (NoDataException e){
            e.message();
            System.exit(0);
        }
        return results;
    }

    public static String[] HeroesList(String heroesString){
        return heroesString.split("\n");
    }
}