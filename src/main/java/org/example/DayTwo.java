package org.example;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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

        //namn
        //1 2 3 4 5

    for(int s=0; s> nrstudents; s++){

      //3.1. Läs in namn (String-array)
      System.out.println("Please enter the student #" + s + " name: ");
      students.add(sc.nextLine());
      grades = populateGrades(s, sc.nextLine(), grades);
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
    System.out.println("pass: " + pass.size() + "fail: " + fail.size());

//    4.5. Visa en ranking-lista (sortera studenter efter genomsnitt)
    HashMap<String, Double> tmp = new HashMap<String, Double>();
    for(int m= 0; m < nrstudents; m++){
      tmp.put(students.get(m), avrgGrade[m]);
    }
    System.out.println("Student ranking list");
    tmp.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

  }

  // 1 2 3 4 5

  private int[][] populateGrades(int index, String studentGrades, int[][] grades){
    String[] gradesTmp = studentGrades.split(" ");
    for(int i = 0; i < gradesTmp.length; i++){
      grades[index][i] = Integer.parseInt(gradesTmp[i]);
    }
    return grades;
  }

  public void veckansUtgifter() {

  }

  public void handelslistaMedPriser () {

  }

  // Begaiym
  public void enkelTallek() {

    System.out.println();
  }
}