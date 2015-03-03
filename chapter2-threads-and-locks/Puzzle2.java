/***
 * Excerpted from "Seven Concurrency Models in Seven Weeks",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/pb7con for more book information.
***/
/**
** To compile the file:
** javac Puzzle2.java
**
** To run:
** java Puzzle2
**
** After compiling/executing this code several times this is the output I get:
** The meaning of life is:42
** I don't know the answer
**
** However the book set a interesting scenario of getting:
** The meaning of life is:0
**
**/
public class Puzzle2 {

  static boolean answerReady = false;
  static int answer = 0;
  static Thread t1 = new Thread() {
    public void run() {
      answer = 42;
      answerReady = true;
    }
  };

  static Thread t2 = new Thread() {
    public void run() {

      while(!answerReady) {
        try {
          Thread.sleep(1000);
        } catch(InterruptedException ie ) {
          System.err.print(ie);
        }
      }

      System.out.println("The meaning of life is:" + answer);
    }
  };

  public static void main(String ...args) throws InterruptedException {
    t1.start(); t2.start();
    t1.join(); t2.join();
  }
}
