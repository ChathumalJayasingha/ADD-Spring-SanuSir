package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {
    @EmbeddedId
    private Item_OrderDetails_PK item_orderDetails_pk;
    private String qty;
    private String unitPrice;
    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private Orders oid;
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code",insertable = false,updatable = false)
    private Item itemCode;
}
