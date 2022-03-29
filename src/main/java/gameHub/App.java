package gameHub;

import gameHub.engine.RPS.Engine;
import gameHub.stats.Statistics;

public class App {
    public static void main(String[] args) {
        Engine e = new Engine();
        System.out.println(e.getTime());
        //e.analyzeCompType();
        e.playRound();
        Statistics.setPlayersInResultsMap();
        e.playRound();
    }
}
