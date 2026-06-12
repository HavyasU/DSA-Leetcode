class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j>=i){
                int ele = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = ele;
                }
            }
        }

        for(int i=0;i<n;i++){
            int start = 0;
            int end = n-1;

            while(start<=end){
                int ele = matrix[i][start];
                matrix[i][start++] = matrix[i][end];
                matrix[i][end--] = ele;
            }
        }




    }
}