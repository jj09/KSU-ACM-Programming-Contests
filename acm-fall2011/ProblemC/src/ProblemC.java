import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jjedrys
 */
public class ProblemC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String input;
        String tab[];
        String output = "";
        int n, k;
        int Case = 0;

        input = br.readLine();

        while (!input.equalsIgnoreCase("0 0")) {
            ++Case;
            tab = input.split(" ");
            n = Integer.parseInt(tab[0]);
            k = Integer.parseInt(tab[1]);
            if (n>1000 || k>8 || n % k != 0) {
                output += "Case " + Case + ": no\n\n";
            } else {
                String[] names = new String[n];
                for (int i = 0; i < n; ++i) {
                    names[i] = br.readLine();
                }

                for (int i = 0; i < n; ++i) {
                    for (int j = i + 1; j < n; ++j) {
                        if (names[i].length() > names[j].length()) {
                            String temp = names[i];
                            names[i] = names[j];
                            names[j] = temp;
                        }
                    }
                }

                boolean isGood = true;
                for (int i = 0; i < n; i += k) {
                    int avgLength = 0;
                    for (int j = 0; j < k; ++j) {
                        avgLength += names[i + j].length();
                    }
                    avgLength /= k;
                    for (int j = 0; j < k; ++j) {
                        if (names[i + j].length() > avgLength + 2 || names[i + j].length() < avgLength - 2) {
                            isGood = false;
                            break;
                        }
                    }
                    if (!isGood) {
                        break;
                    }
                }
                output += "Case " + Case + ": ";
                if (isGood) {
                    output += "yes\n\n";
                } else {
                    output += "no\n\n";
                }
            }
            input = br.readLine();
        }
        System.out.println(output);
    }
}
