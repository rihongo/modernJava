package FunctionalInterfaceExamples.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
public class Order {
    private Long id;
    private String orderNumber;
    List<OrderedItem> items;

    public BigDecimal totalPrice() {
        return FunctionalMethod.total(items, orderedItem -> orderedItem.getProductPrice());
    }
}
