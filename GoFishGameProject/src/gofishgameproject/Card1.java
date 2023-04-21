/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gofishgameproject;

/**
 *
 * @author DELL
 */

enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}
enum Suit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES
}
// Represents a single card with a suit and a rank
public class Card1 {
    private Suit suit; // the suit of the card
    private Rank rank; // the rank of the card

    // default constructor
    public Card1() {
    }

    // constructor that sets the suit and rank of the card
    public Card1(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // getter method for the suit of the card
    public Suit getSuit() {
        return suit;
    }

    // getter method for the rank of the card
    public Rank getRank() {
        return rank;
    }

    // string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

