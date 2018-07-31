package siody.exams;

public class ReRankAbc {
    public static void swap(char[] c, int i,int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    public static void combination(char[] c,int low,int high){
        byte[] flag = new byte[256];
        if(low==high) {
            System.out.println(c);
        }
        for (int i = low; i <= high; i++)
        {
            if(flag[c[i]]!=1){
                swap(c,low, i);
                combination(c, low+1, high);
                swap(c,low,i);
                flag[c[i]]=1;
            }
        }
    }

    public static void main(String[] args){
        char[] str = {'a','b','b'};
        combination(str,0,str.length-1);
    }
}
