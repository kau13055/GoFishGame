/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gofishgameproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nandi
 */
public class DeckTest {

    public DeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testDraw() {
        Deck deck = new Deck();
        int initialSize = deck.size();
        Card1 drawnCard = deck.draw();
        assertEquals(initialSize - 1, deck.size());
        assertNotNull(drawnCard);
    }

    @Test
    public void testDrawBad() {
        System.out.println("draw");
        Deck instance = new Deck();
        while (instance.size() > 0) { // draw all cards
            instance.draw();
        }
        Card1 expResult = null;
        Card1 result = instance.draw(); // draw from empty deck
        assertEquals(expResult, result);
    }

    @Test
    public void testDrawBoundary() {
        System.out.println("draw boundary");

        // Create a new deck and draw all the cards to make it empty
        Deck instance = new Deck();
        for (int i = 0; i < 52; i++) {
            instance.draw();
        }

        // Try to draw a card from the empty deck
        Card1 result = instance.draw();
        assertNull(result);
    }
}
