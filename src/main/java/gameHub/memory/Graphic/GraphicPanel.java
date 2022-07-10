package gameHub.memory.Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicPanel extends JPanel{
    private BufferedImage konImage;
    private BufferedImage pjatkImage;
    private BufferedImage selectedImg;
    private final int indentationPage = 50, indentationLine = 25;
    boolean temp = true;
    public GraphicPanel() {
        super();

        File imageFile = new File("C:\\Portfolio\\src\\main\\resources\\kon.png");
        File imageFile2 = new File("C:\\Portfolio\\src\\main\\resources\\pjatk.png");
        try {
            konImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Fatal error while try to read file");
            System.out.println(imageFile.getAbsolutePath());
            e.printStackTrace();
        }

        try {
            pjatkImage = ImageIO.read(imageFile2);
        } catch (IOException e) {
            System.err.println("Fatal error while try to read file");
            System.out.println(imageFile2.getAbsolutePath());
            e.printStackTrace();
        }

        Dimension dimension = new Dimension(konImage.getWidth() + pjatkImage.getWidth() + 100,
                konImage.getHeight() + pjatkImage.getHeight() + 100);
        Dimension dimension2 = new Dimension();
        setPreferredSize(dimension);
    }
    public GraphicPanel(BufferedImage img) {
        super();
        temp = false;
        selectedImg = img;
        Dimension dimension = new Dimension(300, 200);
        setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(temp) {
            g2d.drawImage(konImage, indentationLine, indentationPage, this);
            g2d.drawImage(pjatkImage, indentationLine + konImage.getWidth() + 25, indentationPage, this);
        } else {
            g2d.drawImage(selectedImg, 50, 50,this);
        }

    }

    public int getIndentationPage() {
        return indentationPage;
    }

    public int getIndentationLine() {
        return indentationLine;
    }
}
