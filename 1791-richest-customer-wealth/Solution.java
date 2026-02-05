class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n;
        int rich = 0;
        for(int i=0;i<m;i++){
            n = accounts[i].length;
            int sum =0;
            for(int j=0;j<n;j++){
                sum+=accounts[i][j];
            }
            rich = Math.max(rich,sum);
        }
        return rich;
    }
}