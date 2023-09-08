import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //First task
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванова Светлана Ивановна", "Инспектор по кадрам", "ivanova@mail.ru", 333445566, 80000, 27);
        employees[1] = new Employee("Кравцов Дмитрий Евгеньевич", "Системный администратор", "kravtsov@mail.ru", 666554433, 90000, 34);
        employees[2] = new Employee("Кравцова Екатерина Васильевна", "Бухгалтер", "kravtsova@mail.ru", 666554434, 80000, 29);
        employees[3] = new Employee("Романова Ангелина Аркадьевна", "Главный бухгалтер", "romanova@mail.ru", 111222333, 150000, 45);
        employees[4] = new Employee("Давыденко Михаил Петрович", "Директор", "bigboss@mail.ru", 777777777, 300000, 50);
        Arrays.stream(employees).
                sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge())).
                filter(e -> e.getAge() > 40).
                forEach(System.out::println);

        //Second task
        Park park = new Park("7:00", "23:00");
        Park.Attractions attraction = new Park("7:00", "23:00").new Attractions("Батут", "10:00", "20:00", 4);
        Park parkWithAttractions = new Park("7:00", "23:00",
                park.new Attractions("Центрифуга", "10:00", park.getEndWorking(), 5));

        Park.NestedAttractions nestedAttractions = new Park.NestedAttractions("Комната смеха", "10:00", "20:00", 5);

        System.out.println("Парк без атракционов - " + park);
        System.out.println("Атракцион в парке - " + attraction);
        System.out.println("Парк с атракционами - " + parkWithAttractions);
        System.out.println("Атракционы \"передвижные\" - " + nestedAttractions);
        park.anonymousAttractions.printInfo(park.anonymousAttractions);
        park.getAbstractAttractions().printInfo(park.getAbstractAttractions());

    }
}
