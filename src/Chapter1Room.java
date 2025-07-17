import java.util.Scanner;

public class Chapter1Room extends Chapter{

    @Override
    protected void setupObjectives() {
        // TODO: Implement objectives setup for Chapter 1
    }
    private final Scanner scanner = new Scanner(System.in);

    public Chapter1Room() {
        super("Chapter 1: The Room");
    }

    @Override
    public void start() {
        System.out.println("\n=== " + title + " ===");
        System.out.println("You are in your room, locked in a fierce showdown with your twin brother over a PS5 game that has gotten way too competitive.");
        System.out.println("Tensions are high, controllers are flying, insults are escalating – and then, out of nowhere, the air shifts.");
        System.out.println("A strange, electric aura crackles around you. Before you can even throw your next sarcastic jab, the floor beneath you vanishes into swirling light.");
        System.out.println("A portal tears open, and you and your twin brother are yanked into the unknown, tumbling headfirst into a world far from home.");
        System.out.println("\nConfused by what just happened, you and your brother lock eyes – then immediately start arguing again, each blaming the other for whatever that portal mess was.");
        System.out.println("As your shouting match escalates, something strange starts happening: the plants around begin to wither and die.");
        System.out.println("Then, out of nowhere, your twin gets hit with a brutal case of hiccups.");
        System.out.println("Not just regular hiccups — loud, dramatic, cartoon-level hiccups that somehow make everything even more annoying and ridiculous.");
        System.out.println("\nThis is when you both finally stop. And the moment you do, your twin's hiccups vanish, and the world around you begins to calm.");
        System.out.println("Slowly, the plants perk back up, the air settles, and the place starts to feel… alive again.");
        System.out.println("You and your twin exchange looks – what just happened?");
        
        presentOptions();
    }

    private void presentOptions() {
        int choice = 0;

        while (choice < 1 || choice >3) {
            System.out.println("\n**What would you like to do?**");
            System.out.println("1. Investigate your twin's hiccup attack.");
            System.out.println("2. Examine the environment's strange phenomenon.");
            System.out.println("3. Try to find a way back home.");
            
           try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        handleChoice(choice);
        continueStory();

    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("\nYour twin trips on a rock on the ground and gets upset, worsening their mood again.");
                System.out.println("They start hiccupping badly and suddenly, the vine around them withers away.");
                System.out.println("You feel a hit — your eyes start to blur, and you ask your twin to calm down.");
                System.out.println("You realize your twin can harm the environment, which punishes them with a bad case of hiccups.");
            }
            case 2 -> {
                System.out.println("\nYou touch a withered vine, and it instantly coils around your hand.");
                System.out.println("The vine starts glowing, causing you to feel giddy.");
                System.out.println("You start giggling as the effect is so strong you feel a new type of connection with nature – unlike anything you have ever felt before.");
                System.out.println("The vine's light starts traveling down to its roots, making an intercalating and dispersed web visible from the ground.");
            }
            case 3 -> {
                System.out.println("\nYou and your twin try to remember the events leading to you falling through the portal, but your memories are hazy.");
                System.out.println("It seems as if the portal has closed behind you, leaving no obvious way back.");
                System.out.println("You cannot get your head around the whole situation.");
            }
        }
    }

    private void continueStory() {
        System.out.println("\nAs you are trying to get your thoughts together, you hear a branch crack, revealing two figures that step out from the shadows of the nearby foliage.");
        System.out.println("One tall with a warm smile, and the other smaller with sharp, observant eyes.");
        System.out.println("There is something off about them — one is dressed like they are from the very far future — pointy shoulder pads that could easily hurt someone, glowing garments, and hair that seems to defy gravity;");
        System.out.println("the other looks like a vintage nerdy mathematician — long black coat, pointy shoes, and a pair of pentagon-shaped glasses.");
        
        presentSecondOptions();
    }

    private void presentSecondOptions() {
        int choice = 0;
        
        while (choice < 1 || choice > 3) {
            System.out.println("\n**What will you ask them?**");
            System.out.println("1. Who are you?");
            System.out.println("2. What do you know about our powers?");
            System.out.println("3. Do you know how we can get back home?");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        handleSecondChoice(choice);
        introduceTwins();
    }

    private void handleSecondChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("\n'Us?' – the small figure raised an eyebrow.");
                System.out.println("'We are just 2 acquaintances that met a moment ago and were interrupted by some childish lookalikes,' uttered the tall figure.");
            }
            case 2 -> {
                System.out.println("\n'Not much — it seems as though everyone is getting some kind of powers here.");
                System.out.println("The portals must have created a ripple through time, cursing everyone with a newly found magical power,' said the tall figure.");
                System.out.println("'You guys are not the only ones here from the past — this place has been infected by people from different centuries,' she added.");
                System.out.println("'Hey — watch your mouth! I feel like I am a good addition to your 'futuristic' 33rd century' the small figure replied, clearly annoyed.");
            }
            case 3 -> {
                System.out.println("\n'Now, that is something we are trying to figure out.");
                System.out.println("All opening portals seem to close immediately, so everyone is stuck here,' the tall figure replied.");
            }
        }
        
        System.out.println("\n'Enough about us — who are *YOU*?' – the small figure exclaimed curiously.");
    }

    private void introduceTwins() {
        int choice = 0;
        
        while (choice < 1 || choice > 3) {
            System.out.println("\nYou and your twin glance at each other.");
            System.out.println("**What do you say?**");
            System.out.println("1. 'I'm Pixie. This is Puck. We don't usually ruin ecosystems with our moods.'");
            System.out.println("2. 'I'm Pixie. He's Puck. And if anyone knows where my controller went, I'll trade it for answers.'");
            System.out.println("3. 'We just fell through a glitch in the universe mid-boss fight.'");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        handleIntroductionChoice(choice);
        askForHelp();
    }

    private void handleIntroductionChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("\n'I'm Pixie. This is Puck. We don't usually destroy ecosystems with our emotions.'");
                System.out.println("The tall woman gives you a curious smile. 'You're not the only ones with emotional fallout. This place reacts... deeply.'");
                System.out.println("The short man snorts. 'Better start meditating.'");
            }
            case 2 -> {
                System.out.println("\n'I'm Pixie. That's Puck. We lost a PS5 controller in the time stream.'");
                System.out.println("The short man narrows his eyes. 'Primitive tools. Cute.'");
                System.out.println("The tall woman chuckles. 'You're going to fit in just fine.'");
            }
            case 3 -> {
                System.out.println("\n'We fell through a glitch in the universe mid-boss fight,' you mutter.");
                System.out.println("The short man sighs. 'Explains the poor fashion sense.'");
                System.out.println("The tall woman rolls her eyes. 'Ignore him. He's from a time when sarcasm was considered a science.'");
            }
        }
        
        System.out.println("\nClara turns to walk, motioning for you to follow.");
        System.out.println("The man in the long coat grumbles and adjusts his weirdly angular glasses.");
        System.out.println("'You're just trusting them?' he says. 'They look like confused time tourists.'");
        System.out.println("Clara smirks. 'Relax, Pixie and Puck aren't the worst strays we've picked up.'");
        System.out.println("You narrow your eyes. 'And who *are* you exactly? Other than 'judgy coat guy.''");
        System.out.println("He gives a dramatic sigh. 'Faust. And I wasn't judging. I was *observing critically.* There's a difference.'");
        System.out.println("Clara rolls her eyes. 'Ignore Faust. He's been cranky since the Renaissance.'");
        System.out.println("'You said your name is...?' Pixie prompts.");
        System.out.println("'Clara,' she says simply. 'Clara from 3200. Yes, the hair is natural.'");
        System.out.println("Puck mutters, 'Cool. We get a math professor and a glowing space warrior. Nice.'");
    }

    private void askForHelp() {
        int choice = 0;
        
        while (choice < 1 || choice > 3) {
            System.out.println("\nYou turn to Clara. She seems calm — way too calm for someone standing in a reality tear.");
            System.out.println("**What do you ask?**");
            System.out.println("1. 'Can you help us understand what's happening?'");
            System.out.println("2. 'Are we stuck here forever?'");
            System.out.println("3. 'Why is nature responding to us in quite an unusual manner? It almost feels… alive.'");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        handleHelpChoice(choice);
        claraResponds();
    }

    private void handleHelpChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("\n'We need answers,' you say. 'We're way out of our depth.'");
                System.out.println("Clara nods. 'Everyone is, at first. This world wasn't meant to hold all of us — or all our timelines.'");
            }
            case 2 -> {
                System.out.println("\n'Is there any way back home?'");
                System.out.println("Clara's expression hardens. 'Not yet. The portals close as soon as they open. No one's figured out how to reverse them.'");
            }
            case 3 -> {
                System.out.println("\n'This place… it feels alive. Why is it reacting to us?'");
                System.out.println("Clara steps forward. 'You're emotionally linked to the landscape. It's a side effect of portal exposure.");
                System.out.println("Some of us have... adapted. Others haven't.'");
            }
        }
    }

    private void claraResponds() {
        System.out.println("\nClara studies both of you carefully.");
        System.out.println("'Why should I help you?'");
        
        int choice = 0;
        
        while (choice < 1 || choice > 3) {
            System.out.println("\n**How do you respond?**");
            System.out.println("1. 'Because we don't know what we're doing, and we don't want to make things worse.'");
            System.out.println("2. 'Because maybe we were brought here for a reason.'");
            System.out.println("3. 'Because if you don't, Puck will hiccup again and nuke a flowerbed.'");
            
            try {
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

    private void handleFinalChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("\n'We're not here to mess things up,' you say. 'We just want to understand this new world.'");
                System.out.println("Clara nods slowly. 'That's more than most newcomers can admit.'");
            }
            case 2 -> {
                System.out.println("\n'Something pulled us here. That has to mean something, right?'");
                System.out.println("Clara meets your eyes. 'It might. And that's what scares me.'");
            }
            case 3 -> {
                System.out.println("\nYou gesture to your twin. 'You've seen what happens when Puck's in a mood. Plants cry.'");
                System.out.println("Faust groans. 'Ugh. Fine. Help them before the forest dies of emotional damage.'");
            }
        }
        
        System.out.println("\nClara sighs, folding her arms. 'Alright. I'll help you — for now. You're... different.");
        System.out.println("The environment's reaction confirms it.'");
        System.out.println("Faust looks between the two of you and mutters, 'Different doesn't mean *good*.'");
        System.out.println("Clara ignores him. 'You'll need to blend in. And fast.'");
        System.out.println("She turns toward the trees, where a faint glowing path emerges in the undergrowth.");
        System.out.println("'Follow me. There's one place where questions might get answered. Or traded.'");
        
        // Transition to Chapter 2
        notifyObservers("Chapter 1 completed. Moving to Chapter 2.");
    }
} 