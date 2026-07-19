class Solution {
    public boolean canReach(int[] start, int[] target) {
        int startsum = start[0]+start[1];
        int targetsum = target[0]+target[1];

        if(startsum%2 == targetsum%2) return true;
        else return false;
    }
}