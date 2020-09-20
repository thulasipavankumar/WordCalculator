package org.example.SpringBoot.WordCalculator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

public class Dictionary {
    private static HashSet<String> words=new HashSet();
    static{
        try {

            words = new HashSet<String>(Files.readAllLines(Paths.get("words_alpha.txt")));
             System.out.println("loaded words");
        }catch(Exception ex){
            System.out.println("Exception in reading dictonary file"+ex.getMessage());
        }
    }
    public static boolean isDictionaryWord(String givenWord){
        return words.contains(givenWord);
    }

}
