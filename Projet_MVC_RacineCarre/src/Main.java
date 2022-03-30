import controller.Controleur;
import modele.Carre;
import modele.Conversion;
import modele.Modele;

import vue.Vue;

public class Main {
    public static void main(String[] args) {

        //view
        Vue view = new Vue();
        view.init();

        //Modele
        Conversion number = new Carre();
        Modele modele = new Modele(number);

        //Controller
        Controleur controleur = new Controleur(modele, view);

        //Observer
        modele.addObserver(view);
        modele.addObserver(controleur);

        //Action
        view.getButton().addActionListener(controleur);


    }
}
