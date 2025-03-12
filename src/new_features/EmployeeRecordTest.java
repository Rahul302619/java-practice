package new_features;

record EmployeeRecord(
        Long id,
        String name,
        Address address,
        Education education
) {
    void displayEmp() {
        System.out.println(this);
    }
}

record Address(String add){}

class Education {
    private String edu;

    public Education(){}

    public Education(String edu) {
        this.edu = edu;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    @Override
    public String toString() {
        return "Education{" +
                "edu='" + edu + '\'' +
                '}';
    }
}

public class EmployeeRecordTest {

    public static void main(String[] args) {
        var address = new Address("Jamshedpur");
        var education = new Education("B-tech");
        var empRecord = new EmployeeRecord(10L, "Rahul Singh", address, education);
        empRecord.displayEmp();
        var add2 = empRecord.address();
        var edu2 = empRecord.education();
        edu2.setEdu("Bachelor");
        System.out.println(empRecord);
        System.out.println(empRecord.id() + "----" + empRecord.name());
    }
}


