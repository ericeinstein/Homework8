import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        // Create snacks
        Snack coke = new Snack("Coke", 1.50, 5);
        Snack pepsi = new Snack("Pepsi", 1.50, 3);

        // Create a list of snacks
        List<Snack> snacks = new ArrayList<>();
        snacks.add(coke);
        snacks.add(pepsi);

        // Create VendingMachine
        vendingMachine = new VendingMachine(snacks);

        // Chain of responsibility setup
        vendingMachine.getSnackDispenser().setNextHandler(new SnackDispenseHandler());
    }

    @Test
    public void testSelectSnack() {
        vendingMachine.selectSnack("Coke");
        assertEquals("WaitingForMoneyState", vendingMachine.getState().getClass().getSimpleName());
    }

    @Test
    public void testInsertMoney() {
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(2.00);
        assertEquals(2, vendingMachine.getSnacks().get(1).getQuantity());
    }

    @Test
    public void testDispenseSnack() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        assertEquals(4, vendingMachine.getSnacks().get(0).getQuantity());
    }
}
