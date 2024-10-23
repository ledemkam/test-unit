package kte.unitest.positions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // ici on configure le test pour les repositories
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2) // ici on configure la base de données pour les tests
class CustomerRepositoryTest {

        // ici on injecte le repository à tester
        @Autowired
        private CustomerRepository customerRepository;

        // ici on teste la méthode search
        @Test
        void shouldReturnAllCustomers() {
                // Arrange
            Customer customerOne = Customer.builder().id(1).email("ledem@gmail.com").build();
            Customer customertTwo = Customer.builder().id(2).email("amrie@gmail.com").build();
            this.customerRepository.saveAll(List.of(customerOne, customertTwo));

              // Act
            final  List<Customer> customerList = this.customerRepository.findAll();

             // Assert
            assertEquals(2, customerList.size());

        }

    @Test
    void shouldReturnCustomersByEmail() {
        // Arrange
        Customer customerOne = Customer.builder().id(1).email("ledem@gmail.com").build();
        Customer customerTwo = Customer.builder().id(2).email("amrie@gmail.com").build();
        this.customerRepository.saveAll(List.of(customerOne, customerTwo));

        // Act
        final Customer customer = this.customerRepository.findByEmail("amrie@gmail.com");

        // Assert
        Assertions.assertEquals(customerTwo.getId(), customer.getId());
        Assertions.assertEquals(customerTwo.getEmail(), customer.getEmail());
    }
}