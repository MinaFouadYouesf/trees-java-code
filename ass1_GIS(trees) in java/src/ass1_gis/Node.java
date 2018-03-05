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
public class Node {

    public int x;
    public int y;
    public Node left;
    public Node right;
    public int level;

    public Node(int x, int y, int level) {

        this.left = null;
        this.right = null;
        set_x(x);
        set_y(y);
        set_left(left);
        set_right(right);
        set_level(level);
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        set_left(left);
        set_right(right);
    }
    /*public Node(Node right) {

       
     this.right = right;
        
     set_right(right);
       
     }*/

    public Node(Node left, Node right, int x, int y, int level) {

        this.right = right;
        this.left = left;
        this.x = x;
        this.y = y;
        this.level = level;
        set_x(x);
        set_y(y);
        set_left(left);
        set_right(right);
        set_level(level);

    }

    public void set_level(int level) {
        this.level = level;

    }

    public void set_x(int x) {
        this.x = x;

    }

    public void set_y(int y) {
        this.y = y;
    }

    public void set_left(Node left) {

        this.left = left;
    }

    public void set_right(Node right) {
        this.right = right;
    }

    public int get_x() {
        return x;
    }

    public int get_level() {
        return level;

    }

    public int get_y() {
        return y;
    }

    public Node get_left() {

        return left;
    }

    public Node get_right() {
        return right;
    }
}
