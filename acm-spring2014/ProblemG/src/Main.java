import java.io.*;
import java.util.LinkedList;

class Case {
	public double lat;
	public double lon;
	public int n;
	public double h;
	public LinkedList<TestCase> tests = new LinkedList<TestCase>();
}

class TestCase {
	public String name;
	public double lat;
	public double lon;
}

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Case> cases = new LinkedList<Case>();
		
		String[] line;
		String temp = stdin.readLine();
		line = temp.split(" ");
		while(line[0].compareTo("0")!=0) {
			Case c = new Case();
			
			c.n = Integer.parseInt(line[0]);
			c.lat = Double.parseDouble(line[1]);
			c.lon = Double.parseDouble(line[2]);
			c.h = Double.parseDouble(line[3]);
			
			for(int i=0; i<c.n; ++i) {
				temp = stdin.readLine();
				temp = temp.replace('\t', ' ');
				line = temp.split(" ");
				TestCase tc = new TestCase();
				tc.name = line[0];
				tc.lat = Double.parseDouble(line[1]);
				tc.lon = Double.parseDouble(line[2]);
				c.tests.add(tc);
			}			
			cases.add(c);			
			temp = stdin.readLine();
			line = temp.split(" ");
		} 
		
		for(Case c : cases) {
			
			String result = "true";
			System.out.println(result);		
		}
	}

}
