package de.pionira.weichwarengemeinschaft.fizzbuzz;

public class FizzBuzzBenni implements FizzBuzz {

    public String fizzbuzz(int limit) {
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ret.append("FizzBuzz");
            } else if (i % 3 == 0) {
                ret.append("Fizz");
            } else if (i % 5 == 0) {
                ret.append("Buzz");
            } else {
                ret.append(i);
            }

            if (i < limit) {
                ret.append(",");
            }
        }

        return ret.toString();
    }
}
