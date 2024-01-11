package com.dream11.dream11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
//       Consumer<String> data= names-> System.out.println(names);
//       data.accept("hussy");
//
//        List<String> lists = Arrays.asList("mike", "stallin", "adam");
//       Consumer<String>val= list-> System.out.println(list);
//       lists.forEach(val);

//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//
//// Using Consumer in forEach
//        names.stream().forEach(name -> System.out.println("Hello, " + name));

        List<Double> prices = Arrays.asList(10.5, 20.0, 15.75);

// Combining Consumers using andThen
        Consumer<Double> printPrice = price -> System.out.println("Price: $" + price);
        Consumer<Double> discount = price -> System.out.println("Discounted Price: $" + (price * 0.9));

        prices.forEach(printPrice.andThen(discount));

    }
}
