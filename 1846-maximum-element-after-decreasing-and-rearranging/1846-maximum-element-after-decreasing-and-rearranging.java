class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if(arr[0]!=1)
            arr[0] = 1;
        int max=arr[0];
        for(int i=1;i<n;i++){
            arr[i] = Math.min(arr[i-1]+1, arr[i]);
            max = Math.max(max,arr[i]);
        }

        return max;

    }
}