package gameHub.memory.Graphic;

import javax.swing.*;

public class GraphicFrame extends JFrame {
    public GraphicFrame() {
        super("Kon testowy");

        JPanel graphicPanel = new GraphicPanel();
        add(graphicPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
