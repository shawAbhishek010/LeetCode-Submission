class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        //creating  2d array
        int walkList[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    walkList[i][j] = 0;
                else
                    walkList[i][j] = Integer.MAX_VALUE;
            }
        }
        //appplying dijkstra(0-1BF{more optimized for 0-1 grid prblm}) algorithm
        walkList[0][0] = grid.get(0).get(0);
        Deque<pair> dq = new ArrayDeque<>();
        dq.add(new pair(0, 0));
        while (!dq.isEmpty()) {
            pair top = dq.removeFirst();
            int row = top.row;
            int col = top.col;
            // Right
            if (col + 1 < n) {
                int newCost = walkList[row][col] + grid.get(row).get(col + 1);
                if (newCost < walkList[row][col + 1]) {
                    walkList[row][col + 1] = newCost;
                    if (grid.get(row).get(col + 1) == 0)
                        dq.addFirst(new pair(row, col + 1));
                    else
                        dq.addLast(new pair(row, col + 1));
                }
            }
            // Down
            if (row + 1 < m) {
                int newCost = walkList[row][col] + grid.get(row + 1).get(col);
                if (newCost < walkList[row + 1][col]) {
                    walkList[row + 1][col] = newCost;
                    if (grid.get(row + 1).get(col) == 0)
                        dq.addFirst(new pair(row + 1, col));
                    else
                        dq.addLast(new pair(row + 1, col));
                }
            }
            // Up
            if (row - 1 >= 0) {
                int newCost = walkList[row][col] + grid.get(row - 1).get(col);
                if (newCost < walkList[row - 1][col]) {
                    walkList[row - 1][col] = newCost;
                    if (grid.get(row - 1).get(col) == 0)
                        dq.addFirst(new pair(row - 1, col));
                    else
                        dq.addLast(new pair(row - 1, col));
                }
            }
            // Left
            if (col - 1 >= 0) {
                int newCost = walkList[row][col] + grid.get(row).get(col - 1);
                if (newCost < walkList[row][col - 1]) {
                    walkList[row][col - 1] = newCost;
                    if (grid.get(row).get(col - 1) == 0)
                        dq.addFirst(new pair(row, col - 1));
                    else
                        dq.addLast(new pair(row, col - 1));
                }
            }
        }
        return walkList[m - 1][n - 1] < health;
    }

    class pair {
        int row;
        int col;

        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}