package FunctionalInterfaceExamples.exercise;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(3L, "A", new BigDecimal("12.00"));
        Product productC = new Product(2L, "A", new BigDecimal("13.00"));
        Product productD = new Product(4L, "A", new BigDecimal("24.00"));
        Product productE = new Product(5L, "A", new BigDecimal("25.00"));

        final List<Product> products = Arrays.asList(
                productA, productB, productC, productD, productE
        );

        final BigDecimal twenty = new BigDecimal("20");
        final List<Product> result =
                FunctionalMethod.filter(products, product -> product.getPrice().compareTo(twenty) >0);

        final List<Product> discountResult =
                FunctionalMethod.map(products, product ->
                        new Product(product.getId(),
                                product.getName(),
                                product.getPrice().multiply(new BigDecimal(0.5))));

        System.out.println(discountResult);
        System.out.println(result);
        System.out.println(FunctionalMethod.total(products, product -> product.getPrice()));

        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderedItem(1L, productA, 2),
                new OrderedItem(2L, productB, 1)
        ));

        System.out.println(order.totalPrice());
    }
}
