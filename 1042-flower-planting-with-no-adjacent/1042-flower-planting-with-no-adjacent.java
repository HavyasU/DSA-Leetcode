class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new  ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int path[] : paths){
            adj[path[0]].add(path[1]);
            adj[path[1]].add(path[0]);
        }
        int types[]= new int[n];
        for(int i=1;i<=n;i++){
            boolean available[] = new boolean[5];
            for(int v : adj[i]){
                if(types[v-1]!=0){
                    available[types[v-1]] = true; 
                    // true means filled
                    // false means available to take.
                }
            }
            for(int k=1;k<available.length;k++){
                if(!available[k]){
                    types[i-1] = k;
                    break;
                }
            }
        }

        return types;

    }
}