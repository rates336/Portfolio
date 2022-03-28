package gameHub;

import gameHub.engine.RPS.Engine;

public class App {
    public static void main(String[] args) {
        Engine e = new Engine();
        System.out.println(e.getTime());
    }
}
