/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ListInterface;
import adt.ArrList;
import entity.Librarian;
import entity.Admin;
import entity.Student;
import java.util.Scanner;
import entity.timeSlot;
import adt.LinkedListInterface;
import entity.Books;
import adt.LinkedList;
import static client.StudentPage.borrowAfternoon;
import static client.StudentPage.borrowMorning;
import static client.StudentPage.borrowrecordlist;
import entity.Borrow;
import entity.BorrowRecord;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;

/**
 *
 * @author User
 */
public class Main {

    static ListInterface<Librarian> LibrarianList = new ArrList<Librarian>();
    static ListInterface<Admin> AdminList = new ArrList<Admin>();
    static ListInterface<Student> StudentList = new ArrList<Student>();
    public static Librarian librarian = new Librarian();
    static ListInterface<timeSlot> time = new ArrList<timeSlot>();
    //static ListInterface<BookData> book = new ArrList<BookData>();
    static LinkedListInterface<Books> Booklists = new LinkedList<Books>();

    public static void main(String args[]) {
        AdminList.add(new Admin("Sim Hui Wen", "A001", "A001"));
        LibrarianList.add(new Librarian("Lim Wei Jian", "19WMR01122", "Morning", "0111234567", "small", "Daily", "L001", "L001"));
        LibrarianList.add(new Librarian("Wong Yee Mun", "18WMR02135", "Morning", "0102205767", "big ", "Daily", "L002", "L002"));
        LibrarianList.add(new Librarian("Ooi Mei Theng", "19WMR09878", "Afternoon", "0169028767", "small", "Daily", "L003", "L003"));
        LibrarianList.add(new Librarian("Yin Shao Juin", "19WMR09630", "Afternoon", "0169028767", "big", "Monthly", "L004", "L004"));
        StudentList.add(new Student("Teh Kok Seng", "19WMR01122", "0111234567", "S001", "S001"));
        StudentList.add(new Student("Wong Chui Yee", "18WMR02135", "0102205767", "S002", "S002"));
        StudentList.add(new Student("Lim Siew Hua", "19WMR09878", "0169028767", "S003", "S003"));
        StudentList.add(new Student("Yee Chee Ping", "19WMR09630", "0169028767", "S004", "S004"));
        /*book.add(new BookData("Mathematics"));
        book.add(new BookData("English"));
        book.add(new BookData("Programming"));
        book.add(new BookData("Accounting"));
        book.add(new BookData("Science"));
        book.add(new BookData("Biology"));
        book.add(new BookData("Chemistry"));
        book.add(new BookData("Physics"));
        book.add(new BookData("Architecture"));*/
        StudentPage.initialdata();
        time.add(new timeSlot("9-11"));
        time.add(new timeSlot("11-1"));
        time.add(new timeSlot("1-3"));
        time.add(new timeSlot("3-5"));
        time.add(new timeSlot("5-7"));
        Booklists.add(new Books("Introduction to Java Programming,Brief Version", "BK1001", "Laura Thomson", "Computer Science", "9780134611037", 5));
        Booklists.add(new Books("PHP and MySQL Web Development (3rd Edition)", "BK1002", "Y. Daniel Liang", "Computer Science", "9780672326721", 5));
        Booklists.add(new Books("System Design Interview – An insider's guide, Second Edition", "BK1003", "Alex Xu ", "Computer Science", "9798664653403", 6));
        Booklists.add(new Books("Sql Guide (Quick Study: SQL)", "BK1004", "Inc. BarCharts", "Computer Science", "1572229160", 2));
        Booklists.add(new Books("Accounting All-in-One For Dummies with Online Practice", "BK1006", "Kenneth W. Boyd", "Accounting", "9780134611037", 8));
        Booklists.add(new Books("Accounting Principles: The Ultimate Beginner’s Guide to Accounting", "BK1007", "Gregory Becker ", "Accounting", "1081670290", 6));
        Booklists.add(new Books("Big 4 Accounting Firms Interview Questions: 32 Questions & Answers to Get You the Job You Deserve", "BK1008", "Christian Wolfe", "Accounting", "1976758491", 4));
        Booklists.add(new Books("The Why And How Of Auditing: Auditing Made Easy", "BK1009", "Charles B. Hall", "Accounting", "0578519739", 1));

       Scanner scanner = new Scanner(System.in);
         //boolean check = true;
        int selection = 1;
        

        while (selection != 0) {
            System.out.println("************************");
            System.out.println("*Library Management System*");
            System.out.println("************************");
            System.out.println("1)Student Login");
            System.out.println("2)Librarian Login");
            System.out.println("3)Admin Login");
            System.out.println("0)Exit");
            System.out.print("Your selection :");
            selection = scanner.nextInt();
            System.out.print("\n\n");
            menu(selection);

        }
    }
    
    

    public static void menu(int selection) {
        Scanner scanner = new Scanner(System.in);
        int MenuSelection;
        int checking;
        boolean checkID = true;
        switch (selection) {

            case 1:
                checking = StudentLogin(StudentList);
                if (checking > 0) {
                    System.out.println("\n\nLogin Sucessfully\n");
                    System.out.println("\n*Welcome!! " + StudentList.getEntry(checking).getName());
                    System.out.println("*Your Student ID    " + String.format(StudentList.getEntry(checking).getStudentID()) + "\n");
                    System.out.println("******************************************");
                    System.out.println("*Library Management System - Student Page*");
                    System.out.println("******************************************");
                    System.out.println("1)Booking");
                    System.out.println("2)Request Borrow");
                    System.out.println("0)Exit");
                    System.out.print("Your selection    :");
                    MenuSelection = scanner.nextInt();

                    if (MenuSelection == 1) {
                        StudentPage.booking();

                    } else if (MenuSelection == 2) {
                        StudentPage.borrowing();
                    } else {
                        System.out.println("Exiting to main");
                       // mainMenu();
                    }

                } else {
                    System.out.print("\n\nLogin Failed\n\n");
                }
                break;

            case 0:

                break;

            case 2:
                checking = LibrarianLogin(LibrarianList);
                if (checking > 0) {
                    System.out.println("\n\nLog-in Sucess");
                    System.out.println("\n*Welcome!! " + LibrarianList.getEntry(checking).getName());
                    System.out.println("****************");
                    System.out.println("Library Management System - Librarian Page");
                    System.out.println("****************");
                    System.out.println("1)Manage Book");
                    System.out.println("2)Manage Borrow");
                    System.out.println("3)Manage Room Booking");
                    System.out.println("0)Exit");
                    System.out.print("Your selection    :");
                    MenuSelection = scanner.nextInt();
                    if (MenuSelection == 1) {
                        int option = 0;
                        ManageBookmenu(option);
                    } else if (MenuSelection == 2) {
                        int option2 = 1;
                        ManageBorrowMenu(option2);    
                    } else if (MenuSelection == 3) {
                        StudentPage.ValidateLibrarianBooking(LibrarianList.getEntry(checking));
                        StudentPage.Librarianbooking(LibrarianList.getEntry(checking));

                    } else {
                        System.out.println("Exiting to main");
                        
                    }
                } else {
                    System.out.print("\n\nLog-in Failed\n\n");

                }
                break;
            case 3:

                checking = adminLogin(AdminList);

                if (checking > 0) {
                    System.out.println("\n\nLogin Sucessfully\n");
                    System.out.println("\nWelcome!! " + AdminList.getEntry(checking).getName() + "\n");

                    System.out.println("*****************************************");
                    System.out.println("*Library Management System - Admin Page*");
                    System.out.println("*****************************************");
                    System.out.println("1)Manage Librarian");
                    System.out.println("2)Manage Book");
                    System.out.println("0)Exit");
                    System.out.print("Your selection    :");
                    MenuSelection = scanner.nextInt();

                    if (MenuSelection == 1) {

                        System.out.println("***************************************************");
                        System.out.println("*Library Management System - Manage Librarian Page*");
                        System.out.println("***************************************************");
                        System.out.println("1)Add Librarian");
                        System.out.println("2)Edit Librarian");
                        System.out.println("3)Delete Librarian");
                        System.out.println("4)View All Librarians");
                        System.out.println("0)Exit");
                        System.out.print("Your selection    :");

                        int ManageSelection;
                        ManageSelection = scanner.nextInt();
                        if (ManageSelection == 1) {
                            LibrarianList.add(createLibrarian());
                            adminPage();
                        } else if (ManageSelection == 2) {
                            editLibrarian();
                            adminPage();
                        } else if (ManageSelection == 3) {

                            deleteLibrarian();

                            adminPage();
                        } else if (ManageSelection == 4) {

                            System.out.println("\n *****All Librarians*****\n" + LibrarianList.toString());

                            adminPage();
                        } else {
                            System.out.println("Exit...");
                        }

                    } else if (MenuSelection == 2) {
                        int option = 0;
                        ManageBookmenu(option);
                    }

                } else {
                    System.out.println("\n\nLogin Failed\n\n");
                }

                break;

        }
    }

    //----------------------StudentLogin--------------------------------------------------------
    public static int StudentLogin(ListInterface<Student> list) {
        Scanner scanner = new Scanner(System.in);
        String password, userpassword, userID, ID;
        int ans = 0;
        Student a;

        System.out.println("Student Login");
        System.out.println("**************");
        System.out.print("Enter Your ID:");
        ID = scanner.next();
        System.out.print("Enter Your Password:");
        password = scanner.next();

        for (int i = 1; i <= list.getLength(); i++) {

            a = list.getEntry(i);
            userID = a.getID();
            userpassword = a.getPassword();

            if (ID.equals(userID) && password.equals(userpassword)) {

                ans = i;
                return ans;
            } else {
                //System.out.print(id);
                //System.out.print(userid);
                //System.out.print(password);
                //System.out.print(userpassword);

            }
        }
        return ans;

    }

    //---------------------------------LibrarianLogin-------------------------------------------------------
    public static int LibrarianLogin(ListInterface<Librarian> list) {
        Scanner scanner = new Scanner(System.in);
        String password, userpassword, userID, ID;
        int ans = 0;
        Librarian a;

        System.out.println("Librarian Login");
        System.out.println("***************");
        System.out.print("Enter Your ID:");
        ID = scanner.next();
        System.out.print("Enter Your Password:");
        password = scanner.next();

        for (int i = 1; i <= list.getLength(); i++) {

            a = list.getEntry(i);
            userID = a.getID();
            userpassword = a.getPassword();

            if (ID.equals(userID) && password.equals(userpassword)) {

                ans = i;
                return ans;
            } else {
                //System.out.print(id);
                //System.out.print(userid);
                //System.out.print(password);
                //System.out.print(userpassword);

            }
        }
        return ans;

    }

    //---------------------------------------AdminLogin-------------------------------------------------
    public static int adminLogin(ListInterface<Admin> list) {
        Scanner scanner = new Scanner(System.in);
        String password, userpassword, userID, ID;
        int ans = 0;
        Admin a;

        System.out.println("Admin Login");
        System.out.println("***********");
        System.out.print("Enter Your ID:");
        ID = scanner.next();
        System.out.print("Enter Your Password:");
        password = scanner.next();

        for (int i = 1; i <= list.getLength(); i++) {

            a = list.getEntry(i);
            userID = a.getID();
            userpassword = a.getPassword();

            if (ID.equals(userID) && password.equals(userpassword)) {

                ans = i;
                return ans;
            } else {

            }
        }
        return ans;
    }

    //----------------------------Edit Librarian---------------------------------------------------------
    public static boolean editLibrarian() {

        String ID, newName, newStudentID, shift, newPhoneNo, newShift;
        char selection;
        int option, selection2 = 0;
        boolean check = false;
        Scanner myObj = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);

        System.out.print("\nSearch Librarian\nPlease enter the librarian's ID: ");
        ID = myObj.nextLine();
        for (int i = 1; i <= LibrarianList.getLength(); i++) {

            if (LibrarianList.getEntry(i).getID().equals(ID)) {
                System.out.println("\nYour search is found: \n" + LibrarianList.getEntry(i));
                librarian = LibrarianList.getEntry(i);
                System.out.println("Do you want to edit it? (Y = yes/N = no)");
                selection = myObj.next().charAt(0);

                while (selection == 'Y' || selection == 'y') {
                    System.out.println("Which category would u like to edit?");
                    System.out.println("1) Name");
                    System.out.println("2) Student ID");
                    System.out.println("3) Duty Shift");
                    System.out.println("4) Phone Number");
                    System.out.println("0) Exit");
                    System.out.print("Enter option:");
                    option = myObj.nextInt();

                    if (option == 1) {
                        do {
                            System.out.print("Enter new name:");
                            newName = scann.nextLine();
                            if (Librarian.validateName(newName) == true) {
                                librarian.setName(newName);
                                System.out.println("\nUpdated Successfully...\n" + LibrarianList.getEntry(i));
                            } else {
                                System.out.println("Please enter your name\n");
                            }
                        } while (Librarian.validateName(newName) != true);

                    } else if (option == 2) {
                        do {
                            System.out.print("Enter new Student ID:");
                            newStudentID = scann.nextLine();
                            if (Librarian.validateStudentID(newStudentID) == true) {
                                librarian.setStudentID(newStudentID);
                                System.out.println("\nUpdated Successfully...\n" + LibrarianList.getEntry(i));
                            } else {
                                System.out.println("Invalid format of Student ID.");
                            }
                        } while (Librarian.validateStudentID(newStudentID) != true);

                    } else if (option == 3) {
                        do {
                            System.out.print("Enter new Shift (Morning / Afternoon):");
                            newShift = scann.nextLine();
                            if (Librarian.validateShift(newShift) == true) {
                                librarian.setShift(newShift);
                                System.out.println("\nUpdated Successfully...\n" + LibrarianList.getEntry(i));
                            } else {
                                System.out.println("Invalid shift entered!!");
                            }
                        } while (Librarian.validateShift(newShift) != true);
                    } else if (option == 4) {
                        do {
                            System.out.print("Enter new phone number:");
                            newPhoneNo = scann.nextLine();
                            if (Librarian.validatePhoneNo(newPhoneNo) == true) {
                                librarian.setPhoneNo(newPhoneNo);
                                System.out.println("\nUpdated Successfully...\n" + LibrarianList.getEntry(i));
                            } else {
                                System.out.println("Invalid phone number entered!!");
                            }
                        } while (Librarian.validatePhoneNo(newPhoneNo) != true);
                    } else if (option == 0) {
                        adminPage();
                    }
                }
                System.out.println("Please enter only Y/N!");
                editLibrarian();
            } else {
                check = false;
            }

        }
        if (check == false) {
            System.out.println(ID + " cannot be found! Please try again...");
            editLibrarian();
        }
        return check;

    }

    //------------------------------------Add librarian-------------------------------------------
    public static Librarian createLibrarian() {
        String name, studentID, shift = null, phoneNo;
        int selection = 0;
        String password, ID, str = String.format("%03d", LibrarianList.getLength() + 1);
        ID = "L" + str;

        Scanner myObj = new Scanner(System.in);
        System.out.println("************************");
        System.out.println("*Register New Librarian*");
        System.out.println("************************");

        do {
            System.out.print("Librarian's Name        :");
            name = myObj.nextLine();
            if (Librarian.validateName(name) == true) {
            } else {
                System.out.println("\nPlease Enter Your Name!!\n");
            }
        } while (Librarian.validateName(name) != true);

        do {
            System.out.print("Librarian's Student ID  :");
            studentID = myObj.nextLine();
            if (Librarian.validateStudentID(studentID) == true) {
            } else {
                System.out.println("\nWrong Student ID! Please Enter Again...\n");
            }
        } while (Librarian.validateStudentID(studentID) != true);

        boolean valid;
        do {
            // must be a digit from 0 - 9, 10-11 digits
            String digit = "0\\d{9,10}";
            System.out.print("Librarian's Phone Number:");
            phoneNo = myObj.nextLine();
            valid = phoneNo.matches(digit);
            if (!valid) {
                System.out.println("\nPlease enter a valid phone number!\n");
            }
        } while (!valid);

        do {
            System.out.print("Librarian's Password    :");
            password = myObj.nextLine();
            if (Librarian.validatePassword(password) == true) {
            } else {
                System.out.println("Password must be at least 4 characters... Please Enter Again...");
            }
        } while (Librarian.validatePassword(password) != true);

        int selection4 = 0;
        String role = "Null";
        System.out.print("Librarian's Role (Room booking):");
        while (selection4 > 2 || selection4 < 1) {
            System.out.println("\n1)big \n2)small");
            selection4 = myObj.nextInt();
            switch (selection4) {
                case 1:
                    role = "big";
                    break;
                case 2:
                    role = "small";
                    break;
            }

        }

        int selection3 = 0;
        String collectPaymentMethod = "Null";
        System.out.print("Librarian's Collect Payment Method:");
        while (selection3 > 2 || selection3 < 1) {
            System.out.println("\n1)Daily \n2)Monthly");
            selection3 = myObj.nextInt();
            switch (selection3) {
                case 1:
                    collectPaymentMethod = "Daily";
                    break;
                case 2:
                    collectPaymentMethod = "Monthly";
                    break;
            }

        }

        System.out.print("Duty Shift              :");
        while (selection > 2 || selection < 1) {
            System.out.println("\n1)Morning \n2)Afternoon");
            selection = myObj.nextInt();
            switch (selection) {
                case 1:
                    shift = "Morning";
                    break;
                case 2:
                    shift = "Afternoon";
                    break;
            }

        }

        Librarian newLibrarian = new Librarian(name, studentID, shift, phoneNo, role, collectPaymentMethod, ID, password);
        System.out.println("\nSuccessfully Registered!\n" + newLibrarian);
        return newLibrarian;
    }

    //--------------------------------------delete librarian----------------------------------
    public static boolean deleteLibrarian() {

        Scanner scanner = new Scanner(System.in);
        String deleteLibrarianID;
        char option;
        boolean checkID = true;

        System.out.println("\n *****All Librarians*****\n" + LibrarianList.toString());
        System.out.println("Which librarian you want to delete? \n(Key in the ID that is shown at the last line)");
        deleteLibrarianID = scanner.next();

        for (int i = 1; i <= LibrarianList.getLength(); i++) {
            if (deleteLibrarianID.equals(LibrarianList.getEntry(i).getID())) {
                System.out.println("\n Librarians " + deleteLibrarianID + " will be deleted. \n Are you sure that you want to delete it?  (Y=yes / N=no)");
                option = scanner.next().charAt(0);

                if (option == 'y' || option == 'Y') {
                    LibrarianList.remove(i);
                    System.out.println("");

                    checkID = true;
                }
            } else {

                checkID = false;

            }
        }
        return checkID;

    }

    private static void adminPage() {

        Scanner scanner = new Scanner(System.in);
        boolean checkID = true;

        System.out.println("***************************************************");
        System.out.println("*Library Management System - Manage Librarian Page*");
        System.out.println("***************************************************");
        System.out.println("1)Add Librarian");
        System.out.println("2)Edit Librarian");
        System.out.println("3)Delete Librarian");
        System.out.println("4)View All Librarians");
        System.out.println("0)Exit");
        System.out.print("Your selection    :");

        int ManageSelection;
        ManageSelection = scanner.nextInt();
        if (ManageSelection == 1) {
            LibrarianList.add(createLibrarian());
            adminPage();
        } else if (ManageSelection == 2) {
            editLibrarian();
            adminPage();
        } else if (ManageSelection == 3) {

            deleteLibrarian();

            adminPage();
        } else if (ManageSelection == 4) {

            System.out.println("\n *****All Librarians*****\n" + LibrarianList.toString());

            adminPage();
        } else {
            System.out.println("Exit...");
        }

    }
//------------------Book Menu----------------------------------------

    public static void ManageBookmenu(int selection) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean checkBook = true;
        try {
            System.out.println("\n--------------------Book Menu--------------------");
            System.out.println("|              (1) View Book List                |");
            System.out.println("|              (2) Search Book                   |");
            System.out.println("|              (3) Add New Book                  |");
            System.out.println("|              (4) Remove Book                   |");
            System.out.println("|              (5) Edit Book                     |");
            System.out.println("|              (0) Exit                          |");
            System.out.println("--------------------------------------------------");
            System.out.print("\nEnter number (0-5)             : ");
            option = scanner.nextInt();

            if (option == 1) {
                System.out.println("******************Book List****************");
                System.out.println("\n" + Booklists.toString());
                ManageBookmenu(option);
            } else if (option == 2) {
                SearchBook();
            } else if (option == 3) {
                Booklists.add(newBooks());
                ManageBookmenu(option);
            } else if (option == 4) {
                DeleteBook();
            } else if (option == 5) {
                EditBook();
                pressAnyKeyToContinue();
            } else if (option == 0) {
                System.out.println("Exiting........");
            } else {
                System.out.println("Invalid option entered,please enter between (0-5) to proceed");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input, please enter only integer.");
            ManageBookmenu(option);
        }
    }
//------------------Add new Book----------------------------------------

    public static Books newBooks() {
        String title, id, author, type = null, isbn = "Null";
        int quantity = 0;
        int selection = 0;    //Books class
        int option = 0;

        boolean check1 = true;
        Scanner myObj = new Scanner(System.in);
        System.out.println("*************************************************");
        System.out.println("*                  Add New Book                 *");
        System.out.println("*************************************************");
        do {
            System.out.print("Book Title                  : ");
            title = myObj.nextLine();
            for (int a = 1; a <= Booklists.getLength(); a++) {
                Books book = Booklists.getEntry(a);
                if (title.equals(Booklists.getEntry(a).getBookTitle())) {

                    System.out.println(title + " is existing in the records!\nDo you want to update the quantity? (Y=yes/N=no)\n");
                    option = myObj.next().charAt(0);

                    if (option == 'Y' || option == 'y') {
                        System.out.print("Enter Book Quantity          : ");
                        int newquantity = myObj.nextInt();
                        book.setBookQuantity(newquantity);
                        System.out.println("Update Successfully...\n");
                    }
                }
            }
        } while (title == null);

        do {
            System.out.print("Book ID  (Eg: BK1001)       : ");
            id = myObj.nextLine().toUpperCase();
            for (int a = 1; a <= Booklists.getLength(); a++) {
                Books book = Booklists.getEntry(a);
                if (id.equals(Booklists.getEntry(a).getBookID())) {
                    System.out.println(id + " is existing in the records! Please enter a different ID.");
                    System.out.print("Book ID  (Eg: BK1001)       : ");
                    id = myObj.nextLine().toUpperCase();
                } else if (!id.equals(Booklists.getEntry(a).getBookID())) {
                    check1 = true;

                }
                if (Books.validateBookID(id) == true && check1 == true) {
                    book.setBookID(id);
                } else {
                    System.out.println("Invalid format!");
                }
            }
        } while (Books.validateBookID(id) != true);

        do {
            System.out.print("Book Author                 : ");
            author = myObj.nextLine();

        } while (author == null);

        do {
            System.out.print("Book ISBN                   : ");
            isbn = myObj.nextLine();

            if (Books.validateISBN(isbn) == true) {
            } else {
                System.out.println("Invalid format,Please enter only 10 Digit or 13 Digit.");
            }
        } while (Books.validateISBN(isbn) != true);

        System.out.print("Book Quantity               : ");
        quantity = myObj.nextInt();

        selection = 0;
        System.out.println("Please Select the Book Type ：");
        System.out.println("1)Computer Science");
        System.out.println("2)Accounting");
        System.out.print("Your selection               : ");
        selection = myObj.nextInt();
        switch (selection) {
            case 1:
                type = "Computer Science";
                break;
            case 2:
                type = "Accounting";
                break;
        }

        Books newbook = new Books(title, id, author, type, isbn, quantity);
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[                  New Added Book                 ]");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(newbook + "\n");
        return newbook;
    }
//------------------Delete Book----------------------------------------

    public static boolean DeleteBook() {
        Scanner scanner = new Scanner(System.in);
        String deletebookID;
        char deleteOption = 0;
        int option = 0;
        boolean checkBook = true;
        System.out.println("\n        Delete Book from Book Lists         ");
        System.out.println("--------------------------------------------------");
        System.out.print("\nEnter the Book ID that you wish to delete: ");
        deletebookID = scanner.next().toUpperCase();
        for (int i = 1; i <= Booklists.getLength(); i++) {
            if (deletebookID.equals(Booklists.getEntry(i).getBookID())) {
                System.out.println(deletebookID + " will be removed with the following details: \n" + Booklists.getEntry(i));
                System.out.print("Are you sure to remove it? (Y=yes/N=no): ");
                deleteOption = scanner.next().charAt(0);
            }
            if (deleteOption == 'y' || deleteOption == 'Y') {
                Booklists.remove(i);
                checkBook = true;
            } else {

                checkBook = false;
            }
        }
        if (checkBook == true) {
            System.out.println("The Book record is successfully removed!\n");
            pressAnyKeyToContinue();
        } else {
            backToManageBookMenu();
        }

        return checkBook;
    }
//------------------Edit Book----------------------------------------

    public static boolean EditBook() {
        Scanner scanner = new Scanner(System.in);
        String BookID, newType = null, newName, newAuthor;
        char choice;
        int option = 0;
        int newQuantity, option1, option2;
        boolean checkBook = true;
        System.out.print("\nPlease enter the Book ID to search: ");
        BookID = scanner.nextLine().toUpperCase();
        for (int i = 1; i <= Booklists.getLength(); i++) {

            if (Booklists.getEntry(i).getBookID().equals(BookID)) {
                System.out.println("Your search is found: \n" + Booklists.getEntry(i));
                Books book = Booklists.getEntry(i);
                System.out.println("\nDo you want to edit it? (Y = yes/N = no): ");
                choice = scanner.next().charAt(0);

                if (choice == 'Y' || choice == 'y') {
                    System.out.println("\nWhich category would u like to edit?");
                    System.out.println("1.Title");
                    System.out.println("2.Author");
                    System.out.println("3.Quantity");
                    System.out.println("4.Type");
                    System.out.println("5.Back to Book Menu");
                    System.out.print("\nEnter option:");
                    option1 = scanner.nextInt();

                    if (option1 == 1) {
                        do {
                            System.out.print("\nEnter new Book Title   :");
                            newName = scanner.next();
                            book.setBookTitle(newName);
                            System.out.println("\nUpdate Successfully...\n");
                            ManageBookmenu(option);
                        } while (newName == null);

                    } else if (option1 == 2) {
                        do {
                            System.out.print("\nEnter new Book Author   :");
                            newAuthor = scanner.next();

                            book.setBookAuthor(newAuthor);
                            System.out.println("\nUpdate Successfully...\n");
                            ManageBookmenu(option);
                        } while (newAuthor == null);

                    } else if (option1 == 3) {
                        System.out.print("\nEnter new Book quantity   :");
                        newQuantity = scanner.nextInt();
                        if (newQuantity == 0) {
                            System.out.print("\nThe Book is now empty, do you want to remove it? (Y=yes/N=no): ");
                            char deleteOption = scanner.next().charAt(0);
                            if (deleteOption == 'y' || deleteOption == 'Y') {
                                Booklists.remove(i);
                                System.out.println("\nThe Book record is successfully removed!\n");
                            } else {
                                book.setBookQuantity(newQuantity);
                                System.out.println("\nUpdate Successfully...\n");
                                ManageBookmenu(option);
                            }
                        }

                    } else if (option1 == 4) {

                        try {
                            System.out.print("Select new Book Type   :\n");
                            System.out.println("1)Computer Science\n");
                            System.out.println("2)Accounting");
                            System.out.print("\nYour selection             : ");
                            option2 = scanner.nextInt();
                            switch (option2) {
                                case 1:
                                    newType = "Computer Science";
                                    break;

                                case 2:
                                    newType = "Accounting";
                                    break;
                            }
                            book.setBookType(newType);
                            System.out.println("Update Successfully...\n");
                            ManageBookmenu(option);

                        } catch (InputMismatchException ex) {
                            System.out.println("Incorrect input, please enter only integer.");

                        }
                    } else if (option1 == 5) {
                        ManageBookmenu(option);
                        checkBook = false;
                    }

                } else {
                    ManageBookmenu(option);
                    checkBook = false;
                }

            } else {

                checkBook = false;
            }

        }
        return checkBook;
    }
//------------------Search Book----------------------------------------

    public static boolean SearchBook() {
        Scanner scanner = new Scanner(System.in);
        String BookID = null;
        String BookAuthor = null;
        String BookTitle = null;
        String BookType = null;
        String ISBN = null;
        char choice;
        int option = 0;
        int option1, option2;
        int selection = 0;
        boolean checkBook = true;
        try {
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("[                  Search Book By :                ]");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1.Book ID");
            System.out.println("2.Book Title");
            System.out.println("3.Book Author");
            System.out.println("4.Book Type");
            System.out.println("5.Book ISBN");
            System.out.println("6.Back to Book Menu");
            System.out.print("\nEnter option:");
            option1 = scanner.nextInt();

            if (option1 == 1) {
                System.out.print("\nPlease enter the Book ID to search: ");
                BookID = scanner.next().toUpperCase();
                for (int i = 1; i <= Booklists.getLength(); i++) {
                    if (Booklists.getEntry(i).getBookID().equals(BookID)) {
                        checkBook = true;
                        pressAnyKeyToContinue();
                    }
                }
                if (checkBook == false) {
                    backToManageBookMenu();
                }
            } else if (option1 == 2) {
                System.out.print("\nPlease enter the Book Title to search: ");
                BookTitle = scanner.next();

                for (int i = 1; i <= Booklists.getLength(); i++) {
                    if (Booklists.getEntry(i).getBookTitle().contains(BookTitle)) {
                        System.out.println("\nYour search is found: \n" + Booklists.getEntry(i));
                        checkBook = true;
                        pressAnyKeyToContinue();
                    }
                }
                if (checkBook == false) {
                    backToManageBookMenu();
                }
            } else if (option1 == 3) {
                System.out.print("\nPlease enter the Book Author to search: ");
                BookAuthor = scanner.next();
                for (int i = 1; i <= Booklists.getLength(); i++) {
                    if (Booklists.getEntry(i).getBookAuthor().contains(BookAuthor)) {
                        System.out.println("\nYour search is found: \n" + Booklists.getEntry(i));
                        checkBook = true;
                        pressAnyKeyToContinue();
                    }
                }
                if (checkBook == false) {
                    backToManageBookMenu();
                }
            } else if (option1 == 4) {
                try {
                    System.out.print("\nSelect new Book Type   :\n");
                    System.out.println("1)Computer Science");
                    System.out.println("2)Accounting");
                    System.out.print("Your selection             : ");
                    option2 = scanner.nextInt();
                    switch (option2) {
                        case 1:
                            BookType = "Computer Science";
                            break;

                        case 2:
                            BookType = "Accounting";
                            break;
                    }
                    for (int i = 1; i <= Booklists.getLength(); i++) {
                        if (Booklists.getEntry(i).getBookType().equals(BookType)) {
                            System.out.println("\nYour search is found: \n" + Booklists.getEntry(i));
                            checkBook = true;
                            ManageBookmenu(option);
                        }
                    }
                    if (checkBook == false) {
                        backToManageBookMenu();
                    } else if (checkBook == true) {
                        pressAnyKeyToContinue();
                    }

                } catch (InputMismatchException ex) {
                    System.out.println("Incorrect input, please enter only integer.");

                }
            } else if (option1 == 5) {
                System.out.print("\nPlease enter the Book ISBN to search: ");
                ISBN = scanner.next();
                for (int i = 1; i <= Booklists.getLength(); i++) {
                    if (Booklists.getEntry(i).getISBN().equals(ISBN)) {
                        System.out.println("\nYour search is found: \n" + Booklists.getEntry(i));
                        checkBook = true;
                        pressAnyKeyToContinue();
                    }
                }
                if (checkBook == false) {
                    backToManageBookMenu();
                }
            } else {
                checkBook = false;
                ManageBookmenu(option);
            }
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input, please enter only integer.");
        }
        return checkBook;
    }

    public static void pressAnyKeyToContinue() {
        System.out.print("Press Enter any key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        int option = 0;
        ManageBookmenu(option);
    }

    public static void backToManageBookMenu() {
        int option = 0;
        System.out.println("The Book you entered is not existing in the records!");
        pressAnyKeyToContinue();
        ManageBookmenu(option);
    }

    public static void ManageBorrowMenu(int selection) {
        Scanner scanner = new Scanner(System.in);
        int option2 = 0;
        int checking;
        checking = LibrarianLogin(LibrarianList);
        boolean checkBorrow = true;
        try {
            System.out.println("\n--------------------Manage Borrow Menu----------------------");
            System.out.println("|                (1) Approve Borrow                          |");
            System.out.println("|                (2) Collect Deposit                         |");
            System.out.println("|                (3) View Deposit Collection Record          |");
            System.out.println("|                (4) View Approve Borrowing Record           |");
            System.out.println("|                (0) Exit                                    |");
            System.out.println("--------------------------------------------------------------");
            System.out.print("\nEnter number (0-4)             : ");
            option2 = scanner.nextInt();

            if (option2 == 1) {

                StudentPage.librarianApproving(LibrarianList.getEntry(checking));
                ManageBorrowMenu(option2);
            } else if (option2 == 2) {
                StudentPage.collectDeposit(LibrarianList.getEntry(checking));
                ManageBorrowMenu(option2);
            } else if (option2 == 3) {
                StudentPage.viewDepositPayment(LibrarianList.getEntry(checking));
                ManageBorrowMenu(option2);
            } else if (option2 == 4) {
                System.out.println("\n All Approve Borrowing Records*\nDate Approved\tLibrarian ID\tDeposit Payment Done\n" + StudentPage.borrowrecordlist.toString());
                ManageBorrowMenu(option2);
            } else if (option2 == 0) {
                System.out.println("Exiting........");
            } else {
                System.out.println("Invalid Option, Please Enter Options Between (0-4) to Proceed");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect Input, Please Enter Only Integer.");
            ManageBorrowMenu(option2);
        }
    }
}
