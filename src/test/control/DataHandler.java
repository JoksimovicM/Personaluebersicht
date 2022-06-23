package test.control;


/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class DataHandler {

    /*private static List<Person> personListe;

    private static void readJSON() {
        try {
            String path = "src/test/data/personen.json";
            byte[] jsonData = Files.readAllBytes(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            Person[] personen = objectMapper.readValue(jsonData, Person[].class);
            for (Person person : personen) {
                getPersonListe().add(person);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String path = "src/test/data/personen.json";
        try {
            fileOutputStream = new FileOutputStream(path);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, personListe);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Person> getPersonListe() {
        if (personListe == null) {
            setPersonListe(new ArrayList<>());
            readJSON();
        }
        return personListe;
    }

    private static void setPersonListe(List<Person> personListe) {
        DataHandler.personListe = personListe;
    }*/
}
