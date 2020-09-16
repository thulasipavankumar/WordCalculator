public class Permutation {
	HashSet<String> finalWords = new HashSet<String>();
    public static void main(String[]  args){
        String word = "123456";
        List<String> listWord = new ArrayList<String>();
        for(char ch:word.toCharArray())
            listWord.add(""+ch);
        Tree root = new Tree(null,listWord,null);
         Permutation obj = new Permutation();
         obj.constructTree(root);
         root.getChildNodes().stream().forEach(childNode->childNode.printValues()  );
         obj.printValues(root);
         System.out.println(obj.finalWords.size());
         obj.finalWords.stream().forEach(val->System.out.println(val));


    }

    public void constructTree(Tree currentNode){
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


    public void  printValues(Tree node){
        if (node.getChildNodes().isEmpty()) {
            printFromBottom(node);
            return;
        }
        ListIterator<Tree> list = node.getChildNodes().listIterator();

        while(list.hasNext()) {
        printValues(list.next());
        }
    }
    public void printFromBottom(Tree node){
        String word="";
        while(node.getParentNode()!=null||node.getCurrentValue()!=null){
            word=word+node.getCurrentValue();
            node = node.getParentNode();
        }
       // System.out.println(word);
        pushToHashSet(word);
    }
    public List<String> removeAElementFromList(List<String> list,String val){
        List<String> duplicate = new ArrayList<String>();
        list.stream().forEach(value->duplicate.add(value));

        duplicate.remove(val);
        return duplicate;
    }
    public  void pushToHashSet(String val){
        finalWords.add(val);

    }
    /*
    public void fill_first_level_in_tree(Tree root){
        List<String> avaialbleElements = root.getAvailableElements();
        for(int i=0;i<avaialbleElements.size();i++){
            String value = avaialbleElements.get(i);
            List <String>ramainingElements = removeAElementFromList(root.getAvailableElements(),value);
            Tree node = new Tree(root,ramainingElements,value);
            root.insertAchildNode(node);
        }
    }

     */
}
