import java.util.List;

public class BabyNameAnalyzer {
    private BabyNameDataHandler dataHandler;

    // Konstruktor, der den Datenhandler injiziert
    public BabyNameAnalyzer(BabyNameDataHandler handler) {
        this.dataHandler = handler;
    }

    // Methode zur Ermittlung des Rangs eines Namens in einem bestimmten Jahr
    public int getRank(String name, int year, String gender) {
        List<BabyNameRecord> records = dataHandler.loadRecords(year);
        int rank = 1;
        for (BabyNameRecord record : records) {
            // Überprüft, ob das Geschlecht übereinstimmt
            if (record.getGender().equals(gender)) {
                // Überprüft, ob der Name übereinstimmt
                if (record.getName().equals(name)) {
                    return rank;
                }
                rank++;
            }
        }
        return -1; // Wenn der Name nicht gefunden wird
    }

    // Methode zur Ermittlung des Namens an einem bestimmten Rang in einem bestimmten Jahr
    public String getName(int year, int rank, String gender) {
        List<BabyNameRecord> records = dataHandler.loadRecords(year);
        int currentRank = 1;
        for (BabyNameRecord record : records) {
            // Überprüft, ob das Geschlecht übereinstimmt
            if (record.getGender().equals(gender)) {
                // Wenn der aktuelle Rang dem gewünschten Rang entspricht, wird der Name zurückgegeben
                if (currentRank == rank) {
                    return record.getName();
                }
                currentRank++;
            }
        }
        return "NO Name"; // Wenn kein Name an dem Rang gefunden wird
    }

    // Methode zur Ermittlung des Jahres, in dem ein Name den höchsten Rang hatte
    public int yearOfHighestRank(String name, String gender) {
        int highestRank = Integer.MAX_VALUE; // Initialisiert mit einem sehr großen Wert
        int yearOfHighestRank = -1;
        List<Integer> years = dataHandler.getAvailableYears();

        for (int year : years) {
            int currentRank = getRank(name, year, gender);
            // Überprüft, ob der aktuelle Rang besser (kleiner) ist als der bisher höchste Rang
            if (currentRank != -1 && currentRank < highestRank) {
                highestRank = currentRank;
                yearOfHighestRank = year;
            }
        }
        return yearOfHighestRank; // Gibt das Jahr mit dem höchsten Rang zurück
    }

    // Methode zur Berechnung des durchschnittlichen Rangs eines Namens über alle verfügbaren Jahre
    public double getAverageRank(String name, String gender) {
        int totalRank = 0;
        int count = 0;
        List<Integer> years = dataHandler.getAvailableYears();

        for (int year : years) {
            int currentRank = getRank(name, year, gender);
            // Zählt nur, wenn der Name in dem Jahr einen Rang hat
            if (currentRank != -1) {
                totalRank += currentRank;
                count++;
            }
        }

        if (count == 0) {
            return -1.0; // Gibt -1 zurück, wenn der Name in keinem Jahr einen Rang hatte
        }
        return (double) totalRank / count; // Durchschnittsberechnung
    }

    // Methode zur Berechnung der Gesamtzahl der Geburten, die einen höheren Rang als ein bestimmter Name haben
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        List<BabyNameRecord> records = dataHandler.loadRecords(year);
        int totalBirths = 0;

        for (BabyNameRecord record : records) {
            if (record.getGender().equals(gender)) {
                if (record.getName().equals(name)) {
                    break; // Beendet die Schleife, sobald der Name erreicht wird
                } else {
                    totalBirths += record.getNumBorn(); // Addiert die Geburtenzahl für Namen mit höherem Rang
                }
            }
        }
        return totalBirths; // Gibt die Gesamtzahl der Geburten für höher gerankte Namen zurück
    }
}
