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
public class InsertPointQuadTree {

    private Nnode root;
   

    public InsertPointQuadTree() {
        root = null;

    }

    public void insert_PQT(int x, int y) {

        this.root = Insertion(x, y, this.root);

    }
   
    private Nnode Insertion(int x, int y, Nnode temp) {

        if (temp == null) {

            temp = new Nnode(x, y);
            
        } else {

            if (x >= temp.get_x() && y >= temp.get_y()) {

                temp.NE = Insertion(x, y, temp.NE);
              
            } else if (x < temp.get_x() && y >= temp.get_y()) {

                temp.NW = Insertion(x, y, temp.NW);

            } else if (x < temp.get_x() && y < temp.get_y()) {

                temp.SW = Insertion(x, y, temp.SW);

            } else if (x >=temp.get_x() && y < temp.get_y()) {

                temp.SE = Insertion(x, y, temp.SE);

            }

        }

        return temp;

    }
    public Nnode pqdRoot()
    {
        return root;
    }
public void show()
{
  display_QT(root);
}

    public void display_QT(Nnode temp) {
        if (temp != null) {

            System.out.print(temp.x);
            System.out.println(temp.y);

            display_QT(temp.NW);
            display_QT(temp.NE);
            display_QT(temp.SW);
            display_QT(temp.SE);
        }
    }
}
