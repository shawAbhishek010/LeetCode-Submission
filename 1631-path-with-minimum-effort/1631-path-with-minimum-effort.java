class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //creating effort 2d array
        int effortList[][] = new int[m][n];
        for(int i= 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i==0 && j==0)effortList[i][j]=0;
                else effortList[i][j]=Integer.MAX_VALUE;
            }
        }
        //appplying dijkstra algorithm
        PriorityQueue<triplet> pq = new PriorityQueue<>();
        pq.add(new triplet(0,0,0));
        while(pq.size()>0){
            triplet top = pq.remove();
            int row = top.row;
            int col =top.col;
            int effort = top.effort;
            // if(effort > effortList[row][col])
            // continue;//OPTIMIZATION
            if(row == m-1 && col == n-1)return effortList[m-1][n-1];
            //->right
            if(col+1<n){
                int x =heights[row][col+1];//right element
                int y =heights[row][col];//current element
                int effortDiff =Math.abs(x-y);
                int finalEffort = Math.max(effortDiff,effort);
                if(finalEffort<effortList[row][col+1]){
                    pq.add(new triplet(row,col+1,finalEffort));
                    effortList[row][col+1] =finalEffort;
                }

            }
            //->down
            if(row+1<m){
                int x =heights[row+1][col];//down element
                int y =heights[row][col];//current element
                int effortDiff =Math.abs(x-y);
                int finalEffort = Math.max(effortDiff,effort);
                if(finalEffort<effortList[row+1][col]){
                    pq.add(new triplet(row+1,col,finalEffort));
                    effortList[row+1][col] =finalEffort;
                }
            }
            //->top
            if(row-1>=0){
                int x =heights[row-1][col];//top element
                int y =heights[row][col];//current element
                int effortDiff =Math.abs(x-y);
                int finalEffort = Math.max(effortDiff,effort);
                if(finalEffort<effortList[row-1][col]){
                    pq.add(new triplet(row-1,col,finalEffort));
                    effortList[row-1][col] =finalEffort;
                }

            }
            //->left
            if(col-1>=0){
                int x =heights[row][col-1];//left element
                int y =heights[row][col];//current element
                int effortDiff =Math.abs(x-y);
                int finalEffort = Math.max(effortDiff,effort);
                if(finalEffort<effortList[row][col-1]){
                    pq.add(new triplet(row,col-1,finalEffort));
                    effortList[row][col-1] =finalEffort;
                }
            }
        }
        return effortList[m-1][n-1];

    }
    class triplet implements Comparable<triplet>{
        int row;
        int col;
        int effort;
        triplet(int r, int c, int e){
            this.row =r;
            this.col = c;
            this.effort =e;
        }
        public int compareTo(triplet T){
            return Integer.compare(this.effort,T.effort);
        }
    }
}