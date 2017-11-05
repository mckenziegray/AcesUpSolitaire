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
            Card toCompare = getTopCard(i);
            if (toCompare.getValue() > card.getValue() && toCompare.getSuit() == card.getSuit()) {
                return true;
            }
        }
        return false;
    }

    //returns the index of an empty column or -1 if none exist
    public int existEmptyCol() {
        for(int i = 0; i < 4; i++) {
            if(this.columns.get(i).isEmpty()) {
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
