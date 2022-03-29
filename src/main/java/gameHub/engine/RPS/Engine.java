package gameHub.engine.RPS;


import gameHub.stats.Statistics;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Engine {
    private final LocalDateTime time = LocalDateTime.now();
    public LocalDateTime getTime() {
        return time;
    }

    List<String> listOfPossibilities = new LinkedList<>();
    public void listFiller() {
        listOfPossibilities.add("Rock");
        listOfPossibilities.add("Paper");
        listOfPossibilities.add("Scissors");
    }
    public void playRound(int computerType) {
        Scanner s = new Scanner(System.in);
        int playerType = s.nextInt();
        if (playerType != 9) {
            if (playerType == computerType) {
                try {
                    Statistics.setResults(Statistics.getComputer(), 0);
                    System.out.println("It's draw.");
                    Statistics.showStats();
                } catch (Exception e) {
                    System.out.println("Error when added results - draw");
                }
            } else {
                if (playerType % 2 == 0 && computerType % 2 == 0) {
                    if (playerType < computerType) {
                        try {
                            Statistics.setResults(Statistics.getUserName(), 1);
                            System.out.println(Statistics.getUserName() + " won round");
                            Statistics.showStats();
                        } catch (Exception e) {
                            System.out.println("Error when added results - player win");
                        }
                    } else {
                        try {
                            Statistics.setResults(Statistics.getComputer(), 1);
                            System.out.println(Statistics.getComputer() + " won round");
                            Statistics.showStats();
                        } catch (Exception e) {
                            System.out.println("Error when added results - Computer win");
                        }
                    }
                } else {
                    if (playerType > computerType) {
                        try {
                            Statistics.setResults(Statistics.getUserName(), 1);
                            System.out.println(Statistics.getUserName() + " won round");
                            Statistics.showStats();
                        } catch (Exception e) {
                            System.out.println("Error when added results - player win");
                        }
                    } else {
                        try {
                            Statistics.setResults(Statistics.getComputer(), 1);
                            System.out.println(Statistics.getComputer() + " won round");
                            Statistics.showStats();
                        } catch (Exception e) {
                            System.out.println("Error when added results - computer win");
                        }
                    }
                }
            }
        } else {
            System.out.println("You finish game");
            String saveOrNot = s.next();

        }

    }
    public void analyzeCompType() {

        System.out.println("test");
    }


}
