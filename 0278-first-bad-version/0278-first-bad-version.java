/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid=-1;
        while(low<high){
            mid = low + (high-low)/2;
            boolean res = isBadVersion(mid);
            if(res == true){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return isBadVersion(low) ? low : -1;
    }
}


// 1, 2, 3, 4, 5
// f  f  f  t  t

// 1,5 = 3 (low = 3, high = 5)
// 3,5 = 4 (low = 3, high = 4)
// 3,4 = 3 (low =3, high = 4)



// 1, 2
// t, t

// 1, 2  = 1    (low = 1, high = 1)
// 1, 1  = 1    (low = 1, high = 1)
