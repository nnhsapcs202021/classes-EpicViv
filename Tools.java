import java.awt.*;

public class Tools {
     public static void print(String x) {
          System.out.print(x);
     }

     public static void println(String x) {
          System.out.println(x);
     }

     public static void print(int x) {
          System.out.print(x);
     }

     public static void println(int x) {
          System.out.println(x);
     }

     public static void print(double x) {
          System.out.print(x);
     }

     public static void println(double x) {
          System.out.println(x);
     }

     public static void enter() {
          print("\n");
     }

     public static void print(int[] x) {
          print("{" + x[0]);
          for (int i = 1; i < x.length; i++) {
               print(", " + x[i]);
          }
          print("}");
     }

     public static void print(double[] x) {
          print("{" + x[0]);
          for (int i = 1; i < x.length; i++) {
               print(", " + x[i]);
          }
          print("}");
     }

     public static void print(String[] x) {
          print("{" + x[0]);
          for (int i = 1; i < x.length; i++) {
               print(", " + x[i]);
          }
          print("}");
     }

     public static void print(Color col){
          System.out.println(col);
     }

     public static void print(Building[] bs){

     }

     public static int[] add(int[] a, int b) {
          int len = a.length;
          int[] newArray = new int[len + 1];
          int newLen = newArray.length;
          for (int i = 0; i < len; i++) {
               newArray[i] = a[i];
          }
          newArray[newLen - 1] = b;
          return newArray;
     }
}
