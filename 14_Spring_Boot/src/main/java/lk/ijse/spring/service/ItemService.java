package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface ItemService {
    void addItem(ItemDTO dto);

    void deleteItem(String id);

    ItemDTO searchItem(String id);

    ArrayList<ItemDTO> getAllItems();

    void updateItem(ItemDTO dto);

}
