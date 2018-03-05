/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1_gis;

/**
 *
 * @author mOOn
 */
public class Nnode {
    public int x;
    public int y;
    public Nnode NW;
    public Nnode SW;
    public Nnode NE;
    public Nnode SE;
    

    public Nnode(int x, int y) {

        this.NW = null;
        this.SW = null;
        this.NE = null;
        this.SE = null;
       
        set_x(x);
        set_y(y);
        
    }
    
    public void set_x(int x){
        this.x = x;

    }
    
    public void set_y(int y){
        this.y = y;

    }
      public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }
    public Nnode get_NW() {

        return NW;
    }
  public Nnode get_SW() {

        return SW;
    }
  public Nnode get_NE() {

        return NE;
    }
  public Nnode get_SE() {

        return SE;
    }
}
