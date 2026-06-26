class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low,high,mid;

        low=0;
        high=m-1;
        mid = -1;
        int ind=-1;
        while(low <= high){
            mid = (low+high)/2;
            if(target >= matrix[mid][0] && target<=matrix[mid][n-1]){
                 ind = mid;
                 break;
            }else if(target<matrix[mid][0]){
                high = mid-1;
            }else if(target > matrix[mid][n-1]){
                low = mid+1;
            }
        }

        if(ind==-1) return false;
        low = 0;
        high = n-1;
        int midind = -1;
        while(low <= high){
            midind  = (low+high)/2;
            if(target == matrix[ind][midind]){
                return true;
            }else if(target<matrix[ind][midind]){
                high = midind-1;
            }else if(target > matrix[ind][midind]){
                low = midind+1;
            }
        }

        return false;

    }
}