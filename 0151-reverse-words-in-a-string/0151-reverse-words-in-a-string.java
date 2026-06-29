class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String word : s.split(" ")){
            if(!word.trim().equals("")){
                sb.append(word+" ");
            }
        }

        String arr[] = sb.toString().split(" ");
        System.out.println(arr[0]);
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            String t = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = t;
        }
        return String.join(" ",arr);
    }
}