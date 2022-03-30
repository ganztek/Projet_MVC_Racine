package observeur;


/**
 interface qui doit etre implementé par
  tous les classes qui souhaite etre observer .
 */
public interface Observable {
                 // inscription
    void addObserver(Observer observer);
                //deinscription
    void deleteObserver(Observer observer);
                 //notification
    void notifyObservers();

}
