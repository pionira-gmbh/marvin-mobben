package de.pionira.weichwarengemeinschaft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void minefield() {
        String minefield = """
                *...
                ....
                .*..
                ....""";

        String expected = """
                *100
                2210
                1*10
                1110""";

        String result = new App().calculateMineDistances(4, 4, minefield);

        assertEquals(expected, result);
    }
}
