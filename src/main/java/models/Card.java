package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of for future assignments.
 */

public class Card implements Serializable {
    private final int value;
    private final Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isAce() {
        if ((suit == Suit.Oros || suit == Suit.Espadas || suit == Suit.Bastos || suit == Suit.Copas) && (value == 13))
                return true;
        else if (value == 14)
                return true;
        else
            return false;
    }

    public String toString() {
        return this.value + this.suit.toString();
    }
}
