/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
//import java.util.Objects;
/**
 *
 * @author User
 */
public class Librarian {
    
  private String name; 
  private String studentID;
  private String shift;
  private String phoneNo;
  private String ID;
  private String password;
  private String collectPaymentMethod;
  private String role;
  
  public Librarian(){}
 
      public Librarian(String name, String studentID, String shift, String phoneNo,String role, String collectPaymentMethod, String ID, String password) {
       
        this.name = name;
        this.studentID = studentID;
        this.shift = shift;
        this.phoneNo = phoneNo;
        this.ID = ID;
        this.password = password;
        this.collectPaymentMethod = collectPaymentMethod;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }
    
    public String getCollectPaymentMethod() {
        return collectPaymentMethod;
    }

    public void setCollectPaymentMethod(String collectPaymentMethod) {
        this.collectPaymentMethod = collectPaymentMethod;
    }
    
  public String toString(){
        return  "\nLibrarian Information\n***********************\n" +"Librarian's Name         :" + name + "\nLibrarian's Student ID   :" + getStudentID() + "\nDuty Shift               :" + shift + "\nLibrarian's Phone Number :" + phoneNo +
                "\nRole(Room Booking)       :"+role+"\nPayment Method           :" + collectPaymentMethod +
                "\n\nID                       :" + ID + "\n\n";
    }

  
  
   public static boolean validateName(String name) {
        boolean valid = true;
        int countLetter = 0;

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!Character.isLetter(ch)) {
                valid = false;
            } else {
                if (Character.isLetter(ch)) {
                    countLetter++;
                }
            }
        }
        if (valid && !(countLetter > 0)) {
            valid = false;
        }

        return valid;
    }
  
  
   //must be at least 6 characters & digits
    public static boolean validateStudentID(String studentID) {
        boolean valid = true;
        if (studentID.length() >= 10) {
            int countLetter = 0;
            int countDigit = 0;
            for (int i = 0; i < studentID.length() && valid; i++) {
                char ch = studentID.charAt(i);
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
    
     public static boolean validateShift(String shift) {
        boolean valid = true;
        int countLetter = 0;

        for (int i = 0; i < shift.length(); i++) {
            char ch = shift.charAt(i);
            if (!Character.isLetter(ch)) {
                valid = false;
            } else {
                if (Character.isLetter(ch)) {
                    countLetter++;
                }
            }
        }
        if (valid && !(countLetter > 0)) {
            valid = false;
        }

        return valid;
    }

  public static boolean validatePhoneNo(String phoneNo){
        boolean valid = true;
        for (int i = 0; i < phoneNo.length(); i++) { 
  
            // Check if character is start with 0, 10-11 digits
            // then return true 
            // else false 
            if (phoneNo.charAt(0)=='0'&&phoneNo.charAt(i) >= '0'&& phoneNo.charAt(i) <= '9'&& phoneNo.length() <=11&&phoneNo.length() >=10) { 
                valid = true; 
            } 
            else { 
                valid = false; 
            } 
        }   
        return valid;
    }
  public static boolean validatePassword(String password) {
        boolean valid = true;
        
        //At least 4 characters with letters and digits
        
        if (password.length() >= 4) {
            int countLetter = 0;
            int countDigit = 0;
            for (int i = 0; i < password.length() && valid; i++) {
                char ch = password.charAt(i);
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

  
}


