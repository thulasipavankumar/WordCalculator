package org.example.SpringBoot.DataStructures;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {
    public static List<String> breakDownStringIntoCharList(String arg){
        List<String> listWord = new ArrayList<String>();
        for(char ch:arg.toCharArray())
            listWord.add(""+ch);
        return listWord;
    }

}
