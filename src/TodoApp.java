import java.io.*;
import java.util.*;

public class TodoApp {
    private static final String FILE_NAME = "tasks.txt";
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        loadTasks();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- TO-DO LİST ---");
            System.out.println("1. Görevleri Listele");
            System.out.println("2. Görev Ekle");
            System.out.println("3. Görev Sil");
            System.out.println("4. Görev Güncelle");
            System.out.println("5. Görevi Tamamlandı Olarak İşaretle");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Boşluğu temizle

            switch (choice) {
                case 1 -> listTasks();
                case 2 -> addTask(scanner);
                case 3 -> deleteTask(scanner);
                case 4 -> updateTask(scanner);
                case 5 -> markTaskAsDone(scanner);
                case 0 -> {
                    saveTasks();
                    System.out.println("Çıkılıyor...");
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        } while (choice != 0);

        scanner.close();
    }

    static class Task {
        String description;
        boolean isDone;

        Task(String description, boolean isDone) {
            this.description = description;
            this.isDone = isDone;
        }

        @Override
        public String toString() {
            return (isDone ? "[X] " : "[ ] ") + description;
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Görev girin: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc, false));
        saveTasks();
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Görev bulunamadı.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    private static void deleteTask(Scanner scanner) {
        listTasks();
        System.out.print("Silinecek görev numarası: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
        } else {
            System.out.println("Geçersiz görev numarası.");
        }
    }

    private static void updateTask(Scanner scanner) {
        listTasks();
        System.out.print("Güncellenecek görev numarası: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < tasks.size()) {
            System.out.print("Yeni görev açıklaması: ");
            String newDesc = scanner.nextLine();
            tasks.get(index).description = newDesc;
            saveTasks();
        } else {
            System.out.println("Geçersiz görev numarası.");
        }
    }

    private static void markTaskAsDone(Scanner scanner) {
        listTasks();
        System.out.print("Tamamlandı olarak işaretlenecek görev numarası: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isDone = true;
            saveTasks();
        } else {
            System.out.println("Geçersiz görev numarası.");
        }
    }

    private static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.isDone + ";" + task.description);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Dosyaya yazılamadı: " + e.getMessage());
        }
    }

    private static void loadTasks() {
        tasks.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);
                boolean isDone = Boolean.parseBoolean(parts[0]);
                String desc = parts[1];
                tasks.add(new Task(desc, isDone));
            }
        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + e.getMessage());
        }
    }
}
