/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerevaluator;

import java.util.*; 
import java.util.stream.*;

/**
 *
 * @author joseph nyahuye
 */
public class PokerEvaluator { 
       
    public static String[][] cardDeckArray = {
        // CLUBS
        {"Ace-Clubs", "Clubs", "Ace", "13", "1"},
        {"King-Clubs", "Clubs", "King", "12", "1"},
        {"Queen-Clubs", "Clubs", "Queen", "11", "1"}, 
        {"Jack-Clubs", "Clubs", "Jack", "10", "1"}, 
        {"10-Clubs", "Clubs", "10", "9", "1"},
        {"9-Clubs", "Clubs", "9", "8", "1"},
        {"8-Clubs", "Clubs", "8", "7", "1"},
        {"7-Clubs", "Clubs", "7", "6", "1"},
        {"6-Clubs", "Clubs", "6", "5", "1"},
        {"5-Clubs", "Clubs", "5", "4", "1"},
        {"4-Clubs", "Clubs", "4", "3", "1"},
        {"3-Clubs", "Clubs", "3", "2", "1"},
        {"2-Clubs", "Clubs", "2", "1", "1"},
        // DIAMONDS
        {"Ace-Diamonds", "Diamonds", "Ace", "13", "2"},
        {"King-Diamonds", "Diamonds", "King", "12", "2"}, 
        {"Queen-Diamonds", "Diamonds", "Queen", "11", "2"}, 
        {"Jack-Diamonds", "Diamonds", "Jack", "10", "2"}, 
        {"10-Diamonds", "Diamonds", "10", "9", "2"},
        {"9-Diamonds", "Diamonds", "9", "8", "2"},
        {"8-Diamonds", "Diamonds", "8", "7", "2"},
        {"7-Diamonds", "Diamonds", "7", "6", "2"},
        {"6-Diamonds", "Diamonds", "6", "5", "2"},
        {"5-Diamonds", "Diamonds", "5", "4", "2"},
        {"4-Diamonds", "Diamonds", "4", "3", "2"},
        {"3-Diamonds", "Diamonds", "3", "2", "2"},
        {"2-Diamonds", "Diamonds", "2", "1", "2"},
        // HEARTS
        {"Ace-Hearts", "Hearts", "Ace", "13", "3"},
        {"King-Hearts", "Hearts", "King", "12", "3"}, 
        {"Queen-Hearts", "Hearts", "Queen", "11", "3"}, 
        {"Jack-Hearts", "Hearts", "Jack", "10", "3"},
        {"10-Hearts", "Hearts", "10", "9", "3"},
        {"9-Hearts", "Hearts", "9", "8", "3"},
        {"8-Hearts", "Hearts", "8", "7", "3"},
        {"7-Hearts", "Hearts", "7", "6", "3"},
        {"6-Hearts", "Hearts", "6", "5", "3"},
        {"5-Hearts", "Hearts", "5", "4", "3"},
        {"4-Hearts", "Hearts", "4", "3", "3"},
        {"3-Hearts", "Hearts", "3", "2", "3"},
        {"2-Hearts", "Hearts", "2", "1", "3"},
        // SPADES
        {"Ace-Spades", "Spades", "Ace", "13", "4"},
        {"King-Spades", "Spades", "King", "12", "4"}, 
        {"Queen-Spades", "Spades", "Queen", "11", "4"}, 
        {"Jack-Spades", "Spades", "Jack", "10", "4"},
        {"10-Spades", "Spades", "10", "9", "4"},
        {"9-Spades", "Spades", "9", "8", "4"},
        {"8-Spades", "Spades", "8", "7", "4"},
        {"7-Spades", "Spades", "7", "6", "4"},
        {"6-Spades", "Spades", "6", "5", "4"},
        {"5-Spades", "Spades", "5", "4", "4"},
        {"4-Spades", "Spades", "4", "3", "4"},
        {"3-Spades", "Spades", "3", "2", "4"},
        {"2-Spades", "Spades", "2", "1", "4"}
    };
    
    public static List<String[]> playerLists = new ArrayList<>();
    
    static void runGreetingOnStart() {
        System.out.println("================================================");
        System.out.println("========= JOSEPH POKER EVALUATOR ===============");
        System.out.println("================================================");
        System.out.println("");
        System.out.println("Welcome to my poker simulator game. Enjoy !!!");
        System.out.println("");
    }
    
    static void addSimulationAndPlayerInputs() {
        Scanner inputs = new Scanner(System.in);
        try {
            System.out.println("");
            System.out.println("Add the number of simulations you would like to run.");
            int simulations = inputs.nextInt();
            try {        
                System.out.println("Add the number of players between the range of 2 and 10.");
                int players = inputs.nextInt();
                System.out.println("");
                if (players > 10 || players < 2) {
                    System.out.println("You have not chosen the correct number of players.");
                    System.out.println("Please enter 1 to try again or any key to quit.");
                    System.out.println("");
                    try {
                        int choiceMade = inputs.nextInt();
                        if (choiceMade == 1) {
                        System.out.println("");
                        addSimulationAndPlayerInputs();
                        } else if (choiceMade > 1 || choiceMade < 1) {
                            System.out.println("");
                            System.out.println("Thank you for playing");
                            System.exit(0);
                        } 
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("");
                        System.out.println("Thank you for playing");
                        System.exit(0);
                    }
                } else {
                    startPokerEvaluation(players, simulations);
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Wrong value entered. Please try again");
                addSimulationAndPlayerInputs();
            }
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Wrong value entered. Please try again below.");
            addSimulationAndPlayerInputs();
        }
    }
    
    static void startPokerEvaluation(int players, int simulations) {
        Scanner inputs = new Scanner(System.in);
        System.out.println(
            "The simulations being run are " + simulations + 
            " and the players are " + players + " players."
        );
        System.out.println("");
        for (int i = 0; i < simulations; i++) {
            int sim = (i + 1);
            System.out.println("");
            System.out.println("SIMULATION " + sim);
            System.out.println("");
            startPokerSimulation(players, sim);
        }  
        
        System.out.println("");
        System.out.println("PLAYER RESULTS SUMMARY");
        System.out.println("");
        
        for (int i = 0; i < players; i++) {
            // ArrayList<String> playerPokerHand = new ArrayList<>();
            int player = 1 + i;
            int royalFlush = 0;
            int straightFlush = 0;
            int fourOfAKind = 0;
            int fullHouse = 0;
            int flush = 0;
            int straight = 0;
            int threeOfAKind = 0;
            int twoPairs = 0;
            int onePair = 0;
            int highCard = 0;   
            for (String[] playerSelected: playerLists) {
                if (Integer.parseInt(playerSelected[0]) == player) {
                    if (null != playerSelected[1]) switch (playerSelected[1]) {
                    case "Royal Flush":
                        royalFlush++;
                        break;
                    case "Straight Flush":
                        straightFlush++;
                        break;
                    case "Four Of A Kind":
                        fourOfAKind++;   
                        break;
                    case "Full House":
                        fullHouse++;   
                        break;
                    case "Flush":
                        flush++;   
                        break;
                    case "Straight":
                        straight++;   
                        break;
                    case "Three Of A Kind":
                        threeOfAKind++;   
                        break;
                    case "Two Pairs":
                        twoPairs++;   
                        break;
                    case "One Pair":
                        onePair++;   
                        break;
                    case "High Card":
                        highCard++;   
                        break;
                    default:
                        break;
                    }
               }
            }
            int playerScore = (royalFlush * 10) + 
            (straightFlush * 9) +
            (fourOfAKind * 8) +
            (fullHouse * 7) +
            (flush * 6) +
            (straight * 5) +
            (threeOfAKind * 4) +
            (twoPairs * 3) +
            (onePair * 2) +
            (highCard * 1);
            System.out.println(
                "Player " + player + " : " +
                playerScore + " points"
            );
            if (royalFlush > 0) {
                System.out.println(
                    "* Royal Flush : " + royalFlush + " hand/s "
                );
            }
            if (straightFlush > 0) {
                System.out.println(
                    "* Straight Flush : " + straightFlush + " hand/s "
                );
            }
            if (fourOfAKind > 0) {
                System.out.println(
                    "* Four Of A Kind : " + fourOfAKind + " hand/s "
                );
            }
            if (fullHouse > 0) {
                System.out.println(
                    "* Full House : " + fullHouse + " hand/s "
                );
            } 
            if (flush > 0) {
                System.out.println(
                    "* Flush : " + flush + " hand/s "
                );
            }
            if (straight > 0) {
                System.out.println(
                    "* Straight : " + straight + " hand/s "
                );
            }
            if (threeOfAKind > 0) {
                System.out.println(
                    "* Three Of A Kind : " + threeOfAKind + " hand/s "
                );
            }
            if (twoPairs > 0) {
                System.out.println(
                    "* Two Pairs : " + twoPairs + " hand/s "
                );
            }
            if (onePair > 0) {
                System.out.println(
                    "* One Pair : " + onePair + " hand/s "
                );
            }
            if (highCard > 0) {
                System.out.println(
                    "* High Card : " + highCard + " hand/s "
                );
            }
            System.out.println("...");
            System.out.println("");
        }
        playerLists.clear();
        System.out.println("");
        System.out.println("End of Poker Evalualtion");
        System.out.println("======================================"); 
        System.out.println("");
        System.out.println("Would you like to play again? Please enter 1 to try again or any key to quit.");
        System.out.println("");
        try
        {
            int choiceMade = inputs.nextInt();
            if (choiceMade == 1) {
            System.out.println("");
            addSimulationAndPlayerInputs();
            } else if (choiceMade > 1 || choiceMade < 1) {
                System.out.println("");
                System.out.println("Thank you for playing");
                System.exit(0);
            } 
        }
        catch(InputMismatchException e)
        {
            System.out.println("");
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }
    
    public static void startPokerSimulation(int players, int sim) {
        shuffleCardArray(cardDeckArray);
        List<Integer[]> royalFlushList = new ArrayList<>();
        List<Integer[]> straightFlushList = new ArrayList<>();
        List<Integer[]> fourOfAKindList = new ArrayList<>();
        List<Integer[]> fullHouseList = new ArrayList<>();
        List<Integer[]> flushList = new ArrayList<>();
        List<Integer[]> straightList = new ArrayList<>();
        List<Integer[]> threeOfAKindList = new ArrayList<>();
        List<Integer[]> twoPairsList= new ArrayList<>();
        List<Integer[]> onePairList = new ArrayList<>();
        List<Integer[]> highCardList = new ArrayList<>();  
        for (int i = 0; i < players; i++) {
            ArrayList<String> playerPokerHand = new ArrayList<>();
            int player = 1 + i;
            int startIndex = i != 0 ? ((player * 5) - 4) : 0;
            int endIndex = i != 0 ? (player * 5) : 5;
            System.out.println(
                "Player " + player + " : " + 
                cardDeckArray[startIndex][0] + ", " +
                cardDeckArray[startIndex + 1][0] + ", " +
                cardDeckArray[startIndex + 2][0] + ", " +
                cardDeckArray[startIndex + 3][0] + ", " +
                cardDeckArray[endIndex][0] 
            );
            playerPokerHand = determinePlayerPokerHand(
                cardDeckArray[startIndex],
                cardDeckArray[startIndex + 1],
                cardDeckArray[startIndex + 2],
                cardDeckArray[startIndex + 3],
                cardDeckArray[endIndex]
            );
            playerLists.add(new String[] {Integer.toString(player), playerPokerHand.get(0)});
            if (null != playerPokerHand.get(0)) switch (playerPokerHand.get(0)) {
                case "Royal Flush":
                    royalFlushList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});
                    break;
                case "Straight Flush":
                    straightFlushList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "Four Of A Kind":
                    fourOfAKindList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "Full House":
                    fullHouseList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "Flush":
                    flushList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "Straight":
                    straightList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "Three Of A Kind":
                    threeOfAKindList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "Two Pairs":
                    twoPairsList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "One Pair":
                    onePairList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                case "High Card":
                    highCardList.add(new Integer[] {player, Integer.parseInt(playerPokerHand.get(1))});   
                    break;
                default:
                    break;
            }
        }
        System.out.println("============================================");
        String playerHand;
        if (royalFlushList.size() > 0) {
            playerHand = "Royal Flush";
            determineSimulationWinner(straightFlushList, sim, playerHand);
        }
        else if (straightFlushList.size() > 0) {
            playerHand = "Straight Flush";
            determineSimulationWinner(straightFlushList, sim, playerHand);
        }
        else if (fourOfAKindList.size() > 0) {
            playerHand = "Four Of A Kind";
            determineSimulationWinner(fourOfAKindList, sim, playerHand);
        }
        else if (fullHouseList.size() > 0) {
            playerHand = "Full House";
            determineSimulationWinner(fullHouseList, sim, playerHand);
        }
        else if (flushList.size() > 0) {
            playerHand = "Flush";
            determineSimulationWinner(flushList, sim, playerHand);
        }
        else if (straightList.size() > 0) {
            playerHand = "Straight List";
            determineSimulationWinner(straightList, sim, playerHand);
        }
        else if (threeOfAKindList.size() > 0) {
            playerHand = "Three Of A Kind";
            determineSimulationWinner(threeOfAKindList, sim, playerHand);
        }
        else if (twoPairsList.size() > 0) {
            playerHand = "Two Pairs";
            determineSimulationWinner(twoPairsList, sim, playerHand);
        }
        else if (onePairList.size() > 0) {
            playerHand = "One Pair";
            determineSimulationWinner(onePairList, sim, playerHand);
        }
        else if (highCardList.size() > 0) {
            playerHand = "High Card";
            determineSimulationWinner(highCardList, sim, playerHand);
        }
        System.out.println("============================================");
    }
    
    public static void determineSimulationWinner(List<Integer[]> playerHandResult, int sim, String playerHand) {
        if ("Royal Flush".equals(playerHand)) {
            if (playerHandResult.size() == 1) { 
                System.out.println(
                    "SIMULATION " + sim + 
                    " : Player " + playerHandResult.get(0)[0] + 
                    " wins. Royal Flush - " + playerHandResult.get(0)[0]
                );
            } else {
                System.out.println(
                    "SIMULATION " + sim + 
                    " : There was a draw." +
                    "The pot will be split between the folowing players."
                );
                playerHandResult.forEach((player) -> {
                    System.out.println(
                        "Player " + player[0]
                    );
                });          
            }
        } 
        else {
            if (playerHandResult.size() == 1) { 
                System.out.println(
                    "SIMULATION " + sim + 
                    " : Player " + playerHandResult.get(0)[0] + 
                    " wins with a " + playerHand
                );
            } else {
                ArrayList<Integer> players = new ArrayList<>();
                ArrayList<Integer>  scores = new ArrayList<>();
                playerHandResult.forEach((player) -> {
                    players.add(player[0]);
                    scores.add(player[1]);
                });
                int maxScore = Collections.max(scores);
                int scoreFrequency = Collections.frequency(
                    scores, maxScore
                );
                if (scoreFrequency == 1) {
                    int winningStraightFlushPlayer = 
                    scores.indexOf(maxScore);   
                    System.out.println(
                        "SIMULATION " + sim + 
                        " : Player " + 
                        players.get(winningStraightFlushPlayer) +
                        " wins with a " + playerHand
                    );
                } else {
                    System.out.println(
                        "SIMULATION " + sim + 
                        " : There was a draw." +
                        "The pot will be split between the players."
                    );
                }
            }
        }
    }
    
    public static ArrayList<String> determinePlayerPokerHand(
        String[] card1, 
        String[] card2,
        String[] card3,
        String[] card4,
        String[] card5
    ) {
        ArrayList<String> result = new ArrayList<>();
        String[] cardSuiteArray = {
            card1[1],
            card2[1],
            card3[1],
            card4[1],
            card5[1]
        };
        String[] cardRankArray = {
            card1[2],
            card2[2],
            card3[2],
            card4[2],
            card5[2]
        };
        int[] cardRankPointArray = {
            Integer.parseInt(card1[3]),
            Integer.parseInt(card2[3]),
            Integer.parseInt(card3[3]),
            Integer.parseInt(card4[3]),
            Integer.parseInt(card5[3])
        };
        Arrays.sort(cardRankPointArray);
        int sum = IntStream.of(cardRankPointArray).sum();
        // SAME SUITE HANDS
        if (
            cardSuiteArray[1].equals(cardSuiteArray[0]) &&
            cardSuiteArray[2].equals(cardSuiteArray[0]) &&
            cardSuiteArray[3].equals(cardSuiteArray[0]) &&
            cardSuiteArray[4].equals(cardSuiteArray[0])
        ) {
            // royal flush check
            result = royalFlushCheck(cardRankArray, sum);
            if (!result.isEmpty()) {
                System.out.println(
                        "Poker Hand : " + result.get(0)
                );
            } else {
                // straight flush check
                result = straightFlush(cardRankPointArray, sum);
                if (!result.isEmpty()) {
                    System.out.println(
                        "Poker Hand : " + result.get(0)
                    );
                } else {
                    // flush check
                    result = flush(cardSuiteArray, sum);
                    System.out.println(
                        "Poker Hand : " + result.get(0)
                    );
                }
            }
        } else {
            // RANK MATCHING HANDS
            result = rankMatching(cardRankArray, sum);
            if (!result.isEmpty()) {
                System.out.println(
                    "Poker Hand : " + result.get(0)
                );
            } else {
                // HIGHEST CARD HANDS
                result = highestCard(cardRankPointArray, sum);
                System.out.println(
                    "Poker Hand : " + result.get(0)
                );
            }
        }
        return result;     
    }
    
    public static ArrayList<String> royalFlushCheck(String[] cardRankArray, int sum) {
        ArrayList<String> pokerHand = new ArrayList<>();
        int firstCard = 0;
        int secondCard = 0;
        int thirdCard = 0;
        int fourthCard = 0;
        int fifthCard = 0;
        for (String i : cardRankArray) {
            if (null != i) switch (i) {
                case "Ace":
                    firstCard++;
                    break;
                case "King":
                    secondCard++;
                    break;
                case "Queen":
                    thirdCard++;
                    break;
                case "Jack":
                    fourthCard++;
                    break;
                case "10":
                    fifthCard++;
                    break;
                default:
                    break;
            }
        }
        int total = firstCard + secondCard + thirdCard + fourthCard + fifthCard;
        if (total == 5) {
            pokerHand.add("Royal Flush");
            pokerHand.add(Integer.toString(sum));
        }   
        return pokerHand; 
    }
    
    public static ArrayList<String> straightFlush(int[] cardRankPointArray, int sum) {
        ArrayList<String> pokerHand = new ArrayList<>();
        int firstValue = cardRankPointArray[4] - cardRankPointArray[3];
        int secondValue = cardRankPointArray[3] - cardRankPointArray[2];
        int thirdValue = cardRankPointArray[2] - cardRankPointArray[1];
        int fourthValue = cardRankPointArray[1] - cardRankPointArray[0];
        if (
            firstValue == 1 &&
            secondValue == 1 &&
            thirdValue == 1 &&
            fourthValue == 1
        ) {
            pokerHand.add("Straight Flush");
            pokerHand.add(Integer.toString(sum));
        }
        return pokerHand;
    }
    
    public static ArrayList<String> flush(String[] cardSuiteArray, int sum) {
        ArrayList<String> pokerHand = new ArrayList<>();
        if (
            cardSuiteArray[1].equals(cardSuiteArray[0]) &&
            cardSuiteArray[2].equals(cardSuiteArray[0]) &&
            cardSuiteArray[3].equals(cardSuiteArray[0]) &&
            cardSuiteArray[4].equals(cardSuiteArray[0])
        ) {
            pokerHand.add("Flush");
            pokerHand.add(Integer.toString(sum));
        }
        return pokerHand;
    }
    
    public static ArrayList<String> rankMatching(String[] cardRankArray, int sum) {
        ArrayList<String> pokerHand = new ArrayList<>();
        int acesCount = 0;
        int kingsCount = 0;
        int queensCount = 0;
        int jacksCount = 0;
        int tensCount = 0;
        int ninesCount = 0;
        int eightsCount = 0;
        int sevensCount = 0;
        int sixesCount = 0;
        int fivesCount = 0;
        int foursCount = 0;
        int threesCount = 0;
        int twosCount = 0;
        for (String i : cardRankArray) {
            if (null != i) switch (i) {
                case "Ace":
                    acesCount++;
                    break;
                case "King":
                    kingsCount++;
                    break;
                case "Queen":
                    queensCount++;
                    break;
                case "Jack":
                    jacksCount++;
                    break;
                case "10":
                    tensCount++;
                    break;
                case "9":
                    ninesCount++;
                    break;
                case "8":
                    eightsCount++;
                    break;
                case "7":
                    sevensCount++;
                    break;
                case "6":
                    sixesCount++;
                    break;
                case "5":
                    fivesCount++;
                    break;
                case "4":
                    foursCount++;
                    break;
                case "3":
                    threesCount++;
                    break;
                case "2":
                    twosCount++;
                    break;
                default:
                    break;
            }
        }
        if ( 
            acesCount == 4
            || kingsCount == 4
            || queensCount == 4
            || jacksCount == 4
            || tensCount == 4
            || ninesCount == 4
            || eightsCount == 4
            || sevensCount == 4
            || sixesCount == 4
            || fivesCount == 4
            || foursCount == 4
            || threesCount == 4
            || twosCount == 4
        ) {
            pokerHand.add("Four Of A Kind");
            pokerHand.add(Integer.toString(sum));
        } 
        if (
            (
                acesCount == 3
                || kingsCount == 3
                || queensCount == 3
                || jacksCount == 3
                || tensCount == 3
                || ninesCount == 3
                || eightsCount == 3
                || sevensCount == 3
                || sixesCount == 3
                || fivesCount == 3
                || foursCount == 3
                || threesCount == 3
                || twosCount == 3
            ) && (
                acesCount == 2
                || kingsCount == 2
                || queensCount == 2
                || jacksCount == 2
                || tensCount == 2
                || ninesCount == 2
                || eightsCount == 2
                || sevensCount == 2
                || sixesCount == 2
                || fivesCount == 2
                || foursCount == 2
                || threesCount == 2
                || twosCount == 2
            )
        ) {
            pokerHand.add("Full House");
            pokerHand.add(Integer.toString(sum));
        }
        if ( 
            acesCount == 3
            || kingsCount == 3
            || queensCount == 3
            || jacksCount == 3
            || tensCount == 3
            || ninesCount == 3
            || eightsCount == 3
            || sevensCount == 3
            || sixesCount == 3
            || fivesCount == 3
            || foursCount == 3
            || threesCount == 3
            || twosCount == 3
        ) {
            pokerHand.add("Three Of A Kind");
            pokerHand.add(Integer.toString(sum));
        }
        if (
            (
                acesCount == 2
                || kingsCount == 2
                || queensCount == 2
                || jacksCount == 2
                || tensCount == 2
                || ninesCount == 2
                || eightsCount == 2
                || sevensCount == 2
                || sixesCount == 2
                || fivesCount == 2
                || foursCount == 2
                || threesCount == 2
                || twosCount == 2
            ) && (
                acesCount == 2
                || kingsCount == 2
                || queensCount == 2
                || jacksCount == 2
                || tensCount == 2
                || ninesCount == 2
                || eightsCount == 2
                || sevensCount == 2
                || sixesCount == 2
                || fivesCount == 2
                || foursCount == 2
                || threesCount == 2
                || twosCount == 2
            )
        ) {
            pokerHand.add("Two Pairs");
            pokerHand.add(Integer.toString(sum));
        }
        if ( 
            acesCount == 2
            || kingsCount == 2
            || queensCount == 2
            || jacksCount == 2
            || tensCount == 2
            || ninesCount == 2
            || eightsCount == 2
            || sevensCount == 2
            || sixesCount == 2
            || fivesCount == 2
            || foursCount == 2
            || threesCount == 2
            || twosCount == 2
        ) {
            pokerHand.add("One Pair");
            pokerHand.add(Integer.toString(sum));
        }
        return pokerHand; 
    }
    
    public static ArrayList<String> highestCard(int[] cardPointArray, int sum) {
        ArrayList<String> pokerHand = new ArrayList<>();
        pokerHand.add("High Card");
        pokerHand.add(Integer.toString(sum));
        return pokerHand;
    }
    
    static void shuffleCardArray(String[][] arrayShuffled)
    {
      Random randomValue = new Random();
      for (int i = arrayShuffled.length - 1; i > 0; i--)
      {
        int index = randomValue.nextInt(i + 1);
        String[] a = arrayShuffled[index];
        arrayShuffled[index] = arrayShuffled[i];
        arrayShuffled[i] = a;
      }
    }
    
    public static void main(String[] args) { 
        runGreetingOnStart();
        addSimulationAndPlayerInputs();
    }
    
}
