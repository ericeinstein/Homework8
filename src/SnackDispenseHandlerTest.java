import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SnackDispenseHandlerTest {
    private SnackDispenseHandler handler;

    @Before
    public void setUp() {
        handler = new SnackDispenseHandler();
    }

    @Test
    public void testDispense() {
        Snack coke = new Snack("Coke", 1.50, 5);
        handler.dispense(coke, 2);
        assertEquals(3, coke.getQuantity());
    }
}
