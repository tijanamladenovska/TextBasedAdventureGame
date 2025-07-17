public class Objective {
    private final String description;
    private boolean complete;

    public Objective(String description) {
        this.description = description;
        this.complete = false;
    }

    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return complete;
    }

    public String getDescription() {
        return description;
    }
}
