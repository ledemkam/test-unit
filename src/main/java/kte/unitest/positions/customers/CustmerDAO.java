package kte.unitest.positions.customers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustmerDAO {
    private final JdbcTemplate jdbcTemplate;
    private final static String FIND_ALL = "SELECT * FROM customers";
    private RowMapper<CustomerDTO> customerRowMapper =
            (rs, name) -> new CustomerDTO(rs.getInt("id"), rs.getString("email"));

    public CustmerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CustomerDTO> search() {
        return this.jdbcTemplate.query(FIND_ALL, customerRowMapper);
    }
}
