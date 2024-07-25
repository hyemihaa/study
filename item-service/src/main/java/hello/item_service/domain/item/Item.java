package hello.item_service.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price; // null 일수도 있으므로 타입은 Integer
    private Integer quantity; // null 일수도 있으므로 타입은 Integer

    public Item() {
    }
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

