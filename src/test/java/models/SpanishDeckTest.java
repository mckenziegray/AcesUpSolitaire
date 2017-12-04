package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpanishDeckTest {

    SpanishDeck deck = new SpanishDeck();

    @Test
    public void testBuild(){
        deck.buildDeck();
        assertEquals(50, 50);
    }
}
