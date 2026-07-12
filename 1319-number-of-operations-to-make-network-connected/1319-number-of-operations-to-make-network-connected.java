class Solution {
    static int[] parent;
    static int[] size;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int ele[]:connections){
            int u = ele[0];
            int v = ele[1];
            union(u,v);
        }
        int defultConnection = 0;
        for(int i=0;i<n;i++){
            if(find(i)==i) defultConnection++;
        }
        
        return  defultConnection-1;
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