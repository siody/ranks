package siody.exams;

public class ReRankNumsBigger {
    public static void main(String[] args){
        int toBigger = 1233;
        char[] toBiggerChars = Integer.toString(toBigger).toCharArray();
        int toSwap=toBiggerChars.length-1;
        for (int i=toBiggerChars.length-1;i>0;--i){
            if (toBiggerChars[i]>toBiggerChars[i-1]){
                // swap
                char tmp = toBiggerChars[i-1];
                toBiggerChars[i-1] = toBiggerChars[toSwap];
                toBiggerChars[toSwap] = tmp;
                break;
            } else if (toBiggerChars[i]<toBiggerChars[i-1]){
                toSwap--;
            } else if (toBiggerChars[i]==toBiggerChars[i-1]){
                toSwap--;
            }
        }
        System.out.println(toBiggerChars);
    }
}
