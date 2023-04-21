/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gofishgameproject;

/**
 *
 * @author DELL
 */

import java.util.Scanner;

public class GoFishGame {
    private final Deck deck;
    private final Player user;
    private final Player computer;

    public GoFishGame() {

        deck = new Deck();
        deck.shuffle();
        user = new Player("User");
        computer = new Player("Computer");
    }
    public void play() {
        System.out.println("Welcome to Go Fish!\n");
        System.out.println("Dealing cards...\n");

        for (int i = 0; i < 5; i++) {

            // Deal card to the user
            Card1 userCard = deck.draw();
            System.out.println("You were dealt " + userCard.toString());
            user.addCard(userCard);

            // Deal card to the computer
            Card1 computerCard = deck.draw();
            computer.addCard(computerCard);
            deck.shuffle();
        }

        // Loop until game is won
        while (true) {
            // User's turn
            System.out.println("Your turn:");
            System.out.println("Your hand: " + user.getHand());
            System.out.println("Computer's hand: " + computer.getHand());
            System.out.print("Enter a card rank to ask for: ");
            Rank rank = Rank.valueOf(new Scanner(System.in).nextLine().toUpperCase());
            while (!user.containsRank(rank)) {
                System.out.print("You don't have any " + rank + "s. Choose another rank: ");
                rank = Rank.valueOf(new Scanner(System.in).nextLine().toUpperCase());
            }
            int numCards = computer.respond(rank);
            if (numCards > 0) {
                System.out.println("Computer had " + numCards + " " + rank + "s. You took them.");
            } else {
                System.out.println("Go fish! You drew a card.");

                user.addCard(deck.draw());
            }
            if (user.checkForBooks()) {
                System.out.println("You have a book of " + rank + "s!");
            }
            if (user.getHand().isEmpty()) {
                System.out.println("Your hand is empty. Game over!");
                break;
            }

            // Computer's turn
            System.out.println("\nComputer's turn:");
            rank = computer.chooseRank();
            System.out.println("Computer asks for " + rank + "s.");
            numCards = user.respond(rank);
            if (numCards > 0) {
                System.out.println("You had " + numCards + " " + rank + "s. Computer took them.");
            } else {
                System.out.println("Computer fishes! Computer drew a card.");
                computer.addCard(deck.draw());
            }
            if (computer.checkForBooks()) {
                System.out.println("Computer has a book of " + rank + "s!");
            }
            if (computer.getHand().isEmpty()) {
                System.out.println("Computer's hand is empty. Game over!");
                break;
            }
        }
    }

}
