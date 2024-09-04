public class BabyNameAnalyzerTest {
    public static void main(String[] args) {
        // Erstellt den Datenhandler und den Analyzer
        BabyNameDataHandler handler = new BabyNameDataHandler();
        BabyNameAnalyzer analyzer = new BabyNameAnalyzer(handler);

        // Testaufrufe der Methoden
        System.out.println("Rank of Frank in 1971: " + analyzer.getRank("Frank", 1971, "M"));
        System.out.println("Name ranked 450 in 1982 (Male): " + analyzer.getName(1982, 450, "M"));
        System.out.println("Year with highest rank for Mich (Male): " + analyzer.yearOfHighestRank("Mich", "M"));
        System.out.println("Average rank for Robert (Male): " + analyzer.getAverageRank("Robert", "M"));
        System.out.println("Total births ranked higher than Drew in 1990 (Male): " + analyzer.getTotalBirthsRankedHigher(1990, "Drew", "M"));

        // Zusätzliche Tests können hi  er hinzugefügt werde
    }
}