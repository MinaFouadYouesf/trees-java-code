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
public class deletePQT {
    public Nnode root;
    public InsertPointQuadTree obj;
    int x,y;
     public ArrayList<Nnode> arr;

  public  deletePQT(int x,int y,InsertPointQuadTree obj)
  {
       arr = new ArrayList<Nnode>();

      this .obj=obj;
      root=obj.pqdRoot();
      this.x=x;
      this.y=y;
       Search( x,y,root,null);
      
  }
    public Nnode Search(int x,int y,Nnode temp,Nnode previousNode)
    {
        
         if (temp != null) {
             
            if (x == temp.get_x() && y == temp.get_y()) {

              Deletion(temp, previousNode);

            } else {

               previousNode=temp;
                    if (x >= temp.x&&y>=temp.y) {

                        temp = Search(x, y, temp.NE,previousNode);

                    } else  if (x< temp.x&&y>=temp.y) {

                        temp = Search(x, y, temp.NW,previousNode);
                    }
                else  if (x <temp.x&&y<temp.y) {

                        temp = Search(x, y, temp.SW,previousNode);
                    }
                  else  if (x >= temp.x&&y<temp.y) {

                        temp = Search(x, y,temp.SE,previousNode);
                    } 
                   
            }
         }
        return temp;
     
    }
    
 public  Nnode  Deletion(Nnode Traverse,Nnode Previous)
  {
    if(Traverse==null)
    {
        return null;
    }
       
      
      
      
      
      
     return  Traverse;
  }
}
