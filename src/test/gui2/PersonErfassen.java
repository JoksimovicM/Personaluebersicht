package test.gui2;

import test.data.Data;
import test.facade.Facade;
import test.facade.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Morris Idahosa
 * @version 1.0
 * @date    21.06.2022
 */

public class PersonErfassen extends JDialog {

    private Data ref;
    private PersonErfassen self;

    private JLabel name;
    private JLabel foto;
    private JLabel leer;
    private JLabel hr;
    private JLabel admin;
    private JTextField nameTextField;
    private JCheckBox checkBoxHr;
    private JCheckBox checkBoxAdmin;
    private JButton abbrechen;
    private JButton speichern;
    private JPanel nameFotoPanel;
    private JPanel hrAdminPanel;
    private JPanel hrAdminLeerPanel;
    private JPanel buttonPanel;
    private JPanel leerButtonPanel;

    public PersonErfassen(JFrame parent, boolean modal) {
        super(parent, modal);
        this.self = this;

        ref = Data.getInstance();

        setTitle("Person erfassen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));

        name = new JLabel("Name:");
        foto = new JLabel("Foto:");
        leer = new JLabel("");
        hr = new JLabel("HR-Mitarbeiter:");
        admin = new JLabel("Administrator:");
        nameTextField = new HintTextField("Vorname Nachname");
        checkBoxHr = new JCheckBox();
        checkBoxAdmin = new JCheckBox();
        abbrechen = new JButton("Abbrechen");
        abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        speichern = new JButton("Speichern");
        nameFotoPanel = new JPanel(new GridLayout(2, 2));
        hrAdminPanel = new JPanel(new GridLayout(2, 2));
        hrAdminLeerPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel = new JPanel(new GridLayout(1, 2));
        leerButtonPanel = new JPanel(new GridLayout(1, 2));

        nameFotoPanel.add(name);
        nameFotoPanel.add(nameTextField);
        nameFotoPanel.add(foto);
        nameFotoPanel.add(leer);

        hrAdminPanel.add(hr);
        hrAdminPanel.add(checkBoxHr);
        hrAdminPanel.add(admin);
        hrAdminPanel.add(checkBoxAdmin);
        hrAdminLeerPanel.add(hrAdminPanel);
        hrAdminLeerPanel.add(leer);

        buttonPanel.add(abbrechen);
        buttonPanel.add(speichern);
        leerButtonPanel.add(leer);
        leerButtonPanel.add(buttonPanel);

        getContentPane().add(nameFotoPanel, BorderLayout.NORTH);
        getContentPane().add(hrAdminLeerPanel, BorderLayout.CENTER);
        getContentPane().add(leerButtonPanel, BorderLayout.SOUTH);

        speichern.addActionListener(new ButtonListener());

        setSize(350, 500);
        setResizable(false);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Facade f = Facade.getInstance();
            String[] splitted = nameTextField.getText().split(" ");
            if (nameTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(self, "Must type in a name!");
            } else if (splitted.length < 2) {
                JOptionPane.showMessageDialog(self, "Must type in first and last name!");
            } else {
                String fName = nameTextField.getText().split(" ")[0];
                String lName = nameTextField.getText().split(" ")[1];
                f.createPerson(fName, lName);
                self.dispose();
            }
        }
    }
}
