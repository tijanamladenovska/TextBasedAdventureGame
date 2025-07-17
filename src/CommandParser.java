public class CommandParser {
    public static void parse(String input, Player player) {
        String[] parts = input.trim().split(" ");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "go" -> handleMovement(parts, player);
            case "take" -> handleItemPickup(parts, player);
            case "use" -> handleItemUse(parts, player);
case "status" -> player.displayInventory();
            case "whisper" -> handleWhisper(parts, input.substring(input.indexOf(' ', 6)), player);
            case "inventory" -> player.displayInventory();
            case "examine" -> handleExamine(parts, player);
            case "talk" -> handleTalk(parts, player);
            case "quit" -> GameState.getInstance().endGame();
            default -> System.out.println("Unknown command. Try: go, take, use, status, whisper, inventory, examine, talk, quit");
        }
    }

    private static void handleMovement(String[] parts, Player player) {
        if (parts.length < 2) {
            System.out.println("Please specify a direction to go.");
            return;
        }
        String direction = parts[1];
        Room nextRoom = GameState.getInstance().getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            GameState.getInstance().setCurrentRoom(nextRoom);
            System.out.println(player.getName() + " moves " + direction + " to " + nextRoom.getName());
            nextRoom.display(); // Display the new room description
        } else {
            System.out.println("You can't go that way.");
        }
    }

    private static void handleItemPickup(String[] parts, Player player) {
        if (parts.length < 2) {
            System.out.println("Please specify an item to take.");
            return;
        }
        String itemName = parts[1];
        Item item = GameState.getInstance().getCurrentRoom().removeItem(itemName);
        if (item != null) {
            player.addItem(item);
        } else {
            System.out.println("Item not found in this room.");
        }
    }

    private static void handleItemUse(String[] parts, Player player) {
        if (parts.length < 2) {
            System.out.println("Please specify an item to use.");
            return;
        }
        String itemName = parts[1];
        player.useItem(itemName);
    }

    private static void handleExamine(String[] parts, Player player) {
        if (parts.length < 2) {
            System.out.println("Please specify an item to examine.");
            return;
        }
        String itemName = parts[1];
        Item item = player.getInventory().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
        if (item != null) {
            System.out.println("Examining " + item.getName() + ": " + item.getDescription());
        } else {
            System.out.println("You don't have that item.");
        }
    }

    private static void handleTalk(String[] parts, Player player) {
        if (parts.length < 2) {
            System.out.println("Please specify an NPC to talk to.");
            return;
        }
        String npcName = parts[1];
        // Implement NPC interaction logic here
        System.out.println(player.getName() + " talks to " + npcName + ".");
    }

    private static void handleWhisper(String[] parts, String message, Player player) {
        if (parts.length < 2) {
            System.out.println("Please specify a player to whisper to.");
            return;
        }
        String targetPlayerName = parts[1];
        Player targetPlayer = GameState.getInstance().getPlayer(targetPlayerName);
if (targetPlayer != null) {
    targetPlayer.receiveMessage(player, message);
    System.out.println("You whisper to " + targetPlayerName + ": " + message);
} else {
            System.out.println("Player " + targetPlayerName + " not found.");
        }
    }
}
