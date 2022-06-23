package test.gui2;

import test.data.Data;
import test.gui.listener.ListListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class Test extends JFrame {

    private Data data = Data.getInstance();

    public Test() {
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<String>();
        for (int i = 0; i < data.getPersonSize(); i++) {
            model.addElement(data.getName(i));
        }
        JLabel label = new JLabel("Test");

        JList liste = new JList<>();
        JScrollPane scrollPane = new JScrollPane(liste);
        liste.setModel(model);
        model.addListDataListener(new ListListener(model));

        getContentPane().add(label, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new Test();
    }
}
