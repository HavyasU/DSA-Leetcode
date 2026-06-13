class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int  m =grid.length;
        int n = grid[0].length;
        int count = 0;
        int sum = 0;
        int maxval=0;
        for(int i=0;i<m;i++){
                Arrays.sort(grid[i]);
        }
        for(int j = 0;j<n;j++){
            int max = 0;
            for(int i=0;i<m;i++){
            int cur = grid[i][n-j-1];
            if(cur>max) max = cur;
            }
            sum+=max;
        }
        return sum;


    }
}