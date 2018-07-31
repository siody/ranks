package siody.javabasic;

public class SubClass2 extends SubClass1 {
    static {
        System.out.println("subclass2 class static "+value);
    }
    {
        System.out.println("subclass2 class package");
    }
    SubClass2() {
        System.out.println("subclass2 class init");
    }
    public static void main(String[] args) {
        System.out.println(SubClass2.value);
    }
}
