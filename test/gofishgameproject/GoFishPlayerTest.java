/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gofishgameproject;

import java.util.ArrayList;
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
public class GoFishPlayerTest {
    
    public GoFishPlayerTest() {
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
     * Test of getHand method, of class GoFishPlayer.
     */
    @Test
    public void testHasCardGoodCase() {
        GoFishPlayer player = new GoFishPlayer("Alice");
        player.getHand().add(new Card1(Suit.SPADES, Rank.ACE));
        player.getHand().add(new Card1(Suit.HEARTS, Rank.TWO));
        player.getHand().add(new Card1(Suit.CLUBS, Rank.THREE));
        assertTrue(player.hasCard(Rank.TWO));
    }

    @Test
    public void testHasCardBadCase() {
        GoFishPlayer player = new GoFishPlayer("Bob");
        player.getHand().add(new Card1(Suit.SPADES, Rank.ACE));
        player.getHand().add(new Card1(Suit.HEARTS, Rank.TWO));
        player.getHand().add(new Card1(Suit.CLUBS, Rank.THREE));
        assertFalse(player.hasCard(Rank.KING));
    }

    @Test
    public void testHasCardBoundaryCase() {
        GoFishPlayer player = new GoFishPlayer("Charlie");
        player.getHand().add(new Card1(Suit.SPADES, Rank.ACE));
        player.getHand().add(new Card1(Suit.HEARTS, Rank.TWO));
        player.getHand().add(new Card1(Suit.CLUBS, Rank.THREE));
        assertTrue(player.hasCard(Rank.ACE));
        assertTrue(player.hasCard(Rank.THREE));
        assertFalse(player.hasCard(null));
    }

}
  