package FunctionalInterfaceExamples.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {
//        defaultFunctionalInferface();
        println(1,2,3, (t1,t2,t3) -> String.valueOf(t1 + t2 +t3));
        println("hongwon", 35, "SEOUL", (name , age, city) -> "name: " + name + ", age: " + age + ", city: " + city);
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, CustomFunction<T1,T2,T3,String> function) {
        System.out.println(function.apply(t1,t2,t3));
    }

    private static void defaultFunctionalInferface() {
    /*
        Function
     */
        final Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        final Integer number = function.apply("100");
        System.out.println(number);

        final Function<String, Integer> function1 = value -> Integer.parseInt(value);

        final Integer number1 = function1.apply("200");
        System.out.println(number1);

        Function.identity();

        /*
            Consumer
            - return 값이 없
         */
        final Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        print.accept("hello");

        final Consumer<String> lamdaPrint = v -> System.out.println(v);
        // Function은 리턴 값이 있어야함
//        final Function<String, Void> lamdaFun = v -> System.out.println(v) -> Error
        lamdaPrint.accept("hello lamda");

        /*
            Predicate
         */

        Predicate<Integer> isPositive = v -> v > 0;
        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(1,2,3,4,-1,-2,-3);
        List<Integer> positiveNumbers = new ArrayList<>();

        for (int i : numbers) {
            if(isPositive.test(i)) {
                positiveNumbers.add(i);
            }
        }
        System.out.println("isPositive numbers: " + positiveNumbers);

        System.out.println("isPositive numbers(filter): " + filter(numbers, isPositive));

        /*
            Supplier
           - parameter X
         */
        final Supplier<String> helloSupplier = () -> "hello";

        printIfValidIndex(1, () -> getVeryExpensiveValue());

        /*

         */
        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$ " + bd.toString();
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T value : list ) {
            if(predicate.test(value)) {
                results.add(value);
            }
        }
        return results;
    }


    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "positive";
    }

    private static void printIfValidIndex(int number, Supplier<String> supplier) {
        if(number >= 0) {
            System.out.println("number is " + supplier.get());
        } else {
            System.out.println("Invalid");
        }
    }
}
