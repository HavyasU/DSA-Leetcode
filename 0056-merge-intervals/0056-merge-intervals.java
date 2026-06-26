class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int n = intervals.length;

        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> sublst = new ArrayList<>();
        sublst.add(intervals[0][0]);
        sublst.add(intervals[0][1]);
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= sublst.get(sublst.size()-1)){
                int ele = sublst.removeLast();
                sublst.add(Math.max(intervals[i][1],ele));
            }else{
                if(sublst.size()>0){
                    lst.add(sublst);
                    sublst = new ArrayList<>();
                }
                sublst.add(intervals[i][0]);
                sublst.add(intervals[i][1]);
            }
        }
        if(sublst.size()>0){
        lst.add(sublst);
        }

        int res[][] = new int[lst.size()][2];
        for(int i=0;i<lst.size();i++){
            res[i][0] = lst.get(i).get(0);
            res[i][1] = lst.get(i).get(1);
        }

        return res;
    }
}