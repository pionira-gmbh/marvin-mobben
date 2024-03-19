package de.pionira.weichwarengemeinschaft;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        String minefield = "4 4\n" +
                           "*...\n" +
                           "....\n" +
                           ".*..\n" +
                           "....";
        String expected = "*100\n" +
                          "2210\n" +
                          "1*10\n" +
                          "1110";

        new App().calculateMineDistances(minefield);

        assertTrue(true);
    }
}
