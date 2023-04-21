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
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
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
     * Test of shuffle method, of class GroupOfCards.
     */
    
@Test
public void testShuffleWithSingleCard() {
    GroupOfCards group = new GroupOfCards(1);
    ArrayList<Card1> initialOrder = new ArrayList<>(group.cards);
    group.shuffle();
    assertEquals(initialOrder, group.cards);
}

@Test
public void testShuffleWithNullGroup() {
    GroupOfCards group = null;
    assertThrows(NullPointerException.class, () -> {
        group.shuffle();
    });
}


@Test
public void testShuffleWithBoundaryGroupSize() {
    GroupOfCards group = new GroupOfCards(1);
    ArrayList<Card1> initialOrder = new ArrayList<>(group.cards);
    group.shuffle();
    assertEquals(initialOrder, group.cards);
}

}