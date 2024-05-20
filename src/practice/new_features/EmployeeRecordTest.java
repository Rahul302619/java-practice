package practice.new_features;

record EmployeeRecord(
        Long id,
        String name
) {

    void displayEmp() {
        System.out.println(this);
    }
}

public class EmployeeRecordTest {

    public static void main(String[] args) {
        var empRecord = new EmployeeRecord(10L, "Rahul Singh");
        empRecord.displayEmp();
        System.out.println(empRecord.id() + "----" + empRecord.name());
    }
}


