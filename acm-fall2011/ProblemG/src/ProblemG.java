import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jjedrys
 */
public class ProblemG {

    /**
     * 
     * @param matrix
     * @param i
     * @param j
     * @param n
     * @param m
     * @param dir 1-north, 2-south, 3-west, 4-east
     * @return 
     */
    public static boolean check(int [][] matrix, int i, int j, int n, int m, int dir)
    {
        switch(dir)
        {
            case 1:
                if(i==0 || matrix[i-1][j]==0)
                    return false;
                else
                    return true;
            case 2:
                if(i==n-1 || matrix[i+1][j]==0)
                    return false;
                else
                    return true;
            case 3:
                if(j==0 || matrix[i][j-1]==0)
                    return false;
                else
                    return true;
            case 4:
                if(j==m-1 || matrix[i][j+1]==0)
                    return false;
                else
                    return true;
            default:
                return false;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String input;
        String tab[];
        String output = "";
        int n, m;

        input = br.readLine();

        while (!input.equalsIgnoreCase("0 0")) {
            tab = input.split(" ");
            n = Integer.parseInt(tab[0]);
            m = Integer.parseInt(tab[1]);
            if (n>200 || m>200 || n<1 || m<1) {
                output += "0\n";
            } 
            else {
                int snakes = 0;
                int [][] matrix = new int[n][m];
                boolean [][] checked = new boolean[n][m];
                String temp;
                for (int i = 0; i < n; ++i) 
                {
                    String[] row = new String[m];
                    temp = br.readLine();
                    for(int j=0; j<m; ++j)
                    {
                        matrix[i][j] = Integer.parseInt(temp.substring(j, j+1));
                    }
                }
                
                for (int i = 0; i < n; ++i) 
                {
                    for(int j=0; j<m; ++j)
                    {
                        if(matrix[i][j]==1 && checked[i][j]==false)
                        {
                            ++snakes;
                            checked[i][j] = true;
                            int ii=i;
                            int jj=j;
                            int iStart;
                            int jStart;
                            int[] dirs = new int[2];
                            int dirsCount = 0;
                            for(int k=1; k<=4; ++k)
                            {
                               if(check(matrix, i, j, n, m, k) )
                               {
                                   dirs[dirsCount++] = k;
                               }                                
                            }
                            if(dirsCount==0)
                            {
                                int emptyNeighbours = 0;
                                int busyFields = 0;
                                for(int k=1; k<=4; ++k)
                                {
                                   if(check(matrix, i-1, j, n, m, k) )
                                   {
                                       ++busyFields;
                                   }
                                }
                                if(busyFields==1)
                                {
                                    --snakes;
                                    continue;
                                }
                                busyFields=0;
                                for(int k=1; k<=4; ++k)
                                {
                                   if(check(matrix, i+1, j, n, m, k) )
                                   {
                                       ++busyFields;
                                   }
                                }
                                if(busyFields==1)
                                {
                                    --snakes;
                                    continue;
                                }
                                busyFields=0;
                                for(int k=1; k<=4; ++k)
                                {
                                   if(check(matrix, i, j+1, n, m, k) )
                                   {
                                       ++busyFields;
                                   }
                                }
                                if(busyFields==1)
                                {
                                    --snakes;
                                    continue;
                                }
                                busyFields=0;
                                for(int k=1; k<=4; ++k)
                                {
                                   if(check(matrix, i, j-1, n, m, k) )
                                   {
                                       ++busyFields;
                                   }
                                }
                                if(busyFields==1)
                                {
                                    --snakes;
                                    continue;
                                }
                                //busyFields=0;                                
                            }
                            else if (dirsCount==1)
                            {
                                
                                switch(dirs[0])
                                {
                                    case 1:
                                        check(matrix, i-1, j, n, m, 1);
                                        break;
                                    case 2:
                                        check(matrix, i+1, j, n, m, 1);
                                        break;
                                    case 3:
                                        check(matrix, i, j-1, n, m, 1);
                                        break;
                                    case 4:
                                        check(matrix, i, j+1, n, m, 1);
                                        break;
                                }
                            }
                            else
                            {
                                
                            }
                        }
                    }
                }
                
            }
            input = br.readLine();
        }
        System.out.println(output);
    }
}
