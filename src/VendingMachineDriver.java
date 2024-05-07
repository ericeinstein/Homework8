import java.util.ArrayList;
import java.util.List;

public class VendingMachineDriver {
    public static void main(String[] args) {
        // Create snacks
        Snack coke = new Snack("Coke", 1.50, 5);
        Snack pepsi = new Snack("Pepsi", 1.50, 3);
        Snack cheetos = new Snack("Cheetos", 1.75, 4);
        Snack doritos = new Snack("Doritos", 2.00, 2);
        Snack kitKat = new Snack("KitKat", 1.25, 6);
        Snack snickers = new Snack("Snickers", 1.50, 0);

        // Create a list of snacks
        List<Snack> snacks = new ArrayList<>();
        snacks.add(coke);
        snacks.add(pepsi);
        snacks.add(cheetos);
        snacks.add(doritos);
        snacks.add(kitKat);
        snacks.add(snickers);

        // Create VendingMachine
        VendingMachine vendingMachine = new VendingMachine(snacks);

        // Chain of responsibility setup
        vendingMachine.getSnackDispenser().setNextHandler(new SnackDispenseHandler());
        vendingMachine.getSnackDispenser().getNextHandler().setNextHandler(new SnackDispenseHandler());
        vendingMachine.getSnackDispenser().getNextHandler().getNextHandler().setNextHandler(new SnackDispenseHandler());
        vendingMachine.getSnackDispenser().getNextHandler().getNextHandler().getNextHandler()
                .setNextHandler(new SnackDispenseHandler());
        vendingMachine.getSnackDispenser().getNextHandler().getNextHandler().getNextHandler().getNextHandler()
                .setNextHandler(new SnackDispenseHandler());

        // Test case 1: Dispense a Coke
        System.out.println("Test case 1: Dispensing a Coke");
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        System.out.println();

        // Test case 2: Try to dispense a Snickers (quantity 0)
        System.out.println("Test case 2: Trying to dispense a Snickers (quantity 0)");
        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();
        System.out.println();

        // Test case 3: Dispense a KitKat
        System.out.println("Test case 3: Dispensing a KitKat");
        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(1.25);
        vendingMachine.dispenseSnack();
        System.out.println();
    }
}
