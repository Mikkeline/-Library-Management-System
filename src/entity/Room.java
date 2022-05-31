/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
public class Room {

    private String time;
    private LocalDate date;
    private String roomSize;

    public Room(String time, String roomSize, LocalDate date) {
        this.time = time;
        this.roomSize = roomSize;
        this.date = date;
    }

    public String gettime() {
        return time;
    }

    public LocalDate getdate() {
        return date;
    }

    public String getroomSize() {
        return roomSize;
    }

    public void settime(String time) {
        this.time = time;
    }

    public void setdate(LocalDate date) {
        this.date = date;
    }

    public void setroomSize(String roomSize) {
        this.roomSize = roomSize;
    }

}
