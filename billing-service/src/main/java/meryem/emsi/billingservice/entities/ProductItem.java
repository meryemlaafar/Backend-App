package meryem.emsi.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import meryem.emsi.billingservice.model.Product;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)//productitem cest pas la peine de renvoyer
    private Bill bill;
    private int quantity;
    private double price;
    private double discount;
    @Transient
    private Product product;
}
