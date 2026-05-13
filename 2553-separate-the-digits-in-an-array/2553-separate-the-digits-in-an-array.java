class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int num:nums){
            for(char ele : String.valueOf(num).toCharArray()){
                lst.add(ele-'0');
            }
        }
    int res[] = new int[lst.size()];
    int idx = 0;
    for(int ele:lst){
        res[idx++] = ele;
    }
    return res;
    }
}