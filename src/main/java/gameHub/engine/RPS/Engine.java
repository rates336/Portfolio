package gameHub.engine.RPS;


import gameHub.stats.Statistics;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Engine {
    private final LocalDateTime time = LocalDateTime.now();
    protected HashMap<Integer, Double> proportionsMap = new HashMap<>();
    public LocalDateTime getTime() {
        return time;
    }

    protected List<String> listOfPossibilities = new LinkedList<>();
    public List<String> getListOfPossibilities() {
        return listOfPossibilities;
    }
    public void listFiller() {
        listOfPossibilities.add("Rock");
        listOfPossibilities.add("Paper");
        listOfPossibilities.add("Scissors");
    }
    public HashMap<Integer, Double> getProportionsMap() {
        return proportionsMap;
    }
    public List<Integer> typeForNext5Rounds() {
        int[] tab = typeForNext5RoundsToShuffle();
        List<Integer> list = new ArrayList<>();
        if(Statistics.getResults().get(Statistics.getComputer()) >=
                Statistics.getResults().get(Statistics.getUserName())) {
            list.add(tab[0]);
            list.add(tab[0]);
            list.add(tab[1]);
            list.add(tab[0]);
            list.add(tab[1]);
        } else {
            list.add(tab[1]);
            list.add(tab[0]);
            list.add(tab[1]);
            list.add(tab[0]);
            list.add(tab[0]);
        }
        return list;
    }
    public int[] typeForNext5RoundsToShuffle() {
        int[] tab = analyzeMoves(Statistics.getResults().get(Statistics.getRounds()),
                Statistics.getResults().get(Statistics.getComputer()));
        int max = 0;
        int nearMax = 0;
        for (int j : tab) {
            if (j > max) {
                nearMax = max;
                max = j;
            } else if (j > nearMax)
                nearMax = j;

        }
        int[] theTab = {max, nearMax};
        return theTab;
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
                    e.printStackTrace();
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
    public int[] analyzeMoves(int lastNumberRound, int winOfLast25Rounds) {
        double proportions = 100;
        double singleValueProportion =
                proportions / Statistics.getResults().get(Statistics.getRounds());
        int[] sumOfPlayerMoves = Statistics.typeCalculator(Statistics.getStrategicList());
        proportionsMap.put(0, (singleValueProportion * sumOfPlayerMoves[0]));
        proportionsMap.put(1, (singleValueProportion * sumOfPlayerMoves[1]));
        proportionsMap.put(2, (singleValueProportion * sumOfPlayerMoves[2]));
        String[] roundPlayerMoves = Statistics.getStrategicList();
        String[] roundCompMoves = Statistics.getCompTypedList();
        int winInLast5Rounds = 0;
            if(lastNumberRound % 25 == 0) {
                winOfLast25Rounds = 0;
            }
            int[] tab = new int[5];
            for (int j = 0; j < 5; j++) {
                tab[j] = Statistics.getRoundResult().get(lastNumberRound - 5 + j);
                winInLast5Rounds += tab[j];
            }
            winOfLast25Rounds += winInLast5Rounds;
            int counter = 0;
            String temp;
            String oldTemp;
            int[] voteTab = {0, 0, 0};
        for (int i = 0; i < 5; i++) {
            if (lastNumberRound < 10) {
                oldTemp = getListOfPossibilities().get(0);
            } else {
                oldTemp = roundPlayerMoves[lastNumberRound - 6];
            }
            if (tab[counter] == 1) {
                temp = roundPlayerMoves[lastNumberRound - 5];
                if (temp.equals(getListOfPossibilities().get(0)) &&
                        oldTemp.equals(temp)) {
                    voteTab[0]++;
                }
            } else {
                temp = roundPlayerMoves[lastNumberRound - 5];
                if (tab[counter] == 0) {
                    if (temp.equals(listOfPossibilities.get(0)))
                        voteTab[0]++;
                    else {
                        if (temp.equals(listOfPossibilities.get(1)))
                            voteTab[1]++;
                        else
                            voteTab[2]++;
                    }
                } else {
                    if (temp.equals(oldTemp)) {
                        if (Statistics.getRoundResult().get(lastNumberRound - 5 + counter - 1) == -1) {
                            double[] theTabProportions = {getProportionsMap().get(0),
                                    getProportionsMap().get(1), getProportionsMap().get(2)};
                            int numberType = theMaxIndexOfNumber(theTabProportions);
                            if (getProportionsMap().get(0) == theTabProportions[numberType]) {
                                voteTab[0]++;
                            } else {
                                if (getProportionsMap().get(1) == theTabProportions[numberType])
                                    voteTab[1]++;
                                else
                                    voteTab[2]++;
                            }
                        }

                    } else {
                        if (listOfPossibilities.get(0).equals(oldTemp)) {
                            voteTab[0]++;
                        } else {
                            if (listOfPossibilities.get(1).equals(oldTemp))
                                voteTab[1]++;
                            else
                                voteTab[2]++;
                        }
                    }
                }
            }
            counter++;
        }

        return voteTab;
        }

    public static int theMaxIndexOfNumber(double[] tab) {
        double max = -1;
        int maxIndex = -1;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] > max) {
                max = tab[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}
