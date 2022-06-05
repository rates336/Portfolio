package gameHub.ludo.game;


import gameHub.ludo.colors.ColorOfPlayer;
import gameHub.ludo.settings.GameSettings;

import java.util.Random;

public class Game {
    ColorOfPlayer[] tabOfPlayers;
    int[] tableNextTenMoves = new int[10];
    char[] fieldsOnMap = new char[]{
            'x','x','x','x','x','x','x','x','x','x',    //0-9
            'x','x','x','x','x','x','x','x','x','x',    //10-19
            'x','x','x','x','x','x','x','x','x','x',    //20-29
            'x','x','x','x','x','x','x','x','x','x',    //30-39
            'x'                                         //40
    };
    int[] pawnNumbers = new int[]{
            1,2,3,4,    //Red (d)
            5,6,7,8,    //Blue (a)
            9,10,11,12, //Yellow (c)
            13,14,15,16 //Green (b)
    };
    public void start(){
        GameSettings gameSettings = new GameSettings();
        gameSettings.selectModesOfGame();
        gameSettings.howManyRealPlayersPlay();
        gameSettings.playWithComputer();
        gameSettings.colorsWitchAreUseToPlay();
        gameSettings.setNicknames();
        gameSettings.witchPlayerStartTheGame(1);
    }
    public void move(ColorOfPlayer player) {

    }
    public int rollADice() {
        System.out.println("Rolling a dice");
        System.out.println("...");
        int temp = new Random().nextInt(5) + 1;
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
        int[] fieldPawn = new int[4];
        int counter = 0;
        for (int i = 0; i < fieldsOnMap.length; i++) {
            if(fieldsOnMap[i] == symbol) {
                fieldPawn[counter] = i;
                counter++;
            }
        }
        counter = 1;
        int[] fieldToMovePawn = new int[fieldPawn.length];
        char[] actionsPawn = new char[]{'n','k','s','e','f'};
        for (int i = 0; i < fieldPawn.length; i++) {
            fieldToMovePawn[i] = fieldPawn[i] + number;
            switch (fieldsOnMap[fieldToMovePawn[i]]) {
                case 'x' -> actionsPawn[i] = 'n';
                //case ''
            }
        }
        System.out.println("Options moves is underline: ");
        System.out.println("One pawn is on " + fieldPawn[0] +
                " and you can move to " + fieldPawn[0] + );
        System.out.println("Second pawn is on " + fieldPawn[1]);
        System.out.println("Third pawn is on " + fieldPawn[2]);
        System.out.println("Four pawn is on " + fieldPawn[3]);
    }
}
