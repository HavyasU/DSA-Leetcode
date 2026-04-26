class Solution {
    public int addRungs(int[] rungs, int dist) {
        int count = 0;
        int cur = 0;
        for(int i=0;i<rungs.length;){
            if(rungs[i]-cur >  dist){
                count+=((rungs[i]-cur-1)/dist);
                cur = rungs[i];
            }else{
                cur=rungs[i];
                i++;
            }
        }
        return count;
    }
}