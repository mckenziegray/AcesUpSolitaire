package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class CardTest {

    Card card = new Card(5, Suit.Spades);

    @Test
    public void getSuitTest() {
        Suit suit = card.getSuit();
        assertEquals(Suit.Spades,suit);
    }

    @Test
    public void getValueTest() {
        int val = card.getValue();
        assertEquals(5,val);
    }

    @Test
    public void testIsAce() {
        assertEquals(false, card.isAce());
        Card card2 = new Card(13, Suit.Spades);
        assertEquals(false, card2.isAce());
        Card ace1 = new Card(14, Suit.Spades);
        assertEquals(true, ace1.isAce());
        Card ace2 = new Card(13, Suit.Espadas);
        assertEquals(true, ace2.isAce());
    }

    @Test
    public void testToString(){
        String str = card.toString();
        assertEquals("5Spades",str);
    }
}

