import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //first task
        String str = "ехал грека через реку видит грека в реке рак сунул грека руку в реку рак за руку греку цап";
        String[] arr = str.split(" ");
        List<String> arrList = Arrays.asList(arr);

        Map<String, Integer> listMap = new HashMap<>();
        for (String s : arrList) {
            if (listMap.containsKey(s)) {
                listMap.put(s, listMap.get(s) + 1);
            } else {
                listMap.put(s, 1);
            }
        }

        listMap.entrySet().
                forEach(entry ->
                        System.out.println("Word: " + entry.getKey() +
                                " | Repetition count: " + entry.getValue()));
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < arrList.size(); i++) {
            if (!arrList.subList(0, i).contains(arrList.get(i))) {
                System.out.printf("Word \"%s\" has repeated %d times.\n", arrList.get(i),
                        Collections.frequency(arrList, arrList.get(i)));
            }
        }
        System.out.println("--------------------------------------------------------------");

        //second task

        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Ivanov: +375298889998");
        td.add("Ivanov: +375296888999");
        td.add("Petrov: +375298989898");
        td.add("Petrov: +375299898989");
        td.add("Petrov: +375299898989");
        td.add("Sidorov: +375299090909");
        td.add("Sidorov: +375290009999");
        td.add("Ivanov-Иванов: +375296888990");

        td.add("");
        td.add("Sidorov: ");
        td.add(" +375290009999");
        td.add("q: 11");
        td.add("qwe: 123");
        td.add("123: qwqe");
        td.add("qwe: qwe");

        System.out.println(td.get("Ivanov"));
        System.out.println(td.get("Petrov"));
        System.out.println(td.get("Sidorov"));
        System.out.println(td.get("Ivanov-Иванов"));

        System.out.println();
        System.out.println(td.getList());

        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите \"ADD\" для добавления, \"LIST\" для просмотра списка");
        while (true) {
            String in = sc.nextLine();
            if (in.equals("EXIT")) {
                break;
            }
            UserInput userInput = UserInput.parseInput(in);
            if (userInput.getCmd().toUpperCase().equals("ADD") || userInput.getCmd().toUpperCase().equals("LIST")) {
                switch (userInput.getCmd().toUpperCase()) {
                    case "ADD":
                        td.add(userInput.getInput());
                        break;
                    case "LIST":
                        System.out.println(td.getList());
                }
            } else {
                System.out.println("Нет такой команды. Введите \"ADD\" для добавления, \"LIST\" для просмотра списка");
            }
        }
    }
}
