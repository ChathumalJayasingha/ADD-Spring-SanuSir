package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private String oid;
    private String date;
    private Customer customerID;
    private List<OrderDetailDTO> orderDetails= new ArrayList<>();
}
