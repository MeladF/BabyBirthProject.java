public class BabyNameRecord {
    private String name;
    private String gender;
    private int numBorn;

    // Konstruktor für das BabyNameRecord-Objekt
    public BabyNameRecord(String name, String gender, int numBorn) {
        this.name = name;
        this.gender = gender;
        this.numBorn = numBorn;
    }

    // Getter-Methoden für den Zugriff auf die Felder
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getNumBorn() {
        return numBorn;
    }
}
