import java.util.HashMap;
import java.util.Map;

public class GameState {
    private static volatile GameState instance;
    private final Map<String, Player> players;
    private Room currentRoom;
    private Chapter currentChapter;
    private boolean gameRunning;

    // Private constructor to prevent instantiation
    private GameState() {
        players = new HashMap<>();
        currentRoom = null; // Initialize to null or set to a starting room
        gameRunning = true;
    }

    public void restoreFrom(GameState other) {
        if (other == null) {
            return;
        }
        this.players.clear();
        this.players.putAll(other.players);
        this.currentRoom = other.currentRoom;
        this.currentChapter = other.currentChapter;
        this.gameRunning = other.gameRunning;
    }

    // Thread-safe getInstace with double-check locking
    public static GameState getInstance() {
        if (instance == null) {
            synchronized (GameState.class) {
                if (instance == null) {
                    instance = new GameState();
                }
            }
        }
        return instance;
    }

    // Player management
    public void addPlayer(String name, Player player) {
        players.put(name, player);
    }

    public Player getPlayer(String name) {
        return players.get(name);
    }

    public void updatePlayerStats(String playerName, int healthChange, int staminaChange) {
        Player player = players.get(playerName);
        if (player != null) {
            player.setHealth(player.getHealth() + healthChange);
            player.setStamina(player.getStamina() + staminaChange);
            notifyPlayerStatusChange(player);
        }
    }

    private void notifyPlayerStatusChange(Player player) {
        // Notify player of their updated status
        player.displayStatus();
    }

    // Getters and setters
    public Room getCurrentRoom() { return currentRoom; }
    public void setCurrentRoom(Room room) { this.currentRoom = room; }
    public Chapter getCurrentChapter() { return currentChapter; }
    public void setCurrentChapter(Chapter chapter) { this.currentChapter = chapter; }
    public boolean isGameRunning() { return gameRunning; }
    public void endGame() { gameRunning = false; }

}

