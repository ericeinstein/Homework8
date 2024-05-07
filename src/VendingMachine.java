import java.util.List;

public class VendingMachine {
    private StateOfVendingMachine currentState;
    private SnackDispenseHandler snackDispenser;
    private List<Snack> snacks;

    public VendingMachine(List<Snack> snacks) {
        this.snacks = snacks;
        this.currentState = new IdleState(this);
        this.snackDispenser = new SnackDispenseHandler();
    }

    public void setState(StateOfVendingMachine state) {
        this.currentState = state;
    }

    public StateOfVendingMachine getState() {
        return currentState;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public SnackDispenseHandler getSnackDispenser() {
        return snackDispenser;
    }

    public void selectSnack(String snackName) {
        currentState.selectSnack(snackName);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack();
    }
}
