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
import java.util.Scanner;

class GoFishPlayer extends Player {
    private static final Rank rank = null;
    private ArrayList<Card1> hand;

    public GoFishPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public ArrayList<Card1> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card1> hand) {
        this.hand = hand;
    }

    public boolean hasCard(Rank rank) {
        for (Card1 card : hand) {
            if (card.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

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

    public void takeCards(ArrayList<Card1> cards) {
        hand.addAll(cards);
    }

    public boolean hasWon() {
        int numSets = getNumSets();
        return numSets == 4;
    }

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

     
    public Rank chooseRank() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the rank you want to ask for (ACE, TWO, THREE, ...): ");
            String input = scanner.nextLine().toUpperCase();
            Rank rank = Rank.valueOf(input);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid card rank.");
        }
        return rank;
    }

}

