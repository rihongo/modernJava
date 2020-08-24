package MethodReferenceExamples;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferenceExamples2Constructor {
    public static void main(String[] args) {
        final Section section = new Section(1);

        final Function<Integer, Section> sectionFactory = o -> new Section(o);
        final Section sectionWithFunction = sectionFactory.apply(1);

        final Function<Integer, Section> sectionFactoryWithMethodReference =
                Section::new;
        final Section section1WithMethodReference = sectionFactoryWithMethodReference.apply(1);

        final OldProduct product = new OldProduct(1L, "A", new BigDecimal("100"));
        final OldProductCreator productCreator = OldProduct::new; // abstract

        productCreator.create(1L, "A" , new BigDecimal("100"));

        final ProductA productA = createProduct(1L, "A", new BigDecimal(123), ProductA::new);
    }

    private static  <T extends Product> T createProduct(final Long id,
                                                final String name,
                                                final BigDecimal price,
                                                final ProductCreator<T> productCreator){
        if(id == null || id < 1L) {
            throw new IllegalArgumentException("The id must be a positive Long");
        }
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name is not given.");
        }
        if(price == null || BigDecimal.ZERO.compareTo(price) <= 0) {
            throw new IllegalArgumentException("The price must be greater than 0.");
        }
        return productCreator.create(id,name,price);
    }
}

@FunctionalInterface
interface ProductCreator<T extends Product> {
    T create(Long id, String name, BigDecimal price);
}

@FunctionalInterface
interface OldProductCreator {
    OldProduct create(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class Section {
    private int number;
}

@AllArgsConstructor
@Data
class OldProduct {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
abstract class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

class ProductA extends Product {

    public ProductA(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A" + super.toString();
    }
}

class ProductB extends Product {

    public ProductB(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B" + super.toString();
    }
}

