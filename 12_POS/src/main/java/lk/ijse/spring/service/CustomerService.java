package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

    void updateCustomer(CustomerDTO dto);

}
