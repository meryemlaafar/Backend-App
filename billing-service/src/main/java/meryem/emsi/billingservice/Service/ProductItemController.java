package meryem.emsi.billingservice.controller;


import meryem.emsi.billingservice.entities.ProductItem;
import meryem.emsi.billingservice.model.Product;
import meryem.emsi.billingservice.Service.ProductRestClient;
import meryem.emsi.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@FeignClient(name = "INVENTORY-SERVICE")
public class ProductItemController {

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductRestClient productRestClient;  // Injection du ProductRestClient

    // Récupérer les productItems avec les informations des produits associés
    @GetMapping("/api/productItems")
    public ResponseEntity<List<ProductItem>> getProductItems() {
        List<ProductItem> productItems = productItemRepository.findAll();
        for (ProductItem item : productItems) {
            // Utilisation de Feign Client pour récupérer le produit par son ID
            if (item.getProductId() != null) {
                Product product = productRestClient.findProductById(item.getProductId());
                item.setProduct(product); // Associer le produit à l'élément de commande
            }
        }
        return ResponseEntity.ok(productItems);
    }
}
