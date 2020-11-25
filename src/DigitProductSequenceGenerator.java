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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a generator for a digit product progression. This class utilizes
 * ArrayList's built in iterator utility
 * 
 * @author DPizz
 *
 */
public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * The constructor for the desired digit product sequence with an initial value and desired
   * sequence size
   * 
   * @param init
   * @param size
   */
  public DigitProductSequenceGenerator(int init, int size) {
    if (size <= 0) { // checks command validity
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    if (init <= 0) { // checks command validity
      throw new IllegalArgumentException(
          "WARNING: The starting element for digit profuct sequence cannot be less than or equal to zero.");
    }
    this.INIT = init; // desired initial value in the sequence
    this.SIZE = size; // desired sequence size
    sequence = new ArrayList<Integer>(); // initializes the sequence ArrayList
    generateSequence(); // calls the generateSequence method
  }

  /**
   * Modifies the sequence ArrayList by adding the product of the current ArrayList element value's
   * individual integers (excluding 0) and the current ArrayList to be the value added to the
   * ArrayList in sequence until the desired size is reached
   * 
   */
  public void generateSequence() {
    sequence.clear(); // clears any previous sequence if called upon more than once
    int i = 0; // initial condition for while loop below
    int current = INIT; // current element
    int next = INIT; // next element per digit sequence condition
    int digitToAdd = 1; // Initialization to be used in while loop

    while (i < SIZE) { // iterates in sequence until desired size is met
      while (current > 0) { // while the current ArrayList value is not 0
        if (current % 10 != 0) { // if the current element is not divisible by 10, its
                                 // integers can be split apart
          digitToAdd = digitToAdd * (current % 10); // updates the digits to add to this ArrayList
                                                    // index
        }
        current /= 10; // divides the current value by 10 to check the next integer in the value
      }
      i++;
      sequence.add(next); // adds the next value to the sequence
      next = next + digitToAdd; // updates the next value to be added
      current = next; // sets the next value to be modified in the loop
      digitToAdd = 1; // re-initializes the digits to add modifier

    }
  }

  /**
   * Getter for the ArrayList sequence's iterator utility
   * 
   * @return
   */
  public Iterator<Integer> getIterator() {
    return sequence.iterator();
  }

public ArrayList<Integer> getSequence(){
  return sequence;
  
}
}
