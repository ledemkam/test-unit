package kte.unitest.positions.customers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerService {
     CustmerDAO custmerDAO;


    public List<Customer> search() {
        return this.custmerDAO.search();
    }

}
