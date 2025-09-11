package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BiblioteksSystem2 {

  public static void main(String[] args) {
    //Init data structures
    // Böcker (index motsvarar varandra)
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

    //Add data
    initData(bookTitles, bookAuthors, bookISBN, bookAvailable, borrowerNames, borrowedBooks,
        userNames, phoneNumbers);

    //Start menuLoop (Enkel huvudmeny (Person 5))
    menuLoop(bookTitles, bookAuthors, bookISBN, bookAvailable, borrowerNames, borrowedBooks,
        userNames, phoneNumbers);

    /* Todo: Add tests */
    //Förinställd testdata (Person 5 skapar detta)

  }

  // Initiera datan!!!
  public static void initData(ArrayList<String> bookTitles, ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN,
      ArrayList<Boolean> bookAvailable, ArrayList<String> borrowerNames,
      ArrayList<String> borrowedBooks,
      ArrayList<String> userNames, ArrayList<String> phoneNumbers) {
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
  }

  //Start menu-loop
  public static void menuLoop(ArrayList<String> bookTitles, ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN,
      ArrayList<Boolean> bookAvailable, ArrayList<String> borrowerNames,
      ArrayList<String> borrowedBooks,
      ArrayList<String> userNames, ArrayList<String> phoneNumbers) {

    Scanner scanner = new Scanner(System.in);

    while (true) {
      handleChoice(scanner, displayMenu(scanner), bookTitles, bookAuthors, bookISBN, bookAvailable,
          borrowerNames, borrowedBooks, userNames, phoneNumbers);
    }
  }

  //Display menu choices
  public static int displayMenu(Scanner scanner) {
    System.out.println("\n=== BIBLIOTEKSSYSTEM ===");

    System.out.println("Enter: ");
    System.out.println("\t\t\t1. Display all books");
    System.out.println("\t\t\t2. Add a book");
    System.out.println("\t\t\t3. Borrow a book");
    System.out.println("\t\t\t4. Return a book");
    System.out.println("\t\t\t5. Show statistics");
    System.out.println("\t\t\t6. Display Borrowed books");
    System.out.println("\t\t\t7. display main menu");
    System.out.println("\t\t\t8. Search for a book");
    System.out.println("\t\t\t9. Register a user");
    System.out.println("\t\t\t10. Display all users");
    System.out.println("\t\t\t11. Search for a user");
    return scanner.nextInt();
  }

//Handle choice options

  public static void handleChoice(Scanner scanner, int menuChoice, ArrayList<String> bookTitles,
      ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN, ArrayList<Boolean> bookAvailable, ArrayList<String> borrowerNames,
      ArrayList<String> borrowedBooks, ArrayList<String> userNames,
      ArrayList<String> phoneNumbers) {

    switch (menuChoice) {
      //Visa alla böcker
      case 1:
        handleDisplayAllBooks(scanner, bookTitles, bookAuthors, bookISBN);
        break;
      //Lägg till bok
      case 2:
        handleAddBook(scanner, bookTitles, bookAuthors, bookISBN, bookAvailable);
        break;
      //Låna bok
      case 3:
        handleBorrowBook(scanner, bookTitles, bookAvailable, borrowedBooks, borrowerNames);
        break;
      //Återlämna bok
      case 4:
        handleReturnBook(scanner, bookAvailable, borrowerNames, borrowedBooks, bookISBN, "", bookTitles, "" );
        break;
      //Visa statistik
      case 5:
        /* Todo: see method for furter info, adjust for changes in method*/
        handleStatistics(scanner,bookTitles, bookAvailable, userNames);
        // displayLibraryStatistics(bookTitles, bookAvailable, userNames);
        break;
      case 6:
        /* Todo: see method for furter info, adjust for changes in method*/
        handleDisplayBorrowedBooks(scanner);

        break;
      /*Todo: maybe add case 7: case 8: case 9:.....eventuella adds ifall vi vill*/
      case 7:
        displayMainMenu(scanner, menuChoice, bookTitles, bookAuthors, bookISBN, bookAvailable,
            borrowerNames, borrowedBooks, userNames, phoneNumbers);
        break;
      case 8:
        handleSearchBook(scanner, bookTitles, bookAuthors);
        break;
      case 9:
        //todo TEST ERROR handleRegisterUser() and registerUser()
        handleRegisterUser(scanner,userNames,phoneNumbers);
        break;
      case 10:
        //todo TEST OK handleDisplayAllUsers() and displayAllUsers()
        handleDisplayAllUsers(userNames, phoneNumbers);
        break;
      case 11:
        //todo TEST ERROR handleSearchUser() and searchUser()
        handleSearchUser(scanner, userNames);
        break;

      case 0:
        scanner.close();
        System.exit(0);
        break;
    }
  }

  // Handle specific Options
  public static void handleDisplayAllBooks(Scanner scanner, ArrayList<String> bookTitles,
      ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN) {
    displayAllBooks(bookTitles, bookAuthors, bookISBN);
  }

  public static void handleSearchBook(Scanner scanner, ArrayList<String> titles,
      ArrayList<String> authors){
    System.out.println("Enter book title or author to"
        + " search for book");
    String searchTmp = scanner.nextLine();
    int index = searchBook(titles, authors, searchTmp);
    if(index == -1){
      System.out.println("No books where found");
    }
    else{
      System.out.println("Result: ");
      System.out.println(titles.get(index) + " " +
                        authors.get(index));
    }
  }
  
  public static void handleDisplayBorrowedBooks(Scanner scanner) {
    /* Todo: add functionality */
  }

  public static void handleSearchUser(Scanner scanner, ArrayList<String> userNames){
    int userIndex = -2;
    System.out.println("Sök användare:");
    String userName = scanner.nextLine();
    userIndex = searchUser(userNames, userName);
    if (userIndex >= 0){
      System.out.println("Användare" + userNames.get(userIndex) + " finns i systemet.");
    } else {
      System.out.println("Användare" + userName + " hittades inte i systemet.");
    }
  }

  public static void handleRegisterUser(Scanner scanner, ArrayList<String> userNames, ArrayList<String> phoneNumbers){
    // Register User
    System.out.println("Registrera Användare:");
    System.out.print("Namn: ");
    String name = scanner.nextLine();
    System.out.print("Telefonnummer: ");
    String phoneNumber = scanner.nextLine();
    registerUser(userNames, phoneNumbers, name, phoneNumber);
  }
  
  public static void handleDisplayAllUsers(ArrayList<String> userNames, ArrayList<String> phoneNumbers){
    displayAllUsers(userNames, phoneNumbers);
  }
  
  public static void handleAddBook(Scanner scanner, ArrayList<String> bookTitles,
      ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN, ArrayList<Boolean> bookAvailable) {

    scanner.nextLine();
    System.out.print("Titel: ");
    String title = scanner.nextLine();
    System.out.print("Författare: ");
    String author = scanner.nextLine();
    System.out.print("ISBN: ");
    String isbn = scanner.nextLine();

    addBook(bookTitles, bookAuthors, bookISBN, bookAvailable, title,
        author, isbn);
  }

  public static void handleBorrowBook(Scanner scanner, ArrayList<String> bookTitles, ArrayList<Boolean> bookAvailable, ArrayList<String> borrowedBooks, ArrayList<String> borrowerNames) {
    scanner.nextLine();
    System.out.println("Ditt namn:");
    String borrower = scanner.nextLine();
    System.out.println("Titel: ");
    String loanTitle = scanner.nextLine();
    System.out.println("Författare: ");
    String loanAuthor = scanner.nextLine();
    System.out.println("ISBN: ");
    String loanISBN = scanner.nextLine();
    borrowBook(bookAvailable, borrowerNames, borrowedBooks, 0, borrower,  bookTitles, loanTitle );
  }

  public static void handleReturnBook(Scanner scanner, ArrayList<Boolean> available, ArrayList<String> borrowers,
      ArrayList<String> borrowedBooks, ArrayList<String> isbnBooks, String bookName,
      ArrayList<String> bookTitles, String borrower) {
    scanner.nextLine();
    System.out.println("Titel: ");
    String returnTitle = scanner.nextLine();
    System.out.println("Författare: ");
    String returnAuthor = scanner.nextLine();
    System.out.println("ISBN: ");
    String returnISBN = scanner.nextLine();
    returnBook(available, borrowers, borrowedBooks, isbnBooks, bookName, bookTitles, borrower);
  }

  public static void handleStatistics(Scanner scanner, ArrayList<String> bookTitles, 
      ArrayList<Boolean> bookAvailable, ArrayList<String> userNames) { 
    /* Todo: Add the arguments needed*/
    /*Todo: Add statistics */
    displayLibraryStatistics(bookTitles,bookAvailable, userNames);
  }

  public static boolean borrowBook(ArrayList<Boolean> available, ArrayList<String> borrowers,
      ArrayList<String> borrowedBooks, int bookIndex, String borrowerName,
      ArrayList<String> bookTitles, String bookName) {
    int index = bookTitles.indexOf(bookName);
    if (index == -1) {
      return false;
    }
    if (available.get(index)) {
      available.set(index, false);
      borrowedBooks.add(bookName);
      borrowers.add(borrowerName);
      return true;
    } else {
      return false;
    }
  }

  public static boolean returnBook(ArrayList<Boolean> available, ArrayList<String> borrowers,
      ArrayList<String> borrowedBooks, ArrayList<String> isbnBooks, String bookName,
      ArrayList<String> bookTitles, String borrower) {
    int index = bookTitles.indexOf(bookName);
    available.set(index, true);
    borrowedBooks.remove(bookName);
    borrowers.remove(borrower);
    return true;
  }

  public static void displayBorrowedBooks(ArrayList<String> borrowers,
      ArrayList<String> borrowBook) {
    for (int i = 0; i < borrowers.size(); i++) {
      System.out.println(borrowBook.get(i) + " was borrowed by " + borrowers.get(i));
    }
  }

  // Functionality methods add when finished

  // PERSON 3

  /**
   * @param userNames
   * @param phoneNumbers
   * @param name
   * @param phoneNumber
   */
  public static void registerUser(ArrayList<String> userNames, ArrayList<String> phoneNumbers,
      String name, String phoneNumber) {
    userNames.add(name);
    phoneNumbers.add(phoneNumber);
  }

  /**
   * @param userNames
   * @param phoneNumbers
   */
  public static void displayAllUsers(ArrayList<String> userNames, ArrayList<String> phoneNumbers) {
    for (int i = 0; i < userNames.size(); i++) {
      System.out.printf("%s %s%n", userNames.get(i), phoneNumbers.get(i));
    }
  }

  /**
   * @param userNames
   * @param name
   * @return int index of user if user (name) found in ArrayList (userNames)
   */
  public static int searchUser(ArrayList<String> userNames, String name) {
    // indexOf() retrieves the index in the Arraylist if the needle is found
    // Else it will be -1
    return userNames.indexOf(name);
  }

  public static void addBook(ArrayList<String> titles,
      ArrayList<String> authors, ArrayList<String> isbn, ArrayList<Boolean> available,
      String title, String author, String isbnNumber) {
    titles.add(title);
    authors.add(author);
    isbn.add(isbnNumber);
    available.add(true);
    System.out.println("Book " + title + " " + authors +
        " " + isbnNumber + " has been added succesfully");
  }

  public static void displayAllBooks(ArrayList<String> titles,
      ArrayList<String> authors, ArrayList<String> isbn) {
    for (int i = 0; i < titles.size(); i++) {
      System.out.println("Books");
      System.out.println(titles.get(i) + " " + authors.get(i) + " " + isbn.get(i));
    }
  }

  public static int searchBook(ArrayList<String> titles,
      ArrayList<String> authors, String searchTerm) {
    int titlesIndex = authors.lastIndexOf(searchTerm);
    int authorsIndex = authors.lastIndexOf(searchTerm);
    if (titlesIndex >= 0) {
      return titlesIndex;
    } else if (authorsIndex >= 0) {
      return authorsIndex;
    }
    return -1;
  }

  public static void displayMainMenu(Scanner scanner, int menuChoice, ArrayList<String> bookTitles,
      ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN, ArrayList<Boolean> bookAvailable, ArrayList<String> borrowerNames,
      ArrayList<String> borrowedBooks, ArrayList<String> userNames,
      ArrayList<String> phoneNumbers) {
    System.out.println("You entered 'Main menu'!");
    System.out.println("To go to 'Book menu' enter '1'");
    System.out.println("To go to 'Loan menu' enter '2'");
    System.out.println("To go to 'Previous menu' enter 3");
    System.out.println("Enter '0' to Exit");

    menuChoice = scanner.nextInt();

    switch (menuChoice) {
      case 1:
        displayBookMenu(
            scanner, bookTitles, bookAuthors, bookISBN, bookAvailable, menuChoice,borrowerNames,
            borrowedBooks, userNames, phoneNumbers
        );
        break;
      case 2:
        displayLoanMenu(
            scanner, menuChoice, bookTitles, bookAuthors, bookISBN, bookAvailable, borrowerNames,
            borrowedBooks, userNames, phoneNumbers
        );
        break;
      case 3:
        handleChoice(scanner, displayMenu(scanner), bookTitles, bookAuthors, bookISBN, bookAvailable, borrowerNames,
            borrowedBooks, userNames, phoneNumbers);
        break;
      case 0:
        System.exit(0);
        break;
    }
  }

  public static void displayBookMenu(
      Scanner scanner,
      ArrayList<String> bookTitles,
      ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN,
      ArrayList<Boolean> available,
      int menuChoice,
      ArrayList<String> borrowerNames,
      ArrayList<String> borrowedBooks,
      ArrayList<String> userNames,
      ArrayList<String> phoneNumbers
  ) {
    System.out.println("You entered 'Book menu'!");
    System.out.println("Enter '1' to add a book");
    System.out.println("Enter '2' to display all books");
    System.out.println("Enter '3' to search a book");
    System.out.println("Enter '4' to go to main manu");
    
    System.out.println("Enter '0' EXIT");
    menuChoice = scanner.nextInt();

    switch (menuChoice) {
      case 1:
        System.out.print("To add a book enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Please enter the author of the book: ");
        String author = scanner.nextLine();
        System.out.print("Please enter the ISBN number of the book: ");
        String isbnNumber = scanner.nextLine();
        addBook(
            bookTitles, bookAuthors, bookISBN, available, title, author, isbnNumber
        );
        break;
      case 2:
        displayAllBooks(bookTitles, bookAuthors, bookISBN);
        break;
      case 3:
        System.out.print("To search a book enter the title of the book: ");
        String searchTerm = scanner.nextLine();
        int result = searchBook(bookTitles, bookAuthors, searchTerm);
        for (int i = 0; i < bookTitles.size(); i++) {
          if (i == result) {
            System.out.println("You searched for the book author:" + bookAuthors.get(i) + " title: "
                + bookTitles.get(i) + " isbn number: " + bookISBN.get(i));
          }
        }
        break;
      case 4:
        handleChoice(scanner, displayMenu(scanner), bookTitles, bookAuthors, bookISBN, available, borrowerNames,
            borrowedBooks, userNames, phoneNumbers);
        break;
      case 0:
        System.exit(0);
        break;
    }
  }

  public static void displayLoanMenu(Scanner scanner, int menuChoice, ArrayList<String> bookTitles,
      ArrayList<String> bookAuthors,
      ArrayList<String> bookISBN, ArrayList<Boolean> bookAvailable, ArrayList<String> borrowerNames,
      ArrayList<String> borrowedBooks, ArrayList<String> userNames,
      ArrayList<String> phoneNumbers) {
    System.out.println("You entered 'Loan menu'!");

    System.out.println("Enter '1' to borrow a book");
    System.out.println("Enter '2' to return a book");
    System.out.println("Enter '3' to display borrowed books");
    System.out.println("Enter '0' EXIT");
    menuChoice = scanner.nextInt();

    switch (menuChoice) {
      case 1:
        System.out.println("To borrow a book enter the index of the book(numbers between 1-3): ");
        int bookIndex = scanner.nextInt();
        System.out.println("Please enter your name: ");
        String borrowerName = scanner.nextLine();
        scanner.nextLine();
        //System.out.println("Please enter name of the book: ");
        String bookName = bookTitles.get(bookIndex);

        boolean result = borrowBook(bookAvailable, borrowerNames, borrowedBooks, bookIndex, borrowerName, bookTitles,
            bookName);
        if (result){
          System.out.print("Success! You borrowed the book: " + bookName);
        }
        break;
      case 2:
        System.out.println("To return a book please enter your name: ");
        String borrower = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Please enter name of the book: ");
        String bookNameReturn = scanner.nextLine();
//        scanner.nextLine();
        
        boolean b = returnBook(
            bookAvailable, borrowerNames, borrowedBooks, bookISBN, bookNameReturn, bookTitles, borrower
        );
        
        if(b) System.out.println("Success! You returned the book");
        break;
      case 3:
        displayBorrowedBooks(borrowerNames, borrowedBooks);
        break;
      case 0:
        System.exit(0);
      break;
    }
  }

    //4 Enkla Rapporter
    public static int countAvailableBooks (ArrayList < Boolean > available) {
      int count_available = 0;
      for (Boolean item : available) {
        if (item) {
          count_available++;
        }
      }
      return count_available;
    }


    public static int countBorrowedBooks (ArrayList < Boolean > available) {
      int count_borrowed = 0;
      for (Boolean item : available) {
        if (!item) {
          count_borrowed++;
        }
      }
      return count_borrowed;
    }

    public static void displayLibraryStatistics
    (ArrayList < String > titles, ArrayList < Boolean > available, ArrayList < String > userNames){
      System.out.println("\n===Library Statistics===");
      System.out.println("Total number of books : " + titles.size());
      System.out.println("Total number of available books : " + countAvailableBooks(available));
      System.out.println("Total number of borrowed books : " + countBorrowedBooks(available));
      System.out.println("Total number of users : " + userNames.size());
    }

}







