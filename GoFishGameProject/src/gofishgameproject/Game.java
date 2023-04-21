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

// Abstract class that represents a generic game with a list of players
abstract class Game {
    protected ArrayList<Player> players; // list of players in the game

    // constructor that sets the name of the game
    public Game(String name) {
    }

    // abstract method to play the game
    public abstract void play();
}

    

