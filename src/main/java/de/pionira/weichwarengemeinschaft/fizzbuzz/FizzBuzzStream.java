package de.pionira.weichwarengemeinschaft.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzStream implements FizzBuzz {
    @Override
    public String fizzbuzz(int limit) {
        return IntStream.rangeClosed(1,limit).mapToObj(
                i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz" )
                        : i % 5 == 0 ? "Buzz" : String.valueOf(i)).collect(Collectors.joining(","));
    }
}
