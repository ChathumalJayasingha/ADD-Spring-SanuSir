package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Already Exist");
        }
        customerRepo.save(mapper.map(dto, Customer.class));
        return true;
    }

    @Override
    public boolean deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())) {
            customerRepo.save(mapper.map(dto, Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public CustomerDTO searchCustomerByName(String name, String address) {
        Optional<Customer> customer = customerRepo.findTopByNameAndAddress(name, address);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;

    }

    @Override
    public List<CustomerDTO> searchCustomersByNameAndAddress(String name, String address) {
        List<Customer> customers = customerRepo.readByNameAndAddress(name, address, PageRequest.of(0,1));
        return mapper.map(customers, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
