import java.io.*;
import java.util.LinkedList;

class Team {
	public int number;
	public LinkedList<Integer> times = new LinkedList<Integer>();
}

public class Main {

	public static int convertTimeToSeconds(String timeStr) {
		String[] temp = timeStr.split(":");
		if (temp[0].compareTo("-")==0) {
			return -1;
		}
		int seconds = Integer.parseInt(temp[2]);
		seconds += Integer.parseInt(temp[1]) * 60;
		seconds += Integer.parseInt(temp[0]) * 60 * 60;
		return seconds;
	}
	
	public static String convertSecondsToTime(int seconds) {
		if(seconds<=0) {
			return "-";
		}
		int mins = seconds/60;
		seconds -= mins*60;
		return mins + ":" + String.format("%02d", seconds) + " min/km";
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = stdin.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		float distance = Float.parseFloat(line[1]);
		
		LinkedList<Team> teams = new LinkedList<Team>();
		
		String temp = stdin.readLine();
		while(temp!=null && temp.compareTo("EOF")!=0) {			
			line = temp.trim().split(" ");
			Team team = new Team();
			team.number = Integer.parseInt(line[0]);
			for(int i=0; i<n; ++i) {
				team.times.add(convertTimeToSeconds(line[1+i]));
			}
			teams.add(team);
			temp = stdin.readLine();
		}
		
		for(Team t : teams) {
			int totalTime = 0;
			for(Integer time : t.times) {
				if(time==-1) {
					totalTime = -1;
					break;
				}
				totalTime += time;
			}
			int avgTimePerKmInSecs = Math.round(totalTime / distance);
			
			System.out.println(t.number + ": " + convertSecondsToTime(avgTimePerKmInSecs));
		}
	}

}
