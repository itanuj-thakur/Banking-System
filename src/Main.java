
import Services.AccountService;
import Services.CustomerService;
import model.Customer;
import exception.*;
void main()  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n========================================");
    System.out.println("        BANKING MANAGEMENT SYSTEM");
    System.out.println("========================================");
    System.out.println("             CUSTOMER LOGIN");
    System.out.println("----------------------------------------");

    System.out.print("Customer ID : ");
    long customerId = scanner.nextLong();
    Customer customer= CustomerService.checkCustomerID(customerId);
    if(customer==null){
        System.out.println("Customer ID not found!!");
        return;
    }
    System.out.print("PIN         : ");
    String pin = scanner.next();
    if(!pin.equals(customer.getPin())){
        System.out.println("Wrong PIN!!");
        return;
    }

    System.out.println("----------------------------------------");
    do {
        System.out.println("\n========================================");
        System.out.println("            CUSTOMER MENU");
        System.out.println("========================================");
        System.out.println("1. View Account Details");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Transfer Money");
        System.out.println("6. View Transaction History");
        System.out.println("7. Change PIN");
        System.out.println("0. Logout");
        System.out.println("========================================");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 0 -> {
                return;
            }
            case 1 -> {
                //view account
                try {
                    AccountService.showAccountDetails(customer);
                } catch (AccountNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }

            case 2 -> {
                // Check Balance
                try {
                    AccountService.checkBalance(customer.getCustomerId());
                } catch (AccountNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }

            case 3 -> {
                // Deposit Money
                try {
                    AccountService.depositMoney(customerId);
                } catch (InvalidAmountException e) {
                    System.err.println(e.getMessage());
                }
            }

            case 4 -> {
                // Withdraw Money
                try {
                    AccountService.withdrawMoney(customerId);
                } catch (AccountNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                catch (InvalidAmountException e) {
                    System.err.println(e.getMessage());
                }
                catch (InsufficientBalanceException e) {
                    System.err.println(e.getMessage());
                }
            }

            case 5 -> {
                // Transfer Money
            }

            case 6 -> {
                // View Transaction History
            }

            case 7 -> {
                // Change PIN
            }

            default -> System.out.println("Invalid choice!");
        }

    } while (true);
}
