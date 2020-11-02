/**
 * This class encrypts strings with a keyphrase version of the classic
 * Caesar Cipher.
 * (as described in The Code Book by Simon Singh)
 *
 * @author gcschmit
 * @version 21 September 2018
 */
public class CaesarCipher {
     /*

     static: one value for the variable for all objects of the class
          This is like class attributes in Python.
          Static class variables can be accessed directly through the class
               (e.g., CaesarCipher.ALPHABET, Math.PI, Color.RED).

     String literal
           is an instance of the String class (not a primitive) delineated by double quotes nad must be defined on a single line

     "ABCDEFGHIJKLMNOPQRSTUVWXYZ" is a string literal equivalent to:
          new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
      */
     private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

     private String keyphrase;

     public CaesarCipher(String initialKeyphrase){
          // prepare the keyphrase by removing duplicate letters
          this.compressKeyphrase(initialKeyphrase);
     }

    /**
     * Returns a string that describes the average time to crack the cipher, in several formats, based on the specified number of seconds per guess.
     *
     * @param secPerGuess the number of seconds to evaluate each attempt
     * @return a string that describes the average time to crack the cipher
     */

    public String getComplexityDescription(int secPerGuess){
        /*
        * Instead of using a "magic number" (e.g., 3.14159), use constants defined by us or the Java Standard Library. For example, in the Math class is defined:
        *
        * public static final double PI = 3.141592654;
        *
        * Declare a constant with the final keyword.
        *   By convention, constants are in all caps with underscores.
        */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY = 24;
        final int DAYS_FOR_EVERY_YEAR = 365;

        //If we try to change the value, a compiler error will be generated
        //SECONDS_FOR_EVERY_MINUTE = 30;

        String desc = "";

        long totalSeconds = this.calculateAverageTimeToCrack(secPerGuess);

        /*
         * Use integer division to calculate how many whole minutes are in the specified number of seconds.
         *
         * Integer division is like // operator in Python because it discards the remainder (truncates).
         *
         * Java does integer division when both operands are integer types
         * It does floaiting-point division when one or both operands are floating-point types.
         *
         * For example:
         *          3 / 4 = 0           (3 and 4 are int literals)
         *          3.0 / 4 = 0.75      (3.0 is a double literal)
         */
        long wholeMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;

        /*
         * Use the modulo operator to calculate how many seconds are left over.
         *
         * The mod operator (%) returns the remainder of the division operation.
         *
         * It can be very useful when paired with integer division.
         *
         * for example:
         *     7 % 2 = 1
         *     11 % 3 = 2
         *     6 % 2 = 0
         *     4 % 11 = 4
         * % 2 is frequently used to test odd/even
         */

         long leftoverSeconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;

         long wholeHours = wholeMinutes / MINUTES_FOR_EVERY_HOUR;
         long leftoverMinutes = wholeMinutes % MINUTES_FOR_EVERY_HOUR;

         long wholeDays = wholeHours / HOURS_FOR_EVERY_DAY;
         long leftoverHours = wholeHours % HOURS_FOR_EVERY_DAY;

         long wholeYears = wholeDays / DAYS_FOR_EVERY_YEAR;
         long leftoverDays = wholeDays % DAYS_FOR_EVERY_YEAR;

         desc = "Average time to crack: " + wholeYears + " years, " + leftoverDays + " days, " + leftoverHours + " hours, " + leftoverMinutes + " minutes, " + leftoverSeconds + " seconds\n";

        return desc;
    }

     /**
      * Compresses the specified keyphrase by remoiving all deplicate letters.
      *
      * @param keyphrase the keyphrase to compress
      */
     public void compressKeyphrase(String keyphrase){
          this.keyphrase = "";

          /*
           * length
           *        returns the number of characters in the string
           */
          int keyphraseLength = keyphrase.length();

          for (int i = 0; i < keyphraseLength; i++){
               /*

               charAt
                    returns the character (of type hat) at the specified index (0-based)

               keyphrase:
               C A E S A R
               0 1 2 3 4 5    <= indices

               length = 6
                */
               char letter = keyphrase.charAt(i);

               /*

               substring
                    returns part of the string starting at the first specified index up to, but not including, the second specified index
                    if only on index is specified, returns part of the string starting at the specified indesx through the end of the string.
                    substring does not support negative indices
                         For example, instead of -2, we would specifyy keyphrase.length() - 2

               keyphrase:
               C A E S A R
               0 1 2 3 4 5    <= indices

               length = 6
               */
               String restOfKeyphrase = keyphrase.substring(i + 1);
               // same as: keyphrase.substring(i + 1, keyphrase.length());

               /*

               indexOf
                    returns the index of the start of the first occurrence of the specified string
                    if not found, returns -1

               restOfKeyphrase:
               A E S A R
               0 1 2 3 4      <= indices

               length = 5
                */
               int index = restOfKeyphrase.indexOf(letter);

               /*

               String concatenation
                    + symbol is the string concatenation operator
                    concatenates the second Strong operand to the end of the first String operand
                    if one or both operands are a String type, + is the string concatenation operator (operands are converted to String object_
                    Otherwise, the + is the addition operator

               Example:

               int x = 7;
               String xAsString = "" + x;    // xAsString => "7"
                */
               if(index ==  -1){
                    this.keyphrase = this.keyphrase + letter;
                    // same as: this.keyphrase += letter;
               }
          }
     }


    /**
      * Encrypts the specified text using the specified keyphrase using a
      * keyphrase-enhanced Caesar Cipher.
      *
      * @param text      the text to encrypt
      * @param keyphrase the keyphrase with which to encrypt the specified text
      * @return the encrypted text
      */
     public String encrypt(String text) {
          String encryptedText = "";

          /*
           * The keyphrase, after removing any repeated letters is used as the beginning of the jumbled cipher alphabet. The remainder of the cipher alphabet is merely the remaining letters of the alphabet, in their correct order, starting where the keyphrase ends.
           */
          String cipherAlphabet = this.keyphrase;
          for (int i = 0; i < CaesarCipher.ALPHABET.length(); i++) {
               char letter = CaesarCipher.ALPHABET.charAt(i);
               if (this.keyphrase.indexOf(letter) == -1) {
                    cipherAlphabet += letter;
               }
          }

          /*
           * For each letter in the text that is a letter, find the corresponding letter at the same position in the cipher alphabet as its replacement.
           */
          for (int i = 0; i < text.length(); i++) {
               char letter = text.charAt(i);

               // if the letter is between A and Z
               if (letter >= 'A' && letter <= 'Z') {
                    // 65 is the ASCII value of 'A'
                    int cipherIndex = letter - 65;
                    encryptedText += cipherAlphabet.charAt(cipherIndex);
               } else    // don't substitute the letter; just use it as is
               {
                    encryptedText += letter;
               }
          }

          return encryptedText;
     }

     /**
      * Calcualtes the average time to crack the cipher, based on the
      * specified length of the keyphrase and seconds to evaluate
      * each attempt, using a brute force approach. This calculation
      * assumes that the cracker knows the length of the keyphrase.
      * If the length is not know, it will take substantially longer
      * to crack the cipher. Regardless, this calculation is only
      * for a brute force approach; other techniques (e.g., frequency
      * analysis) can crack the cipher extremely quickly.
      *
      * @param keyphraseLength the number of characters in the keyphrase
      * @param secPerGuess     the number of seconds to evaluate each attempt
      * @return the average number of seconds to crack the cipher
      */
     public long calculateAverageTimeToCrack(int secPerGuess) {
          final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
          int lettersRemaining = NUMBER_OF_LETTERS_IN_ALPHABET;
          int keyphraseLength = this.keyphrase.length();
          long combinations = 1;

          /*
           * Calculate the number of combintations for the specified keyphrase length.
           *  For example, if the keyphrase is six characters long:
           *      26 * 25 * 24 * 23 * 22 * 21
           *      would be the number of combinations of cipher alphabets for keyphrases
           *      that are six characters long.
           */
          for (int i = 0; i < keyphraseLength; i++) {
               combinations *= lettersRemaining;
               lettersRemaining -= 1;
          }

          long worstCaseTimeToCrack = combinations * secPerGuess;

          // average time is half the worst time since the best time is cracking the
          //  cipher on the first attempt
          return worstCaseTimeToCrack / 2;
     }

     /*
     This method is static, and therefore, is independent of the state of a CasesarCipher object.
     As a result , this method may be invoked on the class instead of a variable that references an object (e.g., CaesarCipher.generateKeyphrase(7);)
     In addition, this method cannot access any instance variables.
      */

     /**
      * Generates a pseudorandom keyphrase of the specified length in characters.
      * @param length the number of characters in the keyphrase
      * @return a pseudorandom keyphrase of the specified length
      */
     public static String generateKeyphrase(int length){
          String keyphrase = "";

          for(int i = 0; i < length; i++){
               /*

               The Math.random static method returns a double [0.0 ... 1.0)

               Often we use the following algorithm to generate random integers from [min ... max]:

               int n = (int)((Math.random() * (max - min + 1)) + min);

               For example: generate a random int [0 ... 25]

               ABCDEFGHIJKLMNOPQRSTUVWXYZ
               0           ...          25
                */

               int letterIndex = (int)(Math.random() *  26);
               keyphrase += CaesarCipher.ALPHABET.substring(letterIndex, letterIndex + 1);
          }

          return keyphrase;
     }
}
