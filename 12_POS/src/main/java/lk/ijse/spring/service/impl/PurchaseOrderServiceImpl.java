package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrdersRepo OrdersRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrdersDTO dto) {
        if (OrdersRepo.existsById(dto.getOid())) {
            throw new ValidateException("Orders Already Exist");
        }
        Orders order = mapper.map(dto, Orders.class);
        OrdersRepo.save(order);

    }

    @Override
    public void deleteOrder(String id) {
        if (!OrdersRepo.existsById(id)) {
            throw new ValidateException("No Orders for Delete..!");
        }
        OrdersRepo.deleteById(id);
    }

    @Override
    public OrdersDTO searchOrder(String id) {
        Optional<Orders> Orders = OrdersRepo.findById(id);
        if (Orders.isPresent()) {
            return mapper.map(Orders.get(), OrdersDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() {
        List<Orders> all = OrdersRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<OrdersDTO>>() {
        }.getType());
    }

    @Override
    public void updateOrder(OrdersDTO dto) {

        if (OrdersRepo.existsById(dto.getOid())) {
            OrdersRepo.save(mapper.map(dto, Orders.class));
        }
    }

}
