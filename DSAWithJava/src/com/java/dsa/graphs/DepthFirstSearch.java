class DepthFirstSearch {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<5; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        ArrayList<Integer> ans = dfsOfGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }
    private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        visited[0] = true;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i=0; i<V; i++) {
            if (visited[i] == false) {
                dfs(i, adj, visited, ls);
            }
        }
        return ls;
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ls) {
        visited[node] = true;
        ls.add(node);
        for (Integer it: adj.get(node)) {
            if (visited[it] == false) {
                dfs(it, adj, visited, ls);
            }
        }
    }
}
