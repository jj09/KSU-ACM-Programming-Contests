import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

class Case {
	public String str;
}

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Case> cases = new LinkedList<Case>();
		
		String temp = stdin.readLine();
		do {			
			int linesCount = Integer.parseInt(temp);
			
			Case c = new Case(); 
			c.str = "";
			for(int i=0; i<linesCount; ++i) {
				temp = stdin.readLine();
				c.str += temp;				
			}			
			cases.add(c);
			
			temp = stdin.readLine();			
		} while(temp.compareTo("0")!=0);
		
		for(Case c : cases) {
			TreeMap<String, Integer> digrams = new TreeMap<String, Integer>();
			for(int i=0; i<c.str.length()-1; ++i) {
				String s = c.str.substring(i, i+2);
				Integer f = digrams.get(s);
				if(f==null) {
					digrams.put(s, 1);
				} else {
					digrams.put(s, f+1);
				}
			}
			
			for(int i=0; i<5; ++i) {
				//find max and remove
				int max = -1;
				String keyMax = "";
				for(String key : digrams.keySet()) {
					int val = digrams.get(key);
					if(val > max) {
						keyMax = key;
						max = val;
					}
				}				
				System.out.println(keyMax + " " + max + " " + String.format("%.6f", (float)max/(c.str.length()-1)) );
				digrams.remove(keyMax);
			}	
			
			System.out.println();
		}
	}

}
