import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TelephoneDirectory {
    private HashMap<String, Set<String>> telephoneBook;

    public TelephoneDirectory() {
        this.telephoneBook = new HashMap<>();
    }

    public void add(String nameAndPhone) {
        if (nameAndPhone.isEmpty()) {
            System.out.println("Не верный формат имени или телефона!");
            return;
        }
        String[] splitter = nameAndPhone.trim().split(":");
        Set<String> phones = new HashSet<>();
        try {
                if (!telephoneBook.containsKey(splitter[0].trim())) {
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
}
