/*
 *
 * This is a tester we provide for you. You should definitely run it!
 * Not all of the tests are implemented. You are strongly encouraged to fill
 * out the remaining tests and make sure your code works correctly.
 * You can also add other methods to have other tests, if you think of any.
 *
 * Do not submit this file when you hand in your homework.
 * 
 */

import java.awt.Color;

public class ColumnPuzzleStudentTester {

    public static void main(String[] args) {
        testAcceptsDifferentNumberOfRows();
        testSetup();
        testSwap();
        testShuffle();
        testSetTitle();
        testIsSolved();
        testAdjacentBlackSquare();
    }

    private static void testAcceptsDifferentNumberOfRows() {
        int tests = 0;
        int failed = 0;

        printHeader("Testing Accepts Different Number of Rows");

        for (int i = 1; i < 5; i++) {
            try {
                ColumnPuzzle temp = new ColumnPuzzle(i);
                temp = null;
            } catch (Exception e) {
                sop("ERROR! Tried to initialize ColumnPuzzle with " + i + 
                    " rows.");
                e.printStackTrace();
                failed++;
            } finally {
                tests++;
            }
        }

        printStats(tests, failed);
    }

    private static void testSetup() {
        int tests = 0;
        int failed = 0;

        printHeader("Testing Setup");

        // Make sure setup actually works and uses the correct number of rows.
        for (int i = 1; i < 5; i++) {
            try {
                ColumnPuzzle temp = new ColumnPuzzle(i);

                if (temp.grid.length != i) {
                    sop("FAILED! Setup did not create the correct dimensions" +
                        " for the grid.");
                    failed++;
                }

                temp = null;
            } catch (Exception e) {
                sop("ERROR! Tried to run setup with " + i +  " rows.");
                e.printStackTrace();
                failed++;
            } finally {
                tests++;
            }
        }

        // Make sure colors are in the right order to start.
        try {
            Color[] colorsList = { Color.RED, Color.YELLOW, Color.GREEN,
                    Color.BLUE, Color.CYAN, Color.MAGENTA };
            ColumnPuzzle temp = new ColumnPuzzle(3);
            temp.setup(3);

            for (int i = 0; i < temp.grid[0].length; i++) {
                if (!temp.grid[0][i].equals(colorsList[i])) {
                    sop("FAILED! Did not insert original colors in the " +
                        "correct order");
                    failed++;
                    break;
                }
            }
        } catch (Exception e) {
            sop("ERROR! Tried to make sure colors were in the correct order.");
            e.printStackTrace();
            failed++;
        } finally {
            tests++;
        }

        // Make sure the last square is blank (i.e. black).
        try {
            ColumnPuzzle temp = new ColumnPuzzle(3);
            temp.setup(3);

            if (!temp.grid[temp.grid.length-1][5].equals(Color.BLACK)) {
                sop("FAILED! The bottom-right square wasn't black, it was " +
                        temp.grid[temp.grid.length-1][5]);
                failed++;
            }

            temp = null;
        } catch (Exception e) {
            sop("ERROR! Tried to make sure the last square was black.");
            e.printStackTrace();
            failed++;
        } finally {
            tests++;
        }

        printStats(tests, failed);
    }

    private static void testSwap() {
        int tests = 0;
        int failed = 0;

        printHeader("Testing Swap");

        try {
            ColumnPuzzle temp = new ColumnPuzzle(3);
            temp.setup(3);

            for (int row = 0; row < temp.grid.length-1; row++) {
                for (int col = 0; col < temp.grid[row].length-1; col++) {
                    try {
                        // Remember what the original colors were.
                        Color color1 = temp.grid[row][col];
                        Color color2 = temp.grid[row+1][col+1];
                        temp.swap(row, col, row+1, col+1);

                        // Make sure they swapped.
                        if (!temp.grid[row+1][col+1].equals(color1)
                                || !temp.grid[row][col].equals(color2)) {
                            sop("FAILED! Swap of " + row + "," + col + 
                                " to " + (row+1) + "," + (col+1) +
                                " did not swap!");
                            failed++;
                        }
                    } catch (Exception e) {
                        sop("ERROR! Tried to swap(" + row + ", " + col +
                            ", " + (row+1) + ", " + (col+1) + "). " +
                            "Java said: " + e);
                        failed++;
                    } finally {
                        tests++;
                    }
                }
            }
        } catch (Exception e) {
            sop("ERROR! Tried to create a Column Puzzle to test swap. " +
                "Java said: " + e);
        }

        printStats(tests, failed);
    }

    private static void testShuffle() {
        // You should write this test.
    }

    private static void testSetTitle() {
        // You should write this test.
    }

    private static void testIsSolved() {
        // In this test, you'll want to create a new 2D Color array and
        // reassign the ColumnPuzzle's array in order to test isSolved().
        // There are two tests here. You should add other test cases.

        int tests = 0;
        int failed = 0;

        printHeader("Testing isSolved");

        Color[][] solved = {
                {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN,
                    Color.MAGENTA},
                {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN,
                    Color.BLACK}
        };

        Color[][] notSolved = {
                {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN,
                    Color.MAGENTA},
                {Color.YELLOW, Color.RED, Color.GREEN, Color.CYAN, Color.BLUE,
                    Color.BLACK}
        };

        ColumnPuzzle temp = new ColumnPuzzle(3);

        try {
            temp.grid = solved;
            if (!temp.isSolved()) {
                sop("FAILED! Puzzle was solved, but isSolved was false.");
                failed++;
            }
        } catch(Exception e) {
            sop("ERROR!");
            e.printStackTrace();
            failed++;
        } finally {
            tests++;
        }

        try {
            temp.grid = notSolved;
            if (temp.isSolved()) {
                sop("FAILED! isSolved was true with unsolved puzzle.");
                failed++;
            }
        } catch(Exception e) {
            sop("ERROR!");
            e.printStackTrace();
            failed++;
        } finally {
            tests++;
        }

        // Add more test cases here!

        printStats(tests, failed);
    }

    private static void testAdjacentBlackSquare() {
        // You should write this test.
    }


    /*
     * Helper methods follow
     */

    private static void printHeader(String s) {
        System.out.print("+");
        for (int i = 0; i < s.length()+4; i++) 
            
            System.out.print("-");
        System.out.println("+");

        sop("|  " + s + "  |");

        System.out.print("+");
        for (int i = 0; i < s.length()+4; i++) System.out.print("-");
        System.out.println("+\n");
    }

    private static void sop(String s) {
        System.out.println(s);
    }

    private static void printStats(int tests, int failed) {
        sop("\n\nSUMMARY:");
        sop("  PASSED: "+(tests-failed)+"\tFAILED: "+failed);
        sop("\n\n");
    }

    private static Color[][] deepCopy(Color[][] colors) {
        Color[][] newColors = new Color[colors.length][colors[0].length];

        for (int row = 0; row < colors.length; row++) {
            for (int col = 0; col < colors[row].length; col++) {
                newColors[row][col] = colors[row][col];
            }
        }

        return newColors;
    }

    private static boolean equal(Color[][] colors1, Color[][] colors2) {
        if (colors1.length != colors2.length
            || colors1[0].length != colors2[0].length) {
            return false;
        }

        for (int row = 0; row < colors1.length; row++) {
            for (int col = 0; col < colors1[row].length; col++) {
                if (colors1[row][col] != colors2[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
