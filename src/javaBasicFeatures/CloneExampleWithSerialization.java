package javaBasicFeatures;

import java.io.*;
import java.util.Arrays;

public class CloneExampleWithSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        * 1) To use Serializable all the nested and parent class should implemented Serializable
        *    or else get NotSerializableException.
        * 2) Since it try to deserialize child class as well that's why child class also need to implement
        *    Serialize and because of this its create deep copy.
        * */
        cloneWithSerializable();
    }

    private static void cloneWithSerializable() throws IOException, ClassNotFoundException {
        Address1 address1 = new Address1("Jamshedpur");
        Student1 student = new Student1("Rahul", address1);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(student);
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Student1 student1 = (Student1) objectInputStream.readObject();

        System.out.println(student);
        System.out.println(student1);
    }
}

record Student1(String name, Address1 address) implements Serializable {}
record Address1(String address) implements Serializable {}
