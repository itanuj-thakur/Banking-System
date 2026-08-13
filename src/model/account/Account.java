package model.account;

public class Account {

    private long accountNumber;
    private long customerId;
    private String accountType;
    private double balance;
    private String status;
    private String bankName;

    public Account(long accountNumber, long customerId, String accountType, double balance, String status, String bankName) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.bankName = bankName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
