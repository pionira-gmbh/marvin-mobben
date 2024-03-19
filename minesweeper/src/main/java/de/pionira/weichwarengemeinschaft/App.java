package de.pionira.weichwarengemeinschaft;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String calculateMineDistances(int height, int width, String minefield) {
        int[][] ints = new int[height][width];

        char[] chars = minefield.toCharArray();

        int h = 0;
        int w = 0;
        for (char ch : chars) {
           if (ch == '\n') {
             h++;
           }
        }

        return "";
    }
}
