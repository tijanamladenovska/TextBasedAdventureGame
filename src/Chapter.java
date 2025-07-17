import java.util.ArrayList;
import java.util.List;

public abstract class Chapter {
    protected String title;
    protected List<ChapterObserver> observers;
    protected WinCondition winCondition;
    
    public Chapter(String title) {
        this.title = title;
        this.observers = new ArrayList<>();
        this.winCondition = new WinCondition();
        setupObjectives();
    }
    
    protected abstract void setupObjectives();
    
    public boolean isChapterComplete() {
        return winCondition.isMet();
    }
    
    public void displayObjectives() {
        winCondition.displayProgress();
    }

    public void addObserver(ChapterObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ChapterObserver observer) {
        observers.remove(observer);
    }

    // Improved notify method
    protected void notifyObservers(String message) {
        for (ChapterObserver observer : new ArrayList<>(observers)) {
            try {
                observer.update(message);
            } catch (Exception e) {
                System.err.println("Error notifying observer: " + e.getMessage());
            }
        }
    }

    public abstract void start();
    
}
