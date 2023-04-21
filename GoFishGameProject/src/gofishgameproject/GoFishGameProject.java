/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gofishgameproject;


import java.util.ArrayList;

public class GoFishGameProject {
    public static void main(String[] args) {
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        players.add(new GoFishPlayer("Player 1"));
        players.add(new GoFishPlayer("Player 2"));
        // players.add(new GoFishPlayer("Player 3"));
        // players.add(new GoFishPlayer("Player 4"));
        
        GoFishGame game = new GoFishGame("Go Fish", players);
        System.out.println("---------------------------------------------------------");
        System.out.println("Result:");
        game.play();
        System.out.println("---------------------------------------------------------");
    }
}

    

