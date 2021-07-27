package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @PostMapping
    public String saveCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.addCustomer(dto);
        return b + "";
    }

    @GetMapping
    public ArrayList<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public CustomerDTO searchCustomer(@PathVariable String id) {
        return service.searchCustomer(id);
    }

    @GetMapping(path = "/name/{name}/{address}")
    public CustomerDTO searchCustomerByName(@PathVariable String name, @PathVariable String address) {
        return service.searchCustomerByName(name, address);
    }

    @GetMapping(path = "/seo/{name}/{address}")
    public ArrayList<CustomerDTO> searchCustomersByNameAndAddress(@PathVariable String name, @PathVariable String address) {
        return (ArrayList<CustomerDTO>) service.searchCustomersByNameAndAddress(name, address);
    }


    @DeleteMapping(params = {"id"})
    public String deleteCustomer(@RequestParam String id) {
        boolean b = service.deleteCustomer(id);
        return b + "";
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.updateCustomer(dto);
        return b + "";
    }

}
