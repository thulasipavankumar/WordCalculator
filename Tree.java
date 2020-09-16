import java.util.*;
public class Tree {
   private final Tree parentNode;
   private     List<Tree> childNodes  = new ArrayList<Tree>();
   private final List<String> availableElements;
   private final String currentValue;
    Tree(Tree parentNode,List<String> availableElements,String currentValue){
       this.parentNode = parentNode;
       this.availableElements = availableElements;
       this.currentValue = currentValue;
   }
   public void insertAchildNode(Tree childNode){
        childNodes.add(childNode);
   }

   public List<Tree> getChildNodes(){
        return childNodes;
   }

   public String getCurrentValue(){
        return currentValue;
   }
   public Tree getParentNode(){
        return parentNode;
   }
   public List<String> getAvailableElements(){
        return availableElements;
   }
   public boolean hasNodeWithValue(String val){
        return childNodes.contains(val);
   }
   public void printValues(){
       System.out.print(currentValue+"->");
       childNodes.stream().forEach(node->System.out.print(node.getCurrentValue()+"->"));
       System.out.print("\n Elements "+currentValue+"->");
       availableElements.stream().forEach(val->System.out.print(val+"=>"));
       System.out.println();
   }

}
