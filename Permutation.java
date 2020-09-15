public class Permutation {
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	    for(int i=11111;i<99999;i++) {
	    	print(""+i);
	    }
	}
	
	public static void print(String arg){
		if(containsAllCharacters("12345",arg))
		if(arg.charAt(1)=='1'){
			System.out.println(arg);
		}
	}
	public static boolean containsAllCharacters(String src,String des){
		if(src.length()!=des.length())
			return false;
		for(int i=0;i<src.length();i++){
			if(!des.contains(""+src.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
