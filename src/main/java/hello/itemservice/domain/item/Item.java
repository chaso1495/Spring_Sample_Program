package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // @Getter @Setter만 필요하면 이거 두개만 쓰는게 바람직하다
public class Item {

    private Long id; // 상품 ID
    private String itemName; // 상품명
    private Integer price; // 가격
    private Integer quantity; // 수량 (nullable을 위한 Integer)

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}