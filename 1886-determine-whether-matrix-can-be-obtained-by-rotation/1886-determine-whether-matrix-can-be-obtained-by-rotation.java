class Solution {
    public boolean rotateMat(int[][] mat, int[][] target){
        int n  = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j>i){
                    int ele = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i]=ele;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                    int ele = mat[i][j];
                    mat[i][j] = mat[i][n-j-1];
                    mat[i][n-j-1] =ele;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(rotateMat(mat,target)){
                return true;
            }
        }
        return false;
    }
}