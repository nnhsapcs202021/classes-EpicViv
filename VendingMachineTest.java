import org.junit.Test; import static org.junit.Assert.*;

public class VendingMachineTest {

     @Test
     public void testReturnInsertedToken(){
          VendingMachine vm = new VendingMachine();
          int initTokens = vm.getTokenCount();
          vm.insertToken(1); vm.insertToken(2);
          vm.returnInsertedToken();
          int finalTokens = vm.getTokenCount();

          assertEquals(1, finalTokens);
     }

     @Test
     public void testInsertToken(){
          VendingMachine vm = new VendingMachine(2);
          int initTokens = vm.getTokenCount();
          vm.insertToken(1);
          int finalTokens = vm.getTokenCount();

          int finalCans = vm.getCanCount();

          assertEquals(1, finalTokens);
          assertEquals(vm.getCapacity()-1, finalCans);
     }

     @Test
     public void testRefillCans(){
          VendingMachine vm = new VendingMachine();
          vm.refillCans();
          int finalCans = vm.getCanCount();

          assertEquals(vm.getCapacity(), finalCans);
     }

     @Test
     public void testEmptyTokens(){
          VendingMachine vm = new VendingMachine();
          int initTokens = vm.getTokenCount();
          vm.emptyTokens();
          int finalTokens = vm.getTokenCount();

          assertEquals(0, finalTokens);
     }

}
