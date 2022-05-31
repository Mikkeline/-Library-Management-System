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
public class LinkQueue<A> implements QueueInterface<A> {

  private Node firstNode; // references node at front of queue
  private Node lastNode;  // references node at back of queue

  public LinkQueue() {
    firstNode = null;
    lastNode = null;
  } 

  public void enqueue(A newEntry) {
    Node newNode = new Node(newEntry, null);

    if (isEmpty()) {
      firstNode = newNode;
    } else {
      lastNode.next = newNode;
    }

    lastNode = newNode;
  } 

  public A getFront() {
    A firstData = null;

    if (!isEmpty()) {
      firstData = firstNode.data;
    }

    return firstData;
  } 

  public A dequeue() {
    A removeData = null;

    if (!isEmpty()) {
      removeData = firstNode.data;
      firstNode = firstNode.next;

      if (firstNode == null) {
        lastNode = null;
      }
    } 

    return removeData;
  } // end dequeue

  public boolean isEmpty() {
    return ((firstNode == null) && (lastNode == null));
  }

  public void clear() {
    firstNode = null;
    lastNode = null;
  } 

  private class Node {

    private A data; 
    private Node next; 

    private Node(A data) {
      this.data = data;
      this.next = null;
    } 

    private Node(A data, Node next) {
      this.data = data;
      this.next = next;
    } 
  } 
}