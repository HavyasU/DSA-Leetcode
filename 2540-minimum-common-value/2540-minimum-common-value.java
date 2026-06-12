class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while(first<n1 && second<n2){
            if(nums1[first] == nums2[second]){
                return nums1[first];
            }else if(nums1[first] < nums2[second]){
                first++;
            }else{
                second++;
            }
        }
        return -1;
    }
}