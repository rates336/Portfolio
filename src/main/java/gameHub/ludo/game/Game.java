package gameHub.ludo.game;


import gameHub.ludo.colors.ColorOfPlayer;
import gameHub.ludo.settings.GameSettings;

public class Game {
    ColorOfPlayer[] tabOfPlayers;
    public void start(){
        GameSettings gameSettings = new GameSettings();
        gameSettings.selectModesOfGame();
    }
}
