
package qm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author venkat
 */
public class app {
   public static void main(String args[]) throws IOException
   {
       BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/yadu/NetBeansProjects/QM/output.txt"));
       writer.write("");
       writer.close();
       Hashtable ht=new Hashtable();
       ht=fileReader.main(null);
       int t,nvar[],nmin[],min[][];
       String inp[][];
       t=(int)ht.get("t");
       System.out.println(t);
       nvar=(int[])ht.get("nvar");
       nmin=(int[])ht.get("nmin");
       min=(int[][])ht.get("min");
       inp=(String[][])ht.get("inp");
       for( int i=0;i<t;i++)
       {
           Hashtable hi=new Hashtable();
           hi.put("inp", inp[i]);
           hi.put("nvar",nvar[i]);
           hi.put("nmin",nmin[i]);
           hi.put("min",min[i]);
           QM.main(hi);
       } 
   }
}
