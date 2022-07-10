package gameHub.memory;

import gameHub.memory.Graphic.GraphicPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class App {
    File imgFile = new File("C:\\Portfolio\\src\\main\\resources\\pjatk.png");
    private BufferedImage selectedStyleCards;
    public static void main(String[] args) {
        App app = new App();
        JFrame jFrame = new JFrame();
        try {
            app.selectedStyleCards = ImageIO.read(app.imgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Button newGame = new Button("New Game");
        Button highScores = new Button("High Scores");
        Button exit = new Button("Exit");
        Button selectStyle = new Button("Select Style");
        newGame.setBackground(Color.LIGHT_GRAY);
        exit.setBackground(Color.RED);
        highScores.setBackground(Color.ORANGE);
        selectStyle.setBackground(Color.CYAN);
        app.setFunctionInButtons(jFrame, newGame, exit, highScores, selectStyle);
        //in future high scores if this game better than last game button is green,
        // else option pink, but when is the best score button have gold color


        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(1080,720);
        //jFrame.setLayout(new BorderLayout());

        jFrame.add(newGame, BorderLayout.CENTER);
        jFrame.add(highScores, BorderLayout.AFTER_LINE_ENDS);
        jFrame.add(selectStyle, BorderLayout.PAGE_START);
        jFrame.add(exit, BorderLayout.AFTER_LAST_LINE);
        jFrame.setVisible(true);
        JFrame test = new JFrame();
        try {
            test.add(new GraphicPanel(app.selectedStyleCards));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Color drawColor() {
        Random random = new Random();

        return new Color((int) (random.nextDouble() * 255), (int) (random.nextDouble() * 255), (int) (random.nextDouble() * 255));
    }

    public void setFunctionInButtons(JFrame jFrame, Button newGame, Button exit,
                                     Button highScores, Button selectStyle) {
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("It is test");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
            }
        });

        selectStyle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame toSelect = new JFrame();
                BufferedImage kon, pjatk;

                File fileKon = new File("C:\\Portfolio\\src\\main\\resources\\kon.png");
                File filePJATK = new File("C:\\Portfolio\\src\\main\\resources\\pjatk.png");
                try {
                    kon = ImageIO.read(fileKon);
                    pjatk = ImageIO.read(filePJATK);
                    GraphicPanel gp = new GraphicPanel();
                    Button btnKonSelect = new Button("Select Chess");
                    Button btnPJATKSelect = new Button("Select PJATK");
                    Dimension konBtn = new Dimension(kon.getWidth(), 25);
                    Dimension pjatkBtn = new Dimension(pjatk.getWidth(), 25);
                    btnKonSelect.setPreferredSize(konBtn);
                    btnPJATKSelect.setPreferredSize(pjatkBtn);
                    Dimension theDim = new Dimension(300, 200);
                    gp.setPreferredSize(theDim);
                    GridLayout gl = new GridLayout(2,3);
                    gl.setVgap(25);
                    gl.setHgap(25);
                    btnKonSelect.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                selectedStyleCards = ImageIO.read(fileKon);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            } finally {
                                System.out.println("Selected card style is ");
                                JPanel jPanel = new JPanel();
                                /*try {
                                    jPanel.paintComponents();
                                } catch (Exception ex) {

                                }*/
                            }
                        }
                    });
                    gp.add(btnKonSelect);
                    gp.add(btnPJATKSelect);
                    toSelect.setLayout(gl);

                    System.out.println(gl.toString());
                    btnKonSelect.setLocation(kon.getWidth() + gp.getIndentationLine(),
                            kon.getHeight() + gp.getIndentationPage() + 20);

                    toSelect.add(gp);
                    toSelect.pack();
                    toSelect.setVisible(true);


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
