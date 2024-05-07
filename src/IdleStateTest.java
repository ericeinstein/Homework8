import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class IdleStateTest {
    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine(new ArrayList<>());
    }

    @Test
    public void testSelectSnack() {
        StateOfVendingMachine state = new IdleState(vendingMachine);
        state.selectSnack("Coke");
        assertEquals("IdleState", vendingMachine.getState().getClass().getSimpleName());
    }
}
