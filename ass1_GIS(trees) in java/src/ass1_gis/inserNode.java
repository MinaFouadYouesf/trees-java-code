/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1_gis;

import java.util.ArrayList;

/**
 *
 * @author moon
 *
 *
 *
 */
public class inserNode {

    private Node root;
    public int count;
    public ArrayList<Integer> arr;

    public inserNode() {
        root = null;
        arr = new ArrayList<Integer>();
    }

    public void insert(int x, int y) {
        count = 0;

        this.root = Insert(x, y, this.root);
       
    }

    private Node Insert(int x, int y, Node temp) {

        if (temp == null) {

            arr.add(x);
            arr.add(y);
            temp = new Node(x, y, count);

        } else {
            if (count % 2 == 0) {
                count++;
                if (x >= temp.get_x()) {

                    temp.right = Insert(x, y, temp.right);

                } else {

                    temp.left = Insert(x, y, temp.left);
                }

            } else if (count % 2 == 1) {
                count++;
                if (y >= temp.get_y()) {

                    temp.right = Insert(x, y, temp.right);

                } else {

                    temp.left = Insert(x, y, temp.left);
                }

            }
        }

        return temp;

    }

    public ArrayList<Integer> nodes() {

        return arr;
    }

    public Node head() {

        return root;
    }

}
