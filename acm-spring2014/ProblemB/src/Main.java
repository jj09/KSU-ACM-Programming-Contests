import java.io.*;
import java.util.LinkedList;

class Case {
	public int n;
	public int k;
	public double[] numbers;
	public double[] queries;
}

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Case> cases = new LinkedList<Case>();
		
		String[] line;
		String temp = stdin.readLine();
		while(temp.compareTo("0 0")!=0) {	
			// read n, k
			line = temp.split(" ");
			Case c = new Case();
			c.n = Integer.parseInt(line[0]);
			c.k = Integer.parseInt(line[1]);
			
			// read numbers
			int consumed = 0;
			c.numbers = new double[c.n];
			do {
				temp = stdin.readLine();
				line = temp.split(" ");				
				for(int i=0; i<line.length; ++i) {
					c.numbers[consumed+i] = Integer.parseInt(line[i]);
				}
				consumed += line.length;
			} while(consumed<c.n);
			
			// read queries
			consumed = 0;
			c.queries = new double[c.k];
			do {
				temp = stdin.readLine();
				line = temp.split(" ");			
				for(int i=0; i<line.length; ++i) {
					c.queries[consumed+i] = Integer.parseInt(line[i]);
				}
				consumed += line.length;
			} while(consumed<c.k);
			
			cases.add(c);
			
			temp = stdin.readLine();
		}
		
		for(Case c : cases) {
			for(Double query : c.queries) {				
				double best = Math.abs(c.numbers[0]);
				double bestAbs = Math.abs(query-best);
				int bestStartIndex = 0;
				int bestEndIndex = 0;
				for(int i=0; i<c.n; ++i) {
					for(int j=i; j<c.n; ++j) {
						double rangeSum = getRangeSum(c.numbers, i, j);
						if (Math.abs(query-rangeSum) < bestAbs) {
							bestAbs = Math.abs(query-rangeSum);
							best = rangeSum;
							bestStartIndex = i;
							bestEndIndex = j;
						}
					}
				}
				
				System.out.println(String.format("%.0f", best) + " " + ++bestStartIndex + " " + ++bestEndIndex);
			}									
		}
	}

	private static double getRangeSum(double[] numbers, int i, int j) {
		double sum = 0;
		while(i<=j) {
			sum += numbers[i];
			++i;
		}
		return Math.abs(sum);
	}
	
//	private static BigInteger getRangeSum(int[] numbers, int i, int j) {
//		BigInteger sum = new BigInteger("0");
//		while(i<=j) {
//			String val = String.format("%d", numbers[i]);
//			sum.add(new BigInteger(val));
//			++i;
//		}
//				
//		return sum.abs();
//	}

}
