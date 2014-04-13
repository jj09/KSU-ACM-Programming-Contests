import java.io.*;
import java.util.*;

public class RoomPaintingMultiple {

	public static int n = 0;
	public static int m = 0;
	public static int[] offered;
	public static int[] needed;
	public static LinkedList<Integer> leaves = new LinkedList<Integer>();

	public static class Node {
		int value;
		Node[] children;
	}

	public static void AddChildren(Node aNode, int currentNeed)
			throws Exception {
		if (aNode.value < currentNeed) {
			aNode.children = new Node[n];
			for (int i = 0; i < n; ++i) {
				aNode.children[i] = new Node();
				aNode.children[i].value = aNode.value + offered[i];
				AddChildren(aNode.children[i], currentNeed);
			}
		} else if (aNode.value == currentNeed) {
			throw new Exception();
		} else {
			leaves.add(aNode.value);
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// read input
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String input = stdin.readLine();

		String[] sizes = input.split(" ");
		n = Integer.parseInt(sizes[0]);
		m = Integer.parseInt(sizes[1]);

		offered = new int[n];
		for (int i = 0; i < n; ++i) {
			input = stdin.readLine();
			offered[i] = Integer.parseInt(input);
		}

		needed = new int[m];
		for (int i = 0; i < m; ++i) {
			input = stdin.readLine();
			needed[i] = Integer.parseInt(input);
		}

		// compute
		int wasted = 0;
		for (int i = 0; i < m; ++i) {
			int currentNeed = needed[i];
			leaves.clear();

			try {
				// create graph
				Node head = new Node();
				head.value = 0;
				AddChildren(head, currentNeed);

				// find min
				int min = 1000;
				for (int j = 0; j < leaves.size(); ++j) {
					int difference = leaves.get(j) - currentNeed;
					if (difference >= 0 && difference < min)
						min = difference;
				}

				// add to total wasted amount
				wasted += min;
			} catch (Exception e) {
				// no wasted paint
			}
		}

		// print output
		System.out.println(wasted);

	}

}
