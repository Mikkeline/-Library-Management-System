/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

public class LinkedList<T> implements LinkedListInterface<T> {
  private Node firstNode;
  private int numOfElement;

  public LinkedList() {
    clear();
  }

  @Override
  public final void clear() {
    firstNode = null;
    numOfElement = 0;
  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);	

    if (isEmpty()) {
      firstNode = newNode;
    } else {                        
      Node currentNode = firstNode;	
      while (currentNode.next != null) { 
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; 
    }

    numOfElement++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) { 
    boolean check = true;

    if ((newPosition >= 1) && (newPosition <= numOfElement + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) { 
        newNode.next = firstNode;
        firstNode = newNode;
      } else {								
        Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		
        }

        newNode.next = nodeBefore.next;	
        nodeBefore.next = newNode;
      }

      numOfElement++;
    } else {
      check = false;
    }

    return check;
  }

  @Override
  public T remove(int givenPosition) {
    T result = null;                 

    if ((givenPosition >= 1) && (givenPosition <= numOfElement)) {
      if (givenPosition == 1) {      
        result = firstNode.data;     
        firstNode = firstNode.next;
      } else {                         
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		
        }
        result = nodeBefore.next.data;  
        nodeBefore.next = nodeBefore.next.next;	
      } 																// one to be deleted (to disconnect node from chain)

      numOfElement--;
    }

    return result; 
  }

  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numOfElement)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		
      }
      currentNode.data = newEntry;	
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numOfElement)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		
      }
      result = currentNode.data;	
    }

    return result;
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }
    return found;
  }

  @Override
  public int getLength() {
    return numOfElement;
  }

  @Override
  public boolean isEmpty() {
    boolean result;

    result = numOfElement == 0;

    return result;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }
  
  public class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }    
}