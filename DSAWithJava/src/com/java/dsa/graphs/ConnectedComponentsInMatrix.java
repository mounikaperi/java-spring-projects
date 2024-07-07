class ConnectedComponentsInMatrix {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (Integer it : adj.get(node)) {
            if (visited[it] == false) {
                dfs(it, adj, visited);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
          ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
          for (int i=0; i<V; i++) {
              adjLs.add(new ArrayList<Integer>());
          }
          for (int i=0; i<V; i++) {
              for (int j=0; j<V; j++) {
                  if (adj.get(i).get(j) == 1 && i!=j) {
                      adjLs.get(i).add(j);
                      adjLs.get(j).add(i);
                  }
              }
          }
          boolean visited[] = new boolean[V];
          visited[0] = true;
          int count = 0;
          for (int i=0; i<V; i++) {
              if (visited[i] == false) {
                  dfs(i, adjLs, visited);
                  ++count;
              }
          }    
      return count;
    }
}
