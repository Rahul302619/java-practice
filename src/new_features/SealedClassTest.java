package new_features;

public class SealedClassTest {

    static String textBlock = """
            My Name is Rahul Singh
            I have total 7 years of experience as software developer
            """;

    public static void main(String[] args) {
        /*
        * For implementing sealed classes child must be record or final class
        * so that other classes can't override the child class behaviour
         */
        System.out.println(textBlock);

        Bank sbi = new Sbi(10);
        Bank hdfc = new Hdfc("Personal Loan");

        sbi.provideLoan();
        sbi.defaultMethodForCommonFunction();
        Bank.staticMethodForUtilityFunction(sbi);

        hdfc.provideLoan();
        hdfc.defaultMethodForCommonFunction();
        Bank.staticMethodForUtilityFunction(hdfc);
    }
}

sealed interface Bank permits Sbi, Hdfc, Axis {

    void provideLoan();

    default void defaultMethodForCommonFunction() {
        System.out.println("Default method use for common functionality");
    }

    static void staticMethodForUtilityFunction(Bank bank) {
        System.out.println("Static method use for utility functionality : " + bank);
    }
}

record Sbi(double intrestRate) implements Bank {

    @Override
    public void provideLoan() {
        System.out.println("Loan provided by SBI at intrest rate : " + intrestRate);
    }
}

record Hdfc(String loanName) implements Bank {

    @Override
    public void provideLoan() {
        System.out.println("Type of loan provided by HDFC : " + loanName);
    }
}

final class Axis implements Bank {

    @Override
    public void provideLoan() {
        System.out.println("Axis");
    }
}

sealed class Animal permits Dog, Cat {}
final class Dog extends Animal {}
final class Cat extends Animal {}