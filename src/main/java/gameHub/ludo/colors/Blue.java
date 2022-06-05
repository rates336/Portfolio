package gameHub.ludo.colors;

import gameHub.ludo.colors.ColorOfPlayer;

public class Blue implements ColorOfPlayer {
    String name;
    int[] pawnsPosition = new int[4];
    public String getName(){
        return name;
    }
    public int getPawnPosition(int number){
        return 0;
    }

    public Blue() {
        name = "Blue";
    }
    public void setName(String name) {
        this.name = name;
    }
}
