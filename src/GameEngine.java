// GameEngine.java
import java.util.Scanner;

class GameEngine implements ChapterObserver {
    private final Scanner scanner;
    
    public GameEngine(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void startGame() {
        System.out.println("=== Multi-Player Text Adventure Game ===");

        Player player = new Player("Player");
        GameState.getInstance().addPlayer("Player", player);

        initializeGameWorld();
        
        // Start with Chapter 1
        Chapter1Room chapter1 = new Chapter1Room();
        chapter1.addObserver(this);
        GameState.getInstance().setCurrentChapter(chapter1);
        chapter1.start();
        
        // Main game loop
        while (GameState.getInstance().isGameRunning()) {
            // Process player input if needed
            if (GameState.getInstance().getCurrentChapter() == null) {
                GameState.getInstance().endGame();
            }
        }
        
        System.out.println("\nThank you for playing!");
    }
    
    private void initializeGameWorld() {
        Room startingRoom = new Room("Your Room", "Your familiar bedroom, now with a strange portal.");
        GameState.getInstance().setCurrentRoom(startingRoom);
        startingRoom.addItem(new Item("PS5 Controller", "A gaming controller, still warm from use.", 0, 0));
    }
    
    @Override
    public void update(String message) {
        System.out.println("\nSystem: " + message);
        
        if (message.contains("Chapter 1 completed")) {
            Chapter2Marketplace chapter2 = new Chapter2Marketplace();
            chapter2.addObserver(this);
            GameState.getInstance().setCurrentChapter(chapter2);
            chapter2.start();
        } else if (message.contains("Chapter 2 completed")) {
            Chapter3Room chapter3 = new Chapter3Room();
            chapter3.addObserver(this);
            GameState.getInstance().setCurrentChapter(chapter3);
            chapter3.start();
        } else if (message.contains("Chapter 3 completed")) {
            Chapter4Room chapter4 = new Chapter4Room();
            chapter4.addObserver(this);
            GameState.getInstance().setCurrentChapter(chapter4);
            chapter4.start();
        } else if (message.contains("Chapter 4 completed")) {
            System.out.println("\nCongratulations! You've completed the game!");
            GameState.getInstance().endGame();
        }
    }
}