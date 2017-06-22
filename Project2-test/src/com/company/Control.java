package com.company;

//import GraphViz.GraphDrawer;

import java.util.Scanner;
/**
 * Created by Admin on 12/27/2016.
 */
public class Control {

    Graph graph = new Graph();
    boolean cycle = false; //baraye tashkhise vojoode dor dar graph
    Edge cycle_edge; //edge i k vaarede cycle mishe
    Node cycle_node; //nodi k cycle dare (k bdoonim kodoom node cycle ijaad karde , hamoono paak konim


    public Graph creategraph() {      //type khorooji Graph hast

        Scanner sc = new Scanner(System.in); //voroodi ro bgirim
        System.out.println("please enter number of nodes");
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {    //b tedade node ha , yaal haamoon ro bkhoonim, mosavi ezafe shode
            //  for (int k = 0; k < i; k++)

            System.out.println("State number :" + i);  //bdoonim node chandom ro mikhaiim bkhoonim
            System.out.println("Enter Adjacants");
            Node node = new Node();  //edge haa doone  doone b in ezafe mishan
            node.value = i;


            String s = sc.next(); //ye string bkhoonim

            String[] edges = s.split("-");  //olgooye joda kardan (ke tedade yaal hamoon maloom mishe), chon khorooji stringe bayad string array tarif konim

            for (int j = 0; j < edges.length; j++) {   //be tedade edge.length , ma yaal darim
                System.out.println(edges[j]); //yaal haa ro chaap kon
                Edge edge = new Edge();
                String[] edgeInfo = edges[j].split(",");   //hala yaal haa ro b komake , joda kon  va har yaal ro tooye edge info negah daar
                if (edgeInfo.length != 2)  //age ye doone vared kard error bede!!! (hatman b sooreat e a, 0 bashe maslan
                    continue;
                edge.value = edgeInfo[0].charAt(0);  //char at , character e avval ro mide behet
                edge.nextnode = Integer.parseInt(edgeInfo[1]);
                node.edgelist.add(edge);//yaal haa ro b node ezafe kon
            }
            graph.nodelist.add(node);  //node e jadid ro b graph ezafe kon
        }

        return graph;
    }


    public void printGraph() {


        System.out.println("State  ");
        for (int i = 0; i < graph.nodelist.size(); i++) {   //b tedade node haa boro jolo

            System.out.print(i + "    ");  //shomare state
            Node node = graph.nodelist.get(i);  //i omin node ro migiram o roo yaal haaash for mizanam
            for (int j = 0; j < node.edgelist.size(); j++) {  //b tedade yaal haa
                Edge edge = node.edgelist.get(j);  //j omin yaal ro migiram
                System.out.print(edge.nextnode + "," + edge.value + "   ");   //namayeshe state va yaal

                //print  e graphici1
               String GraphStr = "hello -> world ";


                GraphDrawer gd = new GraphDrawer();
                gd.draw("test.", GraphStr); //draw (OutputFileName, GraphString)


                /*printe graphici 2
                GraphViz gv = new GraphViz();
                gv.addln(gv.start_graph());
                //   for(int i=0;i<node;i++) {
                gv.addln("(i  ) -> (i+1))");
                //  gv.addln("A -> C;");
                gv.addln(gv.end_graph());
                System.out.println(gv.getDotSource());

                String type = "png";
                String representationType = "dot";
                File out = new File("out." + type);   // out.gif in this example
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, representationType), out);
                */
            }
            System.out.println();  //tamoom shod boro khat e badi edame bede
        }


            System.out.println();  //tamoom shod boro khat e badi edame bede
}

        /*print  e graphici
     String GraphStr = "State";
      GraphDrawer gd = new GraphDrawer();
      gd.draw("test.", GraphStr); //draw (OutputFileName, GraphString)

    }
*/
    //baraye inke tashkhis bedahad mitavanad reshte raa bpazirad yaa na,
    // yek method baa khoroojie boolean

public boolean IsValid()
{
    //string  ro bkhoon
    System.out.println("please enter a string for Recognizing if it is valid");
    System.out.println("********************************************");
    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    char[] input = s.toCharArray(); //arraylisti az character haa laazem darim , string ro doone doone tooye char array mirizim
    Node currentnode = graph.nodelist.get(0);  //node i k alan tooshim , meghdar e avvaliash node 0 om hast{avvalin node graph)
    boolean valid = false ;   //az nazare har input barresi mishe! pas tooye halghe ham bayad false she !

    for(int i = 0 ; i<input.length;i++) //be andazeye voroodi for mizanim taa bbinim b state chandom miresim
    {
        valid=false;   //az nazare har input barresi mishe! pas tooye halghe ham bayad false she !
        char currentInput=input[i];  //alan too che inputi hastam(chio daram barresi mikonm?


        //tedad yaal haaye in nodei k tooshim (tooye har state ,
        // faghat b tedade yaal haye khorooji yaa voroodie har node mitoonim invar oonvar berim
        for(int j=0;j<currentnode.edgelist.size();j++)
        {
            //valid=false;
            Edge currentEdge=currentnode.edgelist.get(j); //too che yaali hastim? oon yaali k dar haale barresishi,

            if(currentEdge.value == currentInput)   //age in yaali ke tooshim , hamooni bood k user vared karde,...
            {
                //bayad break koni , vali ghablesh bayad mano jaa b jaa koni!
                //yani baa tavajjoh b oon mn bdoonm k b kodoom node bayad beram
                  //current node man avaz mishe !
                //az roo node feli , bpar badi!!moshkele in chie? adade!pas shomarasho bayad bdi b graph o nodesho bgiri!
                //intori jensemoon az adad , mishe node!

                currentnode=graph.nodelist.get(currentEdge.nextnode );
                valid=true;

                break;   //bpar biroon! mn donbale hamin migashtam !!!!
            }
          //  System.out.println(valid);  //dishab
        }
        if(!valid)
        {
            return false;  //valid nist
        }

    }
    return true;

}




public boolean IsCyclic()
{
    System.out.println("I will tell you if your Graph is cyclic!");
    System.out.println("********************************************");
  cycle=false;
  DFS(graph.nodelist.get(0));   //dfs raa az node avval shoroo mikonim, recursive mirim jolo !
    return cycle;
}


public void DFS(Node node)   //rooye node haaye mokhtalef dfs raa seda mizanim
{
   node. isok = true;  //is ok neshaan midahad ke baa node feli b kodam edge miravim
   node.isok=false; //?//



    //bachehaa ro check kon
    //ta size hamsaaye haa mire jolo
    //Dfs ro baraye bachehaa seda mizanim , be sharte inke ghablan DFS barash seda nashode bashe
    for(int i=0;i<node.edgelist.size();i++)
    {
        Node next=graph.nodelist.get(node.edgelist.get(i).nextnode);

        //Age toghe daasht
        //ye halate kheili khaase
       if(node.value == next.value)
       {
           cycle_edge=node.edgelist.get(i);
           cycle_node = node;
           cycle=true;
           return;
       }

        else if(!next.visit)  //age node badish visit nashode hanooz
           DFS(next);        //dfs lazem dare

        else if(!next.isok)   // node badish nodie k dor ijaad mikone
        {
            cycle_edge=node.edgelist.get(i);
            cycle_node = node;
            cycle=true;
            return;
        }

    }
    node.isok=true;

}


public void DeleteCycles()
{
    System.out.println("Now i will delete all cycles step by step !");
    System.out.println("********************************************");
    while(IsCyclic())
    {
        System.out.println("****"+cycle_node.value+ "   "+ cycle_edge.nextnode +"  " + cycle_edge.value+"****");
        cycle_node.edgelist.remove(cycle_edge);
        System.out.println("Final Graph(without cycle)is:");
        System.out.println("********************************************");
        printGraph();

    }
    System.out.println(cycle);
    printGraph();
}

}
