import java.util.*;

public class TelephoneDirectory {
    private HashMap<String, Set<String>> telephoneBook;

    public TelephoneDirectory() {
        this.telephoneBook = new HashMap<>();
    }

    public void add(String nameAndPhone) {
        if (nameAndPhone.isEmpty()) {
            System.out.println("Введите фамилию и телефон контакта!");
            return;
        }

        String[] splitter = nameAndPhone.trim().split(":");

        Set<String> phones = new HashSet<>();
        try {

            if (!splitter[0].trim().matches("[-A-Za-zА-Яа-я]{2,256}")) {
                System.out.println("Введено не корректное имя.");
                return;
            } else if (!splitter[1].trim().
                    matches("^\\+?(\\d{1,3})?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$")) {
                //регулярку нагуглил
                System.out.println("Введен не корректный номер телефона.");
                return;
            } else if (!telephoneBook.containsKey(splitter[0].trim())) {
                phones.add(splitter[1].trim());
                telephoneBook.put(splitter[0].trim(), phones);
            } else {
                telephoneBook.get(splitter[0].trim()).add(splitter[1].trim());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не верный формат имени или телефона!");
        }
    }

    public String get(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ": ");
        telephoneBook.get(name).forEach(phone -> sb.append(phone + " | "));
        return sb.toString();
    }

    public String getList() {
        StringBuilder sb = new StringBuilder();
        telephoneBook.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).
                forEach(e -> sb.append(this.get(e.getKey())).append("\n"));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelephoneDirectory)) return false;
        TelephoneDirectory that = (TelephoneDirectory) o;
        return Objects.equals(telephoneBook, that.telephoneBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephoneBook);
    }
}
