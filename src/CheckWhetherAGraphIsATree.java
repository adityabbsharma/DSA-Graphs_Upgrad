/*
* Check Whether a Graph is a Tree
Description
Find if the graph is a tree or not.

The degree of a vertex is given by the number of edges incident or leaving from it.

Some useful properties are as follows:

Tree is connected and has no cycles while graphs can have cycles.
Tree has exactly n-1 edges while there is no such constraint for graph.
It is given that the input graph is connected. We need at least n-1 edges to connect n nodes.
If we take the sum of all the degrees, each edge will be counted twice. Hence, for a tree with n vertices and n – 1 edges, sum of all degrees should be 2 * (n – 1)

Input:

First line contains an integer N, the number of vertices.

Second line contains N space-separated integers, the degrees of the N vertices.

eg:

3

1 2 1

Output:

Print "Yes" (without the quotes) if the graph is a tree or "No" (without the quotes) otherwise

eg:

Yes
* */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CheckWhetherAGraphIsATree {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        scanner.nextLine();
        int[] degrees = new int[vertices];
        for(int i=0;i<vertices;i++){
            degrees[i] = scanner.nextInt();
        }
        int sumOfDegrees = 0;
        for(int i=0;i<vertices;i++){
            sumOfDegrees += degrees[i];
        }
        if((2*(vertices-1))==sumOfDegrees)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
