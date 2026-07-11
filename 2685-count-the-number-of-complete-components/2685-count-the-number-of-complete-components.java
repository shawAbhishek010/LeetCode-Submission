class Solution {
    static int[] parent;
    static int[] size;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);//
        }

        int edgeCount[] = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int root = find(u);
            edgeCount[root]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) != i)
                continue;
            int vertices = size[i];
            int edge1 = edgeCount[i];
            int edge2 = vertices * (vertices - 1) / 2;
            if (edge1 == edge2)
                count++;
        }
        return count;
    }

    private static void union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);
        if (leaderB != leaderA) {
            //deciding on the basis of size
            if (size[leaderA] > size[leaderB]) {
                parent[leaderB] = leaderA;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderA] = leaderB;
                size[leaderB] += size[leaderA];
            }

        }
    }

    private static int find(int a) {
        if (parent[a] == a)
            return a;
        int leader = find(parent[a]);
        parent[a] = leader;
        return leader;
    }
}