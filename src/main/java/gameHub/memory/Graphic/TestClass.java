package gameHub.memory.Graphic;

import java.awt.*;

public class TestClass {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphicFrame();
                new MyFrame();
            }
        });
    }

}
