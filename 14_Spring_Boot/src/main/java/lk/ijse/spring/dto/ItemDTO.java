package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private String code;
    private String description;
    private int qtyOnHand;
    private double unitPrice;

}
