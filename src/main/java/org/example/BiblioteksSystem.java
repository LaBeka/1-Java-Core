package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BiblioteksSystem{

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args){

    ArrayList<String> bookTitles = new ArrayList<>();
    ArrayList<String> bookAuthors = new ArrayList<>();
    ArrayList<String> bookISBN = new ArrayList<>();
    ArrayList<Boolean> bookAvailable = new ArrayList<>(); // true = tillgänglig
    // Lån (index motsvarar varandra)
    ArrayList<String> borrowerNames = new ArrayList<>();
    ArrayList<String> borrowedBooks = new ArrayList<>(); // ISBN för lånad bok
    // Användare (index motsvarar varandra)
    ArrayList<String> userNames = new ArrayList<>();
    ArrayList<String> phoneNumbers = new ArrayList<>();

    //Förinställd testdata (Person 5 skapar detta)
  // Lägg till dessa i början av main för att spara tid på inmatning
  // Fördefinierade böcker
    bookTitles.add("Harry Potter");
    bookTitles.add("Sagan om ringen");
    bookTitles.add("1984");
    bookAuthors.add("J.K. Rowling");
    bookAuthors.add("Tolkien");
    bookAuthors.add("Orwell");
    bookISBN.add("111");
    bookISBN.add("222");
    bookISBN.add("333");
    bookAvailable.add(true);
    bookAvailable.add(true);
    bookAvailable.add(false); // 1984 är utlånad
  // Fördefinierade användare
    userNames.add("Anna");
    userNames.add("Erik");
    phoneNumbers.add("070-1234567");
    phoneNumbers.add("070-7654321");
  // Fördefinierat lån
    borrowerNames.add("Anna");
    borrowedBooks.add("333"); // Anna har lånat 1984
    //Enkel huvudmeny (Person 5)
    //public static void main(String[] args) {


// TEST SECTION PERSON 3
    System.out.println("displayAllUsers");
    displayAllUsers(userNames,phoneNumbers);

    System.out.println("registerUser");
    displayAllUsers(userNames,phoneNumbers);
    registerUser(userNames,phoneNumbers,"Peter","123-1234567");
    displayAllUsers(userNames,phoneNumbers);

    System.out.println("searchUser");
    int retrievedUserIndex = -2;
    retrievedUserIndex = searchUser(userNames,"Erik");
    System.out.println("retrievedUserIndex: " + retrievedUserIndex);

    Scanner scanner = new Scanner(System.in);
  // Initiera listor och testdata här...
      while (true) {
        System.out.println("\n=== BIBLIOTEKSSYSTEM ===");
        System.out.println("1. Show all books");
        System.out.println("2. Add a book");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Show statistics");
        System.out.println("6. Display main menu");
        System.out.println("7. Display loan menu");
        System.out.println("8. Display book menu");

        System.out.println("0. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Rensa newline
        switch (choice) {
          case 1:
            displayAllBooks(bookTitles, bookAuthors,
                bookISBN);
            break;
          case 2:
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author's name: ");
            String author = scanner.nextLine();
            System.out.print("Enter book's ISBN: ");
            String isbn = scanner.nextLine();
            addBook(bookTitles, bookAuthors, bookISBN, title,
                bookAvailable, author, isbn);
            break;
          case 3:
            //borrow
            System.out.println("Enter title");
            String titleOfBook = scanner.nextLine();
            if (borrowBook(bookAvailable, borrowerNames, borrowedBooks, 0, "John Doe",  bookTitles, titleOfBook)) {
              System.out.println("Success!");
            }
            break;
          case 4:
            //return
            break;
      }
   }
}



  public static void addBook(ArrayList<String> titles,
      ArrayList<String> authors, ArrayList<String> isbn,
      String title, ArrayList<Boolean> booksAvailable,
      String author, String isbnNumber){
    titles.add(title);
    authors.add(author);
    isbn.add(isbnNumber);
    booksAvailable.add(true);
  }
  public static void displayAllBooks(ArrayList<String> titles,
      ArrayList<String> authors, ArrayList<String> isbn){
    System.out.println("CurrentBooks");
    for(int i = 0; i < titles.size(); i++){
      System.out.println(titles.get(i) + " " + authors.get(i) + " " + isbn.get(i));
    }
  }
  public static int searchBook(ArrayList<String> titles,
      ArrayList<String> authors, String searchTerm){
    int titlesIndex = authors.indexOf(searchTerm);
    int authorsIndex = authors.indexOf(searchTerm);
    if(titlesIndex != -1){
      return titlesIndex;
    }
    else if(authorsIndex != -1){
      return authorsIndex;
    }
    return -1;
  }

  
  //PERSON 2
  public static boolean borrowBook(ArrayList<Boolean> available, ArrayList<String> borrowers, ArrayList<String> borrowedBooks, int bookIndex, String borrowerName, ArrayList<String> bookTitles, String bookName ){
    int index = bookTitles.indexOf(bookName);
    if(index == -1){ return false; }
    if(available.get(index)){
      available.set(index, false);
      borrowedBooks.add(bookName);
      borrowers.add(borrowerName);
      return true;
    }
    else { return false;}
 }

  public static boolean returnBook(ArrayList<Boolean> available, ArrayList<String> borrowers, ArrayList<String> borrowedBooks, ArrayList<String> isbnBooks, String bookName, ArrayList<String> bookTitles, String borrower) {
    int index = bookTitles.indexOf(bookName);
    available.set(index, true);
    borrowedBooks.remove(bookName);
    borrowers.remove(borrower);
    return true;
  }

  public static void displayBorrowedBooks(ArrayList<String> borrowers, ArrayList<String> borrowBook){
    for(int i=0; i<borrowers.size(); i++){
      System.out.println(borrowBook.get(i) + " was borrowed by " + borrowers.get(i) );
    }
  }

  // PERSON 3
    /**
     *
     * @param userNames
     * @param phoneNumbers
     * @param name
     * @param phoneNumber
     */
    public static void registerUser(ArrayList<String> userNames, ArrayList<String> phoneNumbers, String name, String phoneNumber){
      userNames.add(name);
      phoneNumbers.add(phoneNumber);
    }

    /**
     *
     * @param userNames
     * @param phoneNumbers
     */
    public static void displayAllUsers(ArrayList<String> userNames, ArrayList<String> phoneNumbers){
      for (int i = 0; i < userNames.size(); i++) {
        System.out.printf("%s %s%n", userNames.get(i),phoneNumbers.get(i));
      }
    }

    /**
     *
     * @param userNames
     * @param name
     * @return int index of user if user (name) found in ArrayList (userNames)
     */
    public static int searchUser(ArrayList<String> userNames, String name){
      // indexOf() retrieves the index if found
      // Else it will be -1
      return userNames.indexOf(name);
    }




  //person 5
  //first action inthe method is
    public static void displayMainMenu(){
//      System.out.println("\n=== BIBLIOTEKSSYSTEM ===");
//      System.out.println("1. Show all books");
//      System.out.println("2. Add a book");
//      System.out.println("3. Search a book");
//      System.out.println("4. Register a user");
//      System.out.println("5. Display all users");
//      System.out.println("6. Search a user");
//      System.out.println("0. Exit");
//      int choice = sc.nextInt();
//      sc.nextLine(); // Rensa newline
//      switch (choice) {
//        case 1:
//          displayAllBooks(bookTitles, bookAuthors,
//              bookISBN);
//          break;
//        case 2:
//          System.out.print("Enter title: ");
//          String title = sc.nextLine();
//          System.out.print("Enter author's name: ");
//          String author = sc.nextLine();
//          System.out.print("Enter book's ISBN: ");
//          String isbn = scanner.nextLine();
//          addBook(bookTitles, bookAuthors, bookISBN, title,
//              author, isbn);
//          break;
//        case 3:
//          System.out.println("To borrow a book you need to be log in the system. %nEnter '1' to register new user %nEnter '2' to login");
//          int user = sc.nextInt();
//          user == 1 ? registerUser(userNames, phoneNumbers) : displayAllUsers(userNames, phoneNumbers);
//          break;
//        case 4:
//
//          break;
//      }
    }

    public static void displayBookMenu(
        ArrayList<String> bookAuthors,
        ArrayList<String> bookISBN,
        ArrayList<Boolean> available,
        ArrayList<String> borrowers,
        ArrayList<String> borrowedBooks,
        int bookIndex,
        String borrowerName,
        ArrayList<String> bookTitles,
        String bookName
    ){

      System.out.println("\n=== Section to loan a book ===");
      System.out.println("1. Borrow a book");
      System.out.println("2. Return a book");
      System.out.println("3. Display borrowed books");
      System.out.println("0. Exit");

      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          borrowBook( available,  borrowers,  borrowedBooks, bookIndex, borrowerName, bookTitles, bookName );
          break;
        case 2:
          System.out.print("Enter title: ");
          String title = sc.nextLine();
          System.out.print("Enter author's name: ");
          String author = sc.nextLine();
          System.out.print("Enter book's ISBN: ");
          String isbn = sc.nextLine();
//          returnBook(bookTitles, bookAuthors, bookISBN, title,
//              author, isbn);
          break;
        case 3:
          System.out.println("To borrow a book you need to be log in the system. %nEnter '1' to register new user %nEnter '2' to login");
//          displayBorrowedBooks();
          break;
        case 4:

          break;
      }
    }

    public static void displayLoanMenu(){}





// 4 Enkla Rapporter
    public static int countAvailableBooks(ArrayList<Boolean>available){
      int count_available = 0;
      for (Boolean item : available) {
        if (item) {
          count_available ++;
        }
      }
      return count_available;
    }



    public static int countBorrowedBooks(ArrayList<Boolean> available){
      int count_borrowed = 0;
      for (Boolean item : available) {
        if (!item) {
          count_borrowed ++;
          }
      }
      return count_borrowed;
    }

    public static void displayLibraryStatistics(ArrayList<String>titles, ArrayList<Boolean> available, ArrayList<String>userNames){
        System.out.println("\n===Library Statistics===");
        System.out.println("Total number of books : " + titles.size());
        System.out.println("Total number of available books : " +countAvailableBooks(available));
        System.out.println("Total number of borrowed books : " +countBorrowedBooks(available));
        System.out.println("Total number of users : " + userNames.size());
      }


}