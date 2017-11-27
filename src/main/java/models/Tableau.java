package models;

import java.util.ArrayList;

public class Tableau {

    public java.util.List<java.util.List<Card>> columns = new ArrayList<>(4);

    public Tableau() {
        for (int i = 0; i < 4; i++) {
            columns.add(i,new ArrayList<Card>());
        }
    }

    //return the index of the column with a higher valued card on top or -1 if no such column exists
    //pre-conditions: there is a card in column specified by var index
    public boolean canRemove(int index) {
        Card card = this.getTopCard(index);
        for(int i = 0; i < 4; i++) {
            if(colHasCards(i)) {
                Card toCompare = getTopCard(i);
                if (toCompare.getValue() > card.getValue() && toCompare.getSuit() == card.getSuit()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSpanishDeck() {
        for (int i = 0; i < 4; i++) {
            if (colHasCards(i)) {
                Suit suit = getTopCardSuit(i);
                if (suit == Suit.Copas || suit == Suit.Bastos || suit == Suit.Espadas || suit == Suit.Oros)
                    return true;
            }
        }
        return false;
    }

    /*returns -1 if no open column is available, -2 if no aces to move,
        and if there is an empty column and an ace return in int 0-3 for the index of the
        empty column.
    */
    public int canMove() {
        boolean existAce = false;
        int emptyIndex = -1;
        for(int i = 0; i < 4; i++) {
            if (!this.colHasCards(i)) {
                emptyIndex = i;
            } else {
                if ((!this.isSpanishDeck() && this.getTopCardValue(i) == 14) || (this.isSpanishDeck() && this.getTopCardValue(i) == 13)) {
                    existAce = true;
                }
            }
        }
        if (emptyIndex == -1) {
            return -1;
        } else if (!existAce) {
            return -2;
        }
        return emptyIndex;
    }

    //Check if a Joker is available
    //If it is, return its column; otherwise, return -1
    public int existJoker() {
        for(int i = 0; i < 4; i++) {
            if(this.getTopCardValue(i) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void moveFromToCol(int fromCol, int toCol) {
        this.addCardToCol(toCol,this.takeTopCard(fromCol));
    }

    public void addCardToCol(int colNumber, Card c) {
        columns.get(colNumber).add(c);
    }

    public boolean colHasCards(int colNumber) {
        return !columns.get(colNumber).isEmpty();
    }

    public void removeFromCol(int colNumber) {
        columns.get(colNumber).remove(columns.get(colNumber).size()-1);
    }

    public int getTopCardValue(int colNumber) {
        return this.getTopCard(colNumber).getValue();
    }

    public Suit getTopCardSuit(int colNumber) {
        return this.getTopCard(colNumber).getSuit();
    }


    private Card takeTopCard(int colNumber) {
        Card c = getTopCard(colNumber);
        this.removeFromCol(colNumber);
        return c;
    }

    private Card getTopCard(int colNumber) {
        return columns.get(colNumber).get(columns.get(colNumber).size()-1);
    }

}
