package FunctionalInterfaceExamples.exercise;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalMethod {

    protected static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        // Predicate<? super T>
        //  리스코프 치환 원칙(LSP, Liskov Substitution Principle)
        //  자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위는 수행할 수 있어야 한다.
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


    protected static <T,R> List<R> map(List<T> list, Function<T,R> function){
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    protected static <T> BigDecimal total(List<T> list, Function<T,BigDecimal> mapper){
        BigDecimal total = BigDecimal.ZERO;
        for (final T t: list){
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}
