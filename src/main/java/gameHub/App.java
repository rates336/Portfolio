package gameHub;

import gameHub.engine.RPS.Engine;
import gameHub.stats.Statistics;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Engine e = new Engine();
        System.out.println(e.getTime());
        e.playRound(0);
        Statistics.setPlayersInResultsMap();
        e.playRound(2);
/*        File file = new File("src/main/java/resources/ala.txt");
        Scanner scan = new Scanner("src/main/java/resources/ala.txt");

        String zdanie = scan.nextLine();
        System.out.println(file.getAbsolutePath());
        System.out.println(zdanie);
        System.out.println(file.getName() + " " + file.exists());*/
        System.out.println(Statistics.toStats());
        Statistics.saveStats();

    }
}
