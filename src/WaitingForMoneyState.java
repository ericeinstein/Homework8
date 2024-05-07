public class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;
    private Snack selectedSnack;

    public WaitingForMoneyState(VendingMachine vendingMachine, Snack selectedSnack) {
        this.vendingMachine = vendingMachine;
        this.selectedSnack = selectedSnack;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Please finish your current transaction first.");
    }

    @Override
    public void insertMoney(double amount) {
        if (amount >= selectedSnack.getPrice()) {
            vendingMachine.getSnackDispenser().dispense(selectedSnack, 1);
            vendingMachine.setState(new IdleState(vendingMachine));
        } else
            System.out.println("Insufficient funds. Please insert more money.");

    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please insert money first.");
    }
}
