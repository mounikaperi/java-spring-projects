import java.io.*;
import java.util.*;

class BreadthFirstSearchAlgorithm {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      while (T-- > 0) {
          String[] s = br.readLine().trim().split(" ");
          int V = Integer.parseInt(s[0]);
          int E = Integer.parseInt(s[1]);
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
          for (int i=0; i<V; i++) {
              adj.add(new ArrayList<Integer>());
          }
          for (int i=0; i<E; i++) {
              String[] s = br.readLine().trim().split(" ");
              int u = Integer.parseInt(s[0]);
              int v = Integer.parseInt(s[1]);
              adj.get(u).add(v);
              // adj.get(v).add(u); - for directed graphs - uncomment for undirected graphs
          }
          Solution obj = new Solution();
          ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
          for (int i = 0; i < ans.size(); i++)
              System.out.print(ans.get(i) + " ");
          System.out.println();
      }
    }
}

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
          ArrayList<Integer> bfsResult = new ArrayList<>();
          boolean visited[] = new boolean[V];
          Queue<Integer> queue = new LinkedList<>();
          queue.add(0); // As this is 0 base index graph start with 1 if it is 1 based index graph
          visited[0] = true;
          while (!queue.isEmpty()) {
                Integer nextElementInQueue = queue.poll();
                bfsResult.add(nextElementInQueue);
                for (Integer currentNeighbourElement: adj.get(nextElementInQueue)) {
                      if (visited[currentNeighbourElement] == false) {
                          visited[currentNeighbourElement] = true;
                          queue.add(currentNeighbourElement);
                      }
                }
          }
          return bfsResult;
    }
}
