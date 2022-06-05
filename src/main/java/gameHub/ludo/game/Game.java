package gameHub.ludo.game;


import gameHub.ludo.colors.ColorOfPlayer;
import gameHub.ludo.settings.GameSettings;

import java.util.Random;

public class Game {
    ColorOfPlayer[] tabOfPlayers;

    public void start(){
        GameSettings gameSettings = new GameSettings();
        gameSettings.selectModesOfGame();
        gameSettings.howManyRealPlayersPlay();
        gameSettings.playWithComputer();
        gameSettings.colorsWitchAreUseToPlay();
        gameSettings.setNicknames();
        gameSettings.witchPlayerStartTheGame(1);
    }
    public void move() {

    }
    public int rollADice() {
        System.out.println("Rolling a dice");
        System.out.println("...");
        int temp = new Random().nextInt(5) + 1;
        System.out.println("Was thrown: " + temp);
        return temp;
    }
}
