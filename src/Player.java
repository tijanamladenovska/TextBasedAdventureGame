import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int health;
    private int stamina;
    private final List<Item> inventory;
    private final List<Player> nearbyPlayers;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.stamina = 100;
        this.inventory = new ArrayList<>();
        this.nearbyPlayers = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + " picked up " + item.getName());
    }

    public void useItem(String itemName) {
        Item item = inventory.stream()
            .filter(i -> i.getName().equalsIgnoreCase(itemName))
            .findFirst()
            .orElse(null);
        
        if (item != null) {
            item.use(this); // Use the item, affecting player stats
            inventory.remove(item); // Remove the item from inventory after use
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void sendMessage(String message) {
        for (Player nearbyPlayer : nearbyPlayers) {
            nearbyPlayer.receiveMessage(this, message);
        }
    }

    public void receiveMessage(Player sender, String message) {
        System.out.println(sender.getName() + " whispers: " + message);
    }

    public void tradeItem(Player otherPlayer, String itemName) {
        Item item = inventory.stream()
            .filter(i -> i.getName().equalsIgnoreCase(itemName))
            .findFirst()
            .orElse(null);
        
        if (item != null) {
            inventory.remove(item);
            otherPlayer.addItem(item);
            System.out.println(name + " traded " + item.getName() + " with " + otherPlayer.getName());
        } else {
            System.out.println("Item not found in inventory for trade.");
        }
    }

    public void displayInventory() {
        System.out.println(name + "'s Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            inventory.forEach(item -> System.out.println("- " + item.getName() + ": " + item.getDescription()));
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = Math.max(0, Math.min(100, health)); }
    public int getStamina() { return stamina; }
    public void setStamina(int stamina) { this.stamina = Math.max(0, Math.min(100, stamina)); }
    public List<Item> getInventory() { return inventory; }
    public List<Player> getNearbyPlayers() { return nearbyPlayers; }
    public void addNearbyPlayer(Player player) { nearbyPlayers.add(player); }

    public void displayStatus() {
        System.out.println("Player Status for " + name + ":");
        System.out.println("Health: " + health);
        System.out.println("Stamina: " + stamina);
        System.out.println("Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("  Inventory is empty.");
        } else {
            for (Item item : inventory) {
                System.out.println("  - " + item.getName() + ": " + item.getDescription());
            }
        }
    }
}
