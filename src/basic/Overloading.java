package basic;

public class Overloading {

    public static void main(String[] args) {
        var add = new Add();
        System.out.println(add.add(10,20));
        System.out.println(add.add(10l,20));
    }
}

class Add {
    public long add(long a, int b) {
        return (a+b)*10;
    }

    public int add(int a, int b) {
        return a+b;
    }
}
