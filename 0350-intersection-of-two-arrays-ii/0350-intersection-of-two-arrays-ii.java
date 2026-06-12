class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int point1=0;
        int point2=0;

        ArrayList<Integer> lst = new ArrayList<>();

        while(point1<n1 && point2<n2){
            if(nums1[point1] == nums2[point2]){
                lst.add(nums1[point1]);
                point1++;
                point2++;
            }else if(nums1[point1]<nums2[point2]){
                point1++;
            }else{
                point2++;
            }
        }

        int res[] = new int[lst.size()];
        int idx = 0;
        for(int ele : lst){
            res[idx++] = ele;
        }
        return res;
    }
}