import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final String name;
    private final String description;
    private final Map<String, Room> exits;
    private final List<Item> items;
    private final List<String> npcs;
    private final List<Puzzle> puzzles;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.puzzles = new ArrayList<>();
    }

    // Puzzle-specific methods
    public void addPuzzle(Puzzle puzzle) {
        puzzles.add(puzzle);
    }

    public boolean solvePuzzle(int puzzleIndex) {
        if (puzzleIndex >= 0 && puzzleIndex < puzzles.size()) {
            return puzzles.get(puzzleIndex).solve();
        }
        return false;
    }

    public List<Puzzle> getPuzzles() {
        return new ArrayList<>(puzzles); // Return a copy for encapsulation
    }

    public boolean hasUnsolvedPuzzles() {
        return puzzles.stream().anyMatch(puzzle -> !puzzle.isSolved());
    }

    // Room display and navigation
    public void display() {
        System.out.println("\n=== " + name + " ===");
        System.out.println(description);

        if (!items.isEmpty()) {
            System.out.println("\nItems here:");
            items.forEach(item -> System.out.println("- " + item.getName()));
        }

        if (!npcs.isEmpty()) {
            System.out.println("\nNPCs here:");
            npcs.forEach(npc -> System.out.println("- " + npc));
        }

        if (!puzzles.isEmpty()) {
            System.out.println("\nPuzzles available:");
            for (int i = 0; i < puzzles.size(); i++) {
                String status = puzzles.get(i).isSolved() ? "✓" : " ";
                System.out.println(i + ". [" + status + "] " + puzzles.get(i).getDescription());
            }
        }

        System.out.println("\nExits:");
        exits.keySet().forEach(direction -> 
            System.out.println("- " + direction + ": " + exits.get(direction).getName()));
    }

    // Standard room methods
    public String getName() { return name; }
    public String getDescription() { return description; }
    public void setExit(String direction, Room room) { exits.put(direction, room); }
    public Room getExit(String direction) { return exits.get(direction); }
    public void addItem(Item item) { items.add(item); }
    public Item removeItem(String itemName) {
        return items.stream()
            .filter(item -> item.getName().equalsIgnoreCase(itemName))
            .findFirst()
            .map(item -> {
                items.remove(item);
                return item;
            })
            .orElse(null);
    }
    public void addNPC(String npc) { npcs.add(npc); }
}