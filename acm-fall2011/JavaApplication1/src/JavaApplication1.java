import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author jjedrys
 */
public class JavaApplication1 {

    public static ArrayList<ArrayList<Integer>> data;
    
    public static int checkNeighbors(int v)
    {
        
        return 0;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String output = "";
        int graph = 0;
        
        String input = br.readLine();
        
        while (!input.equalsIgnoreCase("0")) {
            ++graph;
            int v = Integer.parseInt(input);
            input = br.readLine();
            int e = Integer.parseInt(input);
            String [] temp = br.readLine().split(" ");
            while(temp.length<2*e)
            {
                String[] temp2 = br.readLine().split(" ");
                String[] newTemp = new String[temp.length+temp2.length];
                for(int i=0; i<newTemp.length; ++i)
                {
                    for(int j=0; j<temp.length; ++j)
                        newTemp[i] = temp[j];
                    for(int j=0; j<temp2.length; ++j)
                        newTemp[i] = temp2[j];
                }
                temp = newTemp;
            }
            if(v>100 || e>300 || v<2)
            {
                output += "Graph "+graph+ " is";
                output += " not";
                output += " a caterpillar.\n";
                input = br.readLine();
                continue;
            }
            if(v != e+1)
            {
                output += "Graph "+graph+ " is";
                output += " not";
                output += " a caterpillar.\n";
                input = br.readLine();
                continue;
            }
            boolean catterpillar = true;
            int neighbors = 0;
            data = new ArrayList<ArrayList<Integer>>(v);
            for(int i=0 ;i<v; ++i)
                data.add(new ArrayList<Integer>());
            for(int i=0;i<2*e;i+=2)
            {
                Integer ind = Integer.parseInt(temp[i]);
                Integer node = Integer.parseInt(temp[i+1]);
                data.get(ind-1).add(node-1);
                data.get(node-1).add(ind-1);
            }

            ArrayList<Integer> bigNodes = new ArrayList<Integer>();
            for(int i=0; i<v; ++i)
            {
                if(data.get(i).size()<1)
                {
                    catterpillar = false;
                    break;
                }
                if(data.get(i).size()>1)
                {
                    bigNodes.add(i);
                    neighbors = 0;
                    for(int j=0; j<data.get(i).size(); ++j)
                    {                        
                        if(data.get(data.get(i).get(j)).size() >1)
                        {                            
                            ++neighbors;
                        }                        
                    }
                    if(neighbors>2)
                    {
                        catterpillar = false;
                    }
                }
            }
            int connections = 0;
            for(int i=0; i<bigNodes.size(); ++i)
            {
                for(int j=0; j<data.get(bigNodes.get(i)).size(); ++j)
                {
                    for(int k=0; k<bigNodes.size(); ++k)
                    {
                        if(data.get(bigNodes.get(i)).get(j)==bigNodes.get(k))
                        {
                            ++connections;
                        }
                    }
                }
            }
            if(connections/2<bigNodes.size()-1)
                catterpillar = false;
            output += "Graph "+graph+ " is";
            if(!catterpillar)
                output += " not";
            output += " a caterpillar.\n";
            input = br.readLine();
        }
        
        System.out.println(output);
        
    }
}
