import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class WaitingForMoneyStateTest {
    private VendingMachine vendingMachine;
    private Snack selectedSnack;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine(new ArrayList<>());
        selectedSnack = new Snack("Coke", 1.50, 5);
    }

    @Test
    public void testInsertMoney() {
        StateOfVendingMachine state = new WaitingForMoneyState(vendingMachine, selectedSnack);
        state.insertMoney(2.00);
        assertEquals(4, selectedSnack.getQuantity());
    }
}
