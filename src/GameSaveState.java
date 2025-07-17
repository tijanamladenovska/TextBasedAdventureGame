import java.io.Serializable;
import java.util.List;

public class GameSaveState implements Serializable {
    private final int chapterNumber;
    private final int playerHealth;
    private final List<String> inventory;

    public GameSaveState(int chapterNumber, int playerHealth, List<String> inventory) {
        this.chapterNumber = chapterNumber;
        this.playerHealth = playerHealth;
        this.inventory = inventory;
    }

    public int getChapterNumber() { return chapterNumber; }
    public int getPlayerHealth() { return playerHealth; }
    public List<String> getInventory() { return inventory; }
}