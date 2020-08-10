package StreamApiExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples2 {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5).forEach(i -> System.out.println(i));

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(numbers.stream()
                .filter(number -> number > 3)
                .filter(number -> number < 9)
                .map(number -> number * 2)
                .filter(number -> number > 10)
                .findFirst()
        );
    }
}
/*
    intermediate Operation Method
    - 중간 단계
    - 계속 Stream을 리턴하기 때문에 method chaning

    Terminal Operation Method
    - 끝 단계

 */