/**
** To compile the file:
** javac Counting.java
** 
** To run:
** java Counting
**
** After compiling/executing this code three times this is the output:
** 12660
** 12091
** 11903
**/
public class Counting {
  public static void main(String ...args) throws InterruptedException {

      class Counter {

        private int count = 0;
        public void increment() { ++count; }
        public int getCount() { return count; }

      }

      final Counter counter = new Counter();

      class CountingThread extends Thread {

        public void run(){
            for (int x = 0; x < 10000; ++x) {
              counter.increment();
            }
        }
      }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(counter.getCount());
  }

}
