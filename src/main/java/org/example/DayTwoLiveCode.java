package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class DayTwoLiveCode {

  public void program1() throws InterruptedException {

    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    System.out.println("Please type in the number of rounds, type 0 to exit");
    int rounds =  checkIfInteger(sc.nextLine());

    if(rounds == -1){
      System.out.println("You typed an invalid choice");
      program1();
    }

    else if(rounds == 0){
      System.exit(0);
    }

    int playerPoints = 0;
    int computerPoints = 0;
    Timer timer = new Timer();

    for(int i = 0; i < rounds; i++){

      Thread.sleep(1000);

      int playerDice = random.nextInt(1, 7);
      int computerDice = random.nextInt(1, 7);

      System.out.println("player rolled: " + playerDice + " " + "computer rolled: " + computerDice);

      if(playerDice < computerDice){
        computerPoints++;
        System.out.println("Computer wins round: " + (i + 1));
      }
      else if(playerDice > computerDice){
        playerPoints++;
        System.out.println("Player wins round: " + (i + 1));
      }
      else{
        System.out.println("Nobody wins round: " + (i + 1));
      }
      System.out.println();
    }

    if(playerPoints > computerPoints){
      System.out.println("Player wins!!");
    }
    else if(playerPoints < computerPoints){
      System.out.println("Computer wins!!");
    }
    else{
      System.out.println("Nobody wins!!");
    }
    System.out.println(" Player won " + playerPoints + " times" +
        " computer won " + computerPoints + " times");

    System.out.println("Do you want to play again, press 0 to quit, press 1 to play again");
    switch (sc.nextInt()){
      case 0 -> System.exit(0);
      case 1 -> program1();
    }
  }

  private int checkIfInteger(String input){
    String result = input.replaceAll("\\D", "");
    if(result.length() == 0){
      return -1;
    }
    return Integer.parseInt(result);
  }
}
