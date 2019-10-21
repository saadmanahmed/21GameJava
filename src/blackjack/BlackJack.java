/*
 * Saadman Ahmed,Matric:1536451
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random //Used to generate random numbers
import java.util.ArrayList//Importing dynamic array
import java.util.Scanner;

/**This is a standard game of BlackJack Designed by Saadman Ahmed.The user draws
 * card and the sum of the cards must be 21 for the user to win.If the total card points
 * of the user exceeds 21,user is "busted" and loses the game.
 *
 * @author Mirza Ertefa Eram
 */
public class BlackJack {
  static Random r=new Random();
  static Scanner s = new Scanner(System.in);//create a reader to take user input.
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     ArrayList<Integer> cards=drawTwo();
      /*
     * Get the first card from the list, 
     * the second card from the list,
     * and then get the total of them from the cardsTotal() method.
     */
    System.out.println("You drew " + cards.get(0) + " and " + cards.get(1) + " giving you a current score of " + cardsTotal(cards));
     if(cardsTotal(cards)==21){ 
//pass the cards to cards total function to see total points
     System.out.println("Congratulations, you got 21!");
     return;}
    System.out.println("Press 1 to draw another card. Press 2 to stand");//if card is not 21,you can either choose next card,however if you exceed 21,you will be busted!
    playCards(cards);//start the playCards() method, passing it the "cards" list.
  }
     
    
    public static void playCards(ArrayList<Integer> cards){
    int choice = getChoice();//The getChoice method is in the helper methods block.

    if(choice == 1)//The the players choice is 1
    {
      int newCard = drawCard();//draw a card with the "drawCard()" method
      cards.add(newCard);//add it to the list.
      System.out.println("You drew a " + newCard + ".");//print what you drew
      if(cardsTotal(cards) == 21)//and then check if you have 21 or more.
      {
        System.out.println("Congratulations, you got 21!");
        return;
      }
      else if(cardsTotal(cards) > 21)
      {
        System.out.println("Whoops, you have too many points");
        return;
      }
      else {//if you don't have 21 or more, it continues.
        System.out.println("You currently have " + cardsTotal(cards) + " cards. Press 1 or 2 again");
        playCards(cards);//call this method again. This is known as recursion.
      }
    }

    else {//If the user doesn't choose 1
      System.out.println("Your final score is " + cardsTotal(cards));//print the final score
      return;//and break out of the loop.
    }
        
    }
    public static int drawCard(){
        int card=r.nextInt(13)+1;//generates a random number between 1 and 13
        if(card==1){
            card=11;//Since in a deck of cards,ace=1 but ace has a point of 11 in this game
        }
        else if(card>10){
            card=10;//anything more than 10 is counted as 10
        }
        return card;
        
    }
    public static ArrayList<Integer> drawTwo(){
        ArrayList<Integer> cards=new ArrayList<Integer>();
        for(int i=0;i<2;i++){
            cards.add(drawCard());
        }
        return cards;
    }
    public static int cardsTotal(ArrayList<Integer> cards){
        int total=0;
        for(int card:cards){
            total+=card;//get the total point of cards
        }
        return total;
        
    }
    public static int getChoice(){
       int choice=0;
       while(choice!=1 && choice!=2){
           String next=s.next();
           try{
               choice=Integer.parseInt(next);
           }
           catch(Exception e){
               System.out.println("Enter a valid number please1");//in case user enters a wrong number
           }
           }
       return choice;
        
        
        
        
    }
    
}
