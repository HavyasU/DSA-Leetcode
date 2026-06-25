class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        for(int i =0 ; i<n; i++){
            map.put(nums2[i],-1);
            for(int j=i+1;j<n;j++){
                if(nums2[j] > nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }

        int res[] = new int[nums1.length];
        int idx = 0;
        for(int ele : nums1){
            res[idx++] = map.get(ele);
        }

        return res;
    }
}