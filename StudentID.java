public class StudentID {

     private String name;
     private int number;

     public StudentID(String initName, int initNumber){
          this.name = initName;
          this.number = initNumber;
     }

     public String getName(){return this.name;}

     public void setName(String newName){this.name = newName;}

     public int getNumber(){return this.number;}

     public void setNumber(int newNumber){this.number = newNumber;}

     public String getFirstName(){
          return this.name.substring(0, this.name.indexOf(' '));
     }

     public String getLastName(){
          return this.name.substring(this.name.indexOf(' ') + 1);
     }
}