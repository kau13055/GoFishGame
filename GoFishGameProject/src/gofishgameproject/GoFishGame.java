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

// Define GoFishGame class that extends Game
class GoFishGame extends Game {
    // Define instance variables for the deck and pool
    private GroupOfCards deck;
    private ArrayList<Card1> pool;

    // Constructor that takes a name and list of players
    public GoFishGame(String name, ArrayList<GoFishPlayer> players) {
        // Call super constructor with the provided name
        super(name);
        // Initialize the players list with a copy of the provided list
        this.players = new ArrayList<>(players);
        // Create a new deck and pool for the game
        deck = new GroupOfCards(52);
        pool = new ArrayList<>();
        // Initialize the deck with all 52 cards and shuffle them
        initializeDeck();
    }    
 

    // Method to initialize the deck
    public void initializeDeck() {
        // Create a list of all 52 cards
        ArrayList<Card1> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card1(suit, rank));
            }
        }
        // Set the deck's cards to the list of cards and shuffle them
        deck.cards = cards;
        deck.shuffle();
    }

    // Method to deal cards to players
    public void deal() {
        // Set the number of cards to deal to each player
        int numCardsToDeal = 5;
        // For each player, deal them a hand of cards
        for (Player player : players) {
            // Cast the player as a GoFishPlayer to access its specific methods
            GoFishPlayer goFishPlayer = (GoFishPlayer) player;
            // Create a new list to represent the player's hand
            ArrayList<Card1> hand = new ArrayList<>();
            // Deal the player the specified number of cards from the deck
            for (int i = 0; i < numCardsToDeal; i++) {
                Card1 card = deck.cards.remove(deck.cards.size() - 1);
                hand.add(card);
            }
            // Set the player's hand to the newly dealt hand
            goFishPlayer.setHand(hand);
        }
    }

    // Method to play the game
    public void play() {
        // Deal the cards to the players
        deal();

        // Set a flag to indicate if the game is still being played
        boolean gameOn = true;
        // Loop through each player's turn until the game ends
        while (gameOn) {
            // Iterate through each player and prompt them to choose a rank
            for (Player player : players) {
                // Cast the player as a GoFishPlayer to access its specific methods
                GoFishPlayer goFishPlayer = (GoFishPlayer) player;
                // Prompt the player to choose a rank
                Rank chosenRank = goFishPlayer.chooseRank();

                // Create a list of all possible recipients for the chosen rank
                ArrayList<GoFishPlayer> recipients = new ArrayList<>();
                for (Player recipient : players) {
                    // Exclude the current player from the list of recipients
                    if (recipient != goFishPlayer) {
                        recipients.add((GoFishPlayer) recipient);
                    }

                }
                // Initialize variables for the cards given and whether the player got cards or
                // not
                ArrayList<Card1> cardsGiven = new ArrayList<>();
                boolean gotCards = false;
                // Check each recipient to see if they have any cards of the chosen rank
                for (GoFishPlayer recipient : recipients) {
                    if (recipient.hasCard(chosenRank)) {
                        // If a recipient has the chosen rank, take all their cards of that rank and add
                        // them to the pool
                        cardsGiven.addAll(recipient.giveCards(chosenRank));
                        pool.addAll(cardsGiven);
                        // Give the cards to the current player and set gotCards to true

                        goFishPlayer.takeCards(cardsGiven);
                        gotCards = true;
                    }
                }
                // If the current player didn't get any cards, they must draw from the deck
                if (!gotCards) {
                    if (deck.cards.size() > 0) {
                        // Draw a card from the deck and give it to the current player
                        Card1 card = deck.cards.remove(deck.cards.size() - 1);
                        goFishPlayer.takeCards(new ArrayList<Card1>(Collections.singletonList(card)));
                        // Check if the player has won
                        if (goFishPlayer.hasWon()) {
                            gameOn = false;
                        }
                    } else {
                        // If there are no cards left in the deck, end the game
                        gameOn = false;
                    }
                }
                // Check if the current player has won
                if (goFishPlayer.hasWon()) {
                    gameOn = false;
                }
            }
        }

        // Declare the winner of the game
        declareWinner();
    }

    // This is a method to declare the winner of the game
    public void declareWinner() {
        GoFishPlayer winner = null;
        int maxSets = 0;
        // Iterate through each player to find the one with the most sets
        for (Player player : players) {
            GoFishPlayer goFishPlayer = (GoFishPlayer) player;
            int numSets = goFishPlayer.getNumSets();
            // If the current player has more sets than the previous max, set them as the
            // winner and update maxSets
            if (numSets > maxSets) {
                winner = goFishPlayer;
                maxSets = numSets;
            }
        }
        // Print the name of the winner and how many sets they had
        System.out.println("The winner is " + winner.getName() + " with " + maxSets + " sets!");
    }

}
