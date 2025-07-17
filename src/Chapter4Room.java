import java.util.Scanner;

public class Chapter4Room extends Chapter {

    @Override
    protected void setupObjectives() {
        // TODO: Implement objectives setup for Chapter 4
    }
    
    public Chapter4Room() {
        super("Chapter 4: The Final Choice");
    }

    @Override
    public void start() {
        System.out.println("\n=== " + title + " ===");
        System.out.println("The tower interior is unlike anything you've seen—walls lined with relics that defy time, flickering maps of constellations not yet charted, and a cauldron that hums with low, magnetic energy.");
        System.out.println("Clara's grandmother, standing tall with silver braids and a voice that sounds older than the wind, begins to speak:");
        System.out.println("\n\"To open the portal and send you home, three relics must be gathered—fragments of power lost in time's spiral. Each hidden in an era that once touched this world, each guarded by a force that must be confronted.\" – Nyra states");
        System.out.println("\nShe raises her hands, and three orbs float into view—each glowing with a distinct aura:");
        System.out.println("• A marble-white sphere swirling with lightning");
        System.out.println("• A translucent black sphere flickering with neon veins");
        System.out.println("• A golden sphere thrumming with raw, earthy energy");
        System.out.println("\n\"These are your anchors. Not just portals, but vessels—they will carry you and bring back what we need. But beware: these worlds are not simulations. They are real. And the guardians you'll face… they do not sleep.\" – She adds");
        
        collectRelics();

        // Notify completion of Chapter 4
        notifyObservers("Chapter 4 completed");
    }

    private void collectRelics() {
        System.out.println("\n=== Collecting the Relics ===");
        System.out.println("You must now travel through three different time periods to collect the relics.");
        
        // Ancient Greece
        System.out.println("\n🌐 First Sphere: ANCIENT GREECE — The Labyrinth of Theras");
        System.out.println("The floating sphere hums like a tuning fork struck against time itself. When touched, it doesn't pull you—it remembers you.");
        System.out.println("A flash of blinding light, a thump in your chest, and you're standing at the edge of a marble courtyard wreathed in vines.");
        
        System.out.println("\n=== Boss: Theras, The Fallen Champion ===");
        System.out.println("You enter a sunken arena beneath a crumbling amphitheater. Theras awaits, towering and cracked like a broken statue of Ares.");
        System.out.println("\nTheras (booming):");
        System.out.println("\"I fought for glory. Now I bleed for remembrance. If you wish the god-shard I carry, then prove yourself—not with steel… but with balance.\"");
        
        // Simplified boss fight
        if (solvePuzzle("Born before me, died with me. Buried in men, yet sets them free. What am I?", "memory")) {
            System.out.println("\nUpon victory, Theras collapses, the shard glowing in your palm.");
            System.out.println("Theras (fading):");
            System.out.println("\"The gods were never gods… Just the loudest survivors…\"");
        }
        
        // Future Era
        System.out.println("\n🌀 Second Sphere: 18000 CE — Citadel of E.M.E.R.A.");
        System.out.println("You barely touch the next sphere before the world pixelates around you. Your vision boots like a corrupted operating system.");
        
        System.out.println("\n=== Boss: E.M.E.R.A. – Eternal Memory Engine Reclamation AI ===");
        System.out.println("You descend into the Citadel, where a massive spherical AI hovers, wires like spiderwebs.");
        System.out.println("\nEMERA (monotone glitch):");
        System.out.println("\"Genetic signatures unauthorized. Cross-temporal interference detected. Query: Are you… the error?\"");
        
        // Simplified boss fight
        if (solvePuzzle("Initiate sequence: 3-5-8-13-21-??", "34")) {
            System.out.println("\nUpon victory, EMERA flickers. A human voice breaks through the static.");
            System.out.println("EMERA (soft, fading):");
            System.out.println("\"The fifth god… she uploaded herself. I was her echo.\"");
        }
        
        // Prehistoric Era
        System.out.println("\n🌀 Third Sphere: 10000 BCE – The Wild Howl of Varka");
        System.out.println("You expect stone and spears. You get fire and storms. The sky here is always dusk, lit by auroras and roaring beasts.");
        
        System.out.println("\n=== Boss: VARKA – THE PRIMAL WRATH ===");
        System.out.println("A monstrous, four-armed entity made of fur, horn, and rage stands before a stone altar.");
        System.out.println("\nVarka (growling):");
        System.out.println("\"You are not prey… but you are not pack. Bleed, or become worthy.\"");
        
        // Simplified boss fight
        if (solvePuzzle("What is the first law of the wild?", "survive")) {
            System.out.println("\nWhen Varka finally falls, it presses the shard into your chest.");
            System.out.println("Varka (soft, like thunder fading):");
            System.out.println("\"The gods were not born. They were made… and broken.\"");
        }
        
        finalConfrontation();
    }

    private boolean solvePuzzle(String question, String answer) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n" + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toLowerCase();
            
            if (userAnswer.equals(answer)) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println("Incorrect! You take damage.");
                return false;
            }
        }
    }

    private void finalConfrontation() {
        System.out.println("\n✨ Aftermath: Portal of the Forgotten Gods");
        System.out.println("With the three shards glowing like suns, Clara's grandmother performs the ritual—salt, fire, blood, and breath.");
        System.out.println("The tower groans as timelines collapse and reforge.");
        System.out.println("\nBut the sky above is cracking. Pixie clutches her head—Puck's prophecy is unraveling.");
        System.out.println("And just as the portal flickers open…");
        System.out.println("Faust steps from the shadows.");
        System.out.println("And he's not alone.");
        
        System.out.println("\n⚠️ CUTSCENE: TRUTH REVEALED");
        System.out.println("Faust:");
        System.out.println("\"What did you think the portal was, hmm? A door? A key? No. It's a resurrection.\"");
        System.out.println("He steps closer to the shards.");
        System.out.println("Faust (softly):");
        System.out.println("\"You were gathering the gods—not to escape, but to wake them up.\"");
        System.out.println("Clara's grandmother gasps, blood on her palms.");
        System.out.println("Clara's Grandma:");
        System.out.println("\"You... you knew. You've always known.\"");
        System.out.println("Faust:");
        System.out.println("\"Of course I knew. I made a deal with one of them—back before your 'time.'\"");
        System.out.println("\"The fifth god. The only one that chose to sleep.\"");
        System.out.println("The being beside him pulses.");
        System.out.println("\"And now… she wakes.\"");
        
        finalChoice();
    }

    private void finalChoice() {
        System.out.println("\n🌀 DECISION BRANCH");
        System.out.println("Do you:");
        System.out.println("1. Enter the portal and try to make it home—but risk tearing the fabric of reality?");
        System.out.println("2. Seal the relics, banishing the gods once more—but stranding yourselves forever?");
        System.out.println("3. Let Vakar awaken, and attempt to control the god within… to face the true final threat?");
        
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;
            while (choice < 1 || choice > 3) {
                try {
                    System.out.println("\nEnter your choice (1-3):");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > 3) {
                        System.out.println("Please enter a number between 1 and 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
            
            handleFinalChoice(choice);
        }
    }

    private void handleFinalChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("\nYou choose to go home, despite the risks.");
                System.out.println("The twins wake in a hospital bed—weeks passed. No one believes them.");
                System.out.println("But under Puck's pillow? A feather made of stormlight.");
            }
            case 2 -> {
                System.out.println("\nYou choose to seal the relics and banish the gods.");
                System.out.println("The portal closes, but you're trapped in this world forever.");
                System.out.println("You, Clara, and Faust become the new guardians of time.");
            }
            case 3 -> {
                System.out.println("\nYou choose to awaken Vakar and face the true threat.");
                System.out.println("A battle of wills ensues, but through your bond as twins, you contain the god's power.");
                System.out.println("You become the new bridge between worlds, able to travel between them at will.");
            }
        }
        
        System.out.println("\nNarrator:");
        System.out.println("\"The world didn't end. Not yet. But the gods? They're listening again.\"");
        System.out.println("\nYOU WIN.");
        System.out.println("Save file created: \"Threads of Fate – Complete\"");
        
    }
}
