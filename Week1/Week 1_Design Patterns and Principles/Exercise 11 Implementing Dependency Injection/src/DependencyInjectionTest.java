// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulate a customer database lookup
        if (id == 1) {
            return "John Doe";
        } else if (id == 2) {
            return "Jane Smith";
        } else {
            return "Customer not found";
        }
    }
}

// Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Main Class to Test Dependency Injection
public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create a concrete repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to get customer details
        System.out.println(customerService.getCustomerName(1)); // Output: John Doe
        System.out.println(customerService.getCustomerName(2)); // Output: Jane Smith
        System.out.println(customerService.getCustomerName(3)); // Output: Customer not found
    }
}
