package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Item_OrderDetails_PK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
    private Item_OrderDetails_PK_DTO item_orderDetails_pk;
    private String qty;
    private String unitPrice;
}
