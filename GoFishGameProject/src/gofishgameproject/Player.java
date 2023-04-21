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
public class Player {
    private String name;

    /**
     * 
     * Constructor for Player class.
     * 
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * 
     * Getter method for the name of the player.
     * 
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
}
