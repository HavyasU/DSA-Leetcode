class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end  = n-1;
        int maxlevel = 0;
        while(start<end){
            int curlevel = (Math.min(height[start],height[end])) * (end-start);
            if(curlevel > maxlevel) maxlevel = curlevel;
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }

        return maxlevel;
    }
}