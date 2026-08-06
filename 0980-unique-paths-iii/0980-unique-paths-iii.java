class Solution {
    int nonObstacleCount;

    public int uniquePathsIII(int[][] grid) {
        //find non-obstacle count and starting point
        int X = 0;
        int Y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    X = i;
                    Y = j;
                }
                if (grid[i][j] == 1 || grid[i][j] == 0)
                    nonObstacleCount++;
            }
        }
        int ans = helper(X, Y, grid, 0);
        return ans;
    }

    public int helper(int i, int j, int[][] grid, int count) {
        int m = grid.length;
        int n = grid[0].length;
          if (i < 0 || i >= m || j < 0 || j >= n)
            return 0;
        if (grid[i][j] == 5)
            return 0;//5 for visited grid
        if (grid[i][j] == 2 && count == nonObstacleCount)
            return 1;
        if (grid[i][j] == -1)
            return 0;
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 0;
        int temp = grid[i][j];
        grid[i][j] = 5;
        int right = helper(i, j + 1, grid, count+1); //moving right
        int left = helper(i, j - 1, grid, count+1); //moving left 
        int up = helper(i - 1, j, grid, count+1); //moving up
        int down = helper(i + 1, j, grid, count+1); //moving down


        grid[i][j] = temp;
        return right + left + up + down;

    }
}