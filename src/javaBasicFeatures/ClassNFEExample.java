package javaBasicFeatures;

public class ClassNFEExample {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
         * NoClassDefFoundError is related to issues with initializing of a class at runtime(suppose the .class is present but while initialization of the class some error occurred).
         * ClassNotFoundException is related to issues with dynamically loading a class at runtime that cannot be found in the classpath.
         *
         * NoClassDefFoundError -> it is an error, It occur in linking phase of class loader
         * ClassNotFoundException -> it is an exception, It occur while .class file loading phase of class loader
         * */

        //testCNFE();
        testNCDFE();

    }

    private static void testCNFE() throws ClassNotFoundException {
        /*
        * Class.forName look for .class file of the specified name, if it is unable to find
        * then it will throw ClassNotFoundException.
        * This exception occur at runtime when the class being loaded is missing or not available in classpath
        * */
        Class nfeExample = Class.forName("javaBasicFeatures.NFEExample");
        System.out.println(nfeExample);

        Class test = Class.forName("javaBasicFeatures.Test");
        System.out.println(test);
    }

    private static void testNCDFE() throws ClassNotFoundException {
        Class ncdfeExample = Class.forName("javaBasicFeatures.NCDFEExample");
        System.out.println(ncdfeExample);
    }
}

class NFEExample {}

class NCDFEExample {

    private static Class test;

    static {
        try {
            test = Class.forName("javaBasicFeatures.Test");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
