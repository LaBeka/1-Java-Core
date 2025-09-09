package org.example;

import java.util.Scanner;

public class DayOne {

  private Scanner scanner = new Scanner(System.in);


  private int checkUsingParseInt(String message) {
    System.out.print(message);
    String input = scanner.nextLine().trim();
    int num = 0;
    try {
      // Attempt to parse the input string to an integer
      num = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      checkUsingParseInt("Not a valid number. Try again " + message.toLowerCase() );
    }
    return num;
  }

  private double checkUsingParseDouble(String message) {
    System.out.println(message);
    String input = scanner.next().trim();
//    System.out.println("input: "+ input);
    double num = 0.0;
    try {
      num = Double.parseDouble(input);
    } catch (NumberFormatException e) {
      checkUsingParseDouble("Not a valid number. Try again " + message.toLowerCase() );
    }
    return num;
  }

  public void ålderskategorier(){

    int age = checkUsingParseInt("Enter your age: ");

    if (age < 13) {
      System.out.println("Barn");
    } else if (age >= 13 && age <= 19) {
      System.out.println("Tonåring");
    } else if (age >= 20 && age <= 64) {
      System.out.println("Vuxen");
    } else {
      System.out.println("Senior");
    }
    ålderskategorier();

  }

  public void betygskonverterare(){

    int betyg = checkUsingParseInt("Enter your poäng (0-100) : ");
    String poäng = "";

    if(betyg < 0 && betyg > 100){
      System.out.println("Invalid betyg.");
    } else if(betyg <= 100 && betyg >= 90){
      poäng = "A";
    } else if(betyg <= 89 && betyg >= 80){
      poäng = "B";
    } else if(betyg <= 79 && betyg >= 70){
      poäng = "C";
    } else if(betyg <= 69 && betyg >= 60){
      poäng = "D";
    } else if (betyg < 60) {
      poäng = "F";
    }
    System.out.println("Din betyg är: " + poäng);
    betygskonverterare();
  }

  public void enkelKalkylator(){

    double firstNum = checkUsingParseDouble("Enter first number: ");

    double secondNum = checkUsingParseDouble("Enter second number: ");

    System.out.print("Type operation: ");
    char charOperator = scanner.next().charAt(0);

    while (secondNum == 0 && charOperator == '/') {
      secondNum = checkUsingParseDouble("Division by zero is not possible. Enter a positive number again: ");
    }

    double result = 0.0;

    switch (charOperator){
      case '+': result = firstNum + secondNum; break;
      case '-': result = firstNum - secondNum; break;
      case '*': result = firstNum * secondNum; break;
      case '/': result = firstNum / secondNum; break;
      default:
        System.out.println("Enter a valid operation sign: "); break;
    }

    System.out.printf("forst tal: %.1f; andra tal: %.1f; operation: %c; result: %.2f",
        firstNum,
        secondNum,
        charOperator,
        result);
    System.out.println();

    enkelKalkylator();
  }

  public void temperaturomvandlareMedRekommendationer(){

    int konverter = checkUsingParseInt("Välj konverteringsriktning ('1' C->F eller '2' F->C): ");
    while (konverter != 1 && konverter != 2){
      konverter = checkUsingParseInt("Välj konverteringsriktning '1' for (C->F) eller '2' for (F->C): ");
    }
    System.out.print("Ange temperatur: ");
    double temperatur = checkUsingParseDouble("Ange temperatur: ");
    double celsiusResult = 0.0;
    double fahrenheitResult = 0.0;

    switch (konverter){
      case 1:
        // Convert Celsius to Fahrenheit
        fahrenheitResult = (temperatur * 9 / 5) + 32;
        celsiusResult = temperatur;
        System.out.printf("Result: %.2f °C = %.2f °F%n", temperatur, fahrenheitResult);
        break;
      case 2:
        celsiusResult = (temperatur - 32) * 5 / 9;
        fahrenheitResult = temperatur;
        System.out.printf("Result: %.2f °F = %.2f °C%n", temperatur, celsiusResult);
        break;
      default:
        System.out.println("Valet är ogiltigt!");
        break;
    }
    // Give clothing recommendation based on users choice
    System.out.println(konverter == 1 ? getClothingAdvice(celsiusResult) : getClothingAdvice(fahrenheitResult));
    temperaturomvandlareMedRekommendationer();
  }
  private String getClothingAdvice(double result) {
    if (result < 0) {
      return "Mycket kallt - ta på dig vinterkläder!";
    } else if (result <= 10) {
      return "Kallt - jacka behövs";
    } else if (result <= 20) {
      return "Svalt - lätt jacka";
    } else if (result <= 30) {
      return "Behagligt - t-shirt räcker";
    } else {
      return "Varmt - shorts och linne!";
    }
  }

  public void bankkontoSimulator(){
    double balance = 0.0;
    System.out.println("Your current balance is: " + balance);
    System.out.println("Enter the transaction type 'deposit' or 'withdrawal')");
    String type = scanner.nextLine();

    if(type.equals("deposit")){

      double amount = checkUsingParseDouble("Enter how much you want to deposit: ");
      if(amount < 0) checkUsingParseDouble("Entered value can not be negative, try again: ");
      balance += amount;
      System.out.println("Your current balance is: " + balance);

    } else if(type.equals("withdrawal")){

      double amount = checkUsingParseDouble("Enter how much you want to deposit: ");
      if(amount > balance) checkUsingParseDouble("Your current amount is:" + balance +" Enter less amount then your balance: ");
      if(amount < 0) checkUsingParseDouble("Entered value can not be negative, try again: ");
      balance -= amount;
      System.out.println("Your current balance is: " + balance);
    }
    bankkontoSimulator();
  }

}
