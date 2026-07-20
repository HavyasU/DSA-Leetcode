class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n==0) return arr;
        int ranks[] = Arrays.copyOf(arr,n);

        Arrays.sort(ranks);

        HashMap<Integer,Integer> map = new HashMap<>();
        int prev = ranks[0];
        int rank = 1;
        
        for(int ele : ranks){
            if(ele != prev){
                rank++;
                prev = ele;
            }
            map.put(ele,rank);
        }

        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}


// 37,12,28,9,100,56,80,5,12
// 5, 9, 12, 12, 28, 37, 56, 80, 100
// 1