package gameHub.engine.RPS;


import gameHub.stats.Statistics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
    public void playRound() {
        Scanner s = new Scanner(System.in);
        int playerType = s.nextInt();
        //I am not use seconds because it's near to random choice
        int computerType =
                ((getTime().getHour() % 3) * 2 + (getTime().getMinute() + 5)) % 3;
        if(playerType == computerType) {
            try {
                Statistics.setResults(Statistics.getComputer(), 0);
            } catch (Exception e) {
                System.out.println("Error when added results - draw");
            }
        } else {
            if(playerType % 2 == 0 && computerType % 2 == 0) {
                if(playerType < computerType) {
                    try {
                        Statistics.setResults(Statistics.getUserName(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - player win");
                    }
                } else {
                    try {
                        Statistics.setResults(Statistics.getComputer(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - Computer win");
                    }
                }
            } else {
                if(playerType > computerType) {
                    try {
                        Statistics.setResults(Statistics.getUserName(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - player win");
                    }
                } else {
                    try {
                        Statistics.setResults(Statistics.getComputer(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - computer win");
                    }
                }
            }
        }


    }
    public void playRound(int compType) {
        Scanner s = new Scanner(System.in);
        int playerType = s.nextInt();
        //I am not use seconds because it's near to random choice
        int computerType = -1;
        try {
            computerType = compType;
        } catch (Exception e) {
            System.out.println("");
        }
       //How to set Exception for transfer number > 2
        if(playerType == computerType) {
            try {
                Statistics.setResults(Statistics.getComputer(), 0);
            } catch (Exception e) {
                System.out.println("Error when added results - draw");
            }
        } else {
            if(playerType % 2 == 0 && computerType % 2 == 0) {
                if(playerType < computerType) {
                    try {
                        Statistics.setResults(Statistics.getUserName(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - player win");
                    }
                } else {
                    try {
                        Statistics.setResults(Statistics.getComputer(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - Computer win");
                    }
                }
            } else {
                if(playerType > computerType) {
                    try {
                        Statistics.setResults(Statistics.getUserName(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - player win");
                    }
                } else {
                    try {
                        Statistics.setResults(Statistics.getComputer(), 1);
                    } catch (Exception e) {
                        System.out.println("Error when added results - computer win");
                    }
                }
            }
        }


    }
    public int whoWin(String someType) {

        return -1;
    }



}
