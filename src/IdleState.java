public class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        for (Snack snack : vendingMachine.getSnacks()) {
            if (snack.getName().equalsIgnoreCase(snackName)) {
                vendingMachine.setState(new WaitingForMoneyState(vendingMachine, snack));
                System.out.println("Selected " + snackName + ". Please insert money.");
                return;
            }
        }
        System.out.println("Sorry, " + snackName + " is not available.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please select a snack and insert money first.");
    }
}
