/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.*;
import static client.Main.Booklists;
import static client.Main.LibrarianList;
import static client.Main.ManageBookmenu;
import static client.Main.StudentList;
import static client.Main.backToManageBookMenu;
import static client.Main.menu;

import java.util.Random;
import entity.Admin;
import entity.Librarian;
import entity.Student;
import entity.BorrowRecord;
import entity.Room;
import entity.Borrow;
import entity.Payment;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import entity.timeSlot;
import entity.Books;
import java.util.InputMismatchException;

/**
 *
 * @author User
 */
public class StudentPage {

    public static QueueInterface<Room> bookingSmallRoom = new ArrayQueue<Room>();
    public static QueueInterface<Room> bookingBigRoom = new ArrayQueue<Room>();
    public static QueueInterface<Borrow> borrowMorning = new LinkQueue<Borrow>();
    public static QueueInterface<Borrow> borrowAfternoon = new LinkQueue<Borrow>();
    public static LinkedList<BorrowRecord> borrowrecordlist = new LinkedList<BorrowRecord>();
    public static ListInterface<Payment> paymentlist = new ArrList<Payment>();
    private static final int depositMinRange = 5;
    private static final int depositMaxRange = 10;

    public static void booking() {
        ListInterface<timeSlot> time = Main.time;
        ListInterface<Librarian> librarian = Main.LibrarianList;

        String size = "small";
        String big = "big";

        LocalDate date1;
        LocalDate nowdate = LocalDate.now();
        int year, month, day, selection = 2;
        int timeSelect = 10, roomSize = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= time.getLength(); i++) {
            System.out.print(i + ") ");
            System.out.println(time.getEntry(i));

        }

        while (timeSelect > time.getLength()) {
            System.out.print("Select the time slot :");
            timeSelect = scanner.nextInt();
        }

        System.out.println("\nPlease Select Room Size");
        System.out.println("1)Small");
        System.out.println("2)Big");
        while (roomSize > 2 || roomSize < 1) {
            System.out.print("Your selection :");
            roomSize = scanner.nextInt();
        }

        System.out.println("\nSelect Booking Date (Zero 3times to get today date)");
        do {
            System.out.print("Year   :");
            year = scanner.nextInt();
        } while (year != 0 && (year < 2010 || year > nowdate.getYear()));

        do {
            System.out.print("Month  :");
            month = scanner.nextInt();
        } while (month > 12 || month < 0);

        do {
            System.out.print("Date   :");
            day = scanner.nextInt();
        } while (day < 0 || day > 31);

        if (year == 0 && month == 0 && day == 0) {
            date1 = LocalDate.now();
        } else {
            date1 = LocalDate.of(year, month, day);
        }

        if (roomSize == 1) {
            bookingSmallRoom.enqueue(new Room(time.getEntry(timeSelect).gettimeSlot(), size, date1));
            System.out.println("\nYour time slot = " + bookingSmallRoom.getFront().gettime());
            System.out.println(String.format("%15s= %s", "on ", bookingSmallRoom.getFront().getdate()));
            System.out.println(String.format("%15s= %s\n", "room size ", bookingSmallRoom.getFront().getroomSize()));
        } else {
            bookingBigRoom.enqueue(new Room(time.getEntry(timeSelect).gettimeSlot(), big, date1));
            System.out.println("\nYour time slot = " + bookingBigRoom.getFront().gettime());
            System.out.println(String.format("%15s= %s", "on ", bookingBigRoom.getFront().getdate()));
            System.out.println(String.format("%15s= %s\n", "room size ", bookingBigRoom.getFront().getroomSize()));
        }

    }

    public static void ValidateLibrarianBooking(Librarian librarian) {
        int selection = 2;
        if (!(librarian.getrole().equals("small") || (librarian.getrole().equals("big")))) {
            System.out.print("You do not have room booking currently!");
            System.out.println("\n");
            Main.menu(selection);
        }

    }

    public static void Librarianbooking(Librarian librarian) {
        Scanner scanner = new Scanner(System.in);
        int permission;
        int selection = 2;
        Room room;

        if (librarian.getrole().equals("small")) {
            room = bookingSmallRoom.getFront();

            if (bookingSmallRoom.isEmpty()) {
                System.out.print("You do not have room booking currently!");
                System.out.println("\n");
                Main.menu(selection);
            } else {
                do {
                    System.out.println("\n********");
                    System.out.println("*Booking Room Permission   *");
                    System.out.println("********");
                    System.out.println("Time slot  :" + room.gettime());
                    System.out.println("Size       :" + room.getroomSize());
                    System.out.println("Date       :" + room.getdate());
                    System.out.println("1)Confirm");
                    System.out.println("2)Refresh");
                    System.out.println("3)Reject");
                    System.out.println("4)Exit");
                    do {
                        System.out.print("Your Selection :");
                        permission = scanner.nextInt();
                    } while (permission < 1 || permission > 3);

                } while (permission == 2);
                if (permission == 1) {
                    bookingSmallRoom.dequeue();
                    System.out.println("\n\nBooking is confirmed and accepted");
                    Main.menu(selection);

                } else if (permission == 3) {
                    bookingSmallRoom.dequeue();
                    System.out.println("\n\nBooking is removed");
                    Main.menu(selection);
                }else{
                    Main.menu(selection);
                }
            }

        } else {
            room = bookingBigRoom.getFront();
            if (bookingBigRoom.isEmpty()) {
                System.out.print("You do not have room booking currently!");
                System.out.println("\n");
                Main.menu(selection);
            } else {

                do {
                    System.out.println("********");
                    System.out.println("*Booking Room Permission   *");
                    System.out.println("********");
                    System.out.println("Time slot  :" + room.gettime());
                    System.out.println("Size       :" + room.getroomSize());
                    System.out.println("Date       :" + room.getdate());
                    System.out.println("1)Confirm");
                    System.out.println("2)Refresh");
                    System.out.println("3)Reject");
                    System.out.println("4)Exit");
                    do {
                        System.out.print("Your Selection :");
                        permission = scanner.nextInt();
                    } while (permission < 1 || permission > 3);

                } while (permission == 2);

                if (permission == 1) {
                    bookingBigRoom.dequeue();
                    System.out.println("\n\nBooking is confirmed and accepted");
                    Main.menu(selection);

                } else if (permission == 3) {
                    bookingBigRoom.dequeue();
                    System.out.println("\n\nBooking is removed");
                    Main.menu(selection);

                } else {
                    Main.menu(selection);
                }
            }
        }

    }

    public static void borrowing() {
        //ListInterface<BookData> book = Main.book;
        LinkedListInterface<Books> Booklists = Main.Booklists;
        ListInterface<Librarian> librarian = Main.LibrarianList;
        String Select = null;
        String bookID, BookType = null;
        int durationSelect = 0;
        int shift = 0;
        float deposits = 0;
        Scanner scanner = new Scanner(System.in);

//        for(int i=1 ; i< book.getLength(); i++){
//            System.out.print(i);
//            System.out.println(")"+book.getEntry(i+1));
//}
//       
//        while (Select > book.getLength()) {
//            System.out.print("Select The Book: ");
//            Select = scanner.nextInt();
//        }
        try {
            System.out.print("\nSelect a Book Type   :\n");
            System.out.println("1)Computer Science");
            System.out.println("2)Accounting");
            System.out.print("Your selection             : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    BookType = "Computer Science";
                    break;

                case 2:
                    BookType = "Accounting";
                    break;
            }

        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input, please enter only integer.");

        }
//        for(int i=1 ; i< Booklists.getLength(); i++){
//            System.out.print(i);
//            System.out.println(")"+Booklists.getEntry());
        System.out.println("\n*****************Book List*****************");
//        System.out.println("\n" + Booklists.toString());
        for (int i = 1; i <= Booklists.getLength(); i++) {
            if (Booklists.getEntry(i).getBookType().equals(BookType)) {
                System.out.println(Booklists.getEntry(i));

            }
        }

//        while (Select > book.getLength()) {
//            System.out.print("Select The Book: ");
        System.out.print("\nEnter the Book ID that you wish to borrow: ");
        bookID = scanner.next().toUpperCase();
//            Select = scanner.nextInt();
//        }

        for (int i = 1; i <= Booklists.getLength(); i++) {
            if (Booklists.getEntry(i).getBookID().equals(bookID)) {
                System.out.println("\nHow Long Duration You Want To Borrow?");
                System.out.println("Standard 7 Days (Select 7)");
                System.out.println("Extra 14 Days (Select 14)");
                while (durationSelect > 14 || durationSelect < 7) {
                    System.out.print("Your Selection: ");
                    durationSelect = scanner.nextInt();
                }
                if (durationSelect == 7) {
                    deposits = 5;
                } else if (durationSelect == 14) {
                    deposits = 10;
                }

                System.out.println("\nWhen are you borrowing?");
                System.out.println("1)Morning");
                System.out.println("2)Afternoon");

                while (shift > 2 || shift < 1) {
                    System.out.print("Your Selection: ");
                    shift = scanner.nextInt();
                }

//        if (shift == 1) {
//            borrowMorning.enqueue(new Borrow(book.getEntry(Select).getBook(), durationSelect, deposits));
//            System.out.println("The book you are borrowing is " + borrowMorning.getFront().getBook()
//                    + " for " + borrowMorning.getFront().getDuration() + " Days" + " and the deposit is " + borrowMorning.getFront().getDeposit());
//        } else {
//            borrowAfternoon.enqueue(new Borrow(book.getEntry(Select).getBook(), durationSelect, deposits));
//            System.out.println("The book you are borrowing is " + borrowAfternoon.getFront().getBook()
//                   + "for" + borrowMorning.getFront().getDuration() + "Days" + " and the deposit is " + borrowAfternoon.getFront().getDeposit());
//        }
                if (shift == 1) {
                    borrowMorning.enqueue(new Borrow(Booklists.getEntry(i).getBookID(), durationSelect, deposits));
                    System.out.println("The book you are borrowing is " + borrowMorning.getFront().getBook()
                            + " for " + borrowMorning.getFront().getDuration() + " Days" + " and the deposit is " + borrowMorning.getFront().getDeposit());
                } else {
                    borrowAfternoon.enqueue(new Borrow(Booklists.getEntry(i).getBookID(), durationSelect, deposits));
                    System.out.println("The book you are borrowing is " + borrowAfternoon.getFront().getBook()
                            + "for" + borrowMorning.getFront().getDuration() + "Days" + " and the deposit is " + borrowAfternoon.getFront().getDeposit());
                }
            }
        }
    }

    public static void librarianApproving(Librarian librarian1) {
        Scanner scanner = new Scanner(System.in);
        int year, month, day, selection = 2;
        Borrow borrow;

        if (librarian1.getShift().equals("Morning")) {
            borrow = borrowMorning.getFront();

        } else {
            borrow = borrowAfternoon.getFront();
        }

        do {
            System.out.println("********");
            System.out.println("*Librarian Approving Book Borrow   *");
            System.out.println("********");
            System.out.println("Book: " + borrow.getBook());
            System.out.println("Borrow Duration (Days): " + borrow.getDuration());
            System.out.println("Deposit Fee: " + borrow.getDeposit());
            System.out.println("1)Confirm");
            System.out.println("2)Refresh");
            System.out.println("3)Exit");
            do {
                System.out.print("Your Selection: ");
                selection = scanner.nextInt();
            } while (selection < 1 || selection > 3);
        } while (selection == 2);

        if (selection == 1) {
            borrowMorning.dequeue();
            LocalDate date1;
            LocalTime timein, timeout;
            LocalDate nowdate = LocalDate.now();
            System.out.println("\n\nBook Borrowing Approved");

            System.out.println("Select Borrow Date (Press Zero 3 Times To Get Today Date)");
            do {
                System.out.print("Year: ");
                year = scanner.nextInt();
            } while (year != 0 && (year < 2010 || year > nowdate.getYear()));

            do {
                System.out.print("Month: ");
                month = scanner.nextInt();
            } while (month > 12 || month < 0);

            do {
                System.out.print("Date: ");
                day = scanner.nextInt();
            } while (day < 0 || day > 31);

            if (year == 0 && month == 0 && day == 0) {
                date1 = LocalDate.now();
            } else {
                date1 = LocalDate.of(year, month, day);
            }

            timein = LocalTime.now();
            System.out.println("Press Enter Key To Finish...");
            scanner.nextLine();
            timeout = LocalTime.now();

            borrowrecordlist.add(new BorrowRecord(date1, librarian1.getID(), borrow));
        }
    }

    public static void collectDeposit(Librarian librarian) {

        Scanner scanner = new Scanner(System.in);
        int totalAmount = 0;

        ArrList al = new ArrList();
        int yearnow = LocalDate.now().getYear();
        int monthnow = LocalDate.now().getMonthValue();
        int daynow = LocalDate.now().getDayOfMonth();
        String monthly = "Monthly";
        String daily = "Daily";
        if (librarian.getCollectPaymentMethod().equals(monthly)) {
            for (int i = 1; i <= borrowrecordlist.getLength(); i++) {
                if (borrowrecordlist.getEntry(i).getLibrarian_id().equals(librarian.getID())) {
                    if (borrowrecordlist.getEntry(i).isIsPaid() == false) {
                        if (borrowrecordlist.getEntry(i).getBorrowDate().getYear() < yearnow) {
                            al.add(i);
                            System.out.println(borrowrecordlist.getEntry(i).toString());
                            totalAmount += borrowrecordlist.getEntry(i).getBorrow().getDeposit();
                        } else if (borrowrecordlist.getEntry(i).getBorrowDate().getMonthValue() < monthnow && borrowrecordlist.getEntry(i).getBorrowDate().getYear() == yearnow) {
                            al.add(i);
                            System.out.println(borrowrecordlist.getEntry(i).toString());
                            totalAmount += borrowrecordlist.getEntry(i).getBorrow().getDeposit();
                        }
                    }

                }

            }
        } else if (librarian.getCollectPaymentMethod().equals(daily)) {
            for (int i = 1; i <= borrowrecordlist.getLength(); i++) {
                if (borrowrecordlist.getEntry(i).getLibrarian_id().equals(librarian.getID())) {
                    if (borrowrecordlist.getEntry(i).isIsPaid() == false) {
                        if (borrowrecordlist.getEntry(i).getBorrowDate().getYear() < yearnow) {
                            al.add(i);
                            System.out.println(borrowrecordlist.getEntry(i).toString());
                            totalAmount += borrowrecordlist.getEntry(i).getBorrow().getDeposit();
                        } else if (borrowrecordlist.getEntry(i).getBorrowDate().getMonthValue() < monthnow && borrowrecordlist.getEntry(i).getBorrowDate().getYear() == yearnow) {
                            al.add(i);
                            System.out.println(borrowrecordlist.getEntry(i).toString());
                            totalAmount += borrowrecordlist.getEntry(i).getBorrow().getDeposit();
                        } else if (borrowrecordlist.getEntry(i).getBorrowDate().getDayOfMonth() < daynow && borrowrecordlist.getEntry(i).getBorrowDate().getMonthValue() == monthnow && borrowrecordlist.getEntry(i).getBorrowDate().getYear() == yearnow) {
                            al.add(i);
                        }
                        System.out.println(borrowrecordlist.getEntry(i).toString());
                        totalAmount += borrowrecordlist.getEntry(i).getBorrow().getDeposit();
                    }

                }

            }
        } else {
            for (int i = 1; i <= borrowrecordlist.getLength(); i++) {
                if (borrowrecordlist.getEntry(i).getBorrowDate().getYear() < yearnow) {
                    if (borrowrecordlist.getEntry(i).getLibrarian_id().equals(librarian.getID())) {
                        if (borrowrecordlist.getEntry(i).isIsPaid() == false) {
                            al.add(i);
                            System.out.println(borrowrecordlist.getEntry(i).toString());
                            totalAmount += borrowrecordlist.getEntry(i).getBorrow().getDeposit();
                        }
                    }

                }
            }
        }

        System.out.println("\nTotal Amount To Be Collected: " + totalAmount);
        System.out.println("Collect Deposit?(1-- Yes, others-- Exit)");
        int selection = scanner.nextInt();
        if (selection == 1) {
            paymentlist.add(new Payment(LocalDate.now(), totalAmount, librarian));
            for (int i = 1; i <= al.getLength(); i++) {
                borrowrecordlist.getEntry((int) al.getEntry(i)).setIsPaid(true);
            }
        }
    }

    public static void viewDepositPayment(Librarian librarian) {
        System.out.println();
        for (int i = 1; i <= paymentlist.getLength(); i++) {
            if (paymentlist.getEntry(i).getLibrarian().getID().equals(librarian.getID())) {
                System.out.println(paymentlist.getEntry(i).toString());
            }
        }

    }

    public static void initialdata() {
        Borrow borrow = new Borrow("English", 14, (float) 5.0);
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 1), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 3), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2019, 11, 5), "\tL003", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 7), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 9), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2019, 11, 10), "\tL003", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 12), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 14), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 16), "\tL003", borrow));

        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 18), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 20), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 22), "\tL003", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 24), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 26), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 28), "\tL003", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 11, 30), "\tL001", borrow));

        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 1), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 3), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 5), "\tL003", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 6), "\tL001", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 8), "\tL002", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 10), "\tL003", borrow));
        borrowrecordlist.add(new BorrowRecord(LocalDate.of(2020, 12, 12), "\tL001", borrow));
    }

}
