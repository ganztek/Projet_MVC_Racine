package modele;

import observeur.Observable;
import observeur.Observer;
import java.util.LinkedList;
import java.util.List;

/**
 * classe permettant d'obtenir la racine carre d'un nombre
 */
public class Modele implements Observable {

    protected List<Observer> observers = new LinkedList<>();

    public double racine;
    public Conversion convert;

      //constructor

    public Modele(Conversion number) {
        this.convert = number; // Dependency Injection
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }

    }

    public double getRacine() {
        return racine;
    }

    public double getNumber() {
        return this.convert.carre(racine);
    }//Delegation

    public void setRacine(double racine) {
        this.racine = racine;
        notifyObservers();
    }
}
