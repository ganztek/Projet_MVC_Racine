package vue;

import modele.Modele;
import observeur.Observable;
import observeur.Observer;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Vue implements Observer {

                    //etat de la classe (attribut)
    JFrame frame;
    JTextField nombre,resultat;
    JButton button;
    JLabel outputlabel, inputlabel;

                    //getter
    public JTextField getNombre() {return nombre;}

    public JTextField getResultat() {return resultat;}

    public JButton getButton() {
        return button;
    }


    public void init(){
        frame = new JFrame("CALCUL RACINE CARRE");
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 2, true));
        panel.setBackground(Color.WHITE);

                                //entete
        JLabel lblNewLabel = new JLabel("PROJET MVC RACINE CARRE");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lblNewLabel);

                                 //entrer
        inputlabel=new JLabel("Nombre:");
        inputlabel.setFont(new Font("arial",Font.BOLD,22));

        nombre = new JTextField(10);


        button = new JButton("Calculer");
        button.setSize(80,30);
        button.setBackground(Color.LIGHT_GRAY);

        //affichage
        outputlabel = new JLabel("Resultat:");
        outputlabel.setFont(new Font("arial",Font.BOLD,22));

        resultat = new JTextField(10);

        frame.getContentPane().add(panel);
        frame.getContentPane().add(inputlabel);
        frame.getContentPane().add(nombre);
        frame.getContentPane().add(outputlabel);
        frame.getContentPane().add(resultat);
        frame.getContentPane().add(button);
        frame.setLayout(new FlowLayout());
        frame.setLayout(new GridLayout(9,0));
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
                        // mise à jour de la vue
    @Override
    public void update(Observable observable) {
        Modele modele = (Modele) observable;
        JTextField resultat = getResultat();
        resultat.setText(String.valueOf(modele.getNumber()));
    }
}
