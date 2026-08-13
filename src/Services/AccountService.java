package Services;

import model.Customer;
import model.Transaction;
import model.account.Account;
import repository.InitialData;
import exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import utility.inputHelper;

public class AccountService {

    public static void showAccountDetails(Customer customer) {
        Optional<Account> accountOptional = findAccountDetails(customer);
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

    public static Optional<Account> findAccountDetails(Customer customer) {

        return InitialData.accounts.stream()
                .filter(account ->
                        account.getCustomerId() == customer.getCustomerId())
                .findFirst();
    }

    public static void checkBalance(Customer customer) {
        Optional<Account> accountOptional = findAccountDetails(customer);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        System.out.println("Available Balance : ₹" + account.getBalance());
    }

    public static void depositMoney(Customer customer) {
        Optional<Account> accountOptional = findAccountDetails(customer);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        System.out.print("Enter the Amount to be deposited : ");
        double amt = inputHelper.readDouble();
        if (amt <= 0) throw new InvalidAmountException("Amount Must be greater than 0.");
        account.setBalance(account.getBalance() + amt);
        System.out.println("₹" + amt + " added to your Bank Account\n****  New Balance : ₹" + account.getBalance() + "  ****");
        TransactionService.transaction.add(TransactionService.addTransaction(customer,account,"DEPOSIT",amt));
    }

    public static void withdrawMoney(Customer customer) {
        Optional<Account> accountOptional = findAccountDetails(customer);
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
        TransactionService.transaction.add(TransactionService.addTransaction(customer,account,"WITHDRAW",amt));
    }

    public static void transferMoney(Customer customer) {
        Optional<Account> accountOptional = findAccountDetails(customer);
        Account senderAcc = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not Found with this Customer ID"));
        if (!senderAcc.getStatus().equals("ACTIVE")) {
            throw new InvalidTransferException("The sender's account is INACTIVE.");
        }
        System.out.print("Enter the Receiver's Account Number : ");
        long receiverAccNum = inputHelper.readLong();
        if (senderAcc.getAccountNumber() == receiverAccNum) {
            throw new InvalidTransferException("You cannot transfer money to your own account.");
        }
        Account receiverAcc = findAccountViaAccountNum(receiverAccNum);
        if (!receiverAcc.getStatus().equals("ACTIVE")) {
            throw new InvalidTransferException("The receiver's account is INACTIVE.");
        }
        System.out.print("Enter the amount to be transferred : ");
        double amt = inputHelper.readDouble();
        if (amt <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0.");
        }

        if (amt > senderAcc.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        senderAcc.setBalance(senderAcc.getBalance() - amt);
        receiverAcc.setBalance(receiverAcc.getBalance() + amt);
        System.out.println("*****Transaction Successful****");
        System.out.println("Sender's New Balance : **₹"+senderAcc.getBalance()+"**");
        System.out.println("Receiver's New Balance : **₹"+receiverAcc.getBalance()+"**");
        TransactionService.transaction.add(TransactionService.addTransaction(customer,senderAcc,"TRANSFER_OUT",amt));
        TransactionService.transaction.add(TransactionService.addTransaction(customer,receiverAcc,"TRANSFER_IN",amt));
    }

    public static Account findAccountViaAccountNum(long accNum) {
        return InitialData.accounts.stream()
                .filter(acc -> acc.getAccountNumber() == accNum)
                .findFirst()
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account Not Found with this Account Number."
                        ));
    }
    public static void changePIN(Customer customer){
        System.out.print("Enter Current PIN : ");
        String PIN = inputHelper.readString();
        if(!PIN.equals(customer.getPin())){
            throw new InvalidPinException("Invalid PIN.");
        }

        System.out.println("Enter new PIN  : ");
        String newPin = inputHelper.readString();

        if (newPin.length() != 4) {
            throw new InvalidPinException("PIN must contain exactly 4 digits.");
        }

        if (!newPin.matches("\\d{4}")) {
            throw new InvalidPinException("PIN must contain only digits.");
        }

        if (newPin.equals(PIN)) {
            throw new InvalidPinException(
                    "New PIN cannot be the same as the old PIN."
            );
        }
        customer.setPin(newPin);
        System.out.println("***PIN changed successfully***");
    }

}
