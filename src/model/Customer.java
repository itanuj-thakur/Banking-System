package model;

public class Customer {
    private long customerId;
    private String name;
    private String phone;
    private String email;
    private String pin;

    public Customer(long customerId, String name, String phone, String email, String pin) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.pin = pin;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
