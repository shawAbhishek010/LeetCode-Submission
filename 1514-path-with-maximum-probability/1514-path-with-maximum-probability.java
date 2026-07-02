class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //creating adjancency list
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double c = succProb[i];
            adj.get(a).add(new pair(b, c));
            adj.get(b).add(new pair(a, c));

        }
        //creating maxProb arrayList
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == start_node)
                list.add(1.0);
            else
                list.add(0.0);
        }
        //Applying dijkstra algorithm
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new pair(start_node, 1.0));
        while (pq.size() > 0) {
            pair top = pq.remove();
            int node = top.node;
            double prob = top.prob;
            for (pair p : adj.get(node)) {
                double newProb = p.prob * prob;
                if (list.get(p.node) < newProb) {
                    list.set(p.node, newProb);
                    pq.add(new pair(p.node, newProb));
                }
            }
        }
        double ans = list.get(end_node);
        // if (ans == Integer.MIN_VALUE)
        //     return 0;
        return ans;
    }

    class pair implements Comparable<pair> {
        int node;
        double prob;

        pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
        @Override
        public int compareTo(pair other) {
            return Double.compare(this.prob, other.prob); // Max Heap based on prob
        }
    }
}