package display;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardDisplay extends JPanel {

    static final String[] SUITS = {"S", "H", "C", "D"};
    static final String[] NUMBERS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static final int CARD_WIDTH = 80;
    static final int CARD_HEIGHT = 120;

    private final int suit;
    private final int number;

    public CardDisplay(int number, int suit)
    {
        this.suit = suit;
        this.number = number;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("assets/" + NUMBERS[number] + SUITS[suit] + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, 0, 0, CARD_WIDTH, CARD_HEIGHT, null);
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {
        JFrame frame = buildFrame();
        JPanel pane = new CardDisplay(0, 1);
        frame.add(pane);
    }





}
