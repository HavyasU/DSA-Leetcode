class Solution {
    public int findJudge(int n, int[][] trust) {

        int indegrees[] = new int[n];
        int outdegrees[] = new int[n];

        for(int p[] : trust){
            outdegrees[p[0]-1]++;
            indegrees[p[1]-1]++;
        }

        for(int i=0;i<n;i++){
            if(outdegrees[i] == 0 && indegrees[i]==(n-1)){
                return i+1;
            }
        }

        


        return -1;
    }
}