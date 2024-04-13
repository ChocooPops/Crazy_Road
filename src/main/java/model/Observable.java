package model;

import view.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Observable.
 */
public abstract class Observable {
    private List<Observer> observers = new ArrayList<>(); 
    private boolean state; 
    
    public boolean getState() {
        return this.state; 
    }
    
    public void setState(final boolean state) {
        this.state = state; 
    }
    
    /**
    *
    * Ajouter un observer à la liste.
     * @param observer l'observer à ajouter.
    */
    public void addObserver(final Observer observer) {
        this.observers.add(observer); 
    }
    
    /**
    *
    * Si l'objet est changé, notifie tous les observers.
    */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
}
