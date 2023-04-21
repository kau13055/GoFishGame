/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gofishgameproject;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Collections;

// Represents a group of cards, which can be shuffled
class GroupOfCards {
    ArrayList<Card1> cards; // list of cards in the group

    // constructor that sets the number of cards in the group
    public GroupOfCards(int numCards) {
        cards = new ArrayList<>(numCards);
    }

    // shuffles the cards in the group
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
