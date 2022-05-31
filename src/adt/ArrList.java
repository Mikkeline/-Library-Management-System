/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author User
 */
public class ArrList<T> implements ListInterface<T> {

private T[] array;
private int length;
private static final int DEFAULT_ARRCAPACITY = 20;

 public ArrList() {
     
        this(DEFAULT_ARRCAPACITY);
    }
 
 public ArrList(int initialCapacity) {
        length = 0;
        array = (T[]) new Object[initialCapacity];
    }
 
 
@Override
  public boolean add(T newElement){
       for(int i=0; i <length ; i++){
            if(array[i].equals(newElement)){
                return false;
            }
        } 
    if(isArrayFull()){
            doubleArray();
        }
    array[length] = newElement;
    length++;
    return true;
  }
  
  
  
     private boolean isArrayFull() {
        return length == array.length;
    }
    
     
      private void doubleArray(){
        T[] oldArray = array;
        
        array = (T[]) new Object [2 * oldArray.length];
        
        for(int index = 0; index < oldArray.length; index++)
            array[index] = oldArray[index];
    }
      
      
      
      
      public boolean add(int newPosition, T newElement) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(newPosition);
        array[newPosition - 1] = newElement;
        length++;
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
      private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    // move each entry to next higher index, starting at end of
    // array and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }
      
@Override
      public int getLength() {
    return length;
  }
      
  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return false;
  }
@Override
     public String toString() {
       String outputStr = "";
        for (int index = 0; index < length; index++) {
            outputStr += array[index] + "    ";
        }
   return outputStr+"\n";
     }

   
     
@Override
    public T remove(int givenPosition) {
         
       T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            result = array[givenPosition - 1];
            
            if (givenPosition < length) {
                removeGap(givenPosition);
            }

            length--;
        }
        return result;
    }
    
     public boolean remove(T newElement){
        for(int i=0; i<length; i++){
            if(array[i].equals(newElement) ){
                removeGap(i);
                length--;
                return true;
            }
        }
        return true;
    }
    
    
     private void removeGap(int givenPosition) {
        // move each entry to next lower position starting at entry after the
        // one removed and continuing until end of array
        int removedIndex = givenPosition - 1;
        int lastIndex = length - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }
     
     
     
        @Override
    public T getEntry(int givenPosition) {
       T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = array[givenPosition - 1];
    }

    return result;
    }

    
    @Override
    public void clear() {
         length = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      array[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }

 
    @Override
    public boolean contains(T anEntry) {
          boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(array[index])) {
        found = true;
      }
    }

    return found; 
    }

   

   
}
