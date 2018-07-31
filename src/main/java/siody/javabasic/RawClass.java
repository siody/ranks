package siody.javabasic;

public class RawClass {
    static Integer value=322;
    static {
        System.out.println("raw class static "+value);
    }
    {
        System.out.println("raw class package");
    }
    RawClass() {
        System.out.println("raw class init");
    }
}
