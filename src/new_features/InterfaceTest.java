package new_features;

public class InterfaceTest {
    public static void main(String[] args) {
        A c = new C();
        c.add();
    }
}

interface A {
    default void add() {
        System.out.println("Interface A - add method");
    }
}

interface B {
    default void add() {
        System.out.println("Interface B - add method");
    }
}

class C implements A, B {

    //Compile time error if we will not override add method.
    @Override
    public void add() {
        A.super.add();
    }
}
