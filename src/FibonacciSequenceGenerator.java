//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Sequence Generator)
// Files: (ArithmeticSequenceGenerator, GeometricSequenceGenerator,
// FibonacciSequence, DigitProductSequenceGenerator,
// Sequence, SequenceGeneratorTests)
// Course: (CS300, Fall, 2018)
//
// Author: (Dante Pizzini)
// Email: (pizzini@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (none)
// Partner Email: (none)
// Partner Lecturer's Name: (none)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (none)
// Online Sources: (none)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * This class represents a generator for a Fibonacci sequence. This class implements the
 * Iterator<Integer> interface
 * 
 * @author DPizz
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far


  /**
   * Generates the fibonacci sequence of a desired size
   * 
   * @param size
   */
  public FibonacciSequenceGenerator(int size) {
    if (size <= 0) { // checks command validity
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    this.SIZE = size; // desired sequence size
    prev = 0; // initial previous element for a Fibonacci sequence
    next = 1; // initial next element for a Fibonacci sequence
    generatedCount = 0; // initial count is 0
  }


  /**
   * Checks if the iteration has a next element in this sequence
   * 
   * @return true if the current element in the iteration has a next element in this sequence, false
   *         otherwise
   */
  @Override
  public boolean hasNext() {
    //time complexity: O(1)
    return generatedCount < SIZE; // returns true if count is less than size, else false
  }

  /**
   * Returns the next element in this arithmetic sequence iteration with respect to the numbers
   * generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public Integer next() {
    //time complexity: O(1)
    if (!hasNext()) { // check if the current element has a next element in this sequence
      return null;
    }
    if (generatedCount == 0) { // accounts for the initial condition of the Fibonacci sequence
      generatedCount++;
      return 0;
    }

    int current = next; // set the current element
    generatedCount++; // increment the number of generated elements so far
    next += prev;// set the next element (The addition of the current element with the previous one)
    prev = current;
    return current; // return the current number as the generated one
  }

}
