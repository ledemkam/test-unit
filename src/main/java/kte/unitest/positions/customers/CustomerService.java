package kte.unitest.positions.customers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerService {
    CustomerRepository  customerRepository;


    public List<CustomerDTO> search() {
        return customerRepository.findAll()
                                                   .stream().map(customer -> new CustomerDTO(customer.getId(), customer.getEmail()))
                                                   .collect(Collectors.toList());
    }

}
