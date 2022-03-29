package gameHub.stats;

import java.util.HashMap;

public class Statistics {
    static String userName = "InFuture";
    static String computer = "TurboBell";
    protected static HashMap<String, Integer> results = new HashMap<>();

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
}
