class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0;
        int end =n-1;

        while(start<end){
            int cur = numbers[start]+numbers[end];
            if(cur == target){
                return new int[] {start+1,end+1};
            }else if(cur<target){
                start++;
            }else {
                end--;
            }
        }

        return new int[] {};
    }
}