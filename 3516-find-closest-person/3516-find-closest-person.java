class Solution {
    public int findClosest(int x, int y, int z) {
        int xsteps = Math.abs(z-x);
        int ysteps = Math.abs(z-y);
        
        if(xsteps<ysteps){
            return 1;
        }else if(ysteps<xsteps){
            return 2;
        }else{
            return 0;
        }
    }
}