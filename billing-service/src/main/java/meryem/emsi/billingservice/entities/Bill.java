package meryem.emsi.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import meryem.emsi.billingservice.model.Customer;

import java.util.Date;
import java.util.List;
@Entity @Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient //dire a jpa cette attribut dans la classe et non pas dans la BD ignore le
    private Customer customer;
}
