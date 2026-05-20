class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n =words.length;
        int minsteps = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int diff = Math.abs(i-startIndex);
                int steps = Math.min(diff,(n-diff));
                if(steps < minsteps)
                minsteps = steps;
            }
        }
        
        if(minsteps == Integer.MAX_VALUE) return -1;
        return Math.abs(minsteps);
    }
}