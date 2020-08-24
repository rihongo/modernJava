package HigherOrderFunctionExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class HigherOrderFunctionExamples {
    public static void main(String[] args) {
        final Function<Function<Integer, String>, String> f = g-> g.apply(10);
        // 함수를 인자로 받아서 함수를 리턴 - 고차함수
        f.apply(i-> "#" + i); // (i -> "#" + 1) -> 10 -> ("#" + 10)

        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;

        System.out.println(
                f2.apply(1).apply(9) // 10
        );

        final List<Integer> list = Arrays.asList(1,2,3,4,5);
        map(list, i -> "#" + i);

        final Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 =
                i1 -> i2 -> i3 -> i1 + i2 + i3;

        Function<Integer, Function<Integer, Integer>> applied = f3.apply(1);

        applied.apply(2).apply(3); // 컬링을 통해서 값을 나중에 대입가능
    }

    protected static <T,R> List<R> map(List<T> list, Function<T,R> function){
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
