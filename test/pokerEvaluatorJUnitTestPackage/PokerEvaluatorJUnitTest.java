/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerEvaluatorJUnitTestPackage;

import pokerevaluator.PokerEvaluator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*; 
import java.util.stream.IntStream;
import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.CoreMatchers.not;

/**
 *
 * @author joseph
 */
public class PokerEvaluatorJUnitTest {
    
    public PokerEvaluatorJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void  testDeterminePlayerPokerHandFunction() {
        PokerEvaluator pokerEvaluator = new PokerEvaluator();
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        expected.add("Royal Flush");
        expected.add("55");
        actual = pokerEvaluator.determinePlayerPokerHand(
            new String[] {"Ace-Diamonds", "Diamonds", "Ace", "13", "2"},
            new String[] {"King-Diamonds", "Diamonds", "King", "12", "2"}, 
            new String[] {"Queen-Diamonds", "Diamonds", "Queen", "11", "2"}, 
            new String[] {"Jack-Diamonds", "Diamonds", "Jack", "10", "2"},
            new String[] {"10-Diamonds", "Diamonds", "10", "9", "4"}
        );
        assertThat(actual, is(expected));
    }
        
    @Test
    public void  testRoyalFlushCheckFunction() {
        PokerEvaluator pokerEvaluator = new PokerEvaluator();
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        expected.add("Royal Flush");
        expected.add("55");
        String[] cardRanks = {"Ace", "King", "Queen", "Jack", "10"};
        actual = pokerEvaluator.royalFlushCheck(cardRanks, 55);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void  testStraightFlushFunction() {
        PokerEvaluator pokerEvaluator = new PokerEvaluator();
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        expected.add("Straight Flush");
        expected.add("15");
        int[] cardPoints = {2, 5, 1, 4, 3};
        Arrays.sort(cardPoints);
        int sum = IntStream.of(cardPoints).sum();
        actual = pokerEvaluator.straightFlush(cardPoints, sum);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void  testFlushFunction() {
        PokerEvaluator pokerEvaluator = new PokerEvaluator();
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        expected.add("Flush");
        expected.add("44");
        String[] cardSuite = {"Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds"};
        actual = pokerEvaluator.flush(cardSuite, 44);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void  testRankMatchingFunction() {
        PokerEvaluator pokerEvaluator = new PokerEvaluator();
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        expected.add("Three Of A Kind");
        expected.add("46");
        String[] cardRank = {"Jack", "Jack", "Jack", "King", "4"};
        actual = pokerEvaluator.rankMatching(cardRank, 46);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void  testHighestCardFunction() {
        PokerEvaluator pokerEvaluator = new PokerEvaluator();
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        expected.add("High Card");
        expected.add("28");
        int[] cardPoints = {6, 10, 4, 7, 1};
        actual = pokerEvaluator.highestCard(cardPoints, 28);
        assertThat(actual, is(expected));
    }
}
