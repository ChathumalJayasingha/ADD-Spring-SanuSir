package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.service.PurchaseOrderService;
import lk.ijse.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/api/v1/order")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveOrders(@RequestBody OrdersDTO dto) {
        if (dto.getOid().trim().length() <= 0) {
            throw new NotFoundException("Orders id cannot be empty");
        }
        service.purchaseOrder(dto);
        return new ResponseEntity(new StandradResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllOrderss() {
        ArrayList<OrdersDTO> allOrderss = service.getAllOrders();
        return new ResponseEntity(new StandradResponse("200", "Done", allOrderss), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchOrders(@PathVariable String id) {
        OrdersDTO OrdersDTO = service.searchOrder(id);
        return new ResponseEntity(new StandradResponse("200", "Done", OrdersDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrders(@RequestParam String id) {
        service.deleteOrder(id);
        return new ResponseEntity(new StandradResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrders(@RequestBody OrdersDTO dto) {
        if (dto.getOid().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateOrder(dto);
        return new ResponseEntity(new StandradResponse("200", "Done", dto), HttpStatus.OK);
    }

}
