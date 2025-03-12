package javaBasicFeatures;

public class InterfaceAndAbstractExample {

    public static void main(String[] args) {
        /*
        * 1) Abstract class have constructor and mutable member variable
        * 2) Whereas interface don't have constructor and only support final and immuatable(or constant) member variable
        * 3) Also by using interface we can implement multiple interfaces but only one abstract class
        * 4) If we want mutable member variable than we can go with abstract class or else always go
        *  with interface from java8 onward.
        * */
        abstractClassTest();
        interfaceTest();
    }

    private static void abstractClassTest() {
        Bank bank = new Bank("Axis") {
            @Override
            public void abstractMethod() {
                System.out.println("I'm an abstract method");
            }
        };

        // It will give type compile time error
/*        HdfcBank bank12 = new Bank("Test"){
            @Override
            public void abstractMethod() {
                System.out.println("I'm an abstract method");
            }
        };*/

        bank.concreteMethod();
        bank.abstractMethod();

        Bank hdfc = new HdfcBank();
        hdfc.concreteMethod();
        hdfc.abstractMethod();
        //hdfc.hdfcMethod() // child class method not present for parent ref

        Bank sbi = new SbiBank("Sbi");
        sbi.concreteMethod();
        sbi.abstractMethod();

        System.out.println(bank.getBankName());
        System.out.println(hdfc.getBankName());
        System.out.println(sbi.getBankName());

        HdfcBank hdfc1 = new HdfcBank();
        hdfc1.hdfcMethod(); // this method is not visible to base class refrence
    }

    private static void interfaceTest() {
        Vehicle bus = new Bus();
        Vehicle car = new Car();

        bus.abstractMethod();
        bus.defaultMethod();

        car.abstractMethod();
        car.defaultMethod();

        Vehicle.staticMethod(bus);
        Vehicle.staticMethod(car);

        Bus bus1 = new Bus();
        bus1.busMethod(); // this method is not visible to base refrence
    }

}

abstract class Bank {
    private String bankName;

    public Bank() {}

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void concreteMethod() {
        System.out.println("Concrete method in abstract class : " + this.bankName);
    }

    public abstract void abstractMethod();

    public String getBankName() {
        return bankName;
    }
}

class HdfcBank extends Bank {

    @Override
    public void abstractMethod() {
        System.out.println("Hdfc bank abstract" + super.getBankName());
    }

    public void hdfcMethod() {
        System.out.println("hdfc own method");
    }
}

class SbiBank extends Bank {

    public SbiBank(String bankName) {
        super(bankName);
    }

    @Override
    public void abstractMethod() {
        System.out.println("Hdfc bank abstract");
    }

    public void sbiMethod() {
        System.out.println("Sbi own method");
    }
}

interface Vehicle {
    long vehicleNumber = 1124;// we can use constant only

    default void defaultMethod() {
        System.out.println("Default method in interface : " + this.vehicleNumber);
    }

    void abstractMethod();

    static void staticMethod(Vehicle vehicle) {
        System.out.println("Static method in interface: " + vehicle);
    }
}

class Bus implements Vehicle {

    @Override
    public void abstractMethod() {
        System.out.println("Bus abstract");
    }

    public void busMethod() {
        System.out.println("Bus own method");
    }
}

class Car implements Vehicle {

    @Override
    public void abstractMethod() {
        System.out.println("Car abstract");
    }

    public void carMethod() {
        System.out.println("Car own method");
    }
}


