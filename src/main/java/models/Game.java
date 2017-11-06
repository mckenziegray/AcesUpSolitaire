package models;

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
