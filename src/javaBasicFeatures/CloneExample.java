package javaBasicFeatures;

public class CloneExample {

    public static void main(String[] args) {
        sallowCloneExample();
        deepCloneExample();

        /*
        * Clone method is present inside Object class but still without overriding that method
        *  you can not call that it will give compile time error because it is protected native
        * Signature -> protected native Object clone() throws CloneNotSupportedException;
        *
        * The way we can create clone object
        * 1) By implementing Cloneable which will create shallow copy(Since it create shallow copy so
        *  if we not implement cloneable to the child class than also it will work fine
        *   because it will not try to clone child class by default)
        * 2) By Serialization and deserialization
        * 3) By using copy constructor
        *
        * */
    }

    private static void sallowCloneExample() {
        Person person = new Person(1, "Rahul");
        var person1 = person.clone();

        person1.setName("Rohan");

        System.out.println(person);
        System.out.println(person1);
    }

    private static void deepCloneExample() {
        Address address = new Address("Jamshedpur");
        Student student = new Student("Rahul", address);
        Student student1 = student.clone();

        student1.setName("Rohan");
        /*
        * For deep cloning address class also need to implement Cloneable or
        *  while cloning Student need to create copy of address.
        * */
        address.setAddress("Jharkhand");

        System.out.println(student);
        System.out.println(student1);
    }
}

/*
* Have to implement Cloneable to use clone method because clone method is protected inside object class
* */
class Person implements Cloneable {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Person clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Student implements Cloneable{
    private String name;
    private Address address;

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            /*
            * For deep clone use below -
            * clone.setAddress(new Address(clone.getAddress().getAddress()));
            * or implement Cloneable to address as well and call address.clone()
            * */

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}

