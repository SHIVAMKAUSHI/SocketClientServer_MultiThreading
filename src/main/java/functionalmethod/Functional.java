package functionalmethod;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.*;

public class Functional {
    public static void main(String[] args) {
//        Predicate<Integer> predicate =e->e>=10;
        Predicate<Integer> predicate= new Predicate(){
            @Override
            public boolean test(Object o) {
                return false;
            }


        };
        boolean test = predicate.test(5);
        System.out.println(test);
        BiPredicate<Integer,Integer> biPredicate=(x,y)->x>y;
        System.out.println(biPredicate.test(10,11));
        Function<Integer,Integer> function = e->e*e;
        System.out.println(function.apply(10));
        BiFunction <Integer,String,Boolean> biFunction = (x,s)->x>=s.length();
        System.out.println(biFunction.apply(10,"shivam"));
        Consumer<Integer> consumer =System.out::println;
        consumer.accept(10);
        BiConsumer<Integer,String> biConsumer=(x,s)-> System.out.println(s+" Marks in exam is: "+x);
        biConsumer.accept(100,"Shivam");
        Supplier<LocalDateTime> supplier = ()-> LocalDateTime.now();
        Supplier<LocalDateTime> supplier2 = ()-> LocalDateTime.now();
        System.out.println(supplier.get().compareTo(supplier2.get()));
    }
}
