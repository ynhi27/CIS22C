package Final_p1;/** * Yue-Hsi Cheng, Huong Doan, Y Nhi Tran, Travis Huang * Professor Abolghasemi * CIS 22C * June 25th, 2023 *//**   A class of runtime exceptions thrown by methods to   indicate that a stack is empty.   @author Frank M. Carrano   @author Timothy M. Henry   @version 4.0*/public class EmptyStackException extends RuntimeException{   public EmptyStackException()   {      this(null);   } // end default constructor      public EmptyStackException(String message)   {      super(message);   } // end constructor} // end EmptyStackException