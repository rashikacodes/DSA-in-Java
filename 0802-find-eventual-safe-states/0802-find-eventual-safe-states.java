
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<Integer>[] adjRev = new ArrayList[V];

        for (int i = 0; i < V; i++)
            adjRev[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int it : graph[i]) {
                adjRev[it].add(i);
            }
        }

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adjRev[i]) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int it : adjRev[node]) {
                indegree[it]--;

                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
