class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean  mat[][] = new boolean[n][n];

        for(int p[] : trust){
            mat[p[0]-1][p[1]-1] = true;
        }

        for(int i =0;i<n;i++){
            boolean isvalid = true;
            for(int j=0;j<n;j++){
                if(j==i) continue;
                if(mat[i][j] == true || mat[j][i] == false){
                    isvalid = false;
                    break;
                }
            }
            if(isvalid){
                return i+1;
            }
        }


        return -1;
    }
}