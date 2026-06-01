class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst =  new ArrayList<>();
        lst.add(new ArrayList<>(List.of(1)));
        if(numRows>1)
        lst.add(new ArrayList<>(List.of(1,1)));
        
        for(int i=2;i<numRows;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                int ele;
                if(j==0 || j==i){
                    ele = 1;
                }else{
                    ele = lst.get(i-1).get(j-1) + lst.get(i-1).get(j);
                }
                tmp.add(ele);
            }
            lst.add(tmp);
        }
        return lst;

    }
}