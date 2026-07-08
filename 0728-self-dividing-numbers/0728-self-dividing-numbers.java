class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> lst = new ArrayList<>();
        for(int i=left;i<=right;i++){
            boolean valid = true;
            int num = i;
            while(num!=0){
                int d = num % 10;
                if(d==0 || i%d!=0) {
                    valid=false;
                    break;
                }
                num = num/10;
            }
            System.out.println(i);
            if(valid){
                lst.add(i);
            }
        }

        return lst;
    }
}