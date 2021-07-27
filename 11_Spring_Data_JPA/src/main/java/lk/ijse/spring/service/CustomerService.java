package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerService {
    boolean addCustomer(CustomerDTO dto);

    boolean deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

    boolean updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomerByName(String  name,String address);

    List<CustomerDTO> searchCustomersByNameAndAddress(String name,String address);
}
