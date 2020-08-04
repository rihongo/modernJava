package FunctionalInterfaceExamples.basic;

@FunctionalInterface
// 하나의 메소드만 있어야함
// 컴파일 시점에서 에러 - 위의 annotation을 붙여야함
public interface CustomFunction<T1,T2,T3,R> {
    R apply(T1 t1, T2 t2, T3 t3);

//    void print(int i);
}
