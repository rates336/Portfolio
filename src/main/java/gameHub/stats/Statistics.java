package gameHub.stats;

import java.util.HashMap;

public class Statistics {
    String userName = "InFuture";
    String computer = "TurboBell";
    private HashMap<String, Integer> results = new HashMap<>();

    public void setResults(String name, int someResult) {
        someResult += results.get(name);
        results.replace(name, someResult);
    }
    public void setPlayersInResultsMap() {
        results.put(userName, 0);
        results.put(computer, 0);
    }
}
