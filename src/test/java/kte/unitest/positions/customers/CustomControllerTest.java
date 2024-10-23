package kte.unitest.positions.customers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(CustomController.class)
class CustomControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    CustomerService customerService;

    @Test
    void shouldReturnListOfCustomers() throws Exception {
        // Arrange
        CustomerDTO customerOne = new CustomerDTO(1, "ledem@gmail.com");
        CustomerDTO customerTwo = new CustomerDTO(2, "amrie@gmail.com");
        when(this.customerService.search()).thenReturn(List.of(customerOne, customerTwo));

        // Act & Assert
        this.mvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("ledem")));
    }

    @Test
    void shouldReturnOneCustomers() throws Exception {
        // Arrange
        CustomerDTO customerOne = new CustomerDTO(1, "ledem@gmail.com");
        when(this.customerService.read(anyInt())).thenReturn(customerOne);

        // Act & Assert
        this.mvc
                .perform(get("/customers/1"))
                .andExpect(jsonPath("$.email").value(customerOne.email()))
               .andExpect(status().isOk())
                .andDo(print());
    }
}