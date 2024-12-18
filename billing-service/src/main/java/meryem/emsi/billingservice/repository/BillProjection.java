package meryem.emsi.billingservice.repository;

import meryem.emsi.billingservice.entities.Bill;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="fullBill", types= Bill.class)
public interface BillProjection {
    Long getId();
    Date getBillDate();
    Long getCustomerId();
}
