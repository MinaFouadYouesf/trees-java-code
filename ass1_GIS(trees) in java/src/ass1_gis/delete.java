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
public class delete {

    private inserNode ob;
    public int x, y;
    Node rooot;
    public int min;
    public int max;

    public delete(int x, int y, inserNode obj) {
        this.ob = obj;
        this.rooot = ob.head();
        this.x = x;
        this.y = y;
        min = 100000;
        max = 0;
        Search(3, 6, rooot, null);
        Search(5, 4, rooot, null);
        Search(10, 10, rooot, null);
        //    Search(5, 4, rooot, null);
         Search(11, 11, rooot, null);
        Search(4, 7, rooot, null);
        display(rooot);

    }

    public Node Search(int x, int y, Node temp, Node previous_node) {
        if (temp != null) {
            if (x == temp.get_x() && y == temp.get_y()) {

                delete_Node(temp, previous_node);

            } else {

                if (temp.get_level() % 2 == 0) {
                    previous_node = temp;
                    if (x >= temp.get_x()) {

                        temp = Search(x, y, temp.right, previous_node);

                    } else {

                        temp = Search(x, y, temp.left, previous_node);

                    }
                } else if (temp.get_level() % 2 == 1) {

                    previous_node = temp;

                    if (y >= temp.get_y()) {

                        temp = Search(x, y, temp.right, previous_node);

                    } else {

                        temp = Search(x, y, temp.left, previous_node);
                    }

                }

            }
        }
        return temp;

    }
    Node minNOde = null, previous = null;

    public Node findMin_X(Node temp) {

        if (temp != null) {
            // System.out.print(temp.x);
            if (min > temp.get_x()) {
                previous = minNOde;
                min = temp.get_x();
                minNOde = temp;

            }

            findMin_X(temp.left);
            findMin_X(temp.right);
        }

        return minNOde;
    }

    public Node findMin_Y(Node temp) {
        if (temp != null) {
            if (min > temp.get_y()) {
                previous = minNOde;
                min = temp.get_y();
                minNOde = temp;

            }

            findMin_Y(temp.left);
            findMin_Y(temp.right);
        }

        return minNOde;
    }

    //   Node minNOde=null,previous;
    public Node findMax_X(Node temp) {

        if (temp != null) {
            if (max < temp.get_x()) {
                previous = minNOde;
                max = temp.get_x();
                minNOde = temp;

            }

            findMax_X(temp.left);
            findMax_X(temp.right);
        }

        return minNOde;
    }

    public Node findMax_Y(Node temp) {

        if (temp != null) {
            if (max < temp.get_y()) {
                previous = minNOde;
                max = temp.get_y();
                minNOde = temp;

            }

            findMax_Y(temp.left);
            findMax_Y(temp.right);
        }

        return minNOde;
    }

  

    Node box = null, store = null, storeprevious = null;

    public Node delete_Node(Node node, Node prev_Node) {
        

        if (node == null) {
        
            return null;
        }
        if (node.get_left() == null && node.get_right() == null) {
            
            if (prev_Node.left == node) {
                prev_Node.left = null;
            } else if (prev_Node.right == node) {
                prev_Node.right = null;
            }

            return node;

        } else if (node.get_right() != null) {

            if (node.get_level() % 2 == 0) {

                box = findMin_X(node.get_right());

                store = box;
                storeprevious = previous;
                previous = null;
                min = 1000000;

                if (storeprevious != null) {

                    box = new Node(node.left, node.right, box.x, box.y, node.level);
                    if (node == rooot) {
                        rooot = box;

                        delete_Node(store, storeprevious);
                    } else {

                        if (prev_Node.left == node) {
                            prev_Node.left = box;
                        } else if (prev_Node.right == node) {
                            prev_Node.right = box;
                        }
                        //  prev_Node.right = box;

                        delete_Node(store, storeprevious);
                    }

                } else if (storeprevious == null) {
                    //Node T=store;
                    //   store.level=node.level;
                    //    while(T!=)
                    // updateLevel(store);

                    storeprevious = store;
                    if (prev_Node.left == node) {
                        prev_Node.left = store;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = store;
                    }
                    //  prev_Node.right = store;

                    store.left = node.left;
                    store.level = node.level;
                    store.right = node.right;
                    delete_Node(storeprevious, store);
                    /*
                     prev_Node.right = store;
                     store.level=node.level;
                     delete_Node(store, store);*/

                }

            } else if (node.get_level() % 2 == 1) {
//node.x;
//node.y;
                box = findMin_Y(node.get_right());
                // box.x;
                // box.y;
                store = box;
                storeprevious = previous;
                previous = null;

                min = 1000000;

                if (storeprevious != null) {

                    box = new Node(node.left, node.right, box.x, box.y, node.level);
                    if (prev_Node.left == node) {
                        prev_Node.left = box;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = box;
                    }
                  //  prev_Node.right = box;

                    delete_Node(store, storeprevious);
                } else if (storeprevious == null) {
                    //  updateLevel(store);
                    //store.level=node.level;
                    // box = new Node(node.left, node.right, box.x, box.y, node.level);
                    storeprevious = store;
                    if (prev_Node.left == node) {
                        prev_Node.left = store;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = store;
                    }
                    // prev_Node.right = store;

                    store.left = node.left;
                    store.level = node.level;
                    store.right=node.right;
                    delete_Node(storeprevious, store);
                    /*   prev_Node.right = store;
                     store.level=node.level;
                     delete_Node(store, store);*/

                }
            }

        } else if (node.get_right() == null) {

            if (node.get_level() % 2 == 0) {

                box = findMax_X(node.get_left());

                store = box;
                storeprevious = previous;
                previous = null;
                max = 0;
                if (storeprevious != null) {

                    box = new Node(node.left, node.right, box.x, box.y, node.level);
                    if (prev_Node.left == node) {
                        prev_Node.left = box;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = box;
                    }
                    // prev_Node.left = box;

                    delete_Node(store, storeprevious);
                } else if (storeprevious == null) {
                    // store.level=node.level;
                    // updateLevel(store);
                    // box = new Node(node.left, node.right, box.x, box.y, node.level);
                    storeprevious = store;
                    if (prev_Node.left == node) {
                        prev_Node.left = store;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = store;
                    }
                    // prev_Node.right = store;

                    store.left = node.left;
                    store.right = node.right;
                    store.level = node.level;

                    delete_Node(storeprevious, store);
                    /*  prev_Node.right = store;
                     store.level=node.level;
                     delete_Node(store, store);*/

                }
            } else if (node.get_level() % 2 == 1) {

                box = findMax_Y(node.get_left());

                store = box;
                storeprevious = previous;
                previous = null;
                max = 0;
                if (storeprevious != null) {

                    box = new Node(node.left, node.right, box.x, box.y, node.level);
                    if (prev_Node.left == node) {
                        prev_Node.left = box;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = box;
                    }
                    // prev_Node.left = box;

                    delete_Node(store, storeprevious);

                } else if (storeprevious == null) {
                    //store.level=node.level;
                    // updateLevel(store);
                    //   box = new Node(node.left, node.right, box.x, box.y, node.level);
                    storeprevious = store;
                    if (prev_Node.left == node) {
                        prev_Node.left = store;
                    } else if (prev_Node.right == node) {
                        prev_Node.right = store;
                    }
                    //  prev_Node.right = store;

                    store.left = node.left;
                    store.right = node.right;
                    store.level = node.level;
                    /*   prev_Node.right = store;
                     store.level=node.level;
                     delete_Node(store, store);*/

                }
            }

        }
        return null;
    }

    public void display(Node temp) {
        if (temp != null) {

            System.out.print(temp.x);
            System.out.println(temp.y);
            System.out.println(temp.level);

            display(temp.left);
            display(temp.right);

        }
    }
}
