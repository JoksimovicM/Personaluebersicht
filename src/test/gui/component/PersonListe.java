package test.gui.component;

import test.facade.PersonListeModel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class PersonListe extends JPanel {

    private JFrame besitzer;
    private JList<String> liste = new JList<>();
    private JScrollPane scrollPane;
    private JLabel ueberschrift = new JLabel("Überschrift:");

    public PersonListe(JFrame besitzer) {
        this.besitzer = besitzer;
        scrollPane = new JScrollPane(liste);
        init();
    }

    public void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        scrollPane.setPreferredSize(new Dimension(120, 330));
        liste.setModel(new PersonListeModel());

        c.gridy = 0;
        add(ueberschrift, c);
        c.gridy = 1;
        c.weighty = 1.0;
        add(scrollPane, c);
        setPreferredSize(new Dimension(120,350));
    }
}
