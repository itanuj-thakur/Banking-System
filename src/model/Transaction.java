package model;

import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private long accountNumber;
    private String type;
    private double amount;
    private String description;
    private LocalDateTime dateTime;

    public Transaction(long transactionId, long accountNumber, String type, double amount, String description, LocalDateTime dateTime) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = dateTime;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
