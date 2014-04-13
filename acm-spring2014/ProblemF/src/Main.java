import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

class Pair {
	public int from;
	public int to;
}

class Case {
	public LinkedList<Edge> edges = new LinkedList<Edge>();
	public LinkedList<Pair> tests = new LinkedList<Pair>();
}

class Edge {
	public int from;
	public int to;
	public String companies;
}

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Case> cases = new LinkedList<Case>();
		
		String[] line;
		String temp = stdin.readLine();
		int nodesCount = Integer.parseInt(temp);
		while(nodesCount>0) {	
			Case c = new Case();
			
			temp = stdin.readLine();
			while(temp.compareTo("0 0")!=0) {
				line = temp.split(" ");
				Edge e = new Edge();
				e.from = Integer.parseInt(line[0]);
				e.to = Integer.parseInt(line[1]);
				e.companies = line[2];
				c.edges.add(e);
				temp = stdin.readLine();
			}
			
			temp = stdin.readLine();
			while(temp.compareTo("0 0")!=0) {
				line = temp.split(" ");
				Pair p = new Pair();
				p.from = Integer.parseInt(line[0]);
				p.to = Integer.parseInt(line[1]);
				c.tests.add(p);
				temp = stdin.readLine();				
			}
			
			cases.add(c);
			
			temp = stdin.readLine();
			nodesCount = Integer.parseInt(temp);
		};
		
		for(Case c : cases) {
			for(Pair t : c.tests) {
				TreeSet<String> resultCompanies = new TreeSet<String>();
				for(Edge e : c.edges) {
					if(e.from == t.from) {
						//discover
						LinkedList<Integer> visited = new LinkedList<Integer>();
						visited.add(e.from);
						for(int i=0; i<e.companies.length(); ++i) {
							if(e.to == t.to) {
								resultCompanies.add(e.companies.charAt(i)+"");
							} else {
								edges = c.edges;
								goTo(e.to, t.to, visited, e.companies.charAt(i)+"", resultCompanies);
							}
						}
					}
				}
				StringBuffer result = new StringBuffer();
				for(String company : resultCompanies) {
					result.append(company);					
				}
				if(result.length()==0) {
					result.append("-");
				}
				System.out.println(result.toString());
				
			}
			System.out.println();
		}
	}

	private static LinkedList<Edge> edges;
	
	private static void goTo(int start, int destination, LinkedList<Integer> visited,
			String company, TreeSet<String> resultCompanies) {
			visited.add(start);
			for(Edge e : edges) {
				if(e.from == start) {
					if(e.companies.contains(company)) {
						if(e.to == destination) {
							resultCompanies.add(company);
						} else if(visited.contains(e.to) == false) {
							goTo(e.to, destination, visited, company, resultCompanies);
						}
					}
				}
			}		
	}

}
