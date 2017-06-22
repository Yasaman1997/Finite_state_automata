package com.company;

        //import GraphViz.GraphDrawer;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Control c=new Control();
        c.creategraph();
        c.printGraph();
       System.out.println(c.IsValid());
    //    c.IsValid();

       System.out.println(c.IsCyclic());
         c.DeleteCycles();

        String GraphStr = "c ";

    }
}
