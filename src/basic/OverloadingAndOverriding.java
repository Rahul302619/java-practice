package basic;

public class OverloadingAndOverriding {

    public static void main(String[] args) {
        /*
        * Overloading-
        * Method signature must be different(method signature = method name + parameter type)
         */
        var add = new Add();
        System.out.println(add.add(10,20));
        System.out.println(add.add(10l,20));

        /*
         * Overriding-
         * 1)It's occur into parent child class
         * 2)If child is overriding the access modifier of child method
         * must be equal and greater than parent method.
         */
        var vehichle = new Bus();
        vehichle.engin("Normal");
        vehichle.defaultEngin("Normal");
        vehichle.protectedEngin("Normal");
        vehichle.normalEngin("Normal");
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

class Vehichle {
    public void engin(String name) {
        System.out.println("Engine Name: " + name);
    }

    protected void protectedEngin(String name) {
        System.out.println("Protected Engine Name: " + name);
    }

    void defaultEngin(String name) {
        System.out.println("Default Engine Name: " + name);
    }

    void normalEngin(String name) {
        System.out.println("Normal Engine Name: " + name);
    }
}

class Bus extends Vehichle {

    @Override
    public void engin(String name) {
        System.out.println("Bus Engine Name: " + name);
    }

    protected void protectedEngin(String name) {
        System.out.println("Protected Bus Engine Name: " + name);
    }

    public void defaultEngin(String name) {
        System.out.println("Default Bus Engine Name: " + name);
    }
}
