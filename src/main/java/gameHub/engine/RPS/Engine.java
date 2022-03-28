package gameHub.engine.RPS;


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
        String playerType = s.next();
        //I am not use seconds because it's near to random choice
        String opponentType = listOfPossibilities.get(
                ((getTime().getHour() % 3) * 2 + (getTime().getMinute() + 5)) % 3);

    }
    public int whoWin(String someType) {

        return -1;
    }



}
