class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int dist[] = new int[n];
        

        int point = -1;
        for(int i =n-1;i>=0;i--){
            if(s.charAt(i) == c)
               point=0;

            if(point!=-1){
                dist[i] = point++;
            }else{
                dist[i] = -1;
            }
        }

        point = -1;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == c)
                point=0;
            if(point!=-1){
                if(dist[i] > point || dist[i] == -1)
                dist[i] = point;
                point++;
            }
        }

        

        return dist;
    }
}

//   l  o  v  e  l  e  e  t  c  o  d  e
//  [3, 2, 1, 0, 1, 0, 0, 4, 3, 2, 1, 0]



