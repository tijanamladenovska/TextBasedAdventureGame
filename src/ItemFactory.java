public class ItemFactory {
    public static Item createItem(String type) {
        return switch (type.toLowerCase()) {
            case "ration" -> new Item("Stabilized Ration Bar", "Restores 20 health", 20, 0);
            case "hydrate" -> new Item("SynthHydrate Pouch", "Restores 25 stamina", 0, 25);
            case "gauntlet" -> new Item("Nano-Embedded Gauntlet", "Boosts spell effectiveness by 20%", 0, 0);
            case "injector" -> new Item("Illegal Bio-Injector", "Restores all health but causes hallucinations", 100, 0);
            case "controller" -> new Item("Game Controller", "A high-tech game controller", 0, 0);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }
}
