/**
** To compile the file:
** javac HelloWorld.java
**
** To run:
** java HelloWorld
**
** After compiling/executing this code three times this is the output:

** Hello world from new thread
** Hello from main thread
**
** Hello from main thread
** Hello world from new thread
**
** Hello world from new thread
** Hello from main thread
**/

public class HelloWorld {

  public static void main(String ...args) throws InterruptedException {
    Thread myThread = new Thread() {

      public void run(){
          System.out.println("Hello world from new thread");
      }

    };

    myThread.start();
    Thread.yield();
    System.out.println("Hello from main thread");
    myThread.join();
  }

}
