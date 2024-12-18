package meryem.emsi.billingservice.Service;

import meryem.emsi.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE") //communiquer avec customer service
public interface CustomerRestClient {
    @GetMapping(path="/api/customers/{id}")
     Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();

    //Customer findCustomerById(Long customerId);
}
