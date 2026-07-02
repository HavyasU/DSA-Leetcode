class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Arrays.sort(candyType);
        int types = 0;
        for(int i=0;i<n;i++){
            if(i==0){
                types++;
            }else{
                if(candyType[i]!=candyType[i-1]){
                    types++;
                }
            }
        }
        return Math.min(types,n/2);
    }
}