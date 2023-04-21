/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gofishgameproject;

/**
 *
 * @author DELL
 */
import java.util.ArrayList; // Importing the ArrayList class
import java.util.Collections; // Importing the Collections class

// Defining the Deck class
class Deck {

    // Declaring an instance variable to hold the cards in the deck
    private ArrayList<Card1> cards;

    // Defining the constructor for the Deck class
    public Deck() {
        // Initializing the ArrayList to hold the cards
        cards = new ArrayList<Card1>();

        // Looping through each suit and rank to create a new card and add it to the deck
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card1(suit, rank));
            }
        }
    }

    // Defining a method to shuffle the deck
    public void shuffle() {
        // Using the Collections class to shuffle the cards in the deck
        Collections.shuffle(cards);
    }

    // Defining a method to draw a card from the deck
    public Card1 draw() {
        // Checking if there are any cards left in the deck
        if (cards.size() > 0) {
            // Removing the first card from the deck and returning it
            return cards.remove(0);
        }
        // Returning null if there are no cards left in the deck
        return null;
    }

    // Defining a method to get the number of cards left in the deck
    public int size() {
// Returning the size of the ArrayList containing the cards
        return cards.size();
    }
}
