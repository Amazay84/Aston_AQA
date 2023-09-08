import java.util.Arrays;

public class Employee {
    private String fullName;
    private String jobTitle;
    private String email;
    private int phoneNumber;
    private double salary;
    private int age;

    public Employee(String fullName, String jobTitle, String email, int phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return ("Employee: " +
                " ").concat("\nfull name: ".concat(fullName))
                .concat("\njobTitle: ".concat(jobTitle))
                .concat("\nemail: ".concat(email))
                .concat("\nphoneNumber: ".concat(String.valueOf(phoneNumber)))
                .concat("\nsalary: ".concat(String.valueOf(salary)))
                .concat("\nage: ".concat(age + "\n" +
                        "--------------------------------------"));
    }
}
