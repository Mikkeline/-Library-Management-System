/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author User
 */
public class BorrowRecord {
    private LocalDate borrowDate;
  
    private String librarian_id;
    private boolean isPaid;
    private Borrow borrow;

    public BorrowRecord(LocalDate borrowDate, String librarian_id, Borrow borrow) {

        this.borrowDate = borrowDate;
       
        
        this.librarian_id = librarian_id;
        this.isPaid = false;
        this.borrow = borrow;

    }



    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }



  
  
    public String getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(String librarian_id) {
        this.librarian_id = librarian_id;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
    
public String toString(){
    
    return borrowDate+"  "+librarian_id+"\t\t"+borrow.getDeposit()+"\t"+isPaid;
}

}
