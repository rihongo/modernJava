package MethodReferenceExamples;

import java.lang.invoke.MethodHandle;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1,2,3,4,5)
                .forEach(i -> System.out.println(i)); //System.out::println - Consumer

        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("9.1"))
                .stream()
                .sorted(BigDecimalUtil::compare)
                .collect(toList());

        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("9.1"))
                .stream()
                .sorted(BigDecimal::compareTo)
                .collect(toList());


        final String targetString = "c";

        Arrays.asList("a","b","c","d")
                .stream()
//                .anyMatch(x -> x.equals("c"))
                .anyMatch(targetString::equals);

    }


    private static void methodReference03() {
        /* First Class Function
        *
        * */

        // A function can be pass
        // using lambda expression
        testFirstClassFunction(3, i -> String.valueOf(i * 2));

        // using method reference
        testFirstClassFunction(3, MethodReferenceExamples::doubleThenToString);

        // A function can be returned as the result of another function

        // using lambda expression
        final Function<Integer, String> fl = getDoubleThenToStringUsingLambdaExpression();
        fl.apply(3);

        // using method reference
        final Function<Integer, String> fmr = getDoubleThenToStringUsingMethodReference();
        fmr.apply(3);

        // A function can be stored in the data structure

        // using lambda Expression
        final List<Function<Integer, String>> fsL = Arrays.asList(i -> String.valueOf(i * 2));
        for (final Function<Integer,String> f:
             fsL) {
            final String result = f.apply(3);
            System.out.println(result);
        }

        // using method reference
        final List<Function<Integer, String>> fmL = Arrays.asList(MethodReferenceExamples::doubleThenToString);
        for (final Function<Integer,String> f:
                fmL) {
            final String result = f.apply(3);
            System.out.println(result);
        }

        final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
        final Function<Integer, String> fmr2 = MethodReferenceExamples::doubleThenToString;

        /*
            Both Lambda Expression and Method Reference
         */
        final List<Function<Integer, String>> fsBoth =
                Arrays.asList(i -> String.valueOf(i*2),
                        MethodReferenceExamples::doubleThenToString,
                        MethodReferenceExamples::addHashPrefix);
    }

    private static String addHashPrefix(Integer s) {
        return "#" + s;
    }

    private static Function<Integer, String> getDoubleThenToStringUsingMethodReference() {
        return MethodReferenceExamples::doubleThenToString;
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression(){
        return i -> String.valueOf(i * 2);
    }

    private static String doubleThenToString(int i) {
        return String.valueOf(i * 2);
    }

    private static String testFirstClassFunction(int n, Function<Integer, String> function ) {
        return "The result is " + function.apply(n);
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2);
    }
}