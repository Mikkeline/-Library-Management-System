/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author User
 */
public class Books {
    
    private String bookTitle;
    private String bookID;
    private String bookAuthor;
    private String bookType;
    private String ISBN;
    private int bookQuantity;

    public Books(String title, String id, String author, String type, String isbn, int quantity) {
        bookTitle = title;
        bookID = id;
        bookAuthor = author;
        bookType = type;
        bookQuantity = quantity;
        ISBN = isbn;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookType() {
        return bookType;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String toString() {
        String output
                = "Book Title      : " + bookTitle
                + "\nBook ID         : " + bookID
                + "\nAuthor          : " + bookAuthor
                + "\nBook Type       : " + bookType
                + "\nBook ISBN       : " + ISBN
                + "\nBook Quantity   : " + bookQuantity
                + "\n-------------------------------------------------\n";
        return output;
    }

    public static boolean validateBookID(String bookID) {
        boolean valid = true;
        if (bookID.length() >= 6) {
            int countLetter = 0;
            int countDigit = 0;
            for (int i = 0; i < bookID.length() && valid; i++) {
                char ch = bookID.charAt(i);
                if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                    valid = false;
                } else {
                    if (Character.isLetter(ch)) {
                        countLetter++;
                    } else if (Character.isDigit(ch)) {
                        countDigit++;
                    }
                }
            }
            if (valid && !(countLetter > 0 && countDigit > 0)) {
                valid = false;
            }
        } else {
            valid = false;
        }

        return valid;
    }

    public static boolean validateISBN(String ISBN) {
        boolean valid = true;
        if (ISBN.matches("^(?=[1-9]+)\\d{10}$") || ISBN.matches("^(?=[1-9]+)\\d{13}$")) {
            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

}
