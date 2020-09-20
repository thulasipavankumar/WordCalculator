package org.example.SpringBoot.WordCalculator;

import org.example.SpringBoot.DataStructures.StringHelper;
import org.example.SpringBoot.DataStructures.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class Permutation {
    //private final HashSet<String> worldList = new HashSet<String>();
    private  String wordToPermutate;
    public Permutation(){

    }
    public Permutation(String givenWord){
        HashSet<String> worldList = new HashSet<String>();
        this.wordToPermutate = givenWord;



    }
    public void setWordToPermutate(String word){
        this.wordToPermutate = word;
    }
    public String getWordToPermutate(){return this.wordToPermutate;}
    public HashSet<String> getWorldList(){
        Tree root = new Tree(null, StringHelper.breakDownStringIntoCharList( this.wordToPermutate),null);
        constructTree(root);
        HashSet<String> worldList = new HashSet<String>();
        storeValuesIntoHashSet(root,worldList);
        //System.out.println("The combinations are");
        //worldList.stream().forEach(val->System.out.println(val));
        return worldList;

    }
    private HashSet<String>  storeValuesIntoHashSet(Tree node,HashSet<String> hashSet){
        if (node.getChildNodes().isEmpty()) {
            printFromBottom(node,hashSet);
            return hashSet;
        }
        ListIterator<Tree> list = node.getChildNodes().listIterator();

        while(list.hasNext()) {
            storeValuesIntoHashSet(list.next(),hashSet);
        }
        return hashSet;
    }
    private void printFromBottom(Tree node,HashSet<String> result){
        String word="";
        while(node.getParentNode()!=null||node.getCurrentValue()!=null){
            word=word+node.getCurrentValue();
            node = node.getParentNode();
        }
        // System.out.println(word);
        result.add(word);
    }
    private void constructTree(Tree currentNode){
        ListIterator<String> list_of_available_elements = currentNode.getAvailableElements().listIterator();
        while(list_of_available_elements.hasNext()){
            String currentElement = list_of_available_elements.next();
            if(!currentNode.hasNodeWithValue(currentElement)){
                Tree node = new Tree(currentNode,removeAElementFromList(currentNode.getAvailableElements(),currentElement),currentElement);
                currentNode.insertAchildNode(node);
                constructTree(node);
            }
        }
    }

    private List<String> removeAElementFromList(List<String> list,String val){
        List<String> duplicate = new ArrayList<String>();
        list.stream().forEach(value->duplicate.add(value));

        duplicate.remove(val);
        return duplicate;
    }

}
