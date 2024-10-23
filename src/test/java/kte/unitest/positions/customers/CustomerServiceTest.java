package kte.unitest.positions.customers;

import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
     @Mock
     CustomerRepository customerRepository;

     @InjectMocks
     CustomerService customerService;

    @Test
    void shoulldReturnAllCustomers() {
        // Arrange
        Customer customerOne = Customer.builder().id(1).email("ledem@gmail.com").build();
        Customer customertTwo = Customer.builder().id(2).email("amrie@gmail.com").build();
        when(this.customerRepository.findAll()).thenReturn(List.of(customerOne, customertTwo));
        this.customerRepository.saveAll(List.of(customerOne, customertTwo));

        // Act
        final  List<CustomerDTO> customerList = this.customerService.search();

        // Assert
        assertEquals(2, customerList.size());

    }

    @Test
    void shoulldReturnCustomersById() {
        // Arrange
        Customer customerOne = Customer.builder().id(1).email("ledem@gmail.com").build();
        when(this.customerRepository.findById(1)).thenReturn(Optional.of(customerOne));

        // Act
        final  CustomerDTO customerDTO  = this.customerService.read(1);

        // Assert
        assertEquals(customerOne.getId(), customerDTO.id());

    }

    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {
        // Arrange
        when(this.customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act
        final  IllegalArgumentException exception =  assertThrows(
                IllegalArgumentException.class,
                () -> this.customerService.read(1));
        // Assert
        assertEquals("Customer not found 1", exception.getMessage());
    }
}