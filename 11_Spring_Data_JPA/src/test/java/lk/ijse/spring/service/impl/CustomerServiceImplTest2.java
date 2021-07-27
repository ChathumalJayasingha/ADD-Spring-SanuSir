package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Transactional //not committing data to the database
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest2 {

    @Autowired
    CustomerService service;

    @Test
    void addCustomer() {
        //already exited customer
        CustomerDTO customerDTO = new CustomerDTO("C001", "Dasun", "Galle", 1000);
        //we can use Assertion methods to check our methods are processing as we want or not
        //pass if error was thrown from the defined Runtime Exception class by the provided code
        Assertions.assertThrows(RuntimeException.class, () -> {
            service.addCustomer(customerDTO); //code
        });

        //new Customer
        CustomerDTO customerDTO2 = new CustomerDTO("C005", "Dasun", "Galle", 1000);
        //pass if no error thrown from the method call
        Assertions.assertDoesNotThrow(() -> {
            service.addCustomer(customerDTO2);//code
        });
    }

    @Test
    public void addCustomer2() {
//        Check add Customer method with duplicate details
        CustomerDTO c1 = new CustomerDTO("C001", "Dasun", "Galle", 1000);
        assertThrows(RuntimeException.class, () -> {
            service.addCustomer(c1);
        });


//        Put valid data and check whether it is ok or not
        CustomerDTO c2 = new CustomerDTO("C004", "Kamal", "Panadura", 1000);
        assertDoesNotThrow(() -> {
            service.addCustomer(c2);
        });
    }

    @Test
    public void getAllCustomers() {
        CustomerDTO c1 = new CustomerDTO("C001", "Dasun", "Galle", 1000);
        CustomerDTO c2 = new CustomerDTO("C002", "Dasun", "Galle", 1000);
        CustomerDTO c3 = new CustomerDTO("C003", "Dasun", "Galle", 1000);
        service.addCustomer(c1);
        service.addCustomer(c2);
        service.addCustomer(c3);

        ArrayList<CustomerDTO> allCustomers = service.getAllCustomers();
        for (CustomerDTO allCustomer : allCustomers) {
            System.out.println(allCustomer.toString());
        }
        assertNotNull(allCustomers);
    }


}
