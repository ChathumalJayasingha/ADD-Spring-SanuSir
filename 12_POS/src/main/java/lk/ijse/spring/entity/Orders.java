package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    private String oid;
    private String date;
    @ManyToOne
    @JoinColumn(name = "customerID",referencedColumnName = "id")
    private Customer customerID;
    @OneToMany(mappedBy = "oid",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails=new ArrayList<>();
}
