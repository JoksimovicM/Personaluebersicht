package test.facade;

import test.data.Data;
import test.gui.listener.ListListener;
import test.interfaces.ModelListener;
import test.model.Person;

import javax.swing.*;
import java.util.Vector;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class PersonListeModel extends DefaultListModel implements ModelListener {

    private String name = null;

    private JList liste = new JList<>();

    public PersonListeModel() {
        Facade.getInstance().addModelListener(this);
    }

    public String getElementAt(int index) {
        return Facade.getInstance().getPerson(index).getFullName();
    }

    public int getPersonSize() {
        return Facade.getInstance().getAnzahlPersonen();
    }

    public int getSize() {
        return Facade.getInstance().getAllePersonen().size();
    }

    @Override
    public void fireContentsChanged(Object object, int index0, int index1) {
        if (index1 == 1) {
            super.fireContentsChanged(object, index0, getSize());
        } else {
            super.fireContentsChanged(object, index0, index1);
        }
    }
}
