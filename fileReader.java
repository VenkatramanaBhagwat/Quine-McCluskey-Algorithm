
package qm;

/**
 *
 * @author yadu
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class fileReader {
    private static final String FILENAME = "/Users/yadu/NetBeansProjects/QM/input/ip1.txt";
	public static Hashtable main(String[] args) {
                Hashtable ht = new Hashtable();
		BufferedReader br = null;
		FileReader fr = null;
                int min[][],nvar[],nmin[],t;
                String inp[][];
		try {
			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
                        t=Integer.parseInt(br.readLine());
                        ht.put("t",t);
                        nvar=new int[t];
                        nmin=new int[t];
                        int b=(int)Math.pow(10,2)-1;
                        min=new int[t][b];
                        inp=new String[t][b];
                        for(int j=0;j<t;j++)
                        {
                            nvar[j]=Integer.parseInt(br.readLine());
                            nmin[j]=Integer.parseInt(br.readLine());
                            
                            for(int i=0;i<nmin[j];i++)
                            {
                                String tmp=(String)br.readLine();
                                inp[j][i]=tmp;
                                min[j][i]=conv(tmp);
                            }
                        }
                        ht.put("inp",inp);
                        ht.put("nvar",nvar);
                        ht.put("nmin",nmin);
                        ht.put("min",min);
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
                return ht;
	}
        public static int conv(String line)
        {
            int res=0;
            int l=line.length()-1;
            for(int i=0;i<=l;i++)
            {
                
                if((i!=l)&&(line.charAt(i)!='\''))
                {
                    if(line.charAt(i+1)!='\'')
                    {
                        res=res*2+1;
                    }
                    else
                    {
                        res=res*2+0;
                    }
                }
                else if(line.charAt(i)!='\'')
                {
                    res=res*2+1;
                }
            }
            return res; 
        }

}
