public class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public SnackDispenseHandler getNextHandler() {
        return nextHandler;
    }

    public void dispense(Snack snack, int quantity) {
        if (snack.getQuantity() >= quantity) {
            snack.setQuantity(snack.getQuantity() - quantity);
            System.out.println("Dispensing " + quantity + " " + snack.getName());
        } else {
            System.out.println("Sorry, " + snack.getName() + " is out of stock.");
            if (nextHandler != null) {
                nextHandler.dispense(snack, quantity);
            } else
                System.out.println("No more snacks available.");
        }
    }
}
