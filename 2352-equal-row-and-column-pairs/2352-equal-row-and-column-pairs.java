class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        int count = 0;
        HashMap<String,Integer> cols = new HashMap<>();
        for(int i = 0; i < n; i++){
            char val[] = new char[n+(n)];
            int idx = 0;
            for(int j = 0; j < n; j++){
                val[idx++] = (char)(grid[j][i] + '0');
                val[idx++] = '-';
            }
            String strval = String.valueOf(val);
            cols.put(strval,cols.getOrDefault(strval,0)+1);
        }

        for(int i = 0; i < n; i++){
            char val[] = new char[n+(n)];
            int idx = 0;
            for(int j = 0; j < n; j++){
                val[idx++] = (char)(grid[i][j] + '0');
                val[idx++] = '-';
            }
            String strval = String.valueOf(val);
            count += cols.getOrDefault(strval,0);
        }
        return count;
    }


}

