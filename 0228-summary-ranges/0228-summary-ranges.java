class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> lst = new ArrayList<>();
        if(nums.length==0) return lst;
        int prev = nums[0];
        int start = nums[0];
        for(int i=1;i<nums.length;i++){
            int ele = nums[i];
            
                if(ele != (prev+1)){
                    if(prev==start){
                        lst.add(""+start);
                    }else{
                        lst.add(""+start+"->"+prev);
                    }
                    start = ele;
                }
                prev = ele;
        }
        if(nums[nums.length-1] != (prev+1)){
                    if(prev==start){
                        lst.add(""+start);
                    }else{
                        lst.add(""+start+"->"+prev);
                    }
                    // start = ele;
        }
        
        return lst;
    }

}