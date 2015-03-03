package org.examples.deadlock;
/***
 * Excerpted from "Seven Concurrency Models in Seven Weeks",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/pb7con for more book information.
***/
import java.util.Random;

public class Philosopher extends Thread {
  private Chopstick right, left;
  private Random random;
  private int id, maxSleepRandom;

  public Philosopher(Chopstick left, Chopstick right, int id, int maxSleepRandom) {
    this.left = left; this.right = right;
    this.id = id;
    random = new Random();
    this.maxSleepRandom = maxSleepRandom;
  }

  public void run() {
    try {
      while(true) {
        Thread.sleep(random.nextInt(maxSleepRandom));
        synchronized(left) {
          synchronized(right) {
            Thread.sleep(random.nextInt(maxSleepRandom));
            System.out.println(id + " is eating, using chopsticks ( left = "
                              + left.getId() + " ;right = "+right.getId() +" )");
          }
        }
      }
    } catch (InterruptedException ie) {}
  }

}
