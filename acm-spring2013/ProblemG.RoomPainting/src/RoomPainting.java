import java.io.*;

public class RoomPainting {
	
	public static class Node {
		int value;
		Node[] children;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int n = 0;
		int m = 0;
		int[] offered;
		int[] needed;
		
		//read input
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String input = stdin.readLine();
		
		String[] sizes = input.split(" ");
		n = Integer.parseInt(sizes[0]);
		m = Integer.parseInt(sizes[1]);
		
		offered = new int[n];
		for(int i=0; i<n; ++i) {
			input = stdin.readLine();
			offered[i] = Integer.parseInt(input);
		}

		needed = new int[m];
		for(int i=0; i<m; ++i) {
			input = stdin.readLine();
			needed[i] = Integer.parseInt(input);
		}
		
		//sort can sizes
		for(int i=0; i<n; ++i) {
			for(int j=i+1; j<n; ++j) {
				if(offered[i]>offered[j]) {
					int temp = offered[i];
					offered[i] = offered[j];
					offered[j] = temp;
				}
			}
		}
		
		//compute		
		int wasted = 0;
		for(int i=0; i<m; ++i) {
			for(int j=0; j<n; ++j) {
				int difference = offered[j]-needed[i];
				if(difference>=0) {
					wasted += difference;
					break;
				}
			}
		}
		
		
		//output
		System.out.println(wasted);

	}

}
