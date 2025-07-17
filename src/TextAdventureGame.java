// Main class to run the game
public class TextAdventureGame {
    public static void main(String[] args) {
        // Initialize game components
        GameWorld world = new GameWorld();
        GameState.getInstance().setCurrentRoom(world.getRoom("start"));
        
        // Show main menu
        MainMenu.show();
    }
}
