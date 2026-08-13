package repository;

import model.account.Account;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class InitialData {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Account> accounts = new ArrayList<>();

    static {
        loadCustomers();
        loadAccounts();
    }

    private static void loadCustomers() {

        customers.add(new Customer(1001, "Tanuj Thakur", "9876543210", "tanuj@gmail.com", "1234"));

        customers.add(new Customer(1002, "Anuj Sharma", "9876543211", "anuj@gmail.com", "2345"));

        customers.add(new Customer(1003, "Rahul Verma", "9876543212", "rahul@gmail.com", "3456"));

        customers.add(new Customer(1004, "Priya Singh", "9876543213", "priya@gmail.com", "4567"));

        customers.add(new Customer(1005, "Akash Kumar", "9876543214", "akash@gmail.com", "5678"));

        customers.add(new Customer(1006, "Sneha Gupta", "9876543215", "sneha@gmail.com", "6789"));

        customers.add(new Customer(1007, "Rohan Mehta", "9876543216", "rohan@gmail.com", "7890"));

        customers.add(new Customer(1008, "Neha Kapoor", "9876543217", "neha@gmail.com", "8901"));

        customers.add(new Customer(1009, "Vikash Yadav", "9876543218", "vikash@gmail.com", "9012"));

        customers.add(new Customer(1010, "Karan Joshi", "9876543219", "karan@gmail.com", "0123"));
    }

    private static void loadAccounts() {

        accounts.add(new Account(500001, 1001, "Savings", 75000, "ACTIVE", "State Bank of India"));

        accounts.add(new Account(500002, 1002, "Savings", 45000, "ACTIVE", "HDFC Bank"));

        accounts.add(new Account(500003, 1003, "Current", 125000, "ACTIVE", "ICICI Bank"));

        accounts.add(new Account(500004, 1004, "Savings", 32000, "ACTIVE", "Axis Bank"));

        accounts.add(new Account(500005, 1005, "Savings", 68000, "ACTIVE", "Punjab National Bank"));

        accounts.add(new Account(500006, 1006, "Current", 95000, "ACTIVE", "Bank of Baroda"));

        accounts.add(new Account(500007, 1007, "Savings", 28500, "ACTIVE", "Canara Bank"));

        accounts.add(new Account(500008, 1008, "Savings", 56000, "BLOCKED", "Union Bank of India"));

        accounts.add(new Account(500009, 1009, "Current", 150000, "ACTIVE", "Bank of India"));

        accounts.add(new Account(500010, 1010, "Savings", 41000, "ACTIVE", "Indian Bank"));
    }
}