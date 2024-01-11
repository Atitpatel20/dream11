package com.dream11.dream11;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> val=()-> new Random().nextInt(520);
        Integer i = val.get();
        System.out.println(i);
    }
}
