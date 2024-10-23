package kte.unitest.positions.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerDAOTest {

   @Autowired
    JdbcTemplate jdbcTemplate;

    CustmerDAO customerDAO ; // ici on importe la classe à tester

    @Test
    void shouldReturnListOfCustomers() {
                         // afin d effectuer un test unitaire ,il existe 3 étapes: Arrange, Act, Assert

        // Arrangeou  ou Given -> il sert à initialiser les objets nécessaires pour le test
        customerDAO =    new CustmerDAO(jdbcTemplate);


        // Act ou  When -> il sert  à appeler la méthode à tester
        List<Customer> customerList =  this.customerDAO.search();



        // Assert ou Then -> vérifier si le résultat est correct
        Assertions.assertEquals(7, customerList.size());

    }
}