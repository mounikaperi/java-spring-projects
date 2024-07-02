// P: Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

import java.util.*;
import java.io.*;
import java.math.*;

class NumberOfUndirectedGraphs {
    public long count(int n) {
        return (long) Math.pow(2, (n*(n-1)/2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0) {
            int n = sc.nextInt();
            NumberOfUndirectedGraphs obj = new NumberOfUndirectedGraphs();
            long answer = obj.count(n);
            System.out.println(answer);
        }
    }
}
        
