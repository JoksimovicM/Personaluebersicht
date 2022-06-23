package test.facade;

import test.data.Data;
import test.interfaces.ModelListener;
import test.model.Person;

import java.util.Vector;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class Facade {

    private static Facade instance;
    private Data data = Data.getInstance();
    private ModelListener modelListener;

    private Facade() {
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public void setModelListener(ModelListener modelListener) {
        this.modelListener = modelListener;
    }

    public int getAnzahlPersonen() {
        return data.getPersonSize();
    }

    public Vector<Person> getAllePersonen() {
        return data.getPersonen();
    }

    public Person getPerson(int index) {
        return getAllePersonen().get(index);
    }

    public void fireChanges() {
        modelListener.fireContentsChanged(this, 0, -1);
    }

    public void createPerson(String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        data.addPerson(person);
        fireChanges();
    }
}
