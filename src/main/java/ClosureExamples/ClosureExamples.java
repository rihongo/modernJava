package ClosureExamples;

public class ClosureExamples {
    int number = 999;
    public static void main(String[] args) {
        new ClosureExamples().test();
    }

    public void test(){
        int number = 1; // effectively final
//        number = 2; error - race condition 이 발생할수 있기 때문에..

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(number); // this 는 Runnable
                System.out.println(ClosureExamples.this.number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(number));
        testClosure("Lambda Expression", () -> System.out.println(this.number)); // this 는 ClosureExamples
    }

    public static void testClosure(final String name, Runnable runnable) {
        runnable.run();
    }
}
