package org.examples.deadlock;
/***
 * Excerpted from "Seven Concurrency Models in Seven Weeks",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/pb7con for more book information.
***/

/**
** To compile the files:
** go to chapter2-threads-and-locks directory
** javac org/examples/deadlock/Chopstick.java org/examples/deadlock/Philosopher.java org/examples/deadlock/DiningPhilosophers.java
** or simply javac org/examples/deadlock/*.java
** To run:
** java org.examples.deadlock.DiningPhilosophers
**
** After compiling/executing this code several times this is the output I get:
** 0 is eating, using chopsticks ( left=0;right =1 )
** 3 is eating, using chopsticks ( left=3;right =4 )
** 1 is eating, using chopsticks ( left=1;right =2 )
** 2 is eating, using chopsticks ( left=2;right =3 )
**
** Try first with the same amount of Chopsticks and Philosophers
** The book asks for what would you do to increase the likelihood
** of a deadlock.
** What's a logical think to do?
** I was in a deadlock almost after a second after running the code
**
**/
public class DiningPhilosophers {

  private static final int NUMBER_OF_PHILOSOPHERS=5, NUMBER_OF_CHOPSTICKS=5;
  private static final int THINKING_TIME = 1000;

  public static void main(String ...args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
    Chopstick[] chopsticks = new Chopstick[NUMBER_OF_CHOPSTICKS];

    for(int i = 0; i < NUMBER_OF_CHOPSTICKS ; ++i) {
      chopsticks[i] = new Chopstick(i);
    }

    for(int i = 0; i < NUMBER_OF_PHILOSOPHERS ; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i % NUMBER_OF_CHOPSTICKS ],
                          chopsticks[ (i + 1) % NUMBER_OF_CHOPSTICKS], i, THINKING_TIME);
      philosophers[i].start();
    }

    for( int i = 0; i < NUMBER_OF_PHILOSOPHERS ; ++i) {
      philosophers[i].join();
    }

  }

}
