package gameHub;

import gameHub.RPSSL.engine.RPS.Engine;
import gameHub.RPSSL.stats.Statistics;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Engine e = new Engine();
        Statistics.setPlayersInResultsMap("Johny");
        e.playRound(0);
        e.playRound(2);
/*        File file = new File("src/main/java/resources/ala.txt");
        Scanner scan = new Scanner("src/main/java/resources/ala.txt");

        String zdanie = scan.nextLine();
        System.out.println(file.getAbsolutePath());
        System.out.println(zdanie);
        System.out.println(file.getName() + " " + file.exists());*/
        Statistics.saveStats();
        e.listFiller();
        List<Integer> theList = e.typeForNext5Rounds();

    }
}
