package com.company;

import java.util.ArrayList;

/**
 * Created by Admin on 12/27/2016.
 */
public class Node {
    int value;  //shomare har node (shomare state)
    ArrayList<Edge> edgelist =new ArrayList<>();   //listi az yaal haa, baraye dfs zadan rahat tare k bdoone ki baa ki hamsaye hast
    boolean visit ;   //hamoon flagi k baraye dfs lazem darim , ke dge tekraria ro nabinim
    boolean  isok; //node va bachehash bdoone dor bashand , cyclic hast yaa na


}
