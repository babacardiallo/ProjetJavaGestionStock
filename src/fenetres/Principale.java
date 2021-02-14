package fenetres;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class Principale extends JFrame {


    private JFrame frame;
    private JPanel panel;
    private JButton produit = new JButton("Produit");

    public Principale() {
        initFenetre();
    }

    public void initFenetre() {
        produit.setBackground(new Color(255, 255, 255));
        frame = new JFrame("Gestion de stock");
        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBackground(new Color(10, 118, 127));
        panel.add(produit);
        frame.add(panel);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
