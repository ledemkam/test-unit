package kte.unitest.positions.customers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerService {
    CustomerRepository  customerRepository;


    public List<CustomerDTO> search() {
        List<CustomerDTO> list =  new ArrayList<>();
           for (Customer customer : this.customerRepository.findAll()) {
               CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getEmail());
               list.add(customerDTO);
           }
        return list;
    }

    public  CustomerDTO read(int id) {
        Customer customer  =  this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found "  + id));
        return new CustomerDTO(customer.getId(), customer.getEmail());
    }

}
