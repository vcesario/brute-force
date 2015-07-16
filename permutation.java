import java.io.*;
import java.util.*;
import java.lang.*;

class permutation{
	static class CharIterator{
		Vector<Character> v = new Vector<Character>();
		int i = 0;
		CharIterator(char c_array[]){
			for (int k = 0; k < c_array.length; k++){
				v.add(new Character(c_array[k]));
			}
		}
		public char next(){
			if (hasNext())
				return v.get(i++);
			else
				throw new ArrayIndexOutOfBoundsException();
		}
		public boolean hasNext(){
			if (i < v.size())
				return true;
			return false;
		}
		public void begin(){
			i = 0;
		}
	}

	static StringBuffer str = new StringBuffer("\0");
	static CharIterator elements = new CharIterator(new char[]{'e','n','r'});

	static String nextPass(){
		int i = 0;
		boolean found, iterate;
		do{
			found = false;
			iterate = false;
			elements.begin();
			while (!found && elements.hasNext()){
				if (str.charAt(i) == elements.next()){
					found = true;
				}
			}
			if(found && elements.hasNext()){
				str.setCharAt(i,elements.next());
			}
			else if (found){
				str.setCharAt(i,'e');
				if (i+1 >= str.length())
					str.append("e");
				else
					iterate = true;
			}
			else{
				str.setCharAt(0,'e');
			}
			i++;
		}while (iterate && i < str.length());
		return str.toString();
	}

	public static void main(String[] args){
		String answer = "renren";
		int iNumber = 0;
		String trial = nextPass();

		while(!trial.equals(answer)){
			trial = nextPass();
			iNumber++;
		}
		System.out.println(">> answer: " + trial);
		System.out.println(">> # of iterations: " + iNumber);
	}
}