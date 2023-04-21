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
 * A class representing a player in a game.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Player {
    private String name;
    private ArrayList<Card1> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card1>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card1> getHand() {
        return hand;
    }

    public void addCard(Card1 card) {
        hand.add(card);
    }

    public int respond(Rank rank) {
        int numCards = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == rank) {
                numCards++;
                hand.remove(i);
                i--;
            }
        }
        return numCards;
    }

    public boolean checkForBooks() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Card1 card : hand) {
            Rank rank = card.getRank();
            if (rankCounts.containsKey(rank)) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            } else {
                rankCounts.put(rank, 1);
            }
        }
        for (Rank rank : rankCounts.keySet()) {
            if (rankCounts.get(rank) == 4) {
                removeCardsOfRank(rank);
                return true;
            }
        }
        return false;
    }

    public boolean containsRank(Rank rank) {
        for (Card1 card : hand) {
            if (card.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

    public Rank chooseRank() {
        Random random = new Random();
        int index = random.nextInt(hand.size());
        return hand.get(index).getRank();
    }

    public int respond(String rank) {
        return respond(Rank.valueOf(rank.toUpperCase()));
    }

    public void removeCardsOfRank(Rank rank) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == rank) {
                hand.remove(i);
                i--;
            }
        }
    }
}