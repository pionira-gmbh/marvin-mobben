package de.pionira.weichwarengemeinschaft;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String calculateMineDistances(int height, int width, String minefield) {
        String[] lines = minefield.split("\n");

        for (int i = 0; i < lines.length; i++) {
            for(int j = 0; j < lines[i].length(); j++) {
                if (lines[i].charAt(j) == '*') {
                    continue;
                }
                checkNeighbours(i, j, height - 1, width - 1, lines);
            }
        }

        return String.join("\n", lines);
    }

    private void checkNeighbours(int h, int w, int maxHeight, int maxWidth, String[] lines) {
        int countBomb = 0;

        if(h > 0 && w > 0 && isBomb(lines[h-1].charAt(w-1))) {
            countBomb++;
        }
        if (h > 0 && isBomb(lines[h-1].charAt(w))) {
            countBomb++;
        }
        if (h > 0 && w < maxWidth && isBomb(lines[h-1].charAt(w+1))) {
            countBomb++;
        }
        if (w > 0 && isBomb(lines[h].charAt(w-1))) {
            countBomb++;
        }
        if (w < maxWidth && isBomb(lines[h].charAt(w+1))) {
            countBomb++;
        }
        if (h < maxHeight && w < maxWidth && isBomb(lines[h+1].charAt(w+1))) {
            countBomb++;
        }
        if (h < maxHeight && isBomb(lines[h+1].charAt(w))) {
            countBomb++;
        }
        if (h < maxHeight && w > 0 && isBomb(lines[h+1].charAt(w-1))) {
            countBomb++;
        }

        char[] line = lines[h].toCharArray();
        line[w] = Character.forDigit(countBomb, 10);
        lines[h] = String.valueOf(line);
    }

    private boolean isBomb(char ch) {
        return ch == '*';
    }
}
