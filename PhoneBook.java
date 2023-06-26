import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new TreeSet<>());
        }
        contacts.get(name).add(phoneNumber);
    }

    public void displayAllContacts() {
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(contacts.entrySet());
        sortedEntries.sort(new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> entry1, Map.Entry<String, Set<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Вывести всех");
            System.out.println("3. Выход");
            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.print("Введите имя контакта: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    System.out.println("Контакт успешно добавлен");
                    break;
                case 2:
                    System.out.println("\nВсе контакты:");
                    phoneBook.displayAllContacts();
                    break;
                case 3:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}
