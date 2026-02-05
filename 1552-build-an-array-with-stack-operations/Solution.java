class Solution {
    public List<String> buildArray(int[] target, int n) {
        int prev =0;
        List<String> lst = new ArrayList<String>();
        for(int i=0;i<target.length;i++){
            int count = target[i]-prev;
            for(int j=1;j<=count-1;j++){
                lst.add("Push");
                lst.add("Pop");
            }
            prev = target[i];
            lst.add("Push");
        }

        return lst;
    }
}