class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> hs = new HashSet<>();
        int size=0;
        for(int i=0;i<n;i++){
            if(hs.add(candyType[i]))
            size++;
            if(size>n/2) return n/2;
        }
        return Math.min(size,n/2);
    }
}