/*
* All Paths from Source to Target Node
* Description
Given a directed acyclic graph (DAG) of n nodes labelled from 0 to n - 1, count all possible paths from node 0 to node n - 1, and return the number of paths.
    0->1
    |  | (| is downward arrow)
    2->3


The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e. , there is a directed edge from node i to node graph[i][j]).


Example:





Input:

If graph = [[1,2],[3],[3],[]], the input can be taken as follows:



first line: (number of nodes) 4

second line: (nodes you can visit from first node) 1 2

third line: (nodes you can visit from second node) 3

fourth line: (nodes you can visit from third node) 3

fifth line:( nodes you can visit from fourth node) -1



Note: input -1 implies no node can be visited from the given node.



Output: 2

Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
* */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class AllPathsFromSourceToTargetNode {
    // No. of vertices in graph
    private int v;
    static int noOfPaths =0;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    // Constructor
    public AllPathsFromSourceToTargetNode(int vertices)
    {

        // initialise vertex count
        this.v = vertices;

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList()
    {
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v)
    {
        // Add v to u's list.
        //System.out.println("u="+u+" v="+v);
        adjList[u].add(v);
    }

    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(s);

        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList)
    {

        if (u.equals(d)) {
            //System.out.println(localPathList);
            noOfPaths++;
            // if match found then no need to traverse more till depth
            return;
        }

        // Mark the current node
        isVisited[u] = true;

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }

    // Driver program
    public static void main(String[] args) throws Exception
    {
        // Create a sample graph
        Scanner scan = new Scanner(System.in);
        int noOfVertices = scan.nextInt();
        scan.nextLine();
        AllPathsFromSourceToTargetNode g = new AllPathsFromSourceToTargetNode(noOfVertices);
        try{
            for(int i=0;i<noOfVertices;i++){
                String user_input = scan.nextLine();
                String[] stringsArray = user_input.split(" ");
                int[] intArray = new int[stringsArray.length];
                for (int j = 0; j < stringsArray.length; j++) {
                    intArray[j] = Integer.parseInt(stringsArray[j]);
                    if(intArray[j]!= -1)
                        g.addEdge(i,intArray[j]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // arbitrary source
        int s = 0;

        // arbitrary destination
        int d = noOfVertices-1;

//        System.out.println(
//                "Following are all different paths from "
//                        + s + " to " + d);
        g.printAllPaths(s, d);
        System.out.println(noOfPaths);
    }
}
