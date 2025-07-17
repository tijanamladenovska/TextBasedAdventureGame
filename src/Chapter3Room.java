import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Chapter3Room extends Chapter {

    private Chapter currentChapter;  // Declare currentChapter field

    @Override
    protected void setupObjectives() {
        // Objectives setup for Chapter 3
    }

    public Chapter3Room() {
        super("Chapter 3: The Family Trials");
    }

    @Override
    public void start() {
        System.out.println("\n=== " + title + " ===");
        System.out.println("Determined to find your way home, you and your twin follow Clara to your next adventure.");
        System.out.println("Your first enemy - Clara's uncle Jarret.");

        Scanner scanner = new Scanner(System.in);
        uncleJarretPuzzle(scanner);
        auntTrivyaPuzzle(scanner);
        fatherPuzzle(scanner);
        
        // Notify completion and progress to Chapter 4
        notifyObservers("Chapter 3 completed");
    }

    private void uncleJarretPuzzle(Scanner scanner) {
        System.out.println("\nBefore encountering Clara's uncle for the first time, she gives you a warning:");
        System.out.println("\"Uncle Jarret is the 'eccentric gardener' of the family. He never lets anyone through his domain unless they respect the rhythm of nature. He's weirdly into symmetrical planting.\"");
        
        // All 16 unique flower ASCII arts
        String[] allFlowers = {
            "(@)",  // Cherry Blossom
            "*O*",  // Daisy
            "~@~",  // Rose
            "<*>",  // Sunflower
            "{v}",  // Tulip
            "(*)",  // Wildflower
            "(@@)", // Double Bloom
            "%*%",  // Exotic Bloom
            "{*}",  // Poppy
            "(^)",  // Budding Flower
            ":o:",  // Morning Glory
            "[+]",  // Cactus Flower
            "(@~)", // Romantic Rose
            "=*=",  // Minimalist Flower
            "8#8",  // Fluffy Bloom
            "$*$"   // Magical Bloom
        };
        
        // Create mirrored solution with unique pairs (not identical mirroring)
        String[] solution = new String[16];
        for (int i = 0; i < 8; i++) {
            solution[i] = allFlowers[i*2];
            solution[15-i] = allFlowers[i*2+1];
        }
        
        // Create working garden with all flowers shuffled
        String[] workingGarden = allFlowers.clone();
        shuffleArray(workingGarden);
        
        int stamina = 100;
        boolean puzzleSolved = false;
        
        System.out.println("\nThe monorail stops. The doors open with a hiss, and you step into... a greenhouse?");
        System.out.println("Lush greenery sprawls in meticulously perfect patterns. Vines hang in symmetrical arcs. Topiary animals blink at you.");
        System.out.println("\nSuddenly, a man with a moss-covered beard appears, holding a rake that's also a tuning fork.");
        System.out.println("\"Only those who can balance chaos with order may pass. Rearrange my garden in harmonious pairs or face the thorns.\"");
        
        while (!puzzleSolved && stamina > 0) {
            System.out.println("\n=== Your Stamina: " + stamina + " ===");
            displayGarden(solution, workingGarden);
            
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Swap two plants");
            System.out.println("2. Check harmony");
            System.out.println("3. Ask for hint (-15 stamina)");
            
            int choice = getValidInput(scanner, 1, 3);
            
            switch (choice) {
                case 1: {
                    System.out.println("\nEnter positions to swap (0-15):");
                    int pos1 = getValidPosition(scanner);
                    int pos2 = getValidPosition(scanner);
                    
                    // Swap plants
                    String temp = workingGarden[pos1];
                    workingGarden[pos1] = workingGarden[pos2];
                    workingGarden[pos2] = temp;
                    stamina -= 5;
                    System.out.println("Plants swapped! (-5 stamina)");
                    break;
                }
                case 2: {
                    if (Arrays.equals(workingGarden, solution)) {
                        puzzleSolved = true;
                    } else {
                        System.out.println("\n\"Not harmonious yet!\" Jarret frowns.");
                        stamina -= 10;
                        System.out.println("The plants seem disappointed (-10 stamina)");
                        displayGardenWithErrors(solution, workingGarden);
                    }
                    break;
                }
                case 3: {
                    if (stamina >= 15) {
                        giveHint(workingGarden, solution);
                        stamina -= 15;
                    } else {
                        System.out.println("Not enough stamina for a hint!");
                    }
                    break;
                }
            }
        }
        
        if (puzzleSolved) {
            System.out.println("\nJarret nods. \"Nature approves.\" You gain a Fruit of Endurance (restores full stamina).");
        } else {
            System.out.println("\n\"The weeds will consume your haste.\" You take health damage from exploding seed pods.");
        }
    }

    private void auntTrivyaPuzzle(Scanner scanner) {
        System.out.println("\nAfter satisfying Uncle Jarret's symmetric obsession, you follow Clara to the next family member – Aunt Trivya.");
        System.out.println("\"What do we need to know about your aunt?\" – Pixie asks");
        System.out.println("\"My aunt? Just know that she used to run spy operations with code riddles. Now she just plays cruel games with facts and lies.\" – Clara replies");
        System.out.println("\"I love that woman – we would be best friends if we weren't from such different timelines!\" – Faust sounds excited");
        
        String[] statements = {
            "The portal lies in the west.",
            "Clara's grandmother was banished.",
            "You've been here before.",
            "Magic isn't real.",
            "One of you is not who they seem."
        };
        
        int correctAnswer = 2; // "You've been here before" is the truth
        int attempts = 3;
        boolean puzzleSolved = false;
        
        System.out.println("\nYou enter a room that looks like a futuristic detective office – vintage style, futuristic materials – something is off.");
        System.out.println("\"You seek wisdom?\" – Aunt Trivya asks");
        System.out.println("\"Answer this: Five statements, one truth. Pick the true one or lose what you value most.\" – She dares");
        
        while (!puzzleSolved && attempts > 0) {
            System.out.println("\n=== Attempts remaining: " + attempts + " ===");
            for (int i = 0; i < statements.length; i++) {
                System.out.println((i + 1) + ". " + statements[i]);
            }
            
            int choice = getValidInput(scanner, 1, 5);
            
            if (choice == correctAnswer + 1) {
                puzzleSolved = true;
            } else {
                attempts--;
                System.out.println("\n\"Wrong!\" Trivya cackles. The mirror fractures slightly.");
                System.out.println("You feel a sharp pain as your health decreases.");
            }
        }
        
        if (puzzleSolved) {
            System.out.println("\n\"So you're not completely hopeless,\" Trivya huffs, disappearing into a smoke mirror.");
        } else {
            System.out.println("\nThe mirror shatters completely. You wake up in the marketplace with reduced health.");
        }
    }

    private void fatherPuzzle(Scanner scanner) {
        System.out.println("\nYou managed to solve the second puzzle. It is time to face the head of the family – Clara's dad.");
        System.out.println("You follow Clara into an elevator rising above the city – on the last floor of the highest building.");
        System.out.println("At the top an empty room filled with sheer silence. There's nothing – just him, standing in the midst of it.");
        System.out.println("\"My father doesn't deal with riddles. He breaks you down. This one's not a game. It's… him seeing who you are, and deciding if that's enough to let you through.\" – Clara whispers");
        
        int score = 0;
        
        System.out.println("\nA tall figure stands in the dark, with his arms folded.");
        System.out.println("\"You think you are ready to change fate? Step forward. Tell me – why should I let you pass?\"");
        
        // Question 1
        System.out.println("\n\"First question: What is Clara most afraid of?\"");
        System.out.println("1. Losing her family");
        System.out.println("2. Being forgotten");
        System.out.println("3. The inevitable end of magic");
        int answer1 = getValidInput(scanner, 1, 3);
        if (answer1 == 2) score++;
        
        // Question 2
        System.out.println("\n\"Second question: What is stronger - magic or technology?\"");
        System.out.println("1. Magic");
        System.out.println("2. Technology");
        System.out.println("3. They're two sides of the same coin");
        int answer2 = getValidInput(scanner, 1, 3);
        if (answer2 == 3) score++;
        
        // Question 3
        System.out.println("\n\"Final question: If only one of you could return home, who would it be?\"");
        System.out.println("1. Pixie");
        System.out.println("2. Puck");
        System.out.println("3. Neither - we stay together");
        int answer3 = getValidInput(scanner, 1, 3);
        if (answer3 == 3) score++;
        
        if (score >= 2) {
            System.out.println("\nHe steps aside, silently. A door opens to a violet-lit tower.");
            System.out.println("\nYou have solved the third and final puzzle. As the final gate opens, Clara breathes out.");
            System.out.println("\"She will know what to do. But she will also want to know who you are now.\" – She says");
            System.out.println("You have earned the right to meet the last witch.");
        } else {
            System.out.println("\n\"Not yet.\" You wake up in the marketplace. Saved. But changed. Try again.");
            start(); // Restart the chapter
        }
    }

    private void displayGarden(String[] reference, String[] working) {
        System.out.println("\nREFERENCE (Left)       YOUR GARDEN (Right)");
        System.out.println("-------------------    -------------------");
        for (int i = 0; i < 16; i += 4) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(reference[i + j] + " ");
            }
            System.out.print("|    | ");
            for (int j = 0; j < 4; j++) {
                System.out.print(working[i + j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------    -------------------");
        System.out.println("Positions: 0-3(top), 4-7, 8-11, 12-15(bottom)");
    }

    private void displayGardenWithErrors(String[] reference, String[] working) {
        System.out.println("\nMismatches marked with ?:");
        System.out.println("-------------------    -------------------");
        for (int i = 0; i < 16; i += 4) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(reference[i + j] + " ");
            }
            System.out.print("|    | ");
            for (int j = 0; j < 4; j++) {
                String display = working[i + j];
                if (!working[i + j].equals(reference[i + j])) {
                    display += "?";
                }
                System.out.print(display + " ");
            }
            System.out.println("|");
        }
    }

    private void giveHint(String[] working, String[] solution) {
        for (int i = 0; i < working.length; i++) {
            if (!working[i].equals(solution[i])) {
                System.out.println("\nHint: Position " + i + " should be " + solution[i]);
                System.out.println("(It pairs with position " + (15 - i) + ")");
                return;
            }
        }
        System.out.println("The garden is already perfect!");
    }

    private void shuffleArray(String[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private int getValidInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private int getValidPosition(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter position (0-15): ");
                int pos = Integer.parseInt(scanner.nextLine());
                if (pos >= 0 && pos <= 15) {
                    return pos;
                }
                System.out.println("Please enter a number between 0 and 15.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void continueChapter4() {
        // Check if we have a valid save state for Chapter 4
        if (currentChapter == null || !(currentChapter instanceof Chapter4Room)) {
            // If not, create a new Chapter 4 instance
            currentChapter = new Chapter4Room();
        }
        
        // Restore any saved progress if needed
        File saveFile = new File("Chapter4.save");
        if (saveFile.exists()) {
            SaveManager.loadGame("Chapter4.save");
            // Assuming GameState holds the current state, apply it accordingly
            // Here we simulate applying save state by calling applySaveState with null or actual state if accessible
            // For now, we call applySaveState with null as placeholder
            applySaveState(null);
        }
        
        // Start or continue the chapter
        currentChapter.start();

    }

    private void applySaveState(Chapter4SaveState saveState) {
        if (saveState == null) {
            System.out.println("No save state to apply.");
            return;
        }
        // Apply the save state to the current chapter or game state
        System.out.println("Applying save state for Chapter 4...");
        // Example: update relics collected, player health, inventory, etc.
        // This depends on how Chapter4Room and game state are implemented
    }
}
