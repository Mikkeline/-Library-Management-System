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
import  java.util.Date;
import  java.sql.Time;
import java.time.LocalDate;

public class Payment {
    private LocalDate paymentDate;
    private float paymentAmount;
    private Librarian librarian;
            
    public Payment(LocalDate paymentDate, float paymentAmount, Librarian librarian) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.librarian = librarian;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    
    public String toString(){
        return  paymentDate + "\t " + paymentAmount+"\t\t    "+librarian.getID()+"\n";
    }
    
}

