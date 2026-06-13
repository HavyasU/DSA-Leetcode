class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int  m =grid.length;
        int n = grid[0].length;
        int count = 0;
        int sum = 0;
        int maxval=0;
        while(count<(n)) {
            maxval = 0;
            for(int i=0;i<m;i++){
                int rowj=0;
                for(int j=1;j<n;j++){
                    if(grid[i][j]>grid[i][rowj]){
                        rowj = j;
                    }
                }
                if(maxval<grid[i][rowj]){
                    maxval = grid[i][rowj];
                }
                grid[i][rowj] = -1;
            }
            if(maxval>0)
            sum+=maxval;
            count++;
        }
        return sum;
    }
}