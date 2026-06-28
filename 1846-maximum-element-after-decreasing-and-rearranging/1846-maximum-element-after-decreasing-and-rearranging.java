class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max=-999;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i==0){
                if(arr[i]!=1)
                arr[i] = 1;
            }else{
                arr[i] = Math.min(arr[i-1]+1, arr[i]);
            }

            max = Math.max(max,arr[i]);
        }

        return max;

    }
}