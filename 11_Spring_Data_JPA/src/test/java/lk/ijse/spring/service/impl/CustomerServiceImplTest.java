package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/


@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    void addCustomer() {
        Customer c1 = new Customer("C001", "Dasun", "Galle", 1400);
        Customer c2 = new Customer("C002", "Ramal", "Panadura", 2100);
        Customer c3 = new Customer("C003", "Kamal", "Kaluthara", 3100);
        Customer c4 = new Customer("C004", "Wimal", "Moratuwa", 1500);
        Customer c5 = new Customer("C005", "Sunimal", "Imaduwa", 6100);
        Customer c6 = new Customer("C006", "Mewan", "Jaffna", 7100);
        Customer c7 = new Customer("C007", "Ravindu", "Trinko", 8100);
        customerRepo.save(c1);
        customerRepo.save(c2);
        customerRepo.save(c3);
        customerRepo.save(c4);
        customerRepo.save(c5);
        customerRepo.save(c6);
        customerRepo.save(c7);
    }


    @Test
    void getAllCustomers() {
        PageRequest pagination = PageRequest.of(0, 5, Sort.by("id").ascending());
        Page<Customer> all = customerRepo.findAll(pagination);
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }

    }

    @Test
    void testRepo() {
//        Optional<Customer> dasun = customerRepo.getByName("Dasun");
//        System.out.println(dasun.get().toString());

//        Optional<Customer> dasun = customerRepo.queryByName("Dasun");
//        System.out.println(dasun.get());

//        Optional<Customer> dasun = customerRepo.searchByName("Dasun");
//        System.out.println(dasun.get());

//        Streamable<Customer> list = customerRepo.streamByName("Dasun");
//        for (Customer customer : list) {
//            System.out.println(customer.toString());
//        }

//        Long dasun = customerRepo.countByName("jjj");
//        System.out.println(dasun);

//        boolean isAvailable = customerRepo.existsByName("Dasun");
//        System.out.println(isAvailable+"");

//        customerRepo.removeCustomerByName("Ravindu");

        //sql
     /*   List<Customer> myCustomer = customerRepo.getMyCustomer();
        for (Customer customer : myCustomer) {
            System.out.println(customer.toString());
        }*/

        //jpql java persistence query language
    /*    List<Customer> myCustomer = customerRepo.getMyCustomer2();
        for (Customer customer : myCustomer) {
            System.out.println(customer.toString());
        }*/

//        //HQL - hibernate query language
//        List<Customer> myCustomer = customerRepo.getMyCustomer3();
//        for (Customer customer : myCustomer) {
//            System.out.println(customer.toString());
//        }


 /*       //positional parameters
        List<Customer> myCustomer4 = customerRepo.getMyCustomer4("C001", "Galle");
        for (Customer customer : myCustomer4) {
            System.out.println(customer);
        }*/

        //named parameters
        List<Customer> myCustomer4 = customerRepo.getMyCustomer5("C001", "Galle");
        for (Customer customer : myCustomer4) {
            System.out.println(customer);
        }
    }
}
