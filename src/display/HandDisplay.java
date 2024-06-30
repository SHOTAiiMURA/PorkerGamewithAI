package display;

import poker.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class HandDisplay extends JPanel {
    private Hand hand;

    static float PADDING_RATIO = 0.15F;

    public HandDisplay(Hand hand, int max_cards)
    {
        this.hand = hand;
        setSize(CardDisplay.CARD_WIDTH * max_cards, CardDisplay.CARD_HEIGHT);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        update();
    }

    private void update()
    {
        removeAll();
        for(int i = 0; i < hand.size(); i++)
        {
            Card card = hand.get(i);
            add(new CardDisplay(card));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize((int)(CardDisplay.CARD_WIDTH * 5 * (1 + PADDING_RATIO)), 200);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {
        JFrame frame = buildFrame();

        Hand hand = new HandImp();
        hand.addCard(new CardImp(0, CardSuit.SPADES));
        hand.addCard(new CardImp(0, CardSuit.HEARTS));
        hand.addCard(new CardImp(0, CardSuit.CLUBS));
        hand.addCard(new CardImp(0, CardSuit.DIAMONDS));
        JPanel pane = new HandDisplay(hand, 5);
        frame.add(pane);
    }





}
