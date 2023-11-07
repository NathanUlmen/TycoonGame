import java.util.ArrayList;

public class OreObserver implements Subject {
    private ArrayList<Observer> observers;

    public OreObserver() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void orePositionChanged(Ore ore) {
        notifyObservers(ore);
    }

    private void notifyObservers(Ore ore) {
        for (Observer observer : observers) {
            observer.update(ore);
        }
    }
}
