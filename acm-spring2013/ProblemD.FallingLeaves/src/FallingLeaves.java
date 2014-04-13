import java.io.*;
import java.util.*;

public class FallingLeaves {

	public static class Node {
		String value;
		Node left;
		Node right;
	}
	
	public static void visit(Node aNode, String pt) {
		if(aNode.left!=null) {
			pt += aNode.left.value;
			visit(aNode.left, pt);
		}
		if(aNode.right!=null) {
			pt += aNode.right.value;
			visit(aNode.right, pt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		

		//input 
		LinkedList<ArrayList<String>> sequences = new LinkedList<ArrayList<String>>();
		String input = stdin.readLine();
		while(input.compareTo("$")!=0) {			
			ArrayList<String> lines = new ArrayList<String>();
			
			if (input.compareTo("*")==0) {
				sequences.add(lines);
				continue;
			}
			else {
				lines.add(input);
			}			
			input = stdin.readLine();
		}
		
		//compute		
		
		for(int i=0; i<sequences.size(); ++i) {
			//create tree
			ArrayList<String> sequence = sequences.get(i);
			Node head = new Node();
			head.value = sequence.get(sequence.size()-1);
			
			//TODO: insertion to tree
						
			//preorder traversal
			String pt = "";		
			pt += head.value;
			visit(head, pt);			
			
			//output
			System.out.println(pt);
		}
		
		
		
	}
}
