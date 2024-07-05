import java.util.*;
/**
547. Number of Provinces
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
*/
class NumberOfProvinces {
  private int[][] connectionGraph;
  private boolean[] visited;
  private void dfs(int cityIndex) {
    visited[cityIndex] = true;
    for(int i=0; i<connectionGraph.length; i++) {
        if (!isVisited[i] && connectionGraph[cityIndex][i] == 1) {
          dfs(i);
        }
    }
  }
  public int findCircleNum(int[][] isConnected) {
      connectionGraph = isConnected;
      int numOfCities = connectionGraph.length;
      visited = new boolean[numOfCities];
      int numOfProvinces = 0;
      for (int i=0; i<numOfCities; i++) {
          dfs(i);
          ++numOfProvinces;
      }
      return numOfProvinces;
    }
}
