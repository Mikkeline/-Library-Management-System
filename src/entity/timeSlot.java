/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class timeSlot {

    private String timeSlot;

    
    public timeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String gettimeSlot() {
        return timeSlot;
    }

   
    public void settimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    
 
    public String toString(){ 
        return timeSlot;
    }

}