import java.util.HashMap;
import java.util.Map;

public class GameWorld {
    private final Map<String, Room> rooms;
    private Room startingRoom;

    public GameWorld() {
        rooms = new HashMap<>();
        initializeWorld();
    }

    private void initializeWorld() {
        // Create rooms using factory methods
        startingRoom = RoomFactory.createRoom("starting", "Your familiar bedroom");
        Room marketplace = RoomFactory.createRoom("marketplace", "Chaotic bazaar");
        Room techAlley = RoomFactory.createRoom("tech", "Neon-lit alley");

        // Add items using factory
        startingRoom.addItem(ItemFactory.createItem("controller"));
        marketplace.addItem(ItemFactory.createItem("ration"));
        techAlley.addItem(ItemFactory.createItem("gauntlet"));

        // Connect rooms
        startingRoom.setExit("portal", marketplace);
        marketplace.setExit("tech", techAlley);
        techAlley.setExit("back", marketplace);

        // Store rooms
        rooms.put("start", startingRoom);
        rooms.put("market", marketplace);
        rooms.put("tech", techAlley);
    }

    public Room getStartingRoom() { return startingRoom; }
    public Room getRoom(String key) { return rooms.get(key); }
}
