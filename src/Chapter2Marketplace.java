import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Chapter2Marketplace extends Chapter {

    @Override
    protected void setupObjectives() {
        // TODO: Implement objectives setup for Chapter 2
    }

    private boolean hasVisitedMainSquare = false;
    private boolean hasCompletedMainSquare = false;
    private final Set<Integer> visitedLocations = new HashSet<>();
    private boolean hasMainSquareInteraction = false;
    private final Scanner scanner = new Scanner(System.in);

    public Chapter2Marketplace() {
        super("Chapter 2: Marketplace");
    }

    @Override 
    public void start() {
        System.out.println("\n=== " + title + " ===");
        System.out.println("Clara leads the way, and the vines part like they recognize her.");
        System.out.println("The further you walk, the weirder things get — gravity flips for a second, a hummingbird wears a monocle, and a guy in Victorian attire teleports past holding a smoothie.");
        System.out.println("\nThen you see it.");
        System.out.println("\nA sprawling open-air bazaar, stitched together from scraps of every century.");
        System.out.println("Floating stalls, medieval tents with digital billboards, robots trading coins, centaurs arguing with accountants.");
        System.out.println("Everything buzzes with chaotic energy.");
        System.out.println("\nAbove it all, a sign hovers:");
        System.out.println("\n**THE TRANS-EPOCH MARKETPLACE**");
        System.out.println("**— TIME TRAVELERS WELCOME — NO HAGGLING OVER PARADOXES —**");
        System.out.println("\nPixie raises an eyebrow. 'Is that a steam-powered cotton candy cart?'");
        System.out.println("Puck mutters, 'Do you think someone here takes PS5 controllers as currency?'");
        System.out.println("Clara grins. 'Welcome to the Market. Step carefully — this place remembers.'");
        System.out.println("\n**TO BE CONTINUED...**");
        
        presentMarketplaceOptions();
    }

    private void presentMarketplaceOptions() {
        while (!hasCompletedMainSquare) {
            System.out.println("\n=== Current Progress ===");
            System.out.println("Locations visited: " + visitedLocations.size() + "/4");
            
            if (!hasVisitedMainSquare) {
                showInitialMessages();
            }
            
            System.out.println("\n**Where would you like to go?**");
            int optionCounter = 1;
            
            // Always show Main Square first if not visited yet
            if (!hasVisitedMainSquare) {
                System.out.println(optionCounter++ + ". Main Square");
            }
            
            // Show other unvisited locations
            for (int i = 2; i <= 5; i++) {
                if (!visitedLocations.contains(i)) {
                    System.out.println(optionCounter++ + ". " + getLocationName(i));
                }
            }
            
            // Add return to Main Square option if player has visited at least one location
            if (hasVisitedMainSquare && !visitedLocations.isEmpty()) {
                System.out.println(optionCounter + ". Return to Clara at Main Square");
            }

            // Get user input
            int maxOption = optionCounter;
            int choice = getValidChoice(scanner, 1, maxOption);

            if (choice == maxOption && hasVisitedMainSquare && !visitedLocations.isEmpty()) {
                continueToChapter3();
                return;
            } else {
                handleMarketplaceChoice(choice, optionCounter);
            }
        }
    }

    private String getLocationName(int locationId) {
        return switch(locationId) {
            case 1 -> "Main Square";
            case 2 -> "Tech Alley";
            case 3 -> "Food Court";
            case 4 -> "Black Market";
            case 5 -> "Observation Deck";
            default -> "Unknown Location";
        };
    }

    private int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print("\nEnter your choice (" + min + "-" + max + "): ");
                int choice = Integer.parseInt(scanner.nextLine());
                
                if (choice < min || choice > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void handleMarketplaceChoice(int choice, int totalOptions) {
        // If Main Square hasn't been visited yet, it's option 1
        if (!hasVisitedMainSquare) {
            if (choice == 1) {
                mainSquare();
                hasVisitedMainSquare = true;
                return;
            }
            choice--; // Adjust choice since we've handled Main Square
        }
        
        // Map the choice to remaining locations
        int locationIndex = 2; // Start from Tech Alley (location 2)
        for (int i = 2; i <= 5; i++) {
            if (!visitedLocations.contains(i)) {
                if (locationIndex == choice) {
                    switch(i) {
                        case 2 -> techAlley();
                        case 3 -> foodCourt();
                        case 4 -> blackMarket();
                        case 5 -> observationDeck();
                    }
                    visitedLocations.add(i);
                    return;
                }
                locationIndex++;
            }
        }
    }

    private void showInitialMessages() {
        System.out.println("\nA flicker in the air – then, a holographic screen hums to life before you:");
        System.out.println(">> 'Temporal Anchor Established – Memory Core Synced.'");
        System.out.println("\n'A savepoint?' you think to yourself.");
        System.out.println("Then you hear familiar voices…");
        System.out.println("\n**Pixie:**");
        System.out.println("\"This dimension doesn't play fair. If you don't eat or drink regularly, it'll chew you up and spit you into the timestream.\"");
        System.out.println("\n**Puck (rolling his eyes):**");
        System.out.println("\"Basically, don't starve. Also—hydrate or die-drate.\"");
        System.out.println("\n**System Message:**");
        System.out.println("**Hunger and Thirst Mechanics Activated**");
        System.out.println("- Your **health** will decrease if you are **hungry**.");
        System.out.println("- Your **stamina** drops when **thirsty**—you can't fight or run.");
        System.out.println("- Neglect both? Prepare for hallucinations and death.");
        System.out.println("- Visit vendors or discover consumables across the bazaar.");
        System.out.println("\nYou glance into your inventory and notice a small device a vendor had pressed into your hand earlier – a translator.");
    }

    private void mainSquare() {
        System.out.println("\n=== Main Square ===");
        System.out.println("You have walked to the heartbeat of the bazaar. As you look around, a large glowing figure flickers to life – a holographic historian, draped in shifting archival robes.");
        System.out.println("\n\"Welcome, off-worlders. You walk paths few remember. Would you like to learn the history of this fractured sector?\"");

        if (!hasMainSquareInteraction) {
            int choice = 0;

            while (choice < 1 || choice > 2) {
                System.out.println("\n**Your choice:**");
                System.out.println("1. Yes, show me!");
                System.out.println("2. No, thanks.");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 2) {
                        System.out.println("Please enter 1 or 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            if (choice == 1) {
                System.out.println("\nYou unlock lore about the alien city and how the marketplace survived multiple temporal collapses.");
                System.out.println("Hint: There may be a secret entrance beneath the statue of the Time-Scribe.");
                System.out.println("\nYou receive a **Stabilized Ration Bar** (+20 Health).");
                System.out.println("And a **SynthHydrate Pouch** (+25 Stamina).");
                System.out.println("A glowing relic draws your attention – a **Rare Magic Item** awaits…");
                System.out.println("\nYou feel a magical resonance from one of the glowing artifacts. A voice inside your head whispers:");
                System.out.println("\"You may only choose one. Use it wisely, for its power only flows through the next challenge.\"");
                System.out.println("\n**System Message:**");
                System.out.println("`Pick ONE rare magic item to carry into Chapter 3.`");
                selectRareMagicItem();
            } else {
                System.out.println("\n\"As you wish~\" – the hologram bows and flickers out.");
            }

            hasMainSquareInteraction = true;
        } else {
            System.out.println("\nThe Main Square remains bustling with activity. The holographic historian nods at you as you pass by.");
        }

        System.out.println("\nYou spend some time exploring the Main Square before moving on...");
    }

    private void selectRareMagicItem() {
        System.out.println("\n**Choose your rare magic item:**");
        System.out.println("1. **Time-Scribe's Quill** - Grants insight into the past.");
        System.out.println("2. **Chrono-Bloom** - Temporarily slows down time.");
        System.out.println("3. **Ethereal Cloak** - Allows you to become invisible for a short duration.");

        int choice = 0;
        while (choice < 1 || choice > 3) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        switch (choice) {
            case 1 -> System.out.println("\nYou have chosen the **Time-Scribe's Quill**.");
            case 2 -> System.out.println("\nYou have chosen the **Chrono-Bloom**.");
            case 3 -> System.out.println("\nYou have chosen the **Ethereal Cloak**.");
        }
    }

    private void techAlley() {
        System.out.println("\n=== Tech Alley ===");
        System.out.println("You step into the alley, neon circuitry winding like vines across the walls. A vendor grins at you, gesturing at a twitching mechanical limb.");
        System.out.println("\n\"First gen bio-weave. Semi-sentient. Cheap... but a bit temperamental.\"");
        System.out.println("\nSuddenly, the limb spasms and lunges—attaching itself to your forearm.");

        int choice = 0;

        while (choice < 1 || choice > 2) {
            System.out.println("\n**What do you do?**");
            System.out.println("1. Try to control it.");
            System.out.println("2. Rip it off!");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 2) {
                    System.out.println("Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        if (choice == 1) {
            System.out.println("\n*Success?* You gain **Augmented Grip** (can lift heavy objects/break fragile walls).");
            System.out.println("*Failure?* The arm malfunctions and smacks Puck in the face. He sulks for two turns.");
        } else {
            System.out.println("\n*You take 10 health damage* but avoid chaos.");
            System.out.println("The vendor apologizes and gives you a **Data Key** as compensation.");
            System.out.println("You also find a **Neurofibril Drink** (+15 Stamina).");
            System.out.println("A case nearby holds a **Nano-Embedded Gauntlet (Rare Magic Item)** – boosts your spell effectiveness by 20% in Chapter 3.");
        }
    }

    private void foodCourt() {
        System.out.println("\n=== Food Court ===");
        System.out.println("You are greeted by a multi-tentacled chef who offers you a steaming, bioluminescent dish.");
        System.out.println("\n\"Eat and remember a moment not your own... or perhaps one you've yet to live.\"");

        int choice = 0;

        while (choice < 1 || choice > 2) {
            System.out.println("\n**What do you do?**");
            System.out.println("1. Eat the dish.");
            System.out.println("2. Politely decline.");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 2) {
                    System.out.println("Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        if (choice == 1) {
            System.out.println("\n*You see a vision of the world burning time shattering like glass. A familiar figure is calling your name.*");
            System.out.println("Gain **Plasma-Spiced Meal** (+50 Health).");
            System.out.println("Also receive a **Random Buff Trinket** (temporary resistance to status effects).");
            System.out.println("(You feel your magic sensitivity increase briefly...)");
        } else {
            System.out.println("\nThe chef nods solemnly.");
            System.out.println("\"The flavour of prophecy isn't for everyone.\"");
            System.out.println("He gives you an **Ion-Tonic** (+Full Stamina) as a peace offering.");
        }
    }

    private void blackMarket() {
        System.out.println("\n=== Black Market ===");
        System.out.println("You slink past the official stalls into the underbelly of the bazaar. A masked figure whispers:");
        System.out.println("\"Looking for something... illicit?\"");
        System.out.println("\nHe offers you two strange items:");
        System.out.println("\n1. **Illegal Bio-Injector** → Restores ALL health... but gives hallucinations for 3 turns.");
        System.out.println("2. **Forbidden Sigil (Rare Magic)** → Lets you skip ONE puzzle in Chapter 3.");
        System.out.println("\n(You may only choose one.)");

        int choice = 0;

        while (choice < 1 || choice > 2) {
            System.out.println("\nEnter your choice (1 or 2):");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 2) {
                    System.out.println("Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        if (choice == 1) {
            System.out.println("\nYou take the **Illegal Bio-Injector**. Use it wisely...");
        } else {
            System.out.println("\nYou take the **Forbidden Sigil**. It hums with forbidden power.");
        }
    }

    private void observationDeck() {
        System.out.println("\n=== Observation Deck ===");
        System.out.println("Above the chaos, a quiet platform gives a view over the market. You feel calm for the first time in hours.");
        System.out.println("\nYou find:");
        System.out.println("\n**Meditation Sequence** → Slowly restores stamina over 5 actions");
        System.out.println("**Vision Scroll (Rare Magic)** → Reveals one hidden clue during any future puzzle in Chapter 3");
        System.out.println("\nAs you meditate, Pixie's voice echoes faintly:");
        System.out.println("\"It's never quiet for long.\"");
    }

    private void continueToChapter3() {
        hasCompletedMainSquare = true;
        System.out.println("\nAfter looking around, you meet Clara at the main square. She pauses, looking back at you.");
        System.out.println("\"Okay… I haven't told you everything yet.\" – Clara runs a hand through her hair, avoiding your eyes");
        System.out.println("\"There is someone who might be able to help you. Someone who understands magic, not just pretending to be it.\" – She says with a concerned tone");
        System.out.println("\"My grandma\" – Clara says softly after a brief pause");
        System.out.println("\"Your grandma? Like, 'cookies and bedtime stories' grandma?\" – Pixie asks");
        System.out.println("\"More like 'summons storms with a salt circle' grandma. She is the reason I can do what I do. The last real witch this city hasn't silenced.\" – Clara smiles softly");
        System.out.println("\"She looks toward the spires above the skyline – faintly glowing towers tangled with creeping vines and shadowlight.\" – She adds");
        System.out.println("\"Well, where can we find her?!\" – Puck exclaims");
        System.out.println("\"She lives in the Upper District, tucked away in a tower that bends time at the seams. But…\" – Clara sighs");
        System.out.println("\"Getting to her isn't just walking across a few train platforms and smiling at security drones.\" – She adds");
        System.out.println("\"I am guessing there is a 'but' the size of Jupiter coming,\" – Says Puck");
        System.out.println("Clara nods. – \"My family. My uncle. My aunt. And then…\" – She pauses.");
        System.out.println("\"My father. They control the checkpoints between here and her. And they don't like the idea of anyone going to see her.\" – Clara adds");
        System.out.println("\"Why?\" – Pixie asks");
        System.out.println("\"Because they think she's dangerous. A relic. They traded magic for machines a long time ago. They're not going to fight you outright, but they'll try to break you. Test you. Each of them has a… puzzle. A trap. A test of will or wit. That's how they work.\" – Clara explains");
        System.out.println("\"Like a dysfunctional escape room with parental trauma.\" – Puck takes a guess");
        System.out.println("\"Exactly that. But worse.\" – Clara replies");
        System.out.println("\"We will need to go one checkpoint at a time. If you fail… we don't get to Grandma. And without her, there is no portal. No way back home for you.\" – Clara says, her voice steady but her eyes betraying concern");
    
        notifyObservers("Chapter 2 completed. Moving to Chapter 3.");
    }
}