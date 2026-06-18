class Solution {
    public double angleClock(int hour, int minutes) {
        double hr = (hour * 360) /12;
        double min = (minutes * 360) / 60;
        double ded = 30 * (min/360);
        double deg = Math.abs((hr+ded) - min); 

        // System.out.println(hr+ " "+min+" "+ded+" "+deg);
        return Math.min(deg, Math.abs(360-deg));
    }
}

// 3.00 360/4 = 90deg
// 90deg / 15min = 6deg
// 6/60 sec = 0.1 deg 

// 6deg - min;
// 0.1 deg / sec;


// full round = 5sec;
// 5sec / 12t
