import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FnordCom {

	public static ArrayList<String> passwords = new ArrayList<String>();
	public static String vowels = "aeiou";

	public static boolean ContainAtLeastOneVowel(String password) {
		for(int i=0; i<vowels.length(); ++i) {
			if(password.indexOf(vowels.charAt(i)) !=-1)
				return true;
		}
		return false;
	}
	
	public static boolean NotContain3VowelsOr3Consonants(String password) {
		int vowelCount = 0;
		int consonantsCount = 0;
		
		for(int i=0; i<password.length(); ++i) {
			if(vowels.indexOf(password.charAt(i)) !=-1) {
				consonantsCount = 0;
				++vowelCount;
			}
			else {
				vowelCount = 0;
				++consonantsCount;
			}
			
			if(vowelCount == 3 || consonantsCount == 3)
				return false;
		}		
		
		return true;
	}
	
	public static boolean NotRepeatedLetters(String password) {
		for(int i=1; i<password.length(); ++i) {
			char prev = password.charAt(i-1);
			if(password.charAt(i) == prev) {
				if(prev!='e' && prev!='o')
					return false;
			}
		}
		return true;
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String input = "";

		while (true) {
			input = stdin.readLine();
			if(input.compareTo("end") != 0) {
				passwords.add(input);
			}
			else
				break;
		}
		
		for(int i=0; i<passwords.size(); ++i) {
			String password = passwords.get(i);
			if(ContainAtLeastOneVowel(password) && NotContain3VowelsOr3Consonants(password) && NotRepeatedLetters(password)) {
				System.out.println("<"+password+"> is acceptable.");
			}
			else {
				System.out.println("<"+password+"> is not acceptable.");
			}
		}
		
		

	}

}
