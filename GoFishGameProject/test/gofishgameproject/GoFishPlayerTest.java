/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gofishgameproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
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
     * Test of hasCard method, of class GoFishPlayer.
     */
    @Test
    public void testHasCardGood() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        Card1 card1 = new Card1(Suit.HEARTS, Rank.ACE);
        Card1 card2 = new Card1(Suit.DIAMONDS, Rank.TEN);
        Card1 card3 = new Card1(Suit.CLUBS, Rank.QUEEN);
        player.takeCards(new ArrayList<>(List.of(card1, card2, card3)));
        assertTrue(player.hasCard(Rank.ACE));
        assertTrue(player.hasCard(Rank.TEN));
        assertTrue(player.hasCard(Rank.QUEEN));
        assertFalse(player.hasCard(Rank.KING));
    }
    
    @Test
    public void testHasCardBad() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        Card1 card1 = new Card1(Suit.HEARTS, Rank.ACE);
        Card1 card2 = new Card1(Suit.DIAMONDS, Rank.TEN);
        Card1 card3 = new Card1(Suit.CLUBS, Rank.QUEEN);
        player.takeCards(new ArrayList<>(List.of(card1, card2, card3)));
        assertFalse(player.hasCard(Rank.ACE));
        assertFalse(player.hasCard(Rank.TEN));
        assertFalse(player.hasCard(Rank.QUEEN));
        assertTrue(player.hasCard(Rank.KING));
    }
        @Test
public void testHasCardBoundary() {
    GoFishPlayer player = new GoFishPlayer("Player1");
    Card1 card1 = new Card1(Suit.HEARTS, Rank.ACE);
    Card1 card2 = new Card1(Suit.DIAMONDS, Rank.TEN);
    Card1 card3 = new Card1(Suit.CLUBS, Rank.QUEEN);
    player.takeCards(new ArrayList<>(List.of(card1, card2, card3)));

    // Test lowest possible rank value
    assertTrue(player.hasCard(Rank.TWO));
    
    // Test highest possible rank value
    assertTrue(player.hasCard(Rank.ACE));
    
    // Test a rank that is not in the player's hand
    assertFalse(player.hasCard(Rank.KING));
}
 
    /**
     * Test of takeCards method, of class GoFishPlayer.
     */
    @Test
    public void testTakeCardsGood() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        Card1 card1 = new Card1(Suit.HEARTS, Rank.ACE);
        Card1 card2 = new Card1(Suit.DIAMONDS, Rank.TEN);
        ArrayList<Card1> cards = new ArrayList<>(List.of(card1, card2));
        player.takeCards(cards);
        assertEquals(2, player.getHand().size());
        assertTrue(player.hasCard(Rank.ACE));
        assertTrue(player.hasCard(Rank.TEN));
    }

    @Test
    public void testTakeCardsBad() {
        GoFishPlayer player = new GoFishPlayer("Player1");
        ArrayList<Card1> cards = new ArrayList<>();
        player.takeCards(cards);
        assertEquals(0, player.getHand().size());
    }
    
  
@Test
public void testTakeCardsBoundary() {
    GoFishPlayer player = new GoFishPlayer("Player1");
    ArrayList<Card1> cards = new ArrayList<>();
    for (Rank rank : Rank.values()) {
        Card1 card = new Card1(Suit.CLUBS, rank);
        cards.add(card);
    }
    player.takeCards(cards);
    assertEquals(13, player.getHand().size());
    for (Rank rank : Rank.values()) {
        assertTrue(player.hasCard(rank));
    }
}
 
    /**
     * Test of chooseRank method, of class GoFishPlayer.
     */
@Test
public void testChooseRankGood() {
    GoFishPlayer player = new GoFishPlayer("Player1");
    for (int i = 0; i < 1000; i++) {
        Rank rank = player.chooseRank();
        assertNotNull(rank);
        assertTrue(Arrays.asList(Rank.values()).contains(rank));
    }
}
@Test
public void testChooseRankBad() {
    GoFishPlayer player = new GoFishPlayer("Player1");
    Rank rank = player.chooseRank();
    assertFalse(Arrays.asList(Rank.values()).contains(rank));
}
@Test
public void testChooseRankBoundary() {
    GoFishPlayer player = new GoFishPlayer("Player1");
    Random random = new Random();
    int index = random.nextInt(Rank.values().length);
    Rank rank = player.chooseRank();
    assertEquals(Rank.values()[index], rank);
}


    
}
