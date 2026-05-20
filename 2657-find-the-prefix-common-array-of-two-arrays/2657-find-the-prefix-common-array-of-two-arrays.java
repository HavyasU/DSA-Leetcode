class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int prefix[]= new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            count = 0;
            for(int key : map.keySet()){
                if(map.get(key)==2){
                    count++;
                }
            }
            prefix[i] = count;
        }

        return prefix;
    }
}