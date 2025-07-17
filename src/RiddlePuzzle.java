public class RiddlePuzzle implements Puzzle {
    private final String description;
    private final String solution;
    private final boolean solved;
    
    public RiddlePuzzle(String description, String solution) {
        this.description = description;
        this.solution = solution;
        this.solved = false;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public boolean solve() {
        // The solve method currently does not have input to check against solution
        // This method should be updated to handle solution checking externally
        return solved;
    }
    
    @Override
    public boolean isSolved() {
        return solved;
    }
}
