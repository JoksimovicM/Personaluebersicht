package test.model;

public class Person {
    //private ImageIcon photo;
    private String firstName;
    private String lastName;

    //private Participation participation;

    public Person(String fName, String lName) {
        setFirstName(fName);
        setLastName(lName);
        //setPhoto(photo);
    }

    /*public ImageIcon getPhoto() {
        return photo;
    }*/

    /*public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
