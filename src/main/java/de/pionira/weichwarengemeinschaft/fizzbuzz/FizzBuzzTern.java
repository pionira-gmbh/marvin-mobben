package de.pionira.weichwarengemeinschaft.fizzbuzz;

public class FizzBuzzTern implements FizzBuzz {

    @Override
    public String fizzbuzz(int limit) {
        if(limit <= 0) return "";

        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < limit; i++) {
            ret.append(fizzLeBuzz(i)).append(",");

        }


        return ret.append(fizzLeBuzz(limit)).toString();
    }

    private String fizzLeBuzz(int i) {
        return i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz" )
                        : i % 5 == 0 ? "Buzz" : String.valueOf(i);
    }
}
