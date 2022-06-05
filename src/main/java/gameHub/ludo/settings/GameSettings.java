package gameHub.ludo.settings;

import gameHub.ludo.colors.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GameSettings {
    ColorOfPlayer[] defaultSetOfColors = new ColorOfPlayer[]{
            new Red(), new Blue(), new Yellow(), new Green()
    };
    private int[] modesOfGame; //One is a mode, second teamOrNot, third is timeForGame
    private int howManyRealPlayersPlay;
    private boolean playWithComputer;
    private int howManyComputersAccountsPlay;
    private int totalPlayers = howManyRealPlayersPlay + howManyComputersAccountsPlay;
    private ColorOfPlayer[] colorsUsing;
    private String[] nicknames;
    private ColorOfPlayer whoStart;
    Scanner scanner = new Scanner(System.in);
    public void selectModesOfGame() {
        System.out.println("[1] Sandbox - You play solo anyone (computer players or real) not playing with your game");
        System.out.println("[2] Standard - First player witch came to your \"home\" wins");
        System.out.println("[3] NumberOfComesToHome - Players have 5/10/15/ minutes for play and Players getting score for come to yours \"homes\"");
        System.out.println("[4] NumberOfKills - Players have 5/10/15/ minutes for play and Players getting points for killing other players");
        System.out.println("[5] NumberOfPoints - Players have 5/10/15/ min for play and Players getting points for\n" +
                "killing other players and come to yours \"homes\"");
        int selectedOption = scanner.nextInt();
        if(selectedOption > 5 || selectedOption < 1) {
            modesOfGame[0] = selectedOption;
            if (modesOfGame[0] > 1) {
                selectedOption = 10;
                while (selectedOption > 1 || selectedOption < 0) {
                    System.out.println("Because you selected 2, 3, 4 or 5 mode you can select option team or not");
                    System.out.println("If you want's play with teams enter 1 - true or 0 - false");
                    selectedOption = scanner.nextInt();
                }
                if(selectedOption == 1)
                    modesOfGame[1] = 1;
                else
                    modesOfGame[1] = 0;
                if(modesOfGame[0] > 2 && modesOfGame[0] < 6) {
                    selectedOption = 100;
                    while (selectedOption > 4 || selectedOption < 1) {
                        System.out.println("Because you selected 3, 4 or 5 option you can select time have to play");
                        System.out.println("If you want use one of recommended enter number of 1 to 3, else enter 4 and later amount of time");
                        System.out.println("[1] ShortGame - 5 minutes");
                        System.out.println("[2] MediumGame - 10 minutes");
                        System.out.println("[3] LongGame - 15 minutes");
                        System.out.println("[4] IndividualTime - your choice of time, minimum is 1 minute and max is 60 minutes");
                        selectedOption = scanner.nextInt();
                    }
                    if(selectedOption == 4) {
                        selectedOption = 0;
                        while (selectedOption < 1 || selectedOption > 60) {
                            System.out.println("You selected options individualTime and now enter time, min is 1 minute, max is 60 minutes");
                            selectedOption = scanner.nextByte();
                        }
                    }
                    modesOfGame[2] = selectedOption;
                }
            }
        }
    }
    public void howManyRealPlayersPlay() {
        System.out.println("Please enter how many players been played this game");
        int numberOfPlayers = scanner.nextInt();
        while(numberOfPlayers > 4 || numberOfPlayers < 1) {
            System.out.println("Number of players are wrong, you must enter number of player min 1 and max 4");
            numberOfPlayers = scanner.nextInt();
        }
        howManyRealPlayersPlay = numberOfPlayers;
    }
    public void playWithComputer() {
        if(howManyRealPlayersPlay == 4) {
            playWithComputer = false;
            return;
        }
        System.out.println("Do you want play with computer?");
        System.out.println("If you want play solo you and mode game is a not sandbox must enter answer true");
        System.out.println("1 - true");
        System.out.println("0 - false");
        int number = scanner.nextInt();
        if(number > 1 || number < 0)
            playWithComputer();
        if(number == 1)
            playWithComputer = true;
        else
            playWithComputer = false;
        if(playWithComputer)
            howManyComputersAccountsPlay();
        else
            howManyComputersAccountsPlay = 0;
    }
    public void howManyComputersAccountsPlay() {
        if(howManyRealPlayersPlay == 4) {
            System.out.println("Because all of places in game are busy number of computers accounts is set as 0");
            howManyComputersAccountsPlay = 0;
        }
        System.out.println("How many computers accounts wants to play");
        System.out.println("Remember maximum number of player's is 4,\n" +
                "if you want only watch how plays computer accounts set mode of game spectate");
        int number = scanner.nextInt();
        if(number + howManyRealPlayersPlay > 4 || number + howManyRealPlayersPlay < 1)
            howManyRealPlayersPlay();
        else
            howManyComputersAccountsPlay = number;
    }
    public void colorsWitchAreUseToPlay() {
        ColorOfPlayer[] colorsUsing = new ColorOfPlayer[totalPlayers];
        if(colorsUsing.length == 4) {
            colorsUsing = defaultSetOfColors;
            this.colorsUsing = colorsUsing;
            return;
        }
        int[] numbersOfColors = new int[colorsUsing.length];
            System.out.println("Select " + totalPlayers + " been played, select number before color and separate it using enters\n" +
                    "witch are been played," + "if you want use default colors enter 0");
            for (int i = 0; i < numbersOfColors.length; i++) {
                numbersOfColors[i] = scanner.nextInt();
                if(numbersOfColors[i] >= defaultSetOfColors.length || numbersOfColors[i] < 0) {
                    System.out.println("Number isn't section from a 0 to " + (defaultSetOfColors.length - 1));
                    System.out.println("Please enter a correct number");
                    i--;
                }
                if(numbersOfColors[i] == 0) {
                    for (int j = 0; j < numbersOfColors.length; j++) {
                        numbersOfColors[j] = j;
                    }
                    break;
                }
                for (int j = 0; j < i; j++) {
                    if(numbersOfColors[j] == numbersOfColors[i]) {
                        System.out.println("You try to duplicate a color it isn't a allow");
                        System.out.println("Please enter an unique number");
                        i--;
                        break;
                    }
                }
            }
            int counter = 0;
        for (int i = 0; i < defaultSetOfColors.length; i++) {
            for (int j = 0; j < colorsUsing.length; j++) {
                if(defaultSetOfColors[i] == defaultSetOfColors[numbersOfColors[j]]) {
                    colorsUsing[counter] = defaultSetOfColors[numbersOfColors[j]];
                    counter++;
                    break;
                }
            }
        }
        this.colorsUsing =  colorsUsing;
    }
    public void setNicknames() {
        String[] nickNames = new String[colorsUsing.length];
        System.out.println("Do you want replace names of colors nicknames players?");
        System.out.println("1 - true, 0 - false");
        int selectedOption = scanner.nextInt();
        if(selectedOption > 1 || selectedOption < 0)
            setNicknames();
        if(selectedOption == 0)
            return;
        System.out.println("Now you move to setter nicknames, maximum length of nicknames with spaces is 8 symbols");
        for (int i = 0; i < colorsUsing.length; i++) {
            System.out.println("Set nickname for color: " + colorsUsing[i].getName());
            System.out.println("You can't use name one of colors, Red, Blue, Yellow, Green");
            System.out.println("If you want skip some nick use one of names colors (Red, Blue, Yellow, Green)");
            String nickName = scanner.next().toLowerCase().substring(8);
            if(nickName != "red" && nickName != "blue" && nickName != "yellow" && nickName != "green")
                colorsUsing[i].setName(nickName);
        }
        this.nicknames = nickNames;
    }
    public void witchPlayerStartTheGame() {
        System.out.println("Select method which player played first");
        System.out.println("Enter suitable number:");
        System.out.println("1 - Machine draw a first player");
        System.out.println("2 - All players roll a virtual dice and highest number play first,\n" +
                "if higher than one player have been one of the highest this players roll again.");
        System.out.println("3 - In console entered color or nickname this player");
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> drawFirstPlayer(number);
            case 2 -> SelectHighestNumber(number);
            case 3 -> setManual();
            default -> {
                System.out.println("Wrong number");
                witchPlayerStartTheGame();
            }
        }
    }
    public void witchPlayerStartTheGame(int number) {
        System.out.println("Select method which player played first");
        System.out.println("Enter suitable number:");
        System.out.println("1 - Machine draw a first player");
        System.out.println("2 - All players roll a virtual dice and highest number play first,\n" +
                "if higher than one player have been one of the highest this players roll again.");
        System.out.println("3 - In console entered color or nickname this player");
        switch (number) {
            case 1 -> drawFirstPlayer(number);
            case 2 -> SelectHighestNumber(number);
            case 3 -> setManual();
            default -> {
                System.out.println("Wrong number");
                witchPlayerStartTheGame();
            }
        }
    }
    public void drawFirstPlayer(int number) {
        Random random = new Random();
        int temp = random.nextInt(totalPlayers - 1);
        whoStart = colorsUsing[temp];
    }
    public void SelectHighestNumber(int number) {

    }
    public void setManual() {

    }
}
