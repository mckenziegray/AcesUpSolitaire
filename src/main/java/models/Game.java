package models;

public class Game {

    public Deck deck = new Deck();

    public Tableau table = new Tableau();

    //Used to give feedback to the user if an action is not possible
    public String feedbackText = "";

    public int score = 0;

    public char deckType = 'E';

    public boolean playerLost = false;

    public Game(){ this.dealFour(); }

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
            int num = table.canMove();
            if (num >= 0) {
                table.moveFromToCol(colFrom, num);
                feedbackText = "";
            } else if (num == -1) {
                feedbackText = "There are no empty slots to move to!";
            } else if (num == -2) {
                feedbackText = "Only Aces can be moved!";
            }
        } else {
            feedbackText = "No card to move!";
        }
    }

    //deckType = 'E' for english and 'S' for spanish cards
    public void reset() {
        this.score = 0;
        this.feedbackText = "";
        this.table = new Tableau();
        this.playerLost = false;
        if (this.deckType == 'E'){
            this.deck = new Deck();
        } else {
            this.deck = new SpanishDeck();
        }
        this.dealFour();
    }

    //checks if the player has lost, meaning there are no cards in the deck and no removes possible
    public void hasPlayerLost() {
        if (!deck.hasCards()) {
            for (int i = 0; i < 4; i++){
                if (table.canRemove(i)) {
                    return;
                }
            }
            if (table.canMove() >= 0) {
                return;
            }
            this.playerLost = true;
        }
    }

}
