package org.example.SpringBoot.WordCalculator;

import org.example.SpringBoot.DataStructures.*;
import org.example.SpringBoot.Exception.CannotComputeException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Permutation {
    //private final HashSet<String> worldList = new HashSet<String>();
    private  String wordToPermutate;
    public Permutation(){

    }
    public Permutation(String givenWord){
        HashSet<String> worldList = new HashSet<String>();
        this.wordToPermutate = givenWord.toLowerCase();



    }
    public void setWordToPermutate(String word){
        this.wordToPermutate = word.toLowerCase();
    }
    public String getWordToPermutate(){return this.wordToPermutate;}
    public HashSet<String> getWorldList() throws CannotComputeException{
    	if(this.wordToPermutate.length()>9) {
    		throw new CannotComputeException("Current computation cannot generate the values for greater than 9");
    	}
        Tree root = new Tree(null, StringHelper.breakDownStringIntoCharList( this.wordToPermutate),null);
        //constructTree(root);   /// <---------------------    currently can only construct for string length <=
        constructTreeIteratively(root);  /// <---------------------    currently can only construct for string length <=11
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
            	/* check if the current node is already created 
            	 * -> if not then create and insert the child into list and continue recursion
            	 */
                Tree node = new Tree(currentNode,removeAElementFromList(currentNode.getAvailableElements(),currentElement),currentElement);
                currentNode.insertAchildNode(node);
                constructTree(node);
            }
        }
    }
    private Tree constructTreeIteratively(Tree currentNode) {
		 Stack<Tree> stack = new Stack<Tree>();
		 ListIterator<String> list_of_available_elements = currentNode.getAvailableElements().listIterator();
		 
		 while(list_of_available_elements.hasNext()){
	            String currentElement = list_of_available_elements.next();
	            Tree node = new Tree(currentNode,removeAElementFromList(currentNode.getAvailableElements(),currentElement),currentElement);
	            currentNode.insertAchildNode(node);
	            stack.push(node);
		 }
		 while(!stack.empty()) {
			 createImmediateChildNodes(stack.pop()).stream().forEach(childNode->{
				 stack.push(childNode);
			 });
			
		 }
		 return currentNode;
		 
	 }
    /*
	  * create immediate child nodes for abc 
	  * 				O
	  *       /         |        \
	  *  	 /          |         \
	  *     /           |          \
	  *  	a 			b			c    -------------------> Immediate childs for root 
	  *   /  \        /   \		  /   \
	  *  b	  c		 a     c	 a     b  -------------------> Immediate childs for nodes "a","b","c" respectively 
	  *  /     \    /      \   /        \
	  *  c      b c         a b           a -------------------> Immediate childs for nodes "c","b","c","a","b","a" respectively 
	  *                           
	  */
	 
	 private List<Tree> createImmediateChildNodes(Tree givenNode) {
		 givenNode.getAvailableElements().stream().forEach(currentValue->{
			
			 Tree node = new Tree(givenNode,removeAElementFromList(givenNode.getAvailableElements(),currentValue),currentValue);
			 givenNode.insertAchildNode(node);
		 });
		 return givenNode.getChildNodes();
	 }

    private List<String> removeAElementFromList(List<String> list,String val){
        List<String> duplicate = new ArrayList<String>();
        list.stream().forEach(value->duplicate.add(value));

        duplicate.remove(val);
        return duplicate;
    }

}
