package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CircleBFS {

    LinkedList<Integer> graphCircle[];
    Queue<Integer> queue;
    int V;
    CircleBFS(int v){
        V = v;
        graphCircle = new LinkedList[v];
        for(int i= 0; i< v ; i++){
            graphCircle[i]= new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }

    void addCircleEdge(int v, int w){
        graphCircle[v].add(w);
    }

    ArrayList<Integer> BFS(int n){
       ArrayList<Integer> getIDTraverse = new ArrayList<>();
        boolean nodes[] = new boolean[V];
        int a = 0;
        nodes[n] = true;
        queue.add(n);

        while(queue.size()!=0){
            n = queue.poll();
            System.out.println( n + " ");


            for (int i = 0; i < graphCircle[n].size(); i++)  //iterate through the linked list and push all neighbors into queue
            {
                a = graphCircle[n].get(i);
                System.out.println("a " + a );
                if (!nodes[a])                    //only insert nodes into queue if they have not been explored already
                {
                    nodes[a] = true;
                    queue.add(a);

                }
            }


        }
        getIDTraverse.add(n);
        return getIDTraverse;
    }
}
