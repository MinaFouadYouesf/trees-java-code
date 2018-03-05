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
public class Ass1_GIS {

    public static void main(String[] args) {

       inserNode obj = new inserNode();
        obj.insert(3, 6);
        obj.insert(5, 4);
        obj.insert(1, 2);
        obj.insert(5, 1);
        obj.insert(4, 7);
        obj.insert(1, 6);
        obj.insert(10, 10);
        obj.insert(9, 11);
        obj.insert(11, 11);
        obj.insert(4, 2);
        obj.insert(3, 1);
      //  obj.head();
       /* rangeQuery object=new rangeQuery(obj);*/
       //  object.computeRangeQuery(5,6,4);
    //delete object=new delete(5, 4,  obj);
        
       
        InsertPointQuadTree nObj=new InsertPointQuadTree();
        
     nObj.insert_PQT(4, 5);
     nObj.insert_PQT(7, 7);
     nObj.insert_PQT(8, 8);
     deletePQT ob=new  deletePQT(3,4,nObj);
  //nObj.show();
        
    }
}
