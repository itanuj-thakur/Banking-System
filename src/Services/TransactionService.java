package Services;

import exception.AccountNotFoundException;
import model.Customer;
import model.Transaction;
import model.account.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionService {
    static long transactionID = 1000001;
    public static List<Transaction> transaction = new ArrayList<>();

    public static Transaction addTransaction(
            Customer customer,
            Account customerAccount,
            String type,
            double amount) {

        String description = switch (type) {
            case "DEPOSIT" -> "Cash deposited";
            case "WITHDRAW" -> "Cash withdrawn";
            case "TRANSFER_IN" -> "Cash received";
            case "TRANSFER_OUT" -> "Cash transferred";
            default -> "Unknown transaction";
        };

        return new Transaction(
                transactionID++,
                customerAccount.getAccountNumber(),
                type,
                amount,
                description,
                LocalDateTime.now()
        );
    }

    public static void showTransactions(Customer customer) {
        Optional<Account> accountOptional = AccountService.findAccountDetails(customer);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Not found"));
        transaction.stream().filter(transaction -> transaction.getAccountNumber() == account.getAccountNumber()).forEach(transaction -> {
            System.out.println("Transaction ID : " + transaction.getTransactionId());
            System.out.println("Type           : " + transaction.getType());
            System.out.println("Amount         : ₹" + transaction.getAmount());
            System.out.println("Description    : " + transaction.getDescription());
            System.out.println(
                    "Date & Time    : " +
                            transaction.getDateTime()
                                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
            );
            System.out.println("----------------------------------------");


        });
    }

}
