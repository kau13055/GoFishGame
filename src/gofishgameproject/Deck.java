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

class Deck {
    private ArrayList<Card1> cards;

    public Deck() {
        cards = new ArrayList<Card1>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card1(suit, rank));
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card1 draw() {
        if (cards.size() > 0) {
            return cards.remove(0);
        }
        return null;
    }

    public int size() {
        return cards.size();
    }
}