package models;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++) {
            cols.add(i,new ArrayList<Card>());
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
        Collections.shuffle(deck);
        //finished for working test
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        for (int i = 0; i < 4; i++) {
            addCardToCol(i,deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
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
        if(columnHasCards(columnFrom)&&cols.get(columnTo).isEmpty()){
            addCardToCol(columnTo, getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }
        else
            System.out.println("Error: either the columns is empty, or the columnFrom is not empty");
            //Only for server and testing, will be commented out later
        // remove the top card from the columnFrom column, add it to the columnTo column
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
