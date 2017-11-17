package models;

import java.util.ArrayList;
import java.util.Collections;

public class SpanishDeck extends Deck {

    public java.util.List<Card> deck = new ArrayList<>();

    public SpanishDeck() {
        //Create 48 cards, 12 of each suit - Aces now have a value of 13 instead of 14
        for(int i = 2; i < 14; i++){
            deck.add(new Card(i,Suit.Bastos));
            deck.add(new Card(i,Suit.Copas));
            deck.add(new Card(i,Suit.Oros));
            deck.add(new Card(i,Suit.Espadas));
        }
        //Add 2 jokers
        for(int i = 0; i < 2; i++)
        {
            //Note: jokers have an internal value of 0
            //This shouldn't matter, though, since they will always be a special case
            deck.add(new Card(0, Suit.JOKER));
        }
        this.shuffle();
    }

    public Card takeTopCard() {
        Card tempCard = getTopCard();
        this.removeTopCard();
        return tempCard;
    }

    public boolean hasCards() { return !this.deck.isEmpty(); }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    private Card getTopCard(){
        return this.deck.get(deck.size() - 1);
    }

    private void removeTopCard() {
        this.deck.remove(deck.size() - 1);
    }
}

