package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {

}
