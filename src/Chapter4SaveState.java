import java.io.Serializable;
import java.util.List;

public class Chapter4SaveState implements Serializable {
    private final int relicsCollected;
    private final int playerHealth;
    private final List<String> inventory;

    public Chapter4SaveState(int relicsCollected, int playerHealth, List<String> inventory) {
        this.relicsCollected = relicsCollected;
        this.playerHealth = playerHealth;
        this.inventory = inventory;
    }

    // Getters
    public int getRelicsCollected() { return relicsCollected; }
    public int getPlayerHealth() { return playerHealth; }
    public List<String> getInventory() { return inventory; }
}