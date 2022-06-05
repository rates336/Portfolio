package gameHub.ludo.colors;

public interface ColorOfPlayer {
    char colorSymbol = 'e';
    String name = null;
    int[] pawnsPosition = new int[4];
    static String getName(String thisIsStatic) {
        return name;
    }
    String getName();
    int getPawnPosition(int number);
    void setName(String name);
    char getColorSymbol();


}
