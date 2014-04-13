import java.io.*;
import java.util.LinkedList;

class Case {
	public String firstNumber;
	public String secondNumber;
	public String sum;
}

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Case> cases = new LinkedList<Case>();
		
		String[] line;
		String temp;
		do {	
			temp = stdin.readLine();
						
			line = temp.split("\\+");			
			Case c = new Case();
			c.firstNumber = line[0];
			line = line[1].split("=");
			c.secondNumber = line[0];
			c.sum = line[1];			
			cases.add(c);			
			
		} while(temp.compareTo("0+0=0")!=0);
		
		for(Case c : cases) {
			int first = getNumber(c.firstNumber);
			int second = getNumber(c.secondNumber);
			int sum = getNumber(c.sum);
			String result = first+second == sum ? "True" : "False";
			System.out.println(result);		
		}
	}

	private static int getNumber(String number) {
		int sum = 0;
		for(int i=number.length()-1; i>=0; --i) {
			int pow = (int)Math.pow(10.0, (i+1));
			sum += Integer.parseInt(number.charAt(i)+"") * pow;
		}
		return sum;		
	}

}
