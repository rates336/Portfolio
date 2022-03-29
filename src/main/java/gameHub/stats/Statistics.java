package gameHub.stats;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Statistics {
    static String userName = "SomeUserName";
    static String computer = "TurboBell";
    static String rounds = "Round Played: ";
    protected static HashMap<String, Integer> results = new HashMap<>();
    protected static String[] strategicList = new String[1000];
    protected static String[] compTypedList = new String[1000];

    public static void setResults(String name, int someResult) {
        someResult += results.get(name);
        int roundQuantity = results.get("Round Played") + 1;
        results.replace(name, someResult);
        results.replace(rounds, roundQuantity);
    }
    public static void setPlayersInResultsMap() {
        results.put(userName, 0);
        results.put(computer, 0);
        results.put(rounds, 0);
    }
    public static String getUserName() {
        return userName;
    }
    public static String getComputer() {
        return computer;
    }
    public static String getRounds() {
        return rounds;
    }
    public static String[] getStrategicList() {
        return strategicList;
    }
    public static String[] getCompTypedList() {
        return compTypedList;
    }
    protected static int[] typeCalculator(String[] theValue) {
        int[] tab = {
            0, 0, 0
        };
        for (String value:
             theValue) {
            switch (value) {
                case "Rock":
                    tab[0]++;
                    break;
                case "Paper":
                    tab[1]++;
                    break;
                case "Scissors":
                    tab[2]++;
                    break;
                default:
                    return tab;
            }
        }
        return tab;
    }
    public static String toStats() {
/*        int[] tab = typeCalculator(getStrategicList());
        int[] tab2 = typeCalculator(getCompTypedList());*/
        int[] tab = {0, 0, 0};
        int[] tab2 = {0, 0, 0};
        return "Statistic \n\n" +
                getUserName() + ":\n" +
                "have " + results.get(getUserName()) + " wins, " +
                results.get(getComputer()) + " loses and " +
                (results.get(getRounds()) - results.get(getUserName()) - results.get(getComputer())) +
                " draws,\n" + rounds + results.get(rounds) +
                "and showed rock: " + tab[0] + ", paper: " + tab[1] + ", scissors: " + tab[2] + "\n\n" +
                computer + ":\n" +
                "Showed rock: " + tab2[0] + ", paper: " + tab2[1] + ", scissors: " + tab2[2];
    }

    public static void showStats() {
        System.out.println(userName + " have: " + Statistics.results.get(userName) + " and " +
                computer + " have: " + Statistics.results.get(computer));
    }
    public static void saveStats() {
        Random r = new Random();
        String fileName = Statistics.getUserName() + "_" + r.nextInt(1_000_000) + "_PJ4T3K";
        String defaultPathSection = "src/main/resources";
        String pathFile = defaultPathSection + fileName + ".txt";
        Path path = Paths.get(pathFile);
        try {
            if (Files.notExists(path)) {
                File theFile = new File(pathFile);
                PrintWriter editFile = new PrintWriter(pathFile);
                editFile.print(toStats());
                editFile.close();
            } else {
                fileName = Statistics.getUserName() + "_" + r.nextInt(1_000_000) + "_PJ4T3K";
                path = Paths.get((defaultPathSection + fileName));
                if (Files.notExists(path)) {
                    File theFile = new File(fileName);
                } else {
                    System.out.println("Please enter some name file, algorytm not properly");
                    fileName = new Scanner(System.in).next() + r.nextInt(1_000_000);
                }
            }
            System.out.println(Files.readAllLines(path));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error when try to save file");
            System.out.println("You can manually save your stats");
            showStats();
        }

    }
}
