import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class BabyNameDataHandler {

    // Lädt die Namensdatensätze aus einer CSV-Datei für ein bestimmtes Jahr
    public List<BabyNameRecord> loadRecords(int year) {
        String fileName = "yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        List<BabyNameRecord> records = new ArrayList<>();

        // Iteriert über jede Zeile in der CSV-Datei und erstellt einen BabyNameRecord
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String name = rec.get(0);
            String gender = rec.get(1);
            int numBorn = Integer.parseInt(rec.get(2));
            records.add(new BabyNameRecord(name, gender, numBorn));
        }
        return records; // Gibt die Liste der Namensdatensätze zurück
    }

    // Gibt eine Liste der verfügbaren Jahre basierend auf den ausgewählten Dateien zurück
    public List<Integer> getAvailableYears() {
        List<Integer> years = new ArrayList<>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String fileName = f.getName();
            int year = Integer.parseInt(fileName.substring(3, 7));
            years.add(year); // Fügt das Jahr zur Liste der Jahre hinzu
        }
        return years; // Gibt die Liste der Jahre zurück
    }
}
