class Solution {
    public void setZeroes(int[][] matrix) {
        int k=0;
        int m = matrix.length;
        int n = matrix[0].length;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((matrix[i][j] == 0)){
                    k = 0;
                    while(k<m){
                        if(matrix[k][j]!=0)
                        matrix[k][j]=-10;
                        k++;
                    }

                    k = 0;
                    while(k<n){
                        if(matrix[i][k]!=0)
                        matrix[i][k]=-10;
                        k++;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((matrix[i][j] == -10)){
                    matrix[i][j] = 0;
                }}}

    }
}