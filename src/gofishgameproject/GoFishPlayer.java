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
import java.util.Scanner; // Importing the Scanner class

// Defining the GoFishPlayer class, which extends the Player class
class GoFishPlayer extends Player {

    // Declaring instance variables to hold the player's hand and the rank being asked for
    private static final Rank rank = null;
    private ArrayList<Card1> hand;

    // Defining the constructor for the GoFishPlayer class
    public GoFishPlayer(String name) {
        // Calling the constructor of the superclass (Player) to set the player's name
        super(name);
        // Initializing the ArrayList to hold the player's hand
        hand = new ArrayList<>();
    }

    // Defining a method to get the player's hand
    public ArrayList<Card1> getHand() {
        return hand;
    }

    // Defining a method to set the player's hand
    public void setHand(ArrayList<Card1> hand) {
        this.hand = hand;
    }

    // Defining a method to check if the player has a card of the specified rank in their hand
    public boolean hasCard(Rank rank) {
        // Looping through each card in the player's hand
        for (Card1 card : hand) {
            // Checking if the card has the specified rank
            if (card.getRank() == rank) {
                // Returning true if a card with the specified rank is found
                return true;
            }
        }
        // Returning false if no cards with the specified rank are found
        return false;
    }

    // Defining a method to remove and return all cards of the specified rank from the player's hand
    public ArrayList<Card1> giveCards(Rank rank) {
        // Creating a new ArrayList to hold the cards to be given
        ArrayList<Card1> cardsToGive = new ArrayList<>();
        // Looping through each card in the player's hand
        for (Card1 card : hand) {
            // Checking if the card has the specified rank
            if (card.getRank() == rank) {
                // Adding the card to the list of cards to be given
                cardsToGive.add(card);
            }
        }
        // Removing all cards to be given from the player's hand
        hand.removeAll(cardsToGive);
        // Returning the list of cards to be given
        return cardsToGive;
    }

    // Defining a method to add the specified cards to the player's hand
    public void takeCards(ArrayList<Card1> cards) {
        // Adding the cards to the player's hand
        hand.addAll(cards);
    }

    // Defining a method to check if the player has won the game
    public boolean hasWon() {
        // Counting the number of sets (four cards of the same rank) in the player's hand
        int numSets = getNumSets();
        // Returning true if the player has four sets (16 cards) in their hand
        return numSets == 4;
    }

    // Defining a method to count the number of sets (four cards of the same rank) in the player's hand
    public int getNumSets() {
        // Creating an array to count the number of cards of each rank in the player's hand
        int[] numRanks = new int[13];
        // Looping through each card in the player's hand
        for (Card1 card : hand) {
            // Incrementing the count for the rank of the current card
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
