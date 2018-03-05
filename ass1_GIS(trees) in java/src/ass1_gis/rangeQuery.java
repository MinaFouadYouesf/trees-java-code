/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1_gis;
import java.util.ArrayList;
/**
 *
 * @author mOOn
 */
public class rangeQuery 
{
    private inserNode ob;
    public ArrayList<Integer>list;
    private double result;
    public rangeQuery(inserNode obj)
    {
     ob=obj;  
     list=new ArrayList<Integer>();
     list=ob.nodes();
     result=0;
     
    }
    public void computeRangeQuery(int x,int y,int r)
    {
        
        for(int i=0;i<list.size();i=i+2)
        {
            result=Math.sqrt( Math.pow((x-list.get(i)), 2)+ Math.pow((y-list.get(i+1)),2));
            if(result>=r)
            {
                System.out.println("("+list.get(i)+","+list.get(i+1)+")"+"...in Range");
            }
          
        }
        
    }
    
}
