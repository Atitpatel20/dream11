package com.dream11.dream11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "faceWash", "beauty", 55.0),
                new Product(2, "mobile", "electronic", 10520.0),
                new Product(3, "purse", "fashion", 785.0),
                new Product(4, "laptop", "electronic", 35124.0),
                new Product(5, "tshirt", "fashion", 350.0),
                new Product(6, "bodylosan", "beauty", 250)
        );
        Map<String, List<Product>> collect = products.stream().collect(Collectors.groupingBy(str -> str.getType()));

        for ( Map.Entry<String,List<Product>> entry:collect.entrySet() ) {
            String type = entry.getKey();
            List<Product> value = entry.getValue();
            System.out.println("product_type: "+type+"---");
            for ( Product t:value ) {
                System.out.println(t.getId());
                System.out.println(t.getProductName());
                System.out.println(t.getPrice());

            }


        }

    }
}
