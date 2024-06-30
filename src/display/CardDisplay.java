package display;

import poker.Card;
import poker.CardImp;
import poker.CardSuit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardDisplay extends JPanel {

    static final String[] SUITS = {"S", "H", "D", "C"};
    static final String[] NUMBERS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static final int CARD_WIDTH = 80;
    static final int CARD_HEIGHT = 120;

    private final int suit;
    private final int number;

    public CardDisplay(Card card)
    {
        this.suit = card.getSuit().ordinal();
        this.number = card.getNumber();
        setSize(CARD_WIDTH, CARD_HEIGHT);
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
        Card card = new CardImp(0, CardSuit.CLUBS);
        JPanel pane = new CardDisplay(card);
        frame.add(pane);
    }





}
