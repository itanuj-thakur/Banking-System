# 🏦 Banking Management System

A console-based Banking Management System developed in Java to simulate basic banking operations such as account management, deposits, withdrawals, money transfers, and transaction history.

## 🚀 Features

- Customer Login using Customer ID and PIN
- View Account Details
- Check Account Balance
- Deposit Money
- Withdraw Money
- Transfer Money between accounts
- View Transaction History
- Change PIN
- Custom Exception Handling
- Input Validation
- Transaction Date & Time Tracking

## 🛠️ Technologies Used

- Java
- Java Collections
- Streams API
- Optional
- Exception Handling
- Java Time API
- Object-Oriented Programming

## 📂 Project Structure

```text
src/
├── exception/
│   ├── AccountNotFoundException.java
│   ├── InsufficientBalanceException.java
│   ├── InvalidAmountException.java
│   ├── InvalidPinException.java
│   └── InvalidTransferException.java
│
├── model/
│   ├── Customer.java
│   ├── Transaction.java
│   └── account/
│       └── Account.java
│
├── repository/
│   └── InitialData.java
│
├── Services/
│   ├── AccountService.java
│   ├── CustomerService.java
│   └── TransactionService.java
│
├── utility/
│   └── InputHelper.java
│
└── Main.java

```
# 🏦 Application Flow
```text
                    BANKING MANAGEMENT SYSTEM
                              │
                              ▼
                       CUSTOMER LOGIN
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Customer ID            PIN
                    │                   │
                    └─────────┬─────────┘
                              ▼
                       CUSTOMER MENU
                              │
          ┌───────────────────┼───────────────────┐
          │                   │                   │
          ▼                   ▼                   ▼
     Account Details      Check Balance       Transactions
          │                                       │
          ▼                                       ▼
       Deposit                                  History
       Withdraw
       Transfer
          │
          ▼
       Update Balance
          │
          ▼
   Create Transaction
```
