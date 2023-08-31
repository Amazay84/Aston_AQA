public class Employee {
    // TODO:
    //  1) класс с полями: ФИО, должность, email, телефон, зарплата, возраст.
    //  Конструктор класса должен заполнять эти поля при создании объекта.
    //  Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    //  2) Создать массив из 5 сотрудников.
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

    @Override
    public String toString() {
        return "Employee".concat("full name: ".concat(fullName))
                .concat("\njobTitle: ".concat(jobTitle))
                .concat("\nemail: ".concat(email))
                .concat("\nphoneNumber: ".concat(String.valueOf(phoneNumber)))
                .concat("\nsalary: ".concat(String.valueOf(salary)))
                .concat("\nage: ".concat(String.valueOf(age)));
    }
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванова Светлана Ивановна", "Инспектор по кадрам", "ivanova@mail.ru", 333445566, 80000, 27);
        employees[1] = new Employee("Кравцов Дмитрий Евгеньевич", "Системный администратор", "kravtsov@mail.ru", 666554433, 90000, 34);
        employees[2] = new Employee("Кравцова Екатерина Васильевна", "Бухгалтер", "kravtsova@mail.ru", 666554434, 80000, 29);
        employees[3] = new Employee("Романова Ангелина Аркадьевна", "Главный бухгалтер", "romanova@mail.ru", 111222333, 150000, 45);
        employees[4] = new Employee("Давыденко Михаил Петрович", "Директор", "bigboss@mail.ru", 777777777, 300000, 50);
    }
}
