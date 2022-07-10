package gameHub.ludo.game;


import gameHub.ludo.colors.*;
import gameHub.ludo.settings.GameSettings;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    ColorOfPlayer[] tabOfPlayers;
    int[] tableNextTenMoves = new int[10];
    int[] tableOfPawnWhichFinish = new int[4];
    char[] queue = new char[]{'d','a','b','c'};
    char[] fieldsOnMap = new char[]{
            'x','x','x','x','x','x','x','x','x','x',    //0-9
            'x','x','x','x','x','x','x','x','x','x',    //10-19
            'x','x','x','x','x','x','x','x','x','x',    //20-29
            'x','x','x','x','x','x','x','x','x','x',    //30-39
            'x','h'                                     //40, home
    };
    int[] pawnNumbers = new int[]{
            1,2,3,4,    //Red (d)
            5,6,7,8,    //Blue (a)
            9,10,11,12, //Yellow (c)
            13,14,15,16 //Green (b)
    };
    int[] fieldPawn;
    public void start(){
        GameSettings gameSettings = new GameSettings();
        gameSettings.selectModesOfGame();
        gameSettings.howManyRealPlayersPlay();
        gameSettings.playWithComputer();
        gameSettings.colorsWitchAreUseToPlay();
        gameSettings.setNicknames();
        gameSettings.witchPlayerStartTheGame(1);
        int whoPlayNow = findColorPosition(gameSettings.getWhoStart().getColorSymbol());
        move(queue[whoPlayNow]);
        whoPlayNow = queueOperator(whoPlayNow);
        move(queue[whoPlayNow]);


    }
    public int findColorPosition(char symbol) {
        for (int i = 0; i < queue.length; i++) {
            if(queue[i] == symbol) {
                return i;
            }
        }
        return -1;
    }
    public int queueOperator(int number) {
        if(number == queue.length - 1)
            return 0;
        else
            return number + 1;
    }
    public void move(char symbol) {
        boolean onBoardOrNot = false;
        for (char temp : fieldsOnMap) {
            if (temp == symbol) {
                onBoardOrNot = true;
                break;
            }
        }
        if(onBoardOrNot) {
            normalRolls(symbol);
        } else {
            if(tryToGetOutFromBase()){
                switch (symbol) {
                    case 'a' -> fieldsOnMap[0] = new Blue().getColorSymbol();
                    case 'b' -> fieldsOnMap[10] = new Green().getColorSymbol();
                    case 'c' -> fieldsOnMap[20] = new Yellow().getColorSymbol();
                    case 'd' -> fieldsOnMap[30] = new Red().getColorSymbol();
                }
            }
        }
    }
    public void normalRolls(char symbol) {

        int rollResult = rollADice();
        showOptionsHowPlayerCanMove(symbol, rollResult);
        int userAns = scanner.nextInt();
        while (userAns > 4 || userAns < 1) { // 0 in future is automove
            userAns = scanner.nextInt();
        }
        fieldsOnMap[fieldPawn[userAns]] = 'x';
        if(symbol == 'd' && fieldPawn[userAns] + rollResult > 30 && fieldPawn[userAns] < 30)
            tableOfPawnWhichFinish[0]++;
        else
            if(symbol == 'a' && fieldPawn[userAns] + rollResult > 40 && fieldPawn[userAns] < 40)
                tableOfPawnWhichFinish[1]++;
            else
                if(symbol == 'b' && fieldPawn[userAns] + rollResult > 10 && fieldPawn[userAns] < 10)
                    tableOfPawnWhichFinish[2]++;
                else
                    if(symbol == 'c' && fieldPawn[userAns] + rollResult > 20 && fieldPawn[userAns] < 20)
                        tableOfPawnWhichFinish[3]++;
                    else
                        fieldsOnMap[fieldPawn[userAns] + rollResult] = symbol;

    }
    public boolean tryToGetOutFromBase(){
        int remainingTimes = 3;
        int resultOfRoll;
        while (remainingTimes > 0) {
            resultOfRoll = rollADice();
            if(resultOfRoll != 6)
                remainingTimes--;
            else {
                return true;
            }

        }
        return false;
    }
    public int rollADice() {
        System.out.println("Rolling a dice");
        System.out.println("...");
        int temp = new Random().nextInt(6) + 1;
        System.out.println("Was thrown: " + temp);
        return temp;
    }
    public int[] tableNextRollingADice(int numberToDraw) {
        int[] tab = new int[numberToDraw];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = rollADice();
        }
        return tab;
    }
    public void showNumberOfPawnsForSomethingColor(char symbol) {
        switch (symbol) {
            case 'd' -> System.out.println("1, 2, 3, 4");
            case 'a' -> System.out.println("5, 6, 7, 8");
            case 'c' -> System.out.println("9, 10, 11, 12");
            case 'b' -> System.out.println("13, 14, 15, 16");
            default -> System.out.println("Wrong Symbol");
        }
    }
    public void showOptionsHowPlayerCanMove(char symbol, int number) {
        fieldPawn = new int[4];
        int counter = 0;
        for (int i = 0; i < fieldsOnMap.length; i++) {
            if(fieldsOnMap[i] == symbol) {
                fieldPawn[counter] = i;
                counter++;
            }
        }

        int[] fieldToMovePawn = new int[fieldPawn.length];
        String[] actionsPawn = new String[fieldToMovePawn.length];
        for (int i = 0; i < fieldPawn.length; i++) {
            fieldToMovePawn[i] = fieldPawn[i] + number;
            if(fieldsOnMap[fieldToMovePawn[i]] == 'x') {
                actionsPawn[i] = "Normal move";
            } else {
                if(fieldsOnMap[fieldToMovePawn[i]] == symbol) {
                    actionsPawn[i] = "Support";
                } else {
                    if(fieldsOnMap[fieldToMovePawn[i]] == 'h' /*&& to drugi warunek*/) {
                        actionsPawn[i] = "Finish";
                    } else {
                        actionsPawn[i] = "Kill";
                    }
                }
            }
        }
        counter = 0;
        System.out.println("Options moves is underline: ");

        System.out.println("First pawn is on " + fieldPawn[counter] + " and you can move to " +
                fieldPawn[counter] + " action in the move: " + actionsPawn[counter]);
        counter++;
        System.out.println("First pawn is on " + fieldPawn[counter] + " and you can move to " +
                fieldPawn[counter] + " action in the move: " + actionsPawn[counter]);
        counter++;
        System.out.println("First pawn is on " + fieldPawn[counter] + " and you can move to " +
                fieldPawn[counter] + " action in the move: " + actionsPawn[counter]);
        counter++;
        System.out.println("First pawn is on " + fieldPawn[counter] + " and you can move to " +
                fieldPawn[counter] + " action in the move: " + actionsPawn[counter]);

    }
}
