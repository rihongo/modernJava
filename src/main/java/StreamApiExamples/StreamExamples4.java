package StreamApiExamples;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples4 {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5)
                .collect(toList());

        Stream.of(1,2,3,4,5)
                .collect(toSet());

        Product productA = new Product(1L, "A", new BigDecimal("100.00"));
        Product productB = new Product(3L, "A", new BigDecimal("24.00"));
        Product productC = new Product(2L, "A", new BigDecimal("13.45"));
        Product productD = new Product(4L, "A", new BigDecimal("24.20"));
        Product productE = new Product(5L, "A", new BigDecimal("25.60"));

        final List<Product> products = Arrays.asList(
                productA, productB, productC, productD, productE
        );

        System.out.println("Total Price: " +
        products.stream()
                .map(product -> product.getPrice())
//                .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                //      initial value, initial value.add(0).add(1),add(2)....
        );

        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderedItem(1L, productA, 2),
                new OrderedItem(2L, productB, 1)
        ));

        System.out.println(order.totalPrice());
    }
}
