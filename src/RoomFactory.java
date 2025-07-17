// Update RoomFactory to implement the interface
public class RoomFactory implements RoomFactoryInterface {
    @Override
    public static Room createRoom(String type, String description) {
        return switch (type.toLowerCase()) {
            case "marketplace" -> new MarketplaceRoom(description);
            case "tech" -> new TechRoom(description);
            case "puzzle" -> new PuzzleRoom(description);
            default -> new StandardRoom(description);
        };
    }
}

class MarketplaceRoom extends Room {
    public MarketplaceRoom(String description) {
        super("Marketplace", description);
        addNPC("Vendor");
        addPuzzle(new BargainPuzzle());
    }
}

class TechRoom extends Room {
    public TechRoom(String description) {
        super("Tech Alley", description);
        addNPC("Engineer");
    }
}
