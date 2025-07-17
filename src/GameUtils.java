import java.io.IOException;
import java.util.Scanner;

class GameUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (IOException | InterruptedException e) {
            // Handle exception
        }
    }
    
    private static final java.util.concurrent.ScheduledExecutorService scheduler = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();

    public static void typewriterEffect(String text) {
        final char[] chars = text.toCharArray();
        final int length = chars.length;
        final int[] index = {0};

        Runnable task = () -> {
            if (index[0] < length) {
                System.out.print(chars[index[0]]);
                index[0]++;
            } else {
                System.out.println();
                scheduler.shutdown();
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 20, java.util.concurrent.TimeUnit.MILLISECONDS);
    }
    
    public static int getValidInput(int min, int max) {
        int choice = 0;
        while (choice < min || choice > max) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return choice;
    }
}
