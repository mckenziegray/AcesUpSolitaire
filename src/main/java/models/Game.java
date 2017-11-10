package models;

public class Game {

    public Deck deck = new Deck();

    public Tableau table = new Tableau();

    //Used to give feedback to the user if an action is not possible
    public String feedbackText = "";

    public int score = 0;

    public Game(){
        this.dealFour();
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        if (deck.hasCards()) {
            for (int i = 0; i < 4; i++) {
                table.addCardToCol(i, deck.takeTopCard());
            }
            feedbackText = "";
        }
    }

    public void remove(int colNumber) {
        if( table.colHasCards(colNumber) ) {
            if (table.canRemove(colNumber)) {
                table.removeFromCol(colNumber);
                feedbackText = "";
                score++;
            }
            else
                feedbackText = "That card can't be removed!";
        }
        else
            feedbackText = "No card to remove!";
    }

    public void move(int colFrom) {
        if( table.colHasCards(colFrom)) {
            if( table.getTopCardValue(colFrom) == 14){
                int num = table.existEmptyCol();
                if( num != -1 ) {
                    table.moveFromToCol(colFrom, num);
                    feedbackText = "";
                }
                else
                    feedbackText = "There are no empty slots to move to!";
            }
            else
                feedbackText = "Only Aces can be moved!";
        }
        else
            feedbackText = "No card to move!";
    }
}
