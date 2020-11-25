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
import java.util.Arrays;

/**
 * This class checks the Sequence Generator program for bugs and valid output
 * 
 * @author DPizz
 *
 */
public class SequenceGeneratorTests {

  public static void main(String[] args) {

    if (!geometricSequenceGeneratorTest())
      System.out.print("ERROR: program is not correctly constructing geometric sequences");
    if (!fibonacciSequenceGeneratorTest())
      System.out.println("ERROR: program is not correctly constructing Fibonacci Sequence");
    if (digitProductSequenceGeneratorTest())
      System.out.println("Test passed for digit product sequence generator");


  }

  /**
   * assesses program construction validity of a geometric sequence with a known geometric sequence
   * 
   * @return
   */
  public static boolean geometricSequenceGeneratorTest() {
    int fail = 0; // Initially assume tests pass
    int success = 0; // initially number of successful sequence additions

    // geometric sequences to be tested
    // test 1 will be a sequence of [1 4 16 64] if code is functioning correctly
    GeometricSequenceGenerator test1 = new GeometricSequenceGenerator(1, 4, 4);

    while (test1.hasNext()) {// iterates through whole sequence if method is working correctly
      if (test1.next() == 1) // first sequence value
        ++success;
      if (test1.next() == 4) // second sequence value
        ++success;
      if (test1.next() == 16) // third sequence value
        ++success;
      if (test1.next() == 64) // last element in the sequence if correct sequence construction
        ++success;
    }
    if (success == 4)
      System.out.println("Test passed for geometric sequence");
    else
      ++fail;

    if (fail != 0) // program is not constructing geometric sequences correctly
      return false;
    else
      return true; // program is working correctly with respect to geometric sequences
  }

  /**
   * assesses program construction validity of the Fibonacci sequence for a known sequence size
   * 
   * @return
   */
  public static boolean fibonacciSequenceGeneratorTest() {
    int i = 0; // used in while loop below
    int fail = 0; // Initially assume tests pass
    int[] test = new int[10]; // blank array to be populated by constructed sequence values
    int[] correct = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}; // correct Fibonacci sequence to 10th value

    // geometric sequences to be tested
    // test 1 will be a sequence of [0 1 1 2 3 5 8 13 21 34] if code is functioning correctly
    FibonacciSequenceGenerator test1 = new FibonacciSequenceGenerator(10);

    while (test1.hasNext()) {// iterates through whole sequence if method is working correctly
      test[i] = test1.next(); // populates test array with constructed sequence values
      i++;
    }
    if (Arrays.equals(test, correct)) // use of Arrays utility to check if the test array is correct
      System.out.println("Test passed for Fibonacci sequence");
    else
      ++fail;

    if (fail != 0) // program is not constructing Fibonacci sequence correctly
      return false;
    else
      return true; // program is working correctly with respect to the Fibonacci sequence
  }

  public static boolean digitProductSequenceGeneratorTest() {
    int i = 0; //to be used in a for loop
    int fail = 0; //first assume test will pass
    int success = 0; //to be incremented when exceptions are being thrown and caught correctly
    ArrayList<Integer> correctSequence = new ArrayList<Integer>(); // the correct sequence will be
                                                                   // stored in this ArrayList
    correctSequence.add(31);
    correctSequence.add(34);
    correctSequence.add(46);
    correctSequence.add(70);
    correctSequence.add(77);

    try {
      DigitProductSequenceGenerator test1 = new DigitProductSequenceGenerator(31, 5);

      ArrayList<Integer> test1SomeMore = test1.getSequence(); //stores the sequences as an ArrayList
      for (i = 0; i < test1SomeMore.size(); ++i) { //compares the constructed sequence to the correct sequence as ArrayLists
        if (test1SomeMore.get(i) != correctSequence.get(i)) {
          ++fail;
          break;
        }

      }
      DigitProductSequenceGenerator test2 = new DigitProductSequenceGenerator(-1, 5); //should throw an exception for invalid initial value
    }

    catch (IllegalArgumentException e) {
      ++success;
      //System.out.println(e);
    }
    try {
      DigitProductSequenceGenerator test3 = new DigitProductSequenceGenerator(2, -1); //should throw an exception for invalid size
    }
    catch(IllegalArgumentException e){
      ++success;
     // System.out.println(e);
    }

    if (fail == 0 && success == 2) {
      return true;
    } else {
      System.out.println("ERROR: program is not correctly constructing digit product sequence");
      return false;
    }

  }

}
