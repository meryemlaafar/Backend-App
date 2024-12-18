package meryem.emsi.billingservice.web;

import meryem.emsi.billingservice.Service.CustomerRestClient;
import meryem.emsi.billingservice.Service.ProductRestClient;
import meryem.emsi.billingservice.entities.Bill;
import meryem.emsi.billingservice.entities.ProductItem;
import meryem.emsi.billingservice.repository.BillRepository;
import meryem.emsi.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

//    @GetMapping("/fullBill/{id}")
//    public Bill bill(@PathVariable Long id){
//        Bill bill=billRepository.findById(id).get();
//        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
//        // Ajouter les détails des produits
//        bill.getProductItems().forEach(pi -> {
//            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
//        });
//        return bill;
//    }
    //ilyass
@GetMapping(path = "/fullBills/{id}")
public Bill getBill(@PathVariable(name = "id") Long id) {
    Bill bill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));
    bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
    bill.getProductItems().forEach(pi -> {
        pi.setProduct(productRestClient.findProductById(pi.getProductId()));
    });
    return bill;
}

    @GetMapping(path = "/fullBills/{id}/productItems")
    public List<ProductItem> getProductItems(@PathVariable(name = "id") Long billId) {
        try {
            // Log the billId to confirm it's being passed correctly
            System.out.println("Fetching product items for bill ID: " + billId);
            // Get the bill from the database
            Bill bill = billRepository.findById(billId).orElseThrow(() -> new RuntimeException("Bill not found"));
            // Fetch product items associated with the bill
            List<ProductItem> productItems = productItemRepository.findByBillId(billId);
            // Log the fetched product items
            System.out.println("Fetched product items: " + productItems);
            return productItems;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during fetching product items: " + e.getMessage());
        }
    }
}
