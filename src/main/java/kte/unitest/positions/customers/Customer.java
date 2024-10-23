package kte.unitest.positions.customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "customers")
public class Customer {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
         private int id;
         private String email;
}
