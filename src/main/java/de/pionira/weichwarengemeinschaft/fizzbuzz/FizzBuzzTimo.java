package de.pionira.weichwarengemeinschaft.fizzbuzz;

public class FizzBuzzTimo implements FizzBuzz {
    @Override
    public String fizzbuzz(int limit) {
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (i % 3 == 0) {
                ret.append("Fizz");
            }
            if (i % 5 == 0) {
                ret.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                ret.append(i);
            }

            if (i < limit) {
                ret.append(",");
            }
        }

        return ret.toString();
    }
}
