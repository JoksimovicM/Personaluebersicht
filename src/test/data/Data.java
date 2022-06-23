package test.data;

import test.model.Person;
import test.interfaces.ModelListener;

import java.util.Vector;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class Data {

    private static Data instance = null;
    private Vector<Person> personen;
    private ModelListener modelListener;

    private Data() {
        personen = new Vector<>();
        personen.add(new Person("Max", "Muster"));
        personen.add(new Person("Thomas", "Müller"));
        personen.add(new Person("Ana", "Vogel"));
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public void initListen() {

    }

    public Vector<Person> getPersonen() {
        return personen;
    }

    public Person getPerson(int index) {
        return personen.get(index);
    }

    public String getName(int index) {
        return personen.get(index).getFirstName() + " "
                + personen.get(index).getLastName();
    }

    public int getPersonSize() {
        return personen.size();
    }

    public void addPerson(Person person) {
        personen.add(person);
    }

    public void removePerson(int index) {
        personen.remove(index);
    }

    public void removePerson(Person person) {
        personen.remove(person);
    }

    public void createPerson(String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        modelListener.fireContentsChanged(this, 0, -1);
    }

    public void addModelListener(ModelListener modelListener1) {
        modelListener = modelListener1;
    }
}
