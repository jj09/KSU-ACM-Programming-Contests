import java.io.*;
import java.util.*;

public class FallingLeavesTrick {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));

		// input
		LinkedList<ArrayList<String>> sequences = new LinkedList<ArrayList<String>>();
		String input = stdin.readLine();
		while (input.compareTo("$") != 0) {
			ArrayList<String> lines = new ArrayList<String>();

			if (input.compareTo("*") == 0) {
				sequences.add(lines);
				continue;
			} else {
				lines.add(input);
			}
			input = stdin.readLine();
		}

		// compute

		for (int i = 0; i < sequences.size(); ++i) {
			// create tree
			ArrayList<String> sequence = sequences.get(i);

			// preorder traversal
			String pt = "";
			StringBuilder sb = new StringBuilder();

			/*
			 * TODO: strings without the tree: - more than 1 more letter if next
			 * is longer than 1 - next is equal to one, then consume from the
			 * end
			 */
			for (int j = sequence.size() - 1; j >= 0; --j) {
				if (j > 0) {
					if (sequence.get(j).length() > (sequence.get(j - 1).length() + 1)) {
						pt = sequence.get(j).charAt(sequence.get(j).length()-1) + pt;
						sequence[j]  = sequence.get(j).substring(0,sequence.get(j).length()-1);
					}
				}
			}			

			// output
			System.out.println(pt);
		}

	}
}
