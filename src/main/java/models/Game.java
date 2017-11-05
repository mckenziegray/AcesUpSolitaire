package models;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    private Deck deck = new Deck();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++) {
            cols.add(i,new ArrayList<Card>());
        }
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        for (int i = 0; i < 4; i++) {
            addCardToCol(i,deck.takeTopCard());
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column if valid
        if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if (cols.get(columnNumber).isEmpty())
            return false;
        else
            return true;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // checks and moves card if valid, not necessary depending on client views
        // Added: The cald can only be moved into an empty space if the card is an Ace
        if(columnHasCards(columnFrom)&&cols.get(columnTo).isEmpty()&&cols.get(columnFrom).get(cols.get(columnFrom).size() - 1).value == 14){
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }
        else
            System.out.println("Error: either the columns is empty, or the columnFrom is not empty");
            //Only for server and testing, will be commented out later
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
