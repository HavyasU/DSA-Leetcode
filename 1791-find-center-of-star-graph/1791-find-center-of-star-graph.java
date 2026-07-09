class Solution {
    public int findCenter(int[][] edges) {
        int line[] = new int[edges.length+1];

        for(int path[] : edges){
            
            

            if(++line[path[0]-1]==edges.length){
                return path[0];
            }

             if(++line[path[1]-1]==edges.length){
                return path[1];
            }
        }

        return -1;
    }
}