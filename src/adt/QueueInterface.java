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
public interface QueueInterface<A> {
    
  public void enqueue(A newEntry);
  public A dequeue();
  public A getFront();
  public boolean isEmpty();
  public void clear();
  
}
