class Solution {
    public int totalMoney(int n) {
        int sum=0;
        int money = 1;
        for(int i=1;i<=n;i++){
            if(i%7==1){
                money = (i/7)+1;
            }else{
                money++;
            }
            sum+=money;
        }
        return sum;
    }
}