package gameHub.memory.Graphic;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame {

    public MyFrame() {
        super( "Not Hello World" );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocation(50,50);

        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 2"));
        add(new JButton("Przycisk 3"));

        setVisible(true);
    }

}