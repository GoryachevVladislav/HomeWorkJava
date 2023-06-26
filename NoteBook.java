import java.util.*;

public class NoteBook {
    private String brand;
    private int RAM;
    private int storage;
    private String operatingSystem;
    private String color;

    public NoteBook(String brand, int RAM, int storage, String operatingSystem, String color) {
        this.brand = brand;
        this.RAM = RAM;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Set<NoteBook> notebooks = new HashSet<>();
        notebooks.add(new NoteBook("Brand1", 8, 512, "Windows", "Black"));
        notebooks.add(new NoteBook("Brand2", 16, 256, "MacOS", "Silver"));
        notebooks.add(new NoteBook("Brand3", 8, 1024, "Windows", "White"));
        notebooks.add(new NoteBook("Brand4", 12, 512, "Linux", "Black"));
        notebooks.add(new NoteBook("Brand5", 16, 512, "Windows", "Silver"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");
        System.out.println("Введите цифру :");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int filterCriteria = scanner.nextInt();
        scanner.nextLine();

        Map<Integer, String> filterParams = new HashMap<>();
        filterParams.put(1, "ОЗУ");
        filterParams.put(2, "Объем ЖД");
        filterParams.put(3, "Операционная система");
        filterParams.put(4, "Цвет");

        System.out.println("Введите минимальное значение для выбранного критерия:");
        String filterValue = scanner.nextLine();

        Set<NoteBook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria, filterValue);
        System.out.println("\nПодходящие ноутбуки:");
        for (NoteBook notebook : filteredNotebooks) {
            System.out.println(notebook.getBrand());
        }

        scanner.close();
    }

    public static Set<NoteBook> filterNotebooks(Set<NoteBook> notebooks, int filterCriteria, String filterValue) {
        Set<NoteBook> filteredNotebooks = new HashSet<>();

        for (NoteBook notebook : notebooks) {
            boolean isMatching = false;

            switch (filterCriteria) {
                case 1:
                    int minRAM = Integer.parseInt(filterValue);
                    if (notebook.getRAM() >= minRAM) {
                        isMatching = true;
                    }
                    break;
                case 2:
                    int minStorage = Integer.parseInt(filterValue);
                    if (notebook.getStorage() >= minStorage) {
                        isMatching = true;
                    }
                    break;
                case 3:
                if (notebook.getOperatingSystem().equalsIgnoreCase(filterValue)) {
                    isMatching = true;
                }
                break;
            case 4:
                if (notebook.getColor().equalsIgnoreCase(filterValue)) {
                    isMatching = true;
                }
                break;
        }

        if (isMatching) {
            filteredNotebooks.add(notebook);
        }
    }

    return filteredNotebooks;
}
}

