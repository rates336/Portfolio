package gameHub.ludo.colors;

import gameHub.ludo.colors.ColorOfPlayer;

public class Yellow implements ColorOfPlayer {
    char colorSymbol = 'c';
    String name;
    int[] pawnsPosition = new int[4];
    public String getName(){
        return name;
    }
    public int getPawnPosition(int number){
        return 0;
    }

    public Yellow() {
        name = "Yellow";
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getColorSymbol() {
        return colorSymbol;
    }
}
