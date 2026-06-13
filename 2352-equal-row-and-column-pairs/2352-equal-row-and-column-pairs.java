class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        int count = 0;
        HashMap<String,Integer> cols = new HashMap<>();
        for(int i = 0; i < n; i++){
            String val = "";
            for(int j = 0; j < n; j++){
                val += grid[j][i]+"-";
            }
            cols.put(val,cols.getOrDefault(val,0)+1);
        }

        for(int i = 0; i < n; i++){
            String val = "";
            for(int j = 0; j < n; j++){
                val += grid[i][j]+"-";
            }
            count += cols.getOrDefault(val,0);
        }
        return count;
    }


}

