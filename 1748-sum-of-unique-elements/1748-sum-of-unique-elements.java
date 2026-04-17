class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int sum=0;
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }


        // for(Map.Entry<Integer,Integer> ele : freq.entrySet()){
        //     if(ele.getValue() == 1){
        //         sum+=ele.getKey();
        //     }
        // }

        for(int n:nums){
            if(freq.get(n) == 1){
                sum+=n;
            }
        }
        return sum;
    }
}