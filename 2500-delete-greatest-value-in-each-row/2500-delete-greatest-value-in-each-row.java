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
                int maxindi=i;
                int maxindj=0;
                for(int j=0;j<n;j++){
                    if(grid[i][j] > grid[maxindi][maxindj]){
                        maxindi = i;
                        maxindj = j;
                    }
                    // System.out.println(grid[i][j] +" "+ grid[maxindi][maxindj]);
                }
                if(maxval<grid[maxindi][maxindj]){
                    maxval = grid[maxindi][maxindj];
                }
                // maxval = grid[maxindi][maxindj];
                grid[maxindi][maxindj] = -1;
            }
            System.out.println(count + " " +maxval);
            if(maxval>0)
            sum+=maxval;
            count++;
        }
        return sum;
    }
}