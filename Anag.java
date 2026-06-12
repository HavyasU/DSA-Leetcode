import java.util.*;
class Anag{
    public static void main(String[] args){
        String str1 = "listen";
        String str2 = "silent";

        str1 = Arrays.sort(str1.toCharArray()).toString();
        str2 = Arrays.sort(str2.toCharArray()).toString();


        System.out.println(str1);
    }
}