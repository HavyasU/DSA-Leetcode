class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int plantableCount = 0;
        int len = flowerbed.length;
        if(n==0) return true;
        if(len<=1){
            if(len==0) return false;
            if(flowerbed[0] == 0 && n==1) return true;
            return false;
        }
        if(flowerbed[0]==0 && flowerbed[1]==0){
            flowerbed[0]=1;
            plantableCount++;
        }
        if(flowerbed[len-1]==0 && flowerbed[len-2]==0){
            flowerbed[len-1]=1;
            plantableCount++;
        }
        for(int i=1;i<flowerbed.length-2;i++){
            if(flowerbed[i-1] == 0 && flowerbed[i+1]==0 && flowerbed[i] == 0){
                plantableCount++;
                flowerbed[i] = 1;
            }
            if(plantableCount>=n){
                return true;
            }
        }
        return plantableCount>=n;

    }
}