package siody.javabasic;

public class SubClass1 extends RawClass {
    static {
        System.out.println("subclass1 class static "+value);
    }
    {
        System.out.println("subclass1 class package");
    }
    SubClass1() {
        System.out.println("subclass1 class init");
    }

    public static void main(String[] args) {
//        new SubClass1();
        System.out.println(SubClass1.value);
    }
}
