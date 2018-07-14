package siody.ranks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.javafx.application.PlatformImpl.exit;
import static java.lang.Math.min;

public class VsCompare {
    static public void main(String[] args){
        String versionA = "1.2.3a";
        String versionB = "1.2.3b";
    }

    public void compare(String versionA, String versionB) {
        String pattern = "\\d+\\.";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(versionA);
        while(m.find()) {
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
            System.out.println(versionA.substring(m.start(),m.end()-1));
        }
        pattern = "\\d+[^//.][a-z]*";
        r = Pattern.compile(pattern);
        m = r.matcher(versionA);
        while(m.find()) {
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
            System.out.println(versionA.substring(m.start(),m.end()));
        }
    }

    public void faild(String versionA, String versionB) {
        String[] partsa;
        partsa=versionA.split("\\.");
        String[] partsb;
        partsb=versionB.split("\\.");
        if (partsa.length!=partsb.length)
            exit();
        StringBuilder va = new StringBuilder();
        StringBuilder vb = new StringBuilder();
        int result;
        for (int i = 0;i<partsa.length;++i){
            if (partsa[i].length()-partsb[i].length()==0){
                va.append(partsa[i]);
                vb.append(partsb[i]);
            }else if ((result =partsa[i].length()-partsb[i].length())<0){
                for (int j=0;j>result;--j)
                    va.append("0");
                va.append(partsa[i]);
                vb.append(partsb[i]);
            }else if ((result =partsa[i].length()-partsb[i].length())>0){
                for (int j=0;j<result;++j)
                    vb.append("0");
                va.append(partsa[i]);
                vb.append(partsb[i]);
            }
        }
        double valuea = Double.valueOf(va.toString().substring(0,va.length()-1));
        double valueb = Double.valueOf(vb.toString().substring(0,vb.length()-1));
        if (valuea>valueb)
            System.out.println("a");
        if (valuea<valueb)
            System.out.println("b");
        if (valuea==valueb) {
            if (va.toString().charAt(va.length()-1) > vb.toString().charAt(vb.length()-1))
                System.out.println("a");
            if (va.toString().charAt(va.length()-1) < vb.toString().charAt(vb.length()-1))
                System.out.println("b");
            if (va.toString().charAt(va.length()-1) == vb.toString().charAt(vb.length()-1))
                System.out.println("equle");
        }
    }
    public void skipsame(String versionA, String versionB) {
        int end = Math.min(versionA.length(),versionB.length());
        int currentPartStart=0;
        int currentPartEndA=0,currentPartEndB=0;
        for (int i=0;i<end;++i) {
            if (versionA.charAt(i)!=versionB.charAt(i)) {
                currentPartEndA = i;
                currentPartEndB = i;
                while (currentPartEndA < versionA.length() && versionA.charAt(currentPartEndA)!='.'){
                    currentPartEndA++;
                }
                while (currentPartEndB < versionB.length() && versionB.charAt(currentPartEndB)!='.'){
                    currentPartEndB++;
                }
                break;
            } else if (versionA.charAt(i) == '.'){
                currentPartStart = i+1;
            }
        }
        String differentPartA = versionA.substring(currentPartStart,currentPartEndA);
        String differentPartB = versionB.substring(currentPartStart,currentPartEndB);
        char charPartA = 'a';
        char charPartB = 'a';
        if (differentPartA.charAt(differentPartA.length()-1)>='a'){
            charPartA = differentPartA.charAt(differentPartA.length()-1);
            differentPartA = differentPartA.substring(0,differentPartA.length()-1);
        }
        if (differentPartB.charAt(differentPartB.length()-1)>='a'){
            charPartB = differentPartB.charAt(differentPartB.length()-1);
            differentPartB = differentPartB.substring(0,differentPartB.length()-1);
        }
        if (Integer.parseInt(differentPartA)>Integer.parseInt(differentPartB)){
            System.out.println("A is bigger");
        }else if (Integer.parseInt(differentPartA)<Integer.parseInt(differentPartB)) {
            System.out.println("B is bigger");
        }else if (charPartA > charPartB){
            System.out.println("A is bigger");
        }else
            System.out.println("B is bigger");
    }
}
