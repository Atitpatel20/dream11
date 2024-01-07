package com.dream11.dream11;

import java.util.Arrays;
import java.util.List;
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

        List<String> names = Arrays.asList("kevin", "sunny", "stallin", "kevin", "oggy");
        List<String> data1 = names.stream().filter(str -> str.startsWith("o")).collect(Collectors.toList());
        List<String> data2 = names.stream().filter(str -> str.equals("kevin")).collect(Collectors.toList());
        List<String> data3 = names.stream().filter(str -> str.endsWith("n")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
    }
}
