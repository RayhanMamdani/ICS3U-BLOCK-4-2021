package week7;

import java.util.Scanner;

public class CrazyEights {
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int NUM_SUITS = 4;
    private static final int CARDS_PER_SUIT = 13;
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final String ACE = "A";
    private static final int SCORE_CAP = 100;
    

    public static void main(String[] args) {
        int playerPoints = 0, c1Points = 0, c2Points = 0;

        while (!gameOver(playerPoints, c1Points, c2Points)) {
            System.out.println("Your Score = " + playerPoints);
            System.out.println("Computer 1 Score = " + c1Points);
            System.out.println("Computer 2 Score = " + c2Points);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("New round starting...");
            String result = playRound();
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));
        }
         System.out.println(getWinner(playerPoints, c1Points, c2Points));
         System.out.println("-- END RESULTS --");
         System.out.println("Your points: " + playerPoints);
         System.out.println("Computer 1 points: " + c1Points);
         System.out.println("Computer 2 points: " + c2Points);
    }
/**
 * After someone reaches 100 points, declares who has lowest points (the winner)
 * @param playerPoints Players total points
 * @param c1Points Computer 1's total points
 * @param c2Points Computer 2's total points
 * @return The winner who has lowest total points
 */
    private static String getWinner(int playerPoints, int c1Points, int c2Points) {
        if(playerPoints < c1Points && playerPoints < c2Points)
            return "You win!";
        else if(c1Points < playerPoints && c1Points < c2Points)
            return "Computer 1 wins!";
        else if(c2Points < playerPoints && c2Points < c1Points)
            return "Computer 2 wins!";
        else if(playerPoints == c1Points)
            return "You tied with Computer 1!";
        else if(playerPoints == c2Points)
            return "You tied with Computer 2!";
        else
            return "Computer 1 tied with Computer 2!";
    }   
/**
 * Simulates one round of the game of 3 players (2 computers)
 * @return the points of each player after the round
 */
    private static String playRound() {
        Scanner in = new Scanner(System.in);
        String playerHand = dealHand();
        String c1Hand = dealHand();
        String c2Hand = dealHand();

        String topCard = getCard();
        while (topCard.substring(0, 1).equals("8")) {
            topCard = getCard();
        }
        while(playerHand.trim().length() > 0 && c1Hand.trim().length() > 0 && c2Hand.trim().length() > 0){
        System.out.println("Top card: " + topCard);
        
        String temp = processPlayer(playerHand, topCard, in);
        playerHand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
        System.out.println("Your new hand is: " + playerHand);
        System.out.println("-----------------------------------");



        

        System.out.println();
        temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
        System.out.println("Computer 1 Played: " + topCard);
        if(topCard.substring(0, 1).equals("8")){
            System.out.print("Computer 1 played an 8!");
            String newRandomSuit = "";
            if(c1Hand.indexOf(SPADES) >= 0)
                newRandomSuit = SPADES;
            else if(c1Hand.indexOf(HEARTS) >= 0)
                newRandomSuit = HEARTS;
            else if(c1Hand.indexOf(CLUBS) >= 0)
                newRandomSuit = CLUBS;
            else 
                newRandomSuit = DIAMONDS;
            System.out.println(" New suit is " + newRandomSuit);
            topCard = "8" + newRandomSuit;
        }

        String c1NewHand = "";
        int c1Count = 0;
        for(int i = 0; i < c1Hand.length(); i++){
            String str1 = c1Hand.substring(i, i + 1);
            if (" ".equals(str1))
                c1Count++;
        }
        for(int i = 0; i < c1Count; i++){
            c1NewHand += "XX ";
        }
        System.out.println("Computer 1: " + c1NewHand);
        System.out.println("-----------------------------------");
        
        System.out.println();
        temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
        c2Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
        System.out.println("Computer 2 Played: " + topCard);
        if(topCard.substring(0, 1).equals("8")){
            System.out.print("Computer 2 played an 8!");
            String newRandomSuit = "";
            if(c2Hand.indexOf(SPADES) >= 0)
                newRandomSuit = SPADES;
            else if(c2Hand.indexOf(HEARTS) >= 0)
                newRandomSuit = HEARTS;
            else if(c2Hand.indexOf(CLUBS) >= 0)
                newRandomSuit = CLUBS;
            else 
                newRandomSuit = DIAMONDS;
            System.out.println(" New suit is " + newRandomSuit);
            topCard = "8" + newRandomSuit;
        }

        String c2NewHand = "";
        int c2Count = 0;
        for(int i = 0; i < c2Hand.length(); i++){
            String str2 = c2Hand.substring(i, i + 1);
            if (" ".equals(str2))
                c2Count++;
        }
        for(int i = 0; i < c2Count; i++){
            c2NewHand += "XX ";
        }
        System.out.println("Computer 2: " + c2NewHand);
        System.out.println("-----------------------------------");

        }
        int playerScore = 0;
        int c1Score = 0;
        int c2Score = 0;
        if(playerHand.trim().length() == 0){
            c1Score = getScore(c1Hand);
            c2Score = getScore(c2Hand);
            System.out.println("You won this round!");
        }else if(c1Hand.trim().length() == 0){
            playerScore = getScore(playerHand);
            c2Score = getScore(c2Hand);
            System.out.println("Computer 1 won this round!");
        }else{
            playerScore = getScore(playerHand);
            c1Score = getScore(c1Hand);
            System.out.println("Computer 2 won this round!");
        }
        return "" + playerScore + "-" + c1Score  + "-" + c2Score;
    }
/**
 * Gets the score of the remaining cards in a given hand
 * @param hand the leftover cards after a round
 * @return score of the hand
 */
    private static int getScore(String hand) {
        int score = 0;
        for(int i = 0; i < hand.length(); i++){
            if(hand.substring(i, i + 1).equals("1") || hand.substring(i, i + 1).equals(JACK) || hand.substring(i, i + 1).equals(QUEEN) || hand.substring(i, i + 1).equals(KING))
                score += 10;
            else if(hand.substring(i, i + 1).equals("8"))
                score += 50;
            else if(hand.substring(i, i + 1).equals(ACE))
                score += 1;
            else if(hand.substring(i, i + 1).equals(SPADES) || hand.substring(i, i + 1).equals(HEARTS) || hand.substring(i, i + 1).equals(CLUBS) || hand.substring(i, i + 1).equals(DIAMONDS) || hand.substring(i, i + 1).equals(" ")){
            }else
                score += Integer.parseInt(hand.substring(i, i + 1));
        }
        return score;
    }
/**
 * Gets 5 random cards
 * @return 5 random cards with spaces
 */
    private static String dealHand() {
        return getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " ";
    }
/**
 * Gets a random card
 * @return random card with a rank and suit
 */
    private static String getCard() {
        String card = getFace() + getSuit();

        return card;
    }
/**
 * Gets random suit
 * @return random suit
 */
    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);

        if (suit == 0)
            return HEARTS;
        else if (suit == 1)
            return DIAMONDS;
        else if (suit == 2)
            return CLUBS;
        else
            return SPADES;
    }
/**
 * Gets random face
 * @return random face
 */
    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
            return suit + "";
        else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;
    }
/**
 * Simulates which card a computer plays
 * @param currCompHand the hand of the current computer playing
 * @param topCard the top card they have to play on
 * @param playerHand your hand (if one card -> rule 4)
 * @param oppCompHand opposite computer (if one card -> rule 4)
 * @return the new hand of the current computer and the top card (the card just played)
 */
    private static String processComputer(String currCompHand, String topCard, String playerHand, String oppCompHand) {
        int count = 0;
        while(!canPlay(currCompHand, topCard) && count < 5){
            currCompHand += getCard() + " ";
            count++;
            System.out.println("They drew a card!");
        }
        if (count >= 5){
            System.out.println("They drew max cards! Skipping turn...");
            return currCompHand.trim() + " -" + topCard;
        }
        //Rule 4
        if(playerHand.trim().length() <= 3 || oppCompHand.trim().length() <= 3){
            String topCardRank = topCard.substring(0, topCard.length() - 1);
            String topCardSuit = topCard.substring(topCard.length() - 1);
            String cardRank = "";
            boolean sameRankDiffSuit = false;
                for(int i = 0; i < currCompHand.lastIndexOf(" "); i++){
                    cardRank = currCompHand.substring(i, i + topCardRank.length());
                    if(cardRank.equals(topCardRank) && !currCompHand.substring(i + topCardRank.length(), i + topCardRank.length() + 1).equals(topCardSuit)){
                        sameRankDiffSuit = true;
                    }
                if(currCompHand.indexOf("8") >= 0){
                    int index = currCompHand.indexOf("8");
                    topCard = currCompHand.substring(index, index + 2);
                    currCompHand = currCompHand.replaceFirst(currCompHand.substring(index, currCompHand.indexOf(" ", index) + 1), "");
                    return currCompHand.trim() + " -" + topCard;
                }else if(sameRankDiffSuit){
                    String cardRank2 = "";
                    for(int i2 = 0; i2 < currCompHand.lastIndexOf(" "); i2++){
                        cardRank2 = currCompHand.substring(i2, i2 + topCardRank.length());
                        if(cardRank2.equals(topCardRank) && !currCompHand.substring(i2 + topCardRank.length(), i2 + topCardRank.length() + 1).equals(topCardSuit)){
                            int index = i2;
                            topCard = currCompHand.substring(index, index + 2);
                            currCompHand = currCompHand.replaceFirst(currCompHand.substring(index, currCompHand.indexOf(" ", index) + 1), "");
                            return currCompHand.trim() + " -" + topCard;
                        }
                    }
                }
            }

            } 
            String topCardRank = topCard.substring(0, topCard.length() - 1);
            String topCardSuit = topCard.substring(topCard.length() - 1);
            //Rule 1
            //10D 3C 5S 2H 5C
            //6D
            //
            for(int i = 1; i < currCompHand.length(); i++){
                if(topCardSuit.equals(currCompHand.substring(i, i + 1)) && !currCompHand.substring(i - 1, i).equals("8")){
                    int index = i - topCardRank.length();
                    int beginPlaceCard = currCompHand.lastIndexOf(" ", i) + 1;

                    topCard = currCompHand.substring(beginPlaceCard, i + 1);
                    currCompHand = currCompHand.replaceFirst(currCompHand.substring(beginPlaceCard, currCompHand.indexOf(" ", index) + 1), "");
                    return currCompHand.trim() + " -" + topCard;
                }
            }
            //Rule 2
            //10H
            //3D 5H 10H 4S
            for(int i = 0; i < currCompHand.length() - topCardRank.length(); i++){
                if(topCardRank.equals(currCompHand.substring(i, i + topCardRank.length())) && !topCardRank.equals("8")){
                    int index  = i;
                    topCard = currCompHand.substring(i, i + topCard.length());
                    currCompHand = currCompHand.replaceFirst(currCompHand.substring(index, currCompHand.indexOf(" ", index) + 1), "");
                    return currCompHand.trim() + " -" + topCard;
                }
            }

            //Rule 3
            if(currCompHand.indexOf("8") >= 0){
                int index = currCompHand.indexOf("8");
                topCard = currCompHand.substring(index, index + 2);
                currCompHand = currCompHand.replaceFirst(currCompHand.substring(index, currCompHand.indexOf(" ", index) + 1), "");
                return currCompHand.trim() + " -" + topCard;
            }
        
        return currCompHand.trim() + " -" + topCard;
    }
/**
 * Asks user what card to play and validates if they are able to play it
 * @param playerHand the hand of the player before playing
 * @param topCard the top card they have to play on
 * @param in the scanner to read what the user wishes to do
 * @return the new hand of the player and the top card (the card just played)
 */
    private static String processPlayer(String playerHand, String topCard, Scanner in) {
        boolean validInput = false;
        int count = 0;
        System.out.println();
        if(!canPlay(playerHand, topCard) && count < 5){
            playerHand = playerHand.trim() + " ";
        }
        while(!canPlay(playerHand, topCard) && count < 5){
            String newCard = getCard();
            System.out.println("You drew a " + newCard + "!");
            playerHand +=  newCard + " ";
            count++;
        }
        if(count >= 5){
            System.out.println("You drew max cards! Skipping turn...");
            return playerHand + " -" + topCard;
        }
        System.out.println(playerHand);
        System.out.println("Which card would you like to play?");
        while(!validInput){
            try{
                String placeCard = in.nextLine().toUpperCase().trim();
                int index = playerHand.indexOf(placeCard);
                if(!validCard(placeCard, playerHand, topCard)){
                    System.out.println("Invalid Input!");
                }else if(placeCard.substring(0, 1).equals("8")){
                    System.out.println("Which suit would you like to play? [S] [H] [C] [D]: ");
                    String eightSuit = in.nextLine().toUpperCase().trim();
                    if(eightSuit.equals("S") || eightSuit.equals("H") || eightSuit.equals("C") || eightSuit.equals("D")){
                        topCard = "8" + eightSuit;
                        playerHand = playerHand.replaceFirst(playerHand.substring(index, playerHand.indexOf(" ", index) + 1), "");
                        validInput = true;
                        return playerHand + "-" + topCard;
                    }else{
                        System.out.println("Invalid Input");
                    }
                }else{
                    playerHand = playerHand.replaceFirst(playerHand.substring(index, playerHand.indexOf(" ", index) + 1), "");
                    validInput = true;
                    return playerHand + "-" + placeCard;
                }
                
            }catch(Exception ex){
                System.out.println("Invalid Input!");
            }
        }
        return "";  
    }
/**
 * If you are able to play given a certain hand and a top card
 * @param hand the hand to be played from
 * @param topCard the current top card to be played on
 * @return true (can play from hand) or false (cannot play from hand)
 */
    private static boolean canPlay(String hand, String topCard) {
        if(hand.indexOf("8") >= 0 || hand.indexOf(topCard.substring(0, topCard.length() - 1)) >= 0 || hand.indexOf(topCard.substring(topCard.length() - 1)) >= 0)
            return true;
        return false;
    }
    /**
     * Checks if they can play the card from their hand onto a top card
     * @param placeCard the card they wish to play
     * @param playerHand the current hand
     * @param topCard the top card to be played on
     * @return true (can be played) or false (cannot be played)
     */
    private static boolean validCard(String placeCard, String playerHand, String topCard) {
        if(playerHand.indexOf(placeCard) >= 0 && placeCard.length() <= 3){
            if(placeCard.substring(0, placeCard.length() - 1).equals(topCard.substring(0, topCard.length() - 1)))
                return true;
            if(placeCard.substring(placeCard.length() - 1).equals(topCard.substring(topCard.length() - 1)))
                return true;
            if(placeCard.substring(0, 1).equals("8"))
                return true;
        }
        return false;
    }

    /**
     * Checks if someone has reached 100 points (Score cap)
     * @param playerPoints the player total points
     * @param c1Points Computer 1 total points
     * @param c2Points Computer 2 total points
     * @return if someone has reached the point threshhold
     */
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= SCORE_CAP || c1Points >= SCORE_CAP || c2Points >= SCORE_CAP;
    }
}