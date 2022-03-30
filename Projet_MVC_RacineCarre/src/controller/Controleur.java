package controller;

import modele.Modele;
import observeur.Observable;
import observeur.Observer;
import vue.Vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements Observer, ActionListener {
    public Modele modele;
    public Vue view;

    public Controleur(Modele modele, Vue view) {
        this.modele = modele;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField entrerRacine  = view.getNombre();
        modele.setRacine(Double.parseDouble(entrerRacine.getText()));
    }

    @Override
    public void update(Observable observable) {
        Modele modele = (Modele) observable;
        JTextField resultat = view.getResultat();
        resultat.setText(String.valueOf(modele.getNumber()));

    }

}
