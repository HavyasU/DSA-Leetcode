class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>(); 
        HashMap<Integer,Integer> freqMap = new HashMap<>(); 
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        int uniqueVal=0;
        for(int val:hm.values()){
            freqMap.put(val,freqMap.getOrDefault(val,0)+1);
        }

        for(Integer num:nums){
            if(freqMap.get(hm.get(num))==1){
                return num;
            }
        }



        return -1;
    }
}




