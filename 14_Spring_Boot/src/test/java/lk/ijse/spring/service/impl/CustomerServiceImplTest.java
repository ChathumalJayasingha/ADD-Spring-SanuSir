package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Transactional
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void getAllCustomers() {
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        for (CustomerDTO allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
    }
}
