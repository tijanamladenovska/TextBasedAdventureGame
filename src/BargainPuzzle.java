public class BargainPuzzle implements Puzzle {
    private final String description;
    private boolean solved;

    public BargainPuzzle() {
        this.description = "Negotiate a better price with the vendor.";
        this.solved = false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean solve() {
        // Implement bargaining logic here
        // For now, just mark as solved
        solved = true;
        return solved;
    }

    @Override
    public boolean isSolved() {
        return solved;
    }
}

