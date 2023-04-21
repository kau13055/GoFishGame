/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gofishgameproject;

/**
 *
 * @author DELL
 */

/**

A class representing a player in the game of Go Fish.
*/
import java.util.ArrayList;
import java.util.List;

class GoFishPlayer extends Player {
    private ArrayList<Card1> hand;

    /**
     * Constructs a GoFishPlayer object with the specified name.
     * 
     * @param name the name of the player
     */
    public GoFishPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    /**
     * Returns the player's hand of cards.
     * 
     * @return the player's hand
     */
    public ArrayList<Card1> getHand() {
        return hand;
    }

    /**
     * Sets the player's hand of cards.
     * 
     * @param hand the new hand to set
     */
    public void setHand(ArrayList<Card1> hand) {
        this.hand = hand;
    }

    /**
     * Checks if the player has a card of the specified rank in their hand.
     * 
     * @param rank the rank to check for
     * @return true if the player has a card of the rank, false otherwise
     */
    public boolean hasCard(Rank rank) {
        for (Card1 card : hand) {
            if (card.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all cards of the specified rank from the player's hand and returns
     * them in a list.
     * 
     * @param rank the rank of the cards to remove
     * @return a list of the removed cards
     */
    public ArrayList<Card1> giveCards(Rank rank) {
        ArrayList<Card1> cardsToGive = new ArrayList<>();
        for (Card1 card : hand) {
            if (card.getRank() == rank) {
                cardsToGive.add(card);
            }
        }
        hand.removeAll(cardsToGive);
        return cardsToGive;
    }

    /**
     * Adds the specified cards to the player's hand.
     * 
     * @param cards the cards to add
     */
    public void takeCards(ArrayList<Card1> cards) {
        hand.addAll(cards);
    }

    /**
     * Checks if the player has won the game by having 4 cards of the same rank.
     * 
     * @return true if the player has won, false otherwise
     */
    public boolean hasWon() {
        int numSets = getNumSets();
        return numSets == 4;
    }

    /**
     * Returns the number of sets (4 cards of the same rank) in the player's hand.
     * 
     * @return the number of sets
     */
    public int getNumSets() {
        int[] numRanks = new int[13];
        for (Card1 card : hand) {
            numRanks[card.getRank().ordinal()]++;
        }
        int numSets = 0;
        for (int i = 0; i < numRanks.length; i++) {
            if (numRanks[i] == 4) {
                numSets++;
            }
        }
        return numSets;
    }

    /**
     * Allows the player to choose a rank to ask the other players for.
     * In a real game, the player would choose a rank based on their hand and what
     * they think
     * the other players might have. For simplicity, this implementation chooses a
     * random rank.
     * 
     * @return the chosen rank
     */
    public Rank chooseRank() {
        int index = (int) (Math.random() * Rank.values().length);
        return Rank.values()[index];
    }

    /**
     * Unused method inherited from Player class.
     */
    public void giveCards(List<Card1> singletonList) {
    }
}
