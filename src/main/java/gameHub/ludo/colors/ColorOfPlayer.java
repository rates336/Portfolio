package gameHub.ludo.colors;

public interface ColorOfPlayer {
    String name = null;
    int[] pawnsPosition = new int[4];
    static String getName() {
        return name;
    }
    int getPawnPosition(int number);


}
