import java.io.*;

class Brute2{
	//char elements[] = {'e','n','r'};
	static StringBuffer next = new StringBuffer("\0");

	static String nextPass(){
		int i = 0;
		boolean iterate;
		do{
			iterate = false;
			switch(next.charAt(i)){
				case 'e': next.setCharAt(i,'n'); break;
				case 'n': next.setCharAt(i,'r'); break;
				case 'r':
					next.setCharAt(i,'e');
					if (i+1 >= next.length()) next.append("e");
					else iterate = true;
					break;
				default: next.setCharAt(i,'e');
			}
			i++;
		}while (iterate && i < next.length());
		return next.toString();
	}

	public static void main(String[] args){
		String answer = "rrenrer";
		String trial = nextPass();
		int iNumber = 0;
		while(!trial.equals(answer)){
			trial = nextPass();
			iNumber++;
		}
		System.out.println(">> answer: " + trial);
		System.out.println(">> # of iterations: " + iNumber);
	}
}