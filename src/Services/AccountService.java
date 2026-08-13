package Services;

import model.Customer;
import model.account.Account;
import repository.InitialData;
import exception.*;

import java.util.List;
import java.util.Optional;

import utility.inputHelper;

public class AccountService {
    public static void showAccountDetails(Customer customer) {
        Optional<Account> accountOptional = Optional.ofNullable(findAccountDetails(customer.getCustomerId()));
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        System.out.println("\n========================================");
        System.out.println("           ACCOUNT DETAILS");
        System.out.println("========================================");

        System.out.println("Customer ID    : " + customer.getCustomerId());
        System.out.println("Customer Name  : " + customer.getName());
        System.out.println("Phone Number   : " + customer.getPhone());
        System.out.println("Email          : " + customer.getEmail());

        System.out.println("----------------------------------------");

        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Bank Name      : " + account.getBankName());
        System.out.println("Account Type   : " + account.getAccountType());
        System.out.println("Balance        : ₹" + account.getBalance());
        System.out.println("Status         : " + account.getStatus());

        System.out.println("========================================");
    }

    public static Account findAccountDetails(long customerID) {
        List<Account> accountList = InitialData.accounts;
        return accountList.stream().filter(account -> account.getCustomerId() == customerID).findFirst().orElse(null);
    }

    public static void checkBalance(long customerID) {
        Optional<Account> accountOptional = Optional.ofNullable(findAccountDetails(customerID));
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        System.out.println("Available Balance : ₹" + account.getBalance());
    }

    public static void depositMoney(long customerID) {
        Optional<Account> accountOptional = Optional.ofNullable(findAccountDetails(customerID));
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        System.out.print("Enter the Amount to be deposited : ");
        double amt = inputHelper.readDouble();
        if (amt < 0) throw new InvalidAmountException("Amount Must be greater than 0.");
        account.setBalance(account.getBalance() + amt);
        System.out.println("₹" + amt + " added to your Bank Account\n****  New Balance : ₹" + account.getBalance() + "  ****");
    }

    public static void withdrawMoney(long customerID) {
        Optional<Account> accountOptional = Optional.ofNullable(findAccountDetails(customerID));
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        System.out.print("Enter the Amount to be Withdrawn : ");
        double amt = inputHelper.readDouble();
        if (amt <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0.");
        }

        if (amt > account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        account.setBalance(account.getBalance() - amt);
        System.out.println("₹" + amt + " have been withdrawn from your Bank Account\n****  New Balance : ₹" + account.getBalance() + "  ****");
    }
}
