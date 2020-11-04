import java.util.Scanner;

public class StringParsing {
     public static void main(String[] args){
          Scanner scan = new Scanner(System.in);
          D.print("Please enter an integer between 1,000 and 999,999: "); String input = scan.nextLine();

          int commaIndex = 0;

          for (int a = 0; a < input.length(); a++){
               if(input.charAt(a) == ','){
                    commaIndex = a;
               }
          }

          if(commaIndex > 0) {
               D.print(input.substring(0, commaIndex));
               D.print(input.substring(commaIndex + 1));
          }
          else{
               D.print(input.substring(0, input.length() - 3) + "," + input.substring(input.length() - 3));
          }
     }
}
