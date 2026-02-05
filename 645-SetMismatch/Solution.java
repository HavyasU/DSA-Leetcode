class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int arr[] = new int[2];
        int numToBe = 1;

        Set<Integer> st = new HashSet<>();
        int missing;
        int extra;

        for(int i=0;i<n;i++){
            if(st.contains(nums[i])){
                arr[0] = nums[i];
            }else{
                st.add(nums[i]);
            }
        }    
        
        for(int i=1;i<=n;i++){
            if(!st.contains(i)){
                arr[1] = i;
            }
        }
        
        return arr;
    }
}