import java.util.ArrayList;
import java.util.List;

public class WinCondition {
    private final List<Objective> objectives;
    
    public WinCondition() {
        objectives = new ArrayList<>();
    }
    
    public void addObjective(Objective objective) {
        objectives.add(objective);
    }
    
    public boolean isMet() {
        return objectives.stream().allMatch(Objective::isComplete);
    }
    
    public void displayProgress() {
        System.out.println("\n=== Current Objectives ===");
        objectives.forEach(obj -> 
            System.out.println("- " + obj.getDescription() + ": " + 
                (obj.isComplete() ? "✓" : "✗")));
    }
}
