/**
 * This class models a vending machine.
 *
 * @author Vivek Ily
 * @version October 21, 2020
 */

public class VendingMachine {

     private int cans;
     private int tokens;
     private int capacity;
     private int previousPayment;

     /**
      * Default VendingMachine constructor constructs a vending machine object initialized to 10 cans and 0 tokens and no previous payment.
      */
     public VendingMachine(){
          this.cans = 10;
          this.tokens = 0;
          this.capacity = 10;
          this.previousPayment = 0;
     }

     /**
      * Custom VendingMachine construcctor constructs a vending machine object initialized to the specified number of cans passed in as a parameter and 0 tokens and no previous payment.
      * @param num initializes the vending machine object to this number of cans
      */
     public VendingMachine(int num){
          this.cans = num;
          this.tokens = 0;
          this.capacity = num;
          this.previousPayment = 0;
     }

     /**
      * Returns the a token after it is inserted. For example, a client inserts a token, but realizes that he does not need a can, this method will return the token.
      */
     public void returnInsertedToken(){
          this.tokens -= this.previousPayment;
          this.cans += this.previousPayment;
     }

     /**
      * Inserts a token into the vending machine.
      * @param num specifies the number of tokens the client wishes to insert
      */
     public void insertToken(int num){
          if (this.getCanCount() > 0) {
               this.tokens += num;
               this.previousPayment = num;
               this.cans -= num;
          }

          else{
               System.out.println("Not enough cans");
          }
     }

     /**
      * Returns the number of cans left in the vending machine
      * @return number of cans left in the vending machine
      */
     public int getCanCount(){return this.cans;}

     /**
      * Returns the number of tokens in the vending machine
      * @return number of tokens in the vending machine
      */
     public int getTokenCount(){return this.tokens;}

     /**
      * Returns the capacity of the vending machine
      * @return capacity of the vending machine
      */
     public int getCapacity(){return this.capacity;}

     /**
      * Refills the vending machine with cans to full capacity
      */
     public void refillCans(){
          this.cans = this.capacity;
     }

     /**
      * Empties all the tokens into a storage space for tokens
      */
     public void emptyTokens(){this.tokens = 0;}

}
