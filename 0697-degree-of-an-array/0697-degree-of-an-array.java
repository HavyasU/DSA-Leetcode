class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }



        int maxval = -99;
        for(int v : map.values()){
            if(v > maxval) maxval = v;
        }

        int smallLen = Integer.MAX_VALUE;
        for(int key : map.keySet()){
            if(map.get(key) == maxval){

                int start = -1;
                int end = -1;
                for(int i=0;i<nums.length;i++){
                if(nums[i] == key){
                    if(start==-1){
                        start = i; 
                    }
                    end = i;
                }
                }  
                if(smallLen > (end-start+1)) smallLen =  (end-start+1);
            }
        }
       
        return smallLen;
    }
}