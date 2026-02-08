class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[] = new int[m+n];
        int k=0;
        int first = 0;
        int second = 0;

        if(m==1 && n==0){
            
        } 

        while(k<m+n){
            int num1,num2;
            if(first<m){
                num1 = nums1[first];
            }else{
                for(int i=second;i<n;i++){
                    res[k++] = nums2[i];
                }
                break;
            }
            if(second<n){
                num2 = nums2[second];
            }else{
                for(int i=first;i<m;i++){
                    res[k++] = nums1[i];
                }
                break;
            }

            if(num1<num2){
                res[k++] = num1;
                first++;
            }else if(num2<num1){
                res[k++] = num2;
                second++; 
            }else{
                res[k++] = num1;
                res[k++] = num2;
                first++; 
                second++;
            }
            System.out.println(k);
        }

        for(int i=0;i<m+n;i++){
            nums1[i] = res[i];
        }
    }
}