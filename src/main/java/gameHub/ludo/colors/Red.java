package gameHub.ludo.colors;

import gameHub.ludo.colors.ColorOfPlayer;

public class Red implements ColorOfPlayer {
    char colorSymbol = 'd';
    String name;
    int[] pawnsPosition = new int[4];
    public String getName(){
        return name;
    }
    public int getPawnPosition(int number){
        return 0;
    }

    public Red() {
        name = "Red";
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getColorSymbol() {
        return colorSymbol;
    }
}
