package org.example;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DayTwo {
  private Scanner sc = new Scanner(System.in);

  public void temperaturanalysFörEnVecka() {

    double [] weeklyTemp = new double[7];
    String[] weekday = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    Map<String, Double> daysWithTemp = new HashMap<>();

    double avgtemp = 0.0;
    double alltemp = 0.0;

    for (int i = 0; i < weeklyTemp.length; i++) {
      System.out.printf("Write the temp for the day %s \n", weekday[i]);
      double temp = sc.nextDouble();
      daysWithTemp.put(weekday[i], temp);
      weeklyTemp[i] = temp;
      alltemp += temp;
    }
    avgtemp = alltemp / weeklyTemp.length;
    System.out.printf("the average temperature this week is: %.2f%n", avgtemp);

    Arrays.sort(weeklyTemp);
    System.out.printf("The min temperature is: %.2f%n", weeklyTemp[0]);

    System.out.printf("The max temperature is: %.2f%n", weeklyTemp[weeklyTemp.length - 1]);

    int daysOver20 = 0;
    for (double temp : weeklyTemp)
    {
      // System.out.printf("Temperatures are %.2f%n", temp);

      if (temp >= 20)
      {
        daysOver20++;
      }
    }
    System.out.printf("Days where temp is hot and nice over 20 is %s %n", daysOver20);
  }

  /*
          // Uppgift 2: Studentbetyg för en klass

        Beskrivning
        * Hantera betyg för en hel klass och skapa statistik.

        Krav
        * Fråga användaren om antal studenter i klassen
        * Skapa en dynamisk array baserat på antal studenter
        * För varje student:
            * Läs in namn (String-array)
            * Läs in 5 betyg (int-array för varje student = 2D-array)
        * Använd nested loops för att:
            * Beräkna varje students genomsnitt
            * Hitta klassens bästa student
            * Räkna antal godkända (≥3) vs underkända (<3)
        * Visa en ranking-lista (sortera studenter efter genomsnitt)

          for (int a : arr) {
            System.out.println(a);
        }

   */

  public void studentbetygFörEnKlass(){
    Scanner sc = new Scanner(System.in);
    //1. Fråga användaren om antal studenter i klassen
    System.out.println("Please enter the number of students?");
    int nrstudents = sc.nextInt();
    ArrayList<String> students = new ArrayList<>();

//    2. Skapa en dynamisk array baserat på antal studenter
    int[][] grades = new int[nrstudents][5];
    double[] avrgGrade = new double[nrstudents];

    for(int s = 0; s < nrstudents; s++){

      //3.1. Läs in namn (String-array)
      System.out.println("Please enter the student #" + s + " name: ");
      students.add(sc.next());

      grades = populateGrades(s, grades);

      int sum = 0;

      // 3.2. Läs in 5 betyg (int-array för varje student = 2D-array)
      for(int i = 0; i < 5; i++){
        sum+=grades[s][i];
      }

      //4.1. Beräkna varje students genomsnitt
      double avrg = sum / 5;
      avrgGrade[s] = avrg;
    }

    //4.2. Hitta klassens bästa student
    int bestStudentIndex = -1;
    double bestAvrgGrade = Double.NEGATIVE_INFINITY;
    for(int j=0; j < nrstudents; j++){
      if(avrgGrade[j] > bestAvrgGrade){
        bestStudentIndex = j;
        bestAvrgGrade = avrgGrade[j];
      }
    }
    System.out.println("The best student is " + students.get(bestStudentIndex));

//    4.3. Räkna antal godkända (≥3) vs underkända (<3)
    ArrayList<String> pass = new ArrayList<>();
    ArrayList<String> fail = new ArrayList<>();
    for(int k=0; k < nrstudents; k++){
      if(avrgGrade[k] >= 3){
        pass.add(students.get(k));
      }
      else{
        fail.add(students.get(k));
      }
    }
    System.out.println( pass.size() + " have passed the class, " + fail.size()+" have failed.");

//    4.5. Visa en ranking-lista (sortera studenter efter genomsnitt)
    HashMap<String, Double> ranking = new HashMap<String, Double>();
    for(int m= 0; m < nrstudents; m++){
      ranking.put(students.get(m), avrgGrade[m]);
    }
    System.out.println("Student ranking list: ");
    int nr = nrstudents;
    while(nr > 0){
      double max_ = 0;
      String max_s = "";
      for(int b=0;  b < nrstudents; b++){
        if (ranking.get(students.get(b)) > max_){
          max_ = ranking.get(students.get(b)); //students Arraylist<String>
          max_s = students.get(b);
        }
      }
      System.out.println(max_s);
      ranking.put(max_s, Double.parseDouble("-1.0"));

    }
/*
    LinkedHashMap<String, Double> lhm = new LinkedHashMap<String, Double>(ranking);
    lhm.entrySet().stream().sorted(Map.Entry.comparingByValue()).sorted(
        Comparator.reverseOrder().reversed()).forEach(System.out::println);
    //Collections.reverse(ranking.entrySet().stream().sorted(Map.Entry.comparingByValue())).forEach(System.out::println);

 */
    }
  

  private int[][] populateGrades(int index,  int[][] grades){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter the grades: ");
    String studentGrades = sc.nextLine();
    String[] gradesTmp = studentGrades.split(" ");
    while(gradesTmp.length != 5){
      System.out.println("Please enter 5 grades: ");
      studentGrades = sc.nextLine();
      gradesTmp = studentGrades.split(" ");
    }
    for(int i = 0; i < gradesTmp.length; i++){
      grades[index][i] = Integer.parseInt(gradesTmp[i]);
    }
    return grades;
  }

  public void veckansUtgifter() {
    String[] vdagar  = {"måndag", "tisdag", "onsdag", "torsdag", "fredag", "lördag", "söndag"};
    //Skapa en array för 7 dagars utgifter (double[])
    int[] kostnad = new int[7];
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < vdagar.length; i++){
      System.out.println("Vad har du för utgifter för " + vdagar[i]+"?");
      String tmp = sc.nextLine();
      kostnad[i] = Integer.parseInt(tmp);
    }
    int total = 0;

    int overBudgetCount = 0;
    for(int k : kostnad){
      total += k;
      if(k > 100){ overBudgetCount++;}
    }
    int max   = 0;
    int maxIndex = -1;
    for(int j = 0; j < vdagar.length; j++){
      if(kostnad[j] > max){
        max = kostnad[j];
        maxIndex = j;
      }
    }
    System.out.println("totalt: " + total + " kr    dyraste dagen: " + vdagar[maxIndex] + " dagar över 100: " + overBudgetCount);

  }

  /*Uppgift 4: Handelslista med priser
      Beskrivning
  Skapa en handelslista där användaren kan mata in varor och priser.
      Krav
● Fråga användaren hur många varor de vill köpa (max 10)
● Skapa arrayer för varnamn (String[]) och priser (double[])
      ● Använd for-loop för att läsa in varor och priser
● Använd for-loop för att:
      ○ Räkna totalkostnad
○ Hitta dyraste varan
○ Visa hela listan*/

  public void handelslistaMedPriser () {
    Scanner sc = new Scanner(System.in);
    System.out.println("Hur många varor vill du köpa? "
        + "ange ett tal mellan 1 och 10");
    int nr = sc.nextInt();

    if(nr > 10 || nr < 1){
      System.out.println("Ogiltigt antal varor"
          + " ange ett antal mellan 1 och 10");
      handelslistaMedPriser();
    }
    else{
     String[] varor = new String[nr];
     double[] priser = new double[nr];
     double totalKostnad = 0.0;
     int indexDyraste = 0;
     
     for(int i = 0; i < varor.length; i++){
       System.out.println("Vänligen skriv in namn på vara nr: " + (i + 1));
       varor[i] = sc.next();
       System.out.println("Vänligen skriv in pris på vara: " + (i + 1));

       double tmpPris = Double.parseDouble(sc.next().replaceAll(",", "."));
       totalKostnad += tmpPris;
       priser[i] = tmpPris;
       if(priser[i] > priser[indexDyraste]){
         indexDyraste = i;
       }
     }
     System.out.println("Totalkostnad: " + totalKostnad);
      System.out.println("Dyraste varan: " + varor[indexDyraste] +
          " pris: " + priser[indexDyraste]);
      System.out.println("Varor");
      for(int i = 0; i < nr; i++){
        System.out.println(varor[i] + " " + priser[i]);
      }
    }
  }

  public void enkelTallek() {
    Scanner sc = new Scanner(System.in);
    int[] computerSecret = new int[5];
    for(int i = 0; i < computerSecret.length; i++){
      computerSecret[i] = (int) (Math.random() * 20) + 1;
    }

    List<Integer> userGuesses = new ArrayList<>();
    int succces = 0;
    boolean[] correctGuesses = new boolean[computerSecret.length];

    while(succces < 5 && userGuesses.size() < 15){
      System.out.println("Please enter your guess: ");
      userGuesses.add(sc.nextInt());

      for(int i = 0; i < computerSecret.length; i++){
          if((computerSecret[i] == userGuesses.get(userGuesses.size() - 1)) &&
          !correctGuesses[i]){
            correctGuesses[i] = true;
            succces++;
          }
      }
    }
    System.out.println("Your attempts are: " + userGuesses.size());
    System.out.println("Success: " + succces);

  }
}