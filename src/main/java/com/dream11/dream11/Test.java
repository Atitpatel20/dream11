package com.dream11.dream11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Predicate<Integer>val=y->y%2==0;
//        boolean result = val.test(31);
//        System.out.println(result);

//        Predicate<String>val=str->str.equals("Atit");
//        boolean res = val.test("jay");
//        System.out.println(res);

//        List<Integer> numbers = Arrays.asList(1, 6, 91, 20, 34, 61, 27);
//        List<Integer> evenNumbers = numbers.stream().filter(z -> z % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNumbers);

//        List<Integer> numbers = Arrays.asList(15, 35, 61, 24, 25, 94, 12);
//        List<Integer> oddNumbers = numbers.stream().filter(s -> s % 2 != 0).collect(Collectors.toList());
//        System.out.println(oddNumbers);

//        List<String> names = Arrays.asList("kevin", "sunny", "stallin", "kevin", "oggy");
//        List<String> data1 = names.stream().filter(str -> str.startsWith("o")).collect(Collectors.toList());
//        List<String> data2 = names.stream().filter(str -> str.equals("kevin")).collect(Collectors.toList());
//        List<String> data3 = names.stream().filter(str -> str.endsWith("n")).collect(Collectors.toList());
//        System.out.println(data1);
//        System.out.println(data2);
//        System.out.println(data3);

        // find the length of given string
//        Function<String,Integer>val= str->str.length();
//        Integer result = val.apply("pankaj sir acadamy");
//        System.out.println(result);

        // add 25 to any number and give o/p by stream api
//      Function<Integer,Integer>val=  i->i+25;
//        Integer number =val.apply(36);
//        System.out.println(number);

        //  add the 45 to all numbers
//        List<Integer> numbers = Arrays.asList(15, 36, 24, 87, 63, 85);
//        List<Integer> result = numbers.stream().map(i -> i + 45).collect(Collectors.toList());
//        System.out.println(result);

        // i want all the names in upper case & lower case
//        List<String> names = Arrays.asList("mike", "ajay", "stallin", "neel", "kevin");
//        List<String> result = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
//        List<String> result2 = names.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
//        System.out.println(result2);
//        System.out.println(result);

//        // sort all the names in ascending order
//        List<String> names = Arrays.asList("mike", "ajay", "stallin", "neel", "kevin");
//        List<String> result = names.stream().sorted().collect(Collectors.toList());
//        System.out.println(result);

        //  sort all the numbers in ascending order
//        List<Integer> numbers = Arrays.asList(25, 14, 36, 85, 74, 26);
//        List<Integer> result = numbers.stream().sorted().collect(Collectors.toList());
//        System.out.println(result);

        // remove duplicate number & sort the record in ascending order
        List<Integer> numbers = Arrays.asList(15, 25, 25, 40, 60, 70, 80, 40, 70);
        List<Integer> result = numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(result);
    }
}
