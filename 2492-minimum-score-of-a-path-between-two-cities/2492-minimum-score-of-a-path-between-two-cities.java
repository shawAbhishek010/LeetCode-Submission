//BFS
class Solution {
    public int minScore(int n, int[][] roads) {
        //creating adj list
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        //fillling adjancency list
        for (int ele[] : roads) {
            int u = ele[0];
            int v = ele[1];
            int w = ele[2];
            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }
        boolean visited[] = new boolean[n + 1];
        Queue<pair> q = new LinkedList<>();
        int score = Integer.MAX_VALUE;
        q.add(new pair(1, 0));
        while (q.size() != 0) {
            pair pop = q.remove();
            int node = pop.node;
            int dist = pop.dist;
            if (visited[node] == true)
                continue;
            visited[node] = true;
            for (pair p : adj.get(node)) {
                int a = p.node;
                int b = p.dist;
                score = Math.min(score, b);
                if (visited[a] != true) {
                    q.add(new pair(a, b));
                }
            }

        }
        return score;

    }

    class pair {
        int node;
        int dist;

        pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }
    }
}

// class Solution {
//     public int minScore(int n, int[][] roads) {

//     }
// }

// class Solution {
//     static int parent[];
//     static int size[];

//     public int minScore(int n, int[][] roads) {
//         List<triplet> list = new ArrayList<>();
//         n = n + 1;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int x1 = roads[i][0];
//                 int y1 = roads[i][1];
//                 int x2 = roads[j][0];
//                 int y2 = roads[j][1];
//                 int mDistance = Math.abs(x1 - x2) +
//                         Math.abs(y1 - y2);

//                 list.add(new triplet(i, j, mDistance));
//             }
//         }
//         int ans = Integer.MAX_VALUE;
//         Collections.sort(list);
//         parent = new int[n];
//         size = new int[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//             size[i] = 1;
//         }
//         for (int i = 0; i < list.size(); i++) {
//             triplet edge = list.get(i);
//             int u = edge.u;
//             int v = edge.v;
//             int wt = edge.dist;
//             if (find(u) == find(v))
//                 continue;
//             ans = Math.min(ans, wt);
//             union(u, v);
//         }

//         return ans;
//     }

//     public class triplet implements Comparable<triplet> {
//         int u;
//         int v;
//         int dist;

//         triplet(int u, int v, int dist) {
//             this.u = u;
//             this.v = v;
//             this.dist = dist;
//         }

//         public int compareTo(triplet t) {
//             return Integer.compare(this.dist, t.dist);
//         }

//     }

//     // Union By Size
//     public void union(int a, int b) {
//         int leaderA = find(a);
//         int leaderB = find(b);
//         if (leaderA != leaderB) {
//             if (size[leaderA] > size[leaderB]) {
//                 parent[leaderB] = leaderA;
//                 size[leaderA] += size[leaderB];

//             } else {
//                 parent[leaderA] = leaderB;
//                 size[leaderB] += size[leaderA];
//             }
//         }
//     }

//     // finding leader
//     public int find(int a) {
//         if (parent[a] == a)
//             return a;
//         int leader = find(parent[a]);
//         parent[a] = leader;//path compression
//         return leader;
//     }

// }