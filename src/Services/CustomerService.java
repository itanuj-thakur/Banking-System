package Services;
import model.Customer;
import repository.InitialData;

import java.util.List;

public class CustomerService {
    public static Customer checkCustomerID(long id){
        List<Customer> customerList = InitialData.customers;
        return customerList.stream().filter(customer -> customer.getCustomerId()==id).findFirst().orElse(null);
    }
}
