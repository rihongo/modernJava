package StreamApiExamples;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples3 {
    public static void main(String[] args) {
        System.out.println(Stream.of(1,2,3,3,4,5)
                .filter(i -> i >2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(toList()));

        System.out.println(Stream.of(1,2,3,3,4,5)
                .filter(i -> i >2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(toSet()));

        System.out.println(Stream.of(1,2,3,3,4,5)
                .filter(i -> i >2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(joining(",")));

        System.out.println(Stream.of(1,2,3,3,4,5)
                .filter(i -> i >2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(joining(",","[","]")));

        System.out.println(Stream.of(1,2,3,3,4,5)
                .filter(i -> i >2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .distinct()
                .collect(joining(",","[","]")));

        final Integer integer = 3;
        System.out.println(Stream.of(1,2,3,4,5)
                .filter(i -> i == integer)
                .findFirst());

        final Integer integer128 = 128;
        System.out.println(Stream.of(1,2,3,4,5)
                .filter(i -> i == integer128)
                .findFirst());  // X

        // Integer.valueOf() -> Integer Object
        // Integer Cache 를 함
        // .high = (-128 ~ 127)
    }
}
