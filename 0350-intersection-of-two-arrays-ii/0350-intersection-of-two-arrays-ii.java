class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freq[] = new int[1001];
        int res[] = new int[Math.min(nums1.length,nums2.length)];
        int idx = 0;
        for(int num: nums1){
            freq[num]++;
        }

        for(int num:nums2){
            if(freq[num]> 0){
                res[idx++] = num;
            }
            freq[num]--;
        }

        return Arrays.copyOfRange(res,0,idx);
    }
}