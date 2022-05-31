/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Minn
 */
public class Borrow {
    private String book;
    private int duration;
    private float deposit;
    
    public Borrow(String book, int duration, float deposit) {
        this.book = book;
        this.duration = duration;
        this.deposit = deposit;
    }

    public String getBook() {
        return book;
    }

    public int getDuration() {
        return duration;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }
    
}