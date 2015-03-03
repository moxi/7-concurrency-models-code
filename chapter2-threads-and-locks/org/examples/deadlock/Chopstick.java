package org.examples.deadlock;
/***
 * Excerpted from "Seven Concurrency Models in Seven Weeks",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/pb7con for more book information.
***/
public class Chopstick {

  private int id;

  public Chopstick(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
