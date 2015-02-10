/**
** To compile the file:
** javac Puzzle.java
**
** To run:
** java Puzzle
**
** After compiling/executing this code several times this is the output I get:
** The meaning of life is:42
** I don't know the answer
**
** However the book set a interesting scenario of getting:
** The meaning of life is:0
**
**/
public class Puzzle {

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
      if (answerReady) {
        System.out.println("The meaning of life is:" + answer);
      } else {
        System.out.println("I don't know the answer");
      }
    }
  };

  public static void main(String ...args) throws InterruptedException {
    t1.start(); t2.start();
    t1.join(); t2.join();
  }
}
