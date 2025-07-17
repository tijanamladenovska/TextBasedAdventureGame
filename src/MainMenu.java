import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void show() {
        GameUtils.clearScreen();
        System.out.println("=== TEXT ADVENTURE GAME ===");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
        
        int choice = GameUtils.getValidInput(1, 3);
        
        switch (choice) {
            case 1 -> new GameEngine(scanner).startGame();
            case 2 -> {
                System.out.print("Enter save file name: ");
                String filename = scanner.nextLine();
                SaveManager.loadGame(filename);
            }
            case 3 -> System.exit(0);
        }
    }
}
