package gameHub.stats;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Statistics {
    static String userName = "SomeUserName";
    static String computer = "TurboBell";
    protected static HashMap<String, Integer> results = new HashMap<>();
    protected static String[] strategicList = new String[1000];
    protected static String[] compTypedList = new String[1000];

    public static void setResults(String name, int someResult) {
        someResult += results.get(name);
        int roundQuantity = results.get("Round Played") + 1;
        results.replace(name, someResult);
        results.replace("Round Played", roundQuantity);
    }
    public static void setPlayersInResultsMap() {
        results.put(userName, 0);
        results.put(computer, 0);
        results.put("Round Played", 0);
    }
    public static String getUserName() {
        return userName;
    }
    public static String getComputer() {
        return computer;
    }
    public static String[] getStrategicList() {
        return strategicList;
    }
    public static String[] getCompTypedList() {
        return compTypedList;
    }
    public static String analyzer(String[] strategicList) {
        int quantityRockShow = 0, quantityPaperShow = 0, quantityScissorsShow = 0;
        int[] tab = new int[3];
        for (String theValue:
             strategicList) {
            tab = switchMachine(theValue);
            System.out.println("test");
        }
        /*for (int i = 0; i < ; i++) {

        }*/
        return "Rock";
    }
    protected static int[] switchMachine(String theValue) {
        int[] tab = {
            0, 0, 0
        };
        switch (theValue) {
            case "Rock" :
                tab[0]++;
                break;
            case "Paper" :
                tab[1]++;
                break;
            case "Scissors" :
                tab[2]++;
                break;
            default:
                return tab;
        }
        return tab;
    }
    public static void showStats() {
        System.out.println(userName + " have: " + Statistics.results.get(userName) + " and " +
                computer + " have: " + Statistics.results.get(computer));
    }
}
