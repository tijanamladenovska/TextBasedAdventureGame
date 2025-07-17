Implementation Highlights:
Multi-Player Text Adventure Game that provides players with a dynamic world filled with exploration, puzzles, and character interactions. The game is designed to support multiple players who should be able to collaborate or compete as they navigate through various interconnected rooms.

Key features of the implementation include:
Structured Game World that consists of multiple rooms, each with unique descriptions, items, and puzzles, allowing for rich exploration.
Player Interaction allowing players to perform actions such as exploring rooms, picking up items, and interacting with NPCs through a command-line interface.
Game Logic implemented via rules for player interactions, item management, and progression, with clear objectives tracked through a win condition system.
Networking Support that allows players to connect to a shared game session, enabling real-time interactions and collaboration.
Design Patterns implementated further allowing utilization of key software design patterns, including Singleton, Observer, and Factory patterns, which help enhance modularity and maintainability.

Introduction:
You’re just ordinary twins in a quiet 2025 suburban apartment until you fall through a portal into a future where time has collapsed. Ancient myths, future tech, and forgotten eras that coexist in one chaotic world.
To get home, you must navigate twisted timelines, solve puzzles, and survive battles across centuries. But the deeper you go, the more you realize... this wasn’t an accident.
Can you fix time’s fracture or will you be lost in the ripple forever?

Requirements:
Game World:
A structured game world with multiple interconnected rooms is created using the GameWorld and Room classes.
Each room includes descriptions, items and puzzles, making a rich game environment.
Player System:
The game supports multiple players through the Player class and manages player data using the GameState class.
Players can perform actions such as exploring rooms, picking up items, and interacting with NPCs via a command-line interface.
Game Logic:
The game implements rules for player interactions, item management, and puzzle-solving through various methods in the Chapter classes.
A clear win condition is established through the WinCondition class, which tracks objectives for each chapter.
Networking (Optional):
The GameServer and GameClient classes allow players to connect to a shared game session over a network, enabling multi-player functionality.
-- attempted, not sure if it works

Software Patterns:
The Singleton pattern used in the GameState class to ensure consistent access to the global game state.
The Observer pattern implemented in the Chapter class to notify players of changes in the game state, such as chapter completion.
The Factory pattern utilized in the RoomFactory and ItemFactory classes to create game objects based on predefined templates.

Additional Requirements:
A command-line interface is implemented for player interaction, allowing players to input commands and receive feedback.
Unit tests for game logic and core features are yet to be implemented.
Documentation is provided in this README to guide users on how to run and play the game.

Design:
classDiagram
class BargainPuzzle {
+String getDescription()
+boolean solve()
+boolean isSolved()
}

class Chapter {
    +boolean isChapterComplete()
    +void displayObjectives()
    +void addObserver(ChapterObserver observer)
    +void removeObserver(ChapterObserver observer)
    +void notifyObservers(String message)
    +void start()
    <<abstract>>
}

class Chapter1Room {
    +void start()
    +void presentOptions()
    +void handleChoice(int choice)
    +void continueStory()
    +void presentSecondOptions()
    +void handleSecondChoice(int choice)
    +void introduceTwins()
    +void handleIntroductionChoice(int choice)
    +void askForHelp()
    +void handleHelpChoice(int choice)
    +void claraResponds()
    +void handleFinalChoice(int choice)
}

class Chapter2Marketplace {
    +void start()
    +void presentMarketplaceOptions()
    +String getLocationName(int locationId)
    +int getValidChoice(Scanner scanner, int min, int max)
    +void handleMarketplaceChoice(int choice, int totalOptions)
    +void showInitialMessages()
    +void mainSquare()
    +void selectRareMagicItem()
    +void techAlley()
    +void foodCourt()
    +void blackMarket()
    +void observationDeck()
    +void continueToChapter3()
}

class Chapter3Room {
    +void start()
    +void uncleJarretPuzzle(Scanner scanner)
    +void auntTrivyaPuzzle(Scanner scanner)
    +void fatherPuzzle(Scanner scanner)
    +void displayGarden(String[] reference, String[] working)
    +void displayGardenWithErrors(String[] reference, String[] working)
    +void giveHint(String[] working, String[] solution)
    +void shuffleArray(String[] array)
    +int getValidInput(Scanner scanner, int min, int max)
    +int getValidPosition(Scanner scanner)
}

class Chapter4Room {
    +void start()
    +void collectRelics()
    +boolean solvePuzzle(String question, String answer)
    +void finalConfrontation()
    +void finalChoice()
    +void handleFinalChoice(int choice)
}

class CommandParser {
    +void parse(String input, Player player)
    +void handleMovement(String[] parts, Player player)
    +void handleItemPickup(String[] parts, Player player)
    +void handleItemUse(String[] parts, Player player)
    +void handleExamine(String[] parts, Player player)
    +void handleTalk(String[] parts, Player player)
    +void handleWhisper(String[] parts, String message, Player player)
}

class GameEngine {
    +void startGame()
    +void initializeGameWorld()
    +void update(String message)
}

class GameState {
    +void restoreFrom(GameState other)
    +void addPlayer(String name, Player player)
    +Player getPlayer(String name)
    +void updatePlayerStats(String playerName, int healthChange, int staminaChange)
    +Room getCurrentRoom()
    +void setCurrentRoom(Room room)
    +Chapter getCurrentChapter()
    +void setCurrentChapter(Chapter chapter)
    +boolean isGameRunning()
    +void endGame()
}

class Item {
    +String getName()
    +String getDescription()
    +int getHealthEffect()
    +int getStaminaEffect()
    +void use(Player player)
}

class ItemFactory {
    +Item createItem(String type)
}

class Player {
    +void addItem(Item item)
    +void useItem(String itemName)
    +void sendMessage(String message)
    +void receiveMessage(Player sender, String message)
    +void tradeItem(Player otherPlayer, String itemName)
    +void displayInventory()
    +String getName()
    +int getHealth()
    +void setHealth(int health)
    +int getStamina()
    +void setStamina(int stamina)
    +List<Item> getInventory()
    +List<Player> getNearbyPlayers()
    +void addNearbyPlayer(Player player)
    +void displayStatus()
}

class Room {
    +void addPuzzle(Puzzle puzzle)
    +boolean solvePuzzle(int puzzleIndex)
    +List<Puzzle> getPuzzles()
    +boolean hasUnsolvedPuzzles()
    +void display()
    +String getName()
    +String getDescription()
    +void setExit(String direction, Room room)
    +Room getExit(String direction)
    +void addItem(Item item)
    +Item removeItem(String itemName)
    +void addNPC(String npc)
}

class SaveManager {
    +void saveGame(String filename)
    +void loadGame(String filename)
}

class WinCondition {
    +void addObjective(Objective objective)
    +boolean isMet()
    +void displayProgress()
}

Assumptions:
The game is structured in chapters taht represent different parts of the story.
Players progress through these chapters in by solving puzzles in order to complete teh game.
Transitions between chapters are managed through observer notifications.
Players choices can affect the narrative and gameplay by selecting options during dialogues and interactions.
Players will engage with the environment by examining items, talking to NPCs, and solving puzzles.
Puzzles are designed to challenge players' problem-solving skills, with varying levels of difficulty.
Players will understand the mechanics of each puzzle and how to interact with them.
Players can collect and use items that affect their health and stamina which is used throughout the game.
Players will manage their inventory effectively, using items strategically to progress.
Players will form connections with main characters in the game and note their fates.
Players will follow prompts and instructions provided in the text to navigate and make choices.
The game encourages replayability via multiple progression paths and assumes players will explore different choices to reach different endings.
