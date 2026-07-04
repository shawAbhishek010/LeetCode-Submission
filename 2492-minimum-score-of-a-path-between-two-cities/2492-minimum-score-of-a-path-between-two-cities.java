
//dfs
class Solution {
    int score = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        // Create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Fill adjacency list
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, adj, visited);
        return score;
    }

    private void dfs(int node, List<List<Pair>> adj, boolean[] visited) {
        visited[node] = true;
        for (Pair p : adj.get(node)) {
            score = Math.min(score, p.dist);

            if (!visited[p.node]) {
                dfs(p.node, adj, visited);
            }
        }
    }

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
//BFS
// class Solution {
//     public int minScore(int n, int[][] roads) {
//         //creating adj list
//         List<List<pair>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         //fillling adjancency list
//         for (int ele[] : roads) {
//             int u = ele[0];
//             int v = ele[1];
//             int w = ele[2];
//             adj.get(u).add(new pair(v, w));
//             adj.get(v).add(new pair(u, w));
//         }
//         boolean visited[] = new boolean[n + 1];
//         Queue<pair> q = new LinkedList<>();
//         int score = Integer.MAX_VALUE;
//         q.add(new pair(1, 0));
//         while (q.size() != 0) {
//             pair pop = q.remove();
//             int node = pop.node;
//             int dist = pop.dist;
//             if (visited[node] == true)
//                 continue;
//             visited[node] = true;
//             for (pair p : adj.get(node)) {
//                 int a = p.node;
//                 int b = p.dist;
//                 score = Math.min(score, b);
//                 if (visited[a] != true) {
//                     q.add(new pair(a, b));
//                 }
//             }

//         }
//         return score;

//     }

//     class pair {
//         int node;
//         int dist;

//         pair(int n, int d) {
//             this.node = n;
//             this.dist = d;
//         }
//     }
// }
