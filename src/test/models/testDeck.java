package models;

import org.junit.Test;

public class deckTest {
    @Test
    public void testDraw(){
        Deck deck = new Deck();
        deck.takeTopCard();
    }

    @Test
    public void testBuild(){
        Deck deck = new Deck();
    }
}
