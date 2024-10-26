package meryem.emsi.billingservice.repository;

import meryem.emsi.billingservice.entities.Bill;
import meryem.emsi.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
