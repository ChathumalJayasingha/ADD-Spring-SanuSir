package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrdersDTO;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface PurchaseOrderService {
    void purchaseOrder(OrdersDTO dto);

    void deleteOrder(String id);

    OrdersDTO searchOrder(String id);

    ArrayList<OrdersDTO> getAllOrders();

    void updateOrder(OrdersDTO dto);

}
