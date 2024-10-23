package kte.unitest.positions.customers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.xpath.XPath;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping(path = "/customers")
public class CustomController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> search() {
        return this.customerService.search();
    }
}
