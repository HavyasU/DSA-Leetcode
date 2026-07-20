class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){           
                int index = (i*n) + j;
                index=(index+k)%(m*n);
                
                int ai = index/n;
                int aj = index%n;

                ans[ai][aj] = grid[i][j];
            }
        }
        List<List<Integer>> lst = new ArrayList<>();

        for(int[] arr : ans){
            List<Integer> sub = new ArrayList<>();
            for(int ele :arr)
            {
                sub.add(ele);
            }
            lst.add(sub);
        }

        return lst;
    }
}