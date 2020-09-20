package org.example.SpringBoot.WordCalculator;

public class SearchWord {
    private String word;

    public  SearchWord(){

    }
    public SearchWord(String givenWord){
        this.word = givenWord;
    }
    public void setword(String givenWord){
        this.word = givenWord;
    }
    public boolean isDictionaryWord(){
        return Dictionary.isDictionaryWord(this.word);
    }
}
