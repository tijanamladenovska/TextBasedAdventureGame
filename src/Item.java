public class Item {
    private final String name;
    private final String description;
    private final int healthEffect;
    private final int staminaEffect;

    public Item(String name, String description, int healthEffect, int staminaEffect) {
        this.name = name;
        this.description = description;
        this.healthEffect = healthEffect;
        this.staminaEffect = staminaEffect; 
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthEffect() {
        return healthEffect;
    }

    public int getStaminaEffect() {
        return staminaEffect;
    }

    public void use(Player player) {
        player.setHealth(player.getHealth() + healthEffect);
        player.setStamina(player.getStamina() + staminaEffect);
        System.out.println(player.getName() + " used " + name + "!");
        System.out.println("Health: " + player.getHealth() + ", Stamina: " + player.getStamina());
    }
}

