package models;

import javafx.scene.control.Tab;

import java.util.ArrayList;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public Deck deck = new Deck();

    public Tableau table = new Tableau();

    //Used to give feedback to the user if an action is not possible
    public String feedbackText = "";

    public Game(){
        this.dealFour();
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        if (deck.hasCards()){
            for (int i = 0; i < 4; i++) {
                table.addCardToCol(i,deck.takeTopCard());
            }
        }
    }

    public void remove(int colNumber) {
//        // remove the top card from the indicated column if valid
//        if(columnHasCards(columnNumber)) {
//            Card c = getTopCard(columnNumber);
//            boolean removeCard = false;
//            for (int i = 0; i < 4; i++) {
//                if (i != columnNumber) {
//                    if (columnHasCards(i)) {
//                        Card compare = getTopCard(i);
//                        if (compare.getSuit() == c.getSuit()) {
//                            if (compare.getValue() > c.getValue()) {
//                                removeCard = true;
//                            }
//                        }
//                    }
//                }
//            }
//            if (removeCard) {
//                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
//            }
//        }
        if( table.colHasCards(colNumber) ) {
            if( table.canRemove(colNumber)) {
                table.removeFromCol(colNumber);
            }
        }
    }

    public void move(int colFrom) {
        if( table.colHasCards(colFrom)) {
            if( table.getTopCardValue(colFrom) == 14){
                int num = table.existEmptyCol();
                if( num != -1 ) {
                    table.moveFromToCol(colFrom, num);
                }
            }
        }
    }
}
